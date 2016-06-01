package com.kudian.restful.vo.seller;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2016/4/17.
 */
public class AddSellerVO {

    private String access_token;
    private Short gtId;
    private String name;
    private String tel;
    private String deliveryTime;
    private String mobilePhone;

    // 用户主键是通过access_token取得的

    private String address;
    private Boolean isFirst;
    private Double firstAmount;
    private Boolean isFullMinus;
    private Double fullAmount;
    private Double minusAmount;
    private Boolean isShippingFree;
    private Double shippingFee;
    private Boolean isHoliday;
    private Double discount;
    private String busLicencePics;
    private String corporateIcardPics;
    private String sellerPics;
    private String latitudes;
    private String longitudes;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Short getGtId() {
        return gtId;
    }

    public void setGtId(Short gtId) {
        this.gtId = gtId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(Boolean isFirst) {
        this.isFirst = isFirst;
    }

    public Double getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(Double firstAmount) {
        this.firstAmount = firstAmount;
    }

    public Boolean getIsFullMinus() {
        return isFullMinus;
    }

    public void setIsFullMinus(Boolean isFullMinus) {
        this.isFullMinus = isFullMinus;
    }

    public Double getFullAmount() {
        return fullAmount;
    }

    public void setFullAmount(Double fullAmount) {
        this.fullAmount = fullAmount;
    }

    public Double getMinusAmount() {
        return minusAmount;
    }

    public void setMinusAmount(Double minusAmount) {
        this.minusAmount = minusAmount;
    }

    public Boolean getIsShippingFree() {
        return isShippingFree;
    }

    public void setIsShippingFree(Boolean isShippingFree) {
        this.isShippingFree = isShippingFree;
    }

    public Double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public Boolean getIsHoliday() {
        return isHoliday;
    }

    public void setIsHoliday(Boolean isHoliday) {
        this.isHoliday = isHoliday;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getBusLicencePics() {
        return busLicencePics;
    }

    public void setBusLicencePics(String busLicencePics) {
        this.busLicencePics = busLicencePics;
    }

    public String getCorporateIcardPics() {
        return corporateIcardPics;
    }

    public void setCorporateIcardPics(String corporateIcardPics) {
        this.corporateIcardPics = corporateIcardPics;
    }

    public String getSellerPics() {
        return sellerPics;
    }

    public void setSellerPics(String sellerPics) {
        this.sellerPics = sellerPics;
    }

    public String getLatitudes() {
        return latitudes;
    }

    public void setLatitudes(String latitudes) {
        this.latitudes = latitudes;
    }

    public String getLongitudes() {
        return longitudes;
    }

    public void setLongitudes(String longitudes) {
        this.longitudes = longitudes;
    }
}
