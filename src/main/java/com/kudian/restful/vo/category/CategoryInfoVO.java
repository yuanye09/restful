package com.kudian.restful.vo.category;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by Administrator on 2016/4/18.
 */
public class CategoryInfoVO {
    private int catId;
    private Integer sellerId;
    private String catName;

    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    private String keywords;

    private String catDesc;
    private int parentId;

    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    private List<CategoryInfoVO> children;

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getCatDesc() {
        return catDesc;
    }

    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<CategoryInfoVO> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryInfoVO> children) {
        this.children = children;
    }
}
