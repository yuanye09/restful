package com.kudian.restful.vo.cart;

import com.kudian.common.persistence.ResultObj;

import java.util.List;

/**
 * Created by Administrator on 2016/4/27.
 */
public class QueryCartInfoRetVO extends ResultObj {
    private List<CartVO> carts;

    public List<CartVO> getCarts() {
        return carts;
    }

    public void setCarts(List<CartVO> carts) {
        this.carts = carts;
    }
}
