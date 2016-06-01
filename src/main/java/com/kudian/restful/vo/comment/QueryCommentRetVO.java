package com.kudian.restful.vo.comment;

import com.kudian.common.persistence.ResultObj;

import java.util.List;

/**
 * Created by Administrator on 2016/5/30.
 */
public class QueryCommentRetVO extends ResultObj {

    private List<QueryCommentItemRetVO> items;

    public List<QueryCommentItemRetVO> getItems() {
        return items;
    }

    public void setItems(List<QueryCommentItemRetVO> items) {
        this.items = items;
    }
}
