package com.kudian.restful.vo.GoodsType;

import com.kudian.common.persistence.ResultObj;

import java.util.List;

/**
 * Created by Administrator on 2016/4/18.
 */
public class QueryGoodsTypeRetVO extends ResultObj {
    private List<GoodsTypeVO> gtypes;

    public List<GoodsTypeVO> getGtypes() {
        return gtypes;
    }

    public void setGtypes(List<GoodsTypeVO> gtypes) {
        this.gtypes = gtypes;
    }
}
