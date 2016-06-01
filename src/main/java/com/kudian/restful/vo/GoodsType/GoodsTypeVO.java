package com.kudian.restful.vo.GoodsType;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Administrator on 2016/4/18.
 */
public class GoodsTypeVO {
    private short gtId;
    private String gtName;

    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    private String attrGroup;

    private String picUrl;

    public String getAttrGroup() {
        return attrGroup;
    }

    public void setAttrGroup(String attrGroup) {
        this.attrGroup = attrGroup;
    }

    public String getGtName() {
        return gtName;
    }

    public void setGtName(String gtName) {
        this.gtName = gtName;
    }

    public short getGtId() {
        return gtId;
    }

    public void setGtId(short gtId) {
        this.gtId = gtId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
