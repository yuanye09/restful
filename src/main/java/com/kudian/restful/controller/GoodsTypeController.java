package com.kudian.restful.controller;

import com.kudian.restful.entity.GoodsType;
import com.kudian.restful.entity.MediaRes;
import com.kudian.restful.service.GoodsTypeService;
import com.kudian.restful.service.MediaResService;
import com.kudian.restful.vo.GoodsType.GoodsTypeVO;
import com.kudian.restful.vo.GoodsType.QueryGoodsTypeRetVO;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/18.
 */
@RestController
@RequestMapping("goodsType")
public class GoodsTypeController {
    private static final Logger logger = Logger.getLogger(GoodsTypeController.class);

    @Autowired
    private GoodsTypeService goodsTypeService;

    @Autowired
    private MediaResService mediaResService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    @ApiOperation(value = "取得所有商品大类信息", httpMethod = "GET", notes = "取得所有商品大类信息", response = QueryGoodsTypeRetVO.class)
    public QueryGoodsTypeRetVO getAll() {

        QueryGoodsTypeRetVO o = new QueryGoodsTypeRetVO();
        try {
            List<GoodsType> gts = goodsTypeService.getAll();
            for (GoodsType e : gts) {
                GoodsTypeVO vo = new GoodsTypeVO();
                vo.setGtId(e.getGtId());
                vo.setGtName(e.getGtName());
                vo.setPicUrl(this.mediaResService.getResUrl(e.getPic()));

                if (o.getGtypes() == null) {
                    o.setGtypes(new ArrayList<GoodsTypeVO>());
                }
                o.getGtypes().add(vo);

            }
            o.setErrcode(0);
            o.setErrmsg("成功取得商品大类信息");
        } catch (Exception e) {
            logger.error(e);
            o.setErrcode(9999);
            o.setErrmsg("取得商品大类信息失败");
        }
        return o;
    }
}
