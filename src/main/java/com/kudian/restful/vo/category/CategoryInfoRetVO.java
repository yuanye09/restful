package com.kudian.restful.vo.category;

import com.kudian.common.persistence.ResultObj;

import java.util.List;

/**
 * Created by Administrator on 2016/4/18.
 */
public class CategoryInfoRetVO extends ResultObj {
    private List<CategoryInfoVO> categories;

    public List<CategoryInfoVO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryInfoVO> categories) {
        this.categories = categories;
    }
}
