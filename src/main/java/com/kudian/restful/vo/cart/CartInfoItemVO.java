package com.kudian.restful.vo.cart;

/**
 * Created by Administrator on 2016/4/27.
 */
public class CartInfoItemVO {

    private Integer sellerId;
    private Integer goodsId;
    private String goodsSn;
    private String goodsName;
    private Double goodsPrice;
    // 商品的简短描述
    private String goodsBrief;
    // 商品的详细描述
    private String goodsDesc;
    // 是否是实物，1，是；0，否；比如虚拟卡就为0，不是实物，默认1
    private Short isReal;
    private String sellerNote;
    // 以逗号分隔，图片列表
    private String pics;

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

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

    public String getGoodsBrief() {
        return goodsBrief;
    }

    public void setGoodsBrief(String goodsBrief) {
        this.goodsBrief = goodsBrief;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public Short getIsReal() {
        return isReal;
    }

    public void setIsReal(Short isReal) {
        this.isReal = isReal;
    }

    public String getSellerNote() {
        return sellerNote;
    }

    public void setSellerNote(String sellerNote) {
        this.sellerNote = sellerNote;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }
}
