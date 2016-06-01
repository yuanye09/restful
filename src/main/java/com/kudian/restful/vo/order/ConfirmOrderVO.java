package com.kudian.restful.vo.order;

/**
 * 查询自己的订单
 *
 * Created by Administrator on 2016/4/29.
 *
 */
public class ConfirmOrderVO {
    private String access_token;

    private Integer orderId;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
