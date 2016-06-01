package com.kudian.restful.vo.goods;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/4/27.
 */
public class GoodsItemVO {

    private Integer catId;
    private String goodsSn;
    private String goodsName;
    private Integer clickCount;

    private Double shopPrice;
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
    private String area;

    private Integer sellerId;

    private String sellerNote;

    // 以逗号分隔，图片列表
    private String pics;

    // 以逗号分隔，底部图片列表
    private String bottomPics;

    // 商家时间
    private Timestamp addTime;

    // 已售数量
    private Integer soldnum;

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

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public Integer getSoldnum() {
        return soldnum;
    }

    public void setSoldnum(Integer soldnum) {
        this.soldnum = soldnum;
    }
}
