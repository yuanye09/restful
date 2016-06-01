package com.kudian.restful.vo.order;

import com.kudian.common.persistence.ResultObj;

import java.util.List;

/**
 * Created by Administrator on 2016/5/21.
 */
public class QueryOrderInfoRetVO extends ResultObj {
    private List<OrderVO> orders;

    public List<OrderVO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderVO> orders) {
        this.orders = orders;
    }
}
