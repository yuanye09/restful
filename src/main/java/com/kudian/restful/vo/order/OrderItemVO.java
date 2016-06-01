package com.kudian.restful.vo.order;

/**
 * Created by Administrator on 2016/5/21.
 */
public class OrderItemVO {
    private Integer goodsId;
    private String goodsSn;
    private String goodsName;
    private Double goodsPrice;
//    // 商品的简短描述
//    private String goodsBrief;
//    // 商品的详细描述
//    private String goodsDesc;
//    // 是否是实物，1，是；0，否；比如虚拟卡就为0，不是实物，默认1
//    private Short isReal;
//    private String sellerNote;
    // 以逗号分隔，图片列表
    private String pics;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }
}
