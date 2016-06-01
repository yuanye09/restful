package com.kudian.restful.vo.order;

import java.util.List;

/**
 * Created by Administrator on 2016/5/2.
 * 计算商品的归属
 */
public class OrderGoodsVO {
    // 商家ID
    private Integer sellerId;

    // 本店商品所有总金额
    private Double amout;

    private List<GoodsInfoVO> goodsitems;


    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public List<GoodsInfoVO> getGoodsitems() {
        return goodsitems;
    }

    public void setGoodsitems(List<GoodsInfoVO> goodsitems) {
        this.goodsitems = goodsitems;
    }

    public Double getAmout() {
        return amout;
    }

    public void setAmout(Double amout) {
        this.amout = amout;
    }
}
