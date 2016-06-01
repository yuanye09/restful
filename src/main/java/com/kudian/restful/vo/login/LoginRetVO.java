package com.kudian.restful.vo.login;

import com.kudian.common.persistence.ResultObj;

/**
 * Created by Administrator on 2016/4/16.
 */
public class LoginRetVO extends ResultObj {
    private String access_token;

    private String spe;

    private Short sellerStatus;

    private String welcomeMsg;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getSpe() {
        return spe;
    }

    public void setSpe(String spe) {
        this.spe = spe;
    }

    public Short getSellerStatus() {
        return sellerStatus;
    }

    public void setSellerStatus(Short sellerStatus) {
        this.sellerStatus = sellerStatus;
    }

    public String getWelcomeMsg() {
        return welcomeMsg;
    }

    public void setWelcomeMsg(String welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }
}
