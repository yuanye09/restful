package com.kudian.restful.vo.order;

import com.kudian.common.persistence.ResultObj;

import java.util.List;

/**
 * 订单信息VO 传入的是所有商品，这个vo对应的不是同一个订单
 * 创建的是多个订单
 * Created by Administrator on 2016/4/29.
 *
 */
public class AddOrderRetVO extends ResultObj {

    private List<Integer> orderIds;

    public List<Integer> getOrderIds() {
        return orderIds;
    }
    public void setOrderIds(List<Integer> orderIds) {
        this.orderIds = orderIds;
    }
}
