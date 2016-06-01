package com.kudian.restful.vo.category;

import com.kudian.common.persistence.ResultObj;

import java.util.List;

/**
 * Created by Administrator on 2016/4/18.
 */
public class SaveCategoryInfoRetVO extends ResultObj {
    private int catId;

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }
}
