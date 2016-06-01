package com.kudian.restful.vo.seller;

import com.kudian.common.persistence.ResultObj;

/**
 * Created by Administrator on 2016/4/17.
 */
public class AddSellerRetVO extends ResultObj {
    private int sellerId = 0;

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }
}
