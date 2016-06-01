package com.kudian.restful.vo.category;

/**
 * Created by Administrator on 2016/4/18.
 */
public class QueryCategoryVO {
    private String access_token;

    private int sellerId;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }
}
