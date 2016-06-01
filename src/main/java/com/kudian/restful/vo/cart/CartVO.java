package com.kudian.restful.vo.cart;

import java.util.List;

/**
 * Created by Administrator on 2016/5/19.
 */
public class CartVO {
    private Integer sellerId;
    private String name;
    private List<CartInfoItemVO> items;

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CartInfoItemVO> getItems() {
        return items;
    }

    public void setItems(List<CartInfoItemVO> items) {
        this.items = items;
    }
}
