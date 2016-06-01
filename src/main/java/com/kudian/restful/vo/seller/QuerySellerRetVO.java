package com.kudian.restful.vo.seller;

import com.kudian.common.persistence.ResultObj;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2016/4/18.
 */
public class QuerySellerRetVO extends ResultObj {
//    private List<SellerItemVO> items;
//
//    public List<SellerItemVO> getItems() {
//        return items;
//    }
//
//    public void setItems(List<SellerItemVO> items) {
//        this.items = items;
//    }
    SellerItemVO item;

    public SellerItemVO getItem() {
        return item;
    }

    public void setItem(SellerItemVO item) {
        this.item = item;
    }
}
