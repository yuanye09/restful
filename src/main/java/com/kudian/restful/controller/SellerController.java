package com.kudian.restful.controller;

import com.kudian.common.persistence.ResultObj;
import com.kudian.common.utils.DateUtils;
import com.kudian.common.utils.StringUtils;
import com.kudian.restful.entity.LoginSession;
import com.kudian.restful.entity.Seller;
import com.kudian.restful.service.LoginSessionService;
import com.kudian.restful.service.MediaResService;
import com.kudian.restful.service.SellerService;
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
@RequestMapping("seller")
public class SellerController {
    private static final Logger logger = Logger.getLogger(SellerController.class);

    @Autowired
    private SellerService sellerService;

    @Autowired
    private LoginSessionService loginSessionService;

    @Autowired
    private MediaResService mediaResService;

    @RequestMapping(value = "add", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "创建商户信息", httpMethod = "POST", notes = "商户信息以json格式传递", response = AddSellerRetVO.class)
    public AddSellerRetVO add(@RequestBody AddSellerVO addSellerVO) {
        AddSellerRetVO o = new AddSellerRetVO();
        if (addSellerVO == null || StringUtils.isBlank(addSellerVO.getAccess_token())) {
            o.setErrcode(9999);
            o.setErrmsg("创建商户信息失败!access_token为空");
            return o;
        }

        try {
            Seller entity = new Seller();
            // 将商品大类放到商户信息中
            entity.setGtId(addSellerVO.getGtId());
            entity.setName(addSellerVO.getName());
            entity.setTel(addSellerVO.getTel());
            // 配送时间
            entity.setDeliveryTime(addSellerVO.getDeliveryTime());
            entity.setMobilePhone(addSellerVO.getMobilePhone());

            Date date = new Date();
            Timestamp t = new Timestamp(System.currentTimeMillis());
            entity.setRegTime(t);
            entity.setModifyTime(t);

            // 店铺地址
            entity.setAddress(addSellerVO.getAddress());
            // 是否首次减免
            entity.setIsFirst(addSellerVO.getIsFirst());
            // 首次减免额
            entity.setFirstAmount(addSellerVO.getFirstAmount());
            // 是否满减
            entity.setIsFullMinus(addSellerVO.getIsFullMinus());
            // 满多少
            entity.setFullAmount(addSellerVO.getFullAmount());
            // 减多少
            entity.setMinusAmount(addSellerVO.getMinusAmount());
            // 是否减免运费
            entity.setIsShippingFree(addSellerVO.getIsShippingFree());
            // 运费
            entity.setShippingFee(addSellerVO.getShippingFee());

            entity.setIsHoliday(addSellerVO.getIsHoliday());
            entity.setDiscount(addSellerVO.getDiscount());
            entity.setBusLicencePics(addSellerVO.getBusLicencePics());
            entity.setCorporateIcardPics(addSellerVO.getCorporateIcardPics());
            entity.setSellerPics(addSellerVO.getSellerPics());
            // 新建商店
            entity.setSellerStatus((short) 0);
            // 经度
            entity.setLongitudes(addSellerVO.getLongitudes());
            // 纬度
            entity.setLatitudes(addSellerVO.getLatitudes());
            LoginSession ls = loginSessionService.getInfo(addSellerVO.getAccess_token());
            entity.setUserId(ls.getUserId());

            sellerService.save(entity);
            // 失败
            o.setErrcode(0);
            o.setErrmsg("成功创建商户信息成功!");
            o.setSellerId(entity.getSellerId());
        } catch (Exception e) {
            // 失败
            o.setErrcode(9999);
            o.setErrmsg("创建商户信息失败!");
            e.printStackTrace();
            logger.error(e);
        }
        return o;
    }

    @RequestMapping(value = "query", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "取得当前登录用户的商户", httpMethod = "POST", notes = "查询条件以json格式传递", response = QuerySellerRetVO.class)
    public @ResponseBody QuerySellerRetVO query(@RequestBody QuerySellerVO querySellerVO) {
        QuerySellerRetVO o = new QuerySellerRetVO();
        if (querySellerVO == null || StringUtils.isBlank(querySellerVO.getAccess_token())) {
            o.setErrcode(9999);
            o.setErrmsg("查询商户信息失败!access_token为空");
            return o;
        }

        try {
            List<Seller> ses = sellerService.query(querySellerVO);
            if (ses != null && !ses.isEmpty()) {
                SellerItemVO item = new SellerItemVO();
                Seller se = ses.get(0);

                item.setSellerId(se.getSellerId());
                item.setGtId(se.getGtId());
                item.setName(se.getName());
                item.setTel(se.getTel());
                // 配送时间
                item.setDeliveryTime(se.getDeliveryTime());
                item.setMobilePhone(se.getMobilePhone());
                item.setUserId(se.getUserId());
                // TODO 是否返回用户信息

                item.setAddress(se.getAddress());
                if (se.getRegTime() != null) {
                    item.setRegTime(DateUtils.dateFormat(se.getRegTime()));
                }
                if (se.getModifyTime() != null) {
                    item.setModifyTime(DateUtils.dateFormat(se.getRegTime()));
                }
                item.setIsFirst(se.getIsFirst());
                item.setFirstAmount(se.getFirstAmount());
                item.setIsFullMinus(se.getIsFullMinus());
                item.setFullAmount(se.getFullAmount());
                item.setMinusAmount(se.getMinusAmount());
                item.setIsShippingFree(se.getIsShippingFree());
                item.setShippingFee(se.getShippingFee());

                item.setIsHoliday(se.getIsHoliday());
                item.setDiscount(se.getDiscount());

                item.setBusLicencePics(mediaResService.getResUrls(se.getBusLicencePics()));
                item.setCorporateIcardPics(mediaResService.getResUrls(se.getCorporateIcardPics()));
                item.setSellerPics(mediaResService.getResUrls(se.getSellerPics()));

                // 前台转译
                item.setSellerStatus(se.getSellerStatus());

                item.setDeliveryStart(se.getDeliveryStart());
                item.setDeliveryEnd(se.getDeliveryEnd());
                item.setIsopen(se.getIsopen());

                item.setLatitudes(se.getLatitudes());
                item.setLongitudes(se.getLongitudes());

                o.setErrcode(0);
                o.setErrmsg("成功查询商户信息");
                o.setItem(item);
            } else {
                o.setErrcode(0);
                o.setErrmsg("此用户暂无商户信息");
            }

//            for (Seller e : ses) {
//                SellerItemVO item = new SellerItemVO();
//                item.setSellerId(e.getSellerId());
//                item.setGtId(e.getGtId());
//                item.setName(e.getName());
//                item.setTel(e.getTel());
//                // 配送时间
//                item.setDeliveryTime(e.getDeliveryTime());
//                item.setMobilePhone(e.getMobilePhone());
//                item.setUserId(e.getUserId());
//                // TODO 是否返回用户信息
//
//                item.setAddress(e.getAddress());
//                if (e.getRegTime() != null) {
//                    item.setRegTime(DateUtils.dateFormat(e.getRegTime()));
//                }
//                if (e.getModifyTime() != null) {
//                    item.setModifyTime(DateUtils.dateFormat(e.getRegTime()));
//                }
//                item.setIsFirst(e.getIsFirst());
//                item.setFirstAmount(e.getFirstAmount());
//                item.setIsFullMinus(e.getIsFullMinus());
//                item.setFullAmount(e.getFullAmount());
//                item.setMinusAmount(e.getMinusAmount());
//                item.setIsShippingFree(e.getIsShippingFree());
//                item.setShippingFee(e.getShippingFee());
//
//                item.setIsHoliday(e.getIsHoliday());
//                item.setDiscount(e.getDiscount());
//
//                item.setBusLicencePics(mediaResService.getResUrls(e.getBusLicencePics()));
//                item.setCorporateIcardPics(mediaResService.getResUrls(e.getCorporateIcardPics()));
//                item.setSellerPics(mediaResService.getResUrls(e.getSellerPics()));
//
//                // 前台转译
//                item.setSellerStatus(e.getSellerStatus());
//
//                item.setLatitudes(e.getLatitudes());
//                item.setLongitudes(e.getLongitudes());
//                if (o.getItems() == null) {
//                    o.setItems(new ArrayList<SellerItemVO>());
//                }
//                o.getItems().add(item);
//            }
        } catch (Exception e) {
            // 失败
            o.setErrcode(9999);
            o.setErrmsg("取得当前登录用户的商户信息失败!");
            e.printStackTrace();
            logger.error(e);
        }
        return o;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "更新商户信息", httpMethod = "POST", notes = "调用此接口前，先等到商户信息，将信息补充全", response = ResultObj.class)
    public @ResponseBody ResultObj update(@RequestBody UpdateSellerVO updateSellerVO) {
        ResultObj o = new ResultObj();

        if (updateSellerVO == null || StringUtils.isBlank(updateSellerVO.getAccess_token())) {
            o.setErrcode(9999);
            o.setErrmsg("更新商户信息失败!access_token为空");
            return o;
        }

        LoginSession ent = loginSessionService.get(updateSellerVO.getAccess_token());
        if (ent == null) {
            o.setErrcode(9999);
            o.setErrmsg("access_token已失效!");
            return o;
        }

        try {
            sellerService.update(updateSellerVO);
        } catch (Exception e) {
            // 失败
            o.setErrcode(9999);
            o.setErrmsg("更新商户信息失败!");
            e.printStackTrace();
            logger.error(e);
        }
        return o;
    }

    @RequestMapping(value = "modify", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "修改商户提交信息", httpMethod = "POST", notes = "审核不通过，再次提交图片信息", response = ResultObj.class)
    public @ResponseBody ResultObj modify(@RequestBody ModifySellerVO modifySellerVO) {
        ResultObj o = new ResultObj();

        if (modifySellerVO == null || StringUtils.isBlank(modifySellerVO.getAccess_token())) {
            o.setErrcode(9999);
            o.setErrmsg("修改商户提交信息失败!access_token为空");
            return o;
        }
        LoginSession ent = loginSessionService.get(modifySellerVO.getAccess_token());
        if (ent == null) {
            o.setErrcode(9999);
            o.setErrmsg("access_token已失效!");
            return o;
        }

        try {
            sellerService.modify(modifySellerVO);
        } catch (Exception e) {
            // 失败
            o.setErrcode(9999);
            o.setErrmsg("修改商户提交信息失败!");
            e.printStackTrace();
            logger.error(e);
        }
        return o;
    }
}
