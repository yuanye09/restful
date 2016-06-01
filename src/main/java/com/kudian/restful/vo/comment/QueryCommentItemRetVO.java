package com.kudian.restful.vo.comment;

import com.kudian.common.persistence.ResultObj;

/**
 * Created by Administrator on 2016/5/30.
 */
public class QueryCommentItemRetVO {
    private Integer commentId;
    private String content;
    private Short commentRank;
    private Integer userId;
    private String userName;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Short getCommentRank() {
        return commentRank;
    }

    public void setCommentRank(Short commentRank) {
        this.commentRank = commentRank;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
