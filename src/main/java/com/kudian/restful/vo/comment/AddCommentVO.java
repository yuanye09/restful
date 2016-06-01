package com.kudian.restful.vo.comment;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/5/30.
 */
public class AddCommentVO {
    private String access_token;

    private Short commentType;
    private Integer idValue;
    private String content;
    private Short commentRank;
//    private Integer userId;
//    private String userName;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Short getCommentType() {
        return commentType;
    }

    public void setCommentType(Short commentType) {
        this.commentType = commentType;
    }

    public Integer getIdValue() {
        return idValue;
    }

    public void setIdValue(Integer idValue) {
        this.idValue = idValue;
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

//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
}
