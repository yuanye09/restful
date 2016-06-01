package com.kudian.restful.controller;

import com.kudian.common.persistence.ResultObj;
import com.kudian.common.utils.StringUtils;
import com.kudian.restful.entity.LoginSession;
import com.kudian.restful.service.CartService;
import com.kudian.restful.service.LoginSessionService;
import com.kudian.restful.service.OrderService;
import com.kudian.restful.vo.cart.AddCartInfoVO;
import com.kudian.restful.vo.cart.QueryCartInfoRetVO;
import com.kudian.restful.vo.cart.QueryCartInfoVO;
import com.kudian.restful.vo.goods.AddGoodsRetVO;
import com.kudian.restful.vo.order.*;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2016/4/27.
 */
@RestController
@RequestMapping("order")
public class OrderInfoController {

    private static final Logger logger = Logger.getLogger(OrderInfoController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private LoginSessionService loginSessionService;

    @RequestMapping(value = "add", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "创建订单信息", httpMethod = "POST", notes = "创建订单信息", response = ResultObj.class)
    public AddOrderRetVO add(@RequestBody AddOrderVO vo) {
        AddOrderRetVO o = new AddOrderRetVO();

        if (vo == null || StringUtils.isBlank(vo.getAccess_token())) {
            o.setErrcode(9999);
            o.setErrmsg("创建订单信息失败!access_token为空");
            return o;
        }
        LoginSession ent = loginSessionService.get(vo.getAccess_token());
        if (ent == null) {
            o.setErrcode(9999);
            o.setErrmsg("access_token已失效!");
            return o;
        }

        try {
            // TODO 加推送商家信息处理
            o.setErrcode(0);
            o.setErrmsg("创建订单信息成功!");
            o.setOrderIds(orderService.add(vo));
        } catch (Exception e) {
            logger.error(e);
            o.setErrcode(9999);
            o.setErrmsg("创建订单信息失败!");
        }
        return o;
    }

    @RequestMapping(value = "pay", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "直接支付订单", httpMethod = "POST", notes = "直接支付订单", response = ResultObj.class)
    public ResultObj pay(@RequestBody AddOrderVO vo) {
        ResultObj o = new ResultObj();

        return o;
    }

    @RequestMapping(value = "querybyself", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "查询客户自己订单信息", httpMethod = "POST", notes = "查询客户自己订单信息", response = QueryOrderInfoRetVO.class)
    public QueryOrderInfoRetVO querybyself(@RequestBody QueryOrderVO vo) {
        QueryOrderInfoRetVO o = new QueryOrderInfoRetVO();

        if (vo == null || StringUtils.isBlank(vo.getAccess_token())) {
            o.setErrcode(9999);
            o.setErrmsg("查询订单信息失败!access_token为空");
            return o;
        }
        LoginSession ent = loginSessionService.get(vo.getAccess_token());
        if (ent == null) {
            o.setErrcode(9999);
            o.setErrmsg("access_token已失效!");
            return o;
        }

        try {
            o = orderService.querybyself(vo);
            o.setErrcode(0);
            o.setErrmsg("查询订单信息成功!");
        } catch (Exception e) {
            logger.error(e);
            o.setErrcode(9999);
            o.setErrmsg("查询订单信息失败!");
        }
        return o;
    }

    @RequestMapping(value = "querybybus", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "查询店铺订单信息", httpMethod = "POST", notes = "查询店铺自己订单信息", response = QueryOrderInfoRetVO.class)
    public QueryOrderInfoRetVO querybybus(@RequestBody QueryOrderVO vo) {
        QueryOrderInfoRetVO o = new QueryOrderInfoRetVO();

        if (vo == null || StringUtils.isBlank(vo.getAccess_token())) {
            o.setErrcode(9999);
            o.setErrmsg("查询店铺订单信息失败!access_token为空");
            return o;
        }
        LoginSession ent = loginSessionService.get(vo.getAccess_token());
        if (ent == null) {
            o.setErrcode(9999);
            o.setErrmsg("access_token已失效!");
            return o;
        }

        try {
            o = orderService.querybybus(vo);
            o.setErrcode(0);
            o.setErrmsg("查询店铺订单信息成功!");
        } catch (Exception e) {
            logger.error(e);
            o.setErrcode(9999);
            o.setErrmsg("查询店铺订单信息失败!");
        }
        return o;
    }

    @RequestMapping(value = "confirm", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ApiOperation(value = "商家确认订单信息", httpMethod = "POST", notes = "商家确认订单信息", response = ResultObj.class)
    public ResultObj confirm(@RequestBody ConfirmOrderVO vo) {
        QueryOrderInfoRetVO o = new QueryOrderInfoRetVO();
        if (vo == null || StringUtils.isBlank(vo.getAccess_token())) {
            o.setErrcode(9999);
            o.setErrmsg("商家确认订单信息失败!access_token为空");
            return o;
        }
        LoginSession ent = loginSessionService.get(vo.getAccess_token());
        if (ent == null) {
            o.setErrcode(9999);
            o.setErrmsg("access_token已失效!");
            return o;
        }

        try {
            orderService.confirmorder(vo);
            o.setErrcode(0);
            o.setErrmsg("商家确认订单信息成功!");
        } catch (Exception e) {
            logger.error(e);
            o.setErrcode(9999);
            o.setErrmsg("商家确认订单信息失败!");
        }
        return o;
    }
}
