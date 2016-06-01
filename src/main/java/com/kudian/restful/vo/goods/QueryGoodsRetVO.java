package com.kudian.restful.vo.goods;

import com.kudian.common.persistence.ResultObj;
import com.kudian.restful.vo.seller.SellerItemVO;

import java.util.List;

/**
 * Created by Administrator on 2016/4/26.
 */
public class QueryGoodsRetVO extends ResultObj {
    private List<GoodsByCategoryVO> goodsinfos;

    public List<GoodsByCategoryVO> getGoodsinfos() {
        return goodsinfos;
    }

    public void setGoodsinfos(List<GoodsByCategoryVO> goodsinfos) {
        this.goodsinfos = goodsinfos;
    }
}
