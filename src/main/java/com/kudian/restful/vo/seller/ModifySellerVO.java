package com.kudian.restful.vo.seller;

/**
 * Created by Administrator on 2016/4/18.
 */
public class ModifySellerVO {

    private String access_token;

    private String busLicencePics;
    private String corporateIcardPics;
    private String sellerPics;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
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
}
