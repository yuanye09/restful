package com.kudian.restful.vo.goods;

import com.kudian.common.persistence.ResultObj;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/4/25.
 */
public class AddGoodsRetVO extends ResultObj {
    private Integer goodsId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}
