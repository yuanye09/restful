package com.kudian.restful.vo.goods;

import java.util.List;

/**
 * Created by Administrator on 2016/6/1.
 */
public class GoodsByCategoryVO {
    private Integer catId;
    private String catName;

    private List<GoodsItemVO> items;

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public List<GoodsItemVO> getItems() {
        return items;
    }

    public void setItems(List<GoodsItemVO> items) {
        this.items = items;
    }
}
