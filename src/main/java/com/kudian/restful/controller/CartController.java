package com.kudian.restful.controller;

import com.kudian.common.persistence.ResultObj;
import com.kudian.common.utils.StringUtils;
import com.kudian.restful.entity.LoginSession;
import com.kudian.restful.service.CartService;
import com.kudian.restful.service.LoginSessionService;
import com.kudian.restful.vo.cart.AddCartInfoVO;
import com.kudian.restful.vo.cart.QueryCartInfoRetVO;
import com.kudian.restful.vo.cart.QueryCartInfoVO;
import com.kudian.restful.vo.category.CategoryInfoRetVO;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/4/27.
 */
@RestController
@RequestMapping("cart")
public class CartController {

    private static final Logger logger = Logger.getLogger(CartController.class);

    @Autowired
    private CartService cartService;

    @Autowired
    private LoginSessionService loginSessionService;

    @RequestMapping(value = "addToCart", method = RequestMethod.POST)
    @ApiOperation(value = "添加产品到购物车", httpMethod = "POST", notes = "添加产品到购物车", response = ResultObj.class)
    public ResultObj addToCart(@RequestBody AddCartInfoVO vo) {

        ResultObj o = new ResultObj();
        if (vo == null || StringUtils.isBlank(vo.getAccess_token())) {
            o.setErrcode(9999);
            o.setErrmsg("添加产品到购物车失败!access_token为空");
            return o;
        }
        LoginSession ent = loginSessionService.get(vo.getAccess_token());
        if (ent == null) {
            o.setErrcode(9999);
            o.setErrmsg("access_token已失效!");
            return o;
        }

        try {
            cartService.addToCart(vo);
            o.setErrcode(0);
            o.setErrmsg("添加产品到购物车成功");
        } catch (Exception e) {
            o.setErrcode(9999);
            o.setErrmsg("添加产品到购物车失败");
            logger.error(e);
        }
        return o;
    }

    @RequestMapping(value = "queryCartInfo", method = RequestMethod.POST)
    @ApiOperation(value = "取得当前登录用户中的购物车信息", httpMethod = "POST", notes = "取得当前登录用户中的购物车信息", response = QueryCartInfoRetVO.class)
    public QueryCartInfoRetVO queryCartInfo(@RequestBody QueryCartInfoVO vo) {

        QueryCartInfoRetVO o = new QueryCartInfoRetVO();
        if (vo == null || StringUtils.isBlank(vo.getAccess_token())) {
            o.setErrcode(9999);
            o.setErrmsg("取得当前登录用户中的购物车信息失败!access_token为空");
            return o;
        }
        LoginSession ent = loginSessionService.get(vo.getAccess_token());
        if (ent == null) {
            o.setErrcode(9999);
            o.setErrmsg("access_token已失效!");
            return o;
        }

        try {
            o.setCarts(cartService.queryCartInfo(vo));
            o.setErrcode(0);
            o.setErrmsg("取得当前登录用户中的购物车信息成功");
        } catch (Exception e) {
            o.setErrcode(9999);
            o.setErrmsg("取得当前登录用户中的购物车信息失败");
            logger.error(e);
        }
        return o;
    }
}
