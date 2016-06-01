package com.kudian.restful.vo.goods;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/4/25.
 */
public class AddGoodsVO {

    private String access_token;

    private Integer catId;

    private String goodsSn;
    private String goodsName;
    private Integer clickCount;
    // 品牌目前先不开放
    // private Short brandId;
    private Double shopPrice;
    // private String keywords;
    // 商品的简短描述
    private String goodsBrief;
    // 商品的详细描述
    private String goodsDesc;
    // 库存
    private Integer inventory;
    // 商品单位
    private String measureUnit;
    // 单位注释
    private String unitDesc;
    // 商品显示顺序(在本商店)
    private Short sortOrder;

    // 是否是实物，1，是；0，否；比如虚拟卡就为0，不是实物，默认1
    private Short isReal;
    private Boolean isOnSale;
// 一下几项先设置默认值，之后再添加功能
//    private Boolean isShipping;
//    private Short sortOrder;
//    private Boolean isDelete;
//    private Boolean isBest;
//    private Boolean isNew;
//    private Boolean isHot;
//    private Boolean isPromote;
    private String area;

    private Integer sellerId;
    private String sellerNote;

    // 以逗号分隔，图片列表
    private String pics;

    // 以逗号分隔，底部图片列表
    private String bottomPics;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
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

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
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

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    public String getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc;
    }

    public Short getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Short sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Short getIsReal() {
        return isReal;
    }

    public void setIsReal(Short isReal) {
        this.isReal = isReal;
    }

    public Boolean getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(Boolean isOnSale) {
        this.isOnSale = isOnSale;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
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

    public String getBottomPics() {
        return bottomPics;
    }

    public void setBottomPics(String bottomPics) {
        this.bottomPics = bottomPics;
    }
}
