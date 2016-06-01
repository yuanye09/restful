package com.kudian.restful.controller;

import com.kudian.common.utils.DateUtils;
import com.kudian.common.utils.StringUtils;
import com.kudian.restful.entity.Goods;
import com.kudian.restful.entity.LoginSession;
import com.kudian.restful.entity.Seller;
import com.kudian.restful.service.GoodsService;
import com.kudian.restful.service.LoginSessionService;
import com.kudian.restful.service.SellerService;
import com.kudian.restful.vo.goods.*;
import com.kudian.restful.vo.seller.*;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/4/17.
 */
@RestController
@RequestMapping("goods")
public class GoodsController {
    private static final Logger logger = Logger.getLogger(GoodsController.class);

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private LoginSessionService loginSessionService;

    @RequestMapping(value = "add", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "创建商品信息", httpMethod = "POST", notes = "商品信息以json格式传递", response = AddGoodsRetVO.class)
    public @ResponseBody AddGoodsRetVO add(@RequestBody AddGoodsVO addGoodsVO) {
        AddGoodsRetVO o = new AddGoodsRetVO();
        if (addGoodsVO == null || StringUtils.isBlank(addGoodsVO.getAccess_token())) {
            o.setErrcode(9999);
            o.setErrmsg("创建商品信息失败!access_token为空");
            return o;
        }

        try {

            Integer goodsid = goodsService.saveGoodsAndPics(addGoodsVO);
            // 成功
            o.setErrcode(0);
            o.setErrmsg("创建商品信息成功!");
            o.setGoodsId(goodsid);
        } catch (Exception e) {
            // 失败
            o.setErrcode(9999);
            o.setErrmsg("创建商品信息失败!");
            e.printStackTrace();
            logger.error(e);
        }
        return o;
    }

    @RequestMapping(value = "query", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
         @ApiOperation(value = "取得商品信息", httpMethod = "POST", notes = "商品信息以json格式传递", response = QueryGoodsRetVO.class)
    public @ResponseBody QueryGoodsRetVO query(@RequestBody QueryGoodsVO queryGoodsVO) {
        QueryGoodsRetVO o = new QueryGoodsRetVO();
        if (queryGoodsVO == null || StringUtils.isBlank(queryGoodsVO.getAccess_token())) {
            o.setErrcode(9999);
            o.setErrmsg("取得商品信息失败!access_token为空");
            return o;
        }

        try {
            // o.setItems(goodsService.queryGoodsAndPics(queryGoodsVO));
            o.setGoodsinfos(goodsService.goodsByCategory(goodsService.queryGoodsAndPics(queryGoodsVO)));
            o.setErrcode(0);
            o.setErrmsg("取得商品信息成功!");
        } catch (Exception e) {
            o.setErrcode(9999);
            o.setErrmsg("取得商品信息失败!");
            e.printStackTrace();
            logger.error(e);
        }
        return o;
    }

    @RequestMapping(value = "details", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "取得商品明细", httpMethod = "POST", notes = "", response = DetailGoodsRetVO.class)
    public @ResponseBody DetailGoodsRetVO details(@RequestBody DetailGoodsVO detailGoodsVO) {
        DetailGoodsRetVO o = new DetailGoodsRetVO();
        try {
            o.setInfo(this.goodsService.details(detailGoodsVO.getGoodsId()));
            o.setErrcode(0);
            o.setErrmsg("取得商品明细成功!");
        } catch (Exception e) {
            o.setErrcode(9999);
            o.setErrmsg("取得商品明细失败!");
            e.printStackTrace();
            logger.error(e);
        }
        return o;
    }
}
