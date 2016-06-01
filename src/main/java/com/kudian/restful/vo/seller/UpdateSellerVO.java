package com.kudian.restful.vo.seller;

/**
 * Created by Administrator on 2016/4/18.
 */
public class UpdateSellerVO {

    private String access_token;
    private String tel;
    private String deliveryTime;
    private String mobilePhone;
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
    private String deliveryStart;
    private String deliveryEnd;
    private String latitudes;
    private String longitudes;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
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

    public String getDeliveryStart() {
        return deliveryStart;
    }

    public void setDeliveryStart(String deliveryStart) {
        this.deliveryStart = deliveryStart;
    }

    public String getDeliveryEnd() {
        return deliveryEnd;
    }

    public void setDeliveryEnd(String deliveryEnd) {
        this.deliveryEnd = deliveryEnd;
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
