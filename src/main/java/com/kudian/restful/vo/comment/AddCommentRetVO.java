package com.kudian.restful.vo.comment;

import com.kudian.common.persistence.ResultObj;

/**
 * Created by Administrator on 2016/5/30.
 */
public class AddCommentRetVO extends ResultObj {
    private Integer commentId;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
}
