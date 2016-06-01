package com.kudian.restful.vo.goods;

/**
 * Created by Administrator on 2016/4/26.
 */
public class QueryGoodsVO {
    private String access_token;

    private Integer sellerId;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }
}
