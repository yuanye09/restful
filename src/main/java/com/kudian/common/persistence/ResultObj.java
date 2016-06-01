package com.kudian.common.persistence;

/**
 * Created by Administrator on 2016/4/16.
 */
public class ResultObj {
    private int errcode;
    private String errmsg;

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }
}
