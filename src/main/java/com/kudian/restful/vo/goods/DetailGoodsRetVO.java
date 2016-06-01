package com.kudian.restful.vo.goods;

import com.kudian.common.persistence.ResultObj;

/**
 * Created by Administrator on 2016/4/25.
 */
public class DetailGoodsRetVO extends ResultObj {
    private GoodsItemVO info;

    public GoodsItemVO getInfo() {
        return info;
    }

    public void setInfo(GoodsItemVO info) {
        this.info = info;
    }
}
