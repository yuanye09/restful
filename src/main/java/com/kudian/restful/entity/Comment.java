package com.kudian.restful.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comment")
public class Comment implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private Short commentType;
	private Integer idValue;
	private String userName;
	private String content;
	private Short commentRank;
	private Timestamp addTime;
	private Short status;
	private Integer parentId;
	private Integer userId;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(Short commentType, Integer idValue,
			String userName, String content, Short commentRank,
			Timestamp addTime, Short status, Integer parentId, Integer userId) {
		this.commentType = commentType;
		this.idValue = idValue;
		this.userName = userName;
		this.content = content;
		this.commentRank = commentRank;
		this.addTime = addTime;
		this.status = status;
		this.parentId = parentId;
		this.userId = userId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "comment_id", unique = true, nullable = false)
	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	@Column(name = "comment_type", nullable = false)
	public Short getCommentType() {
		return this.commentType;
	}

	public void setCommentType(Short commentType) {
		this.commentType = commentType;
	}

	@Column(name = "id_value", nullable = false)
	public Integer getIdValue() {
		return this.idValue;
	}

	public void setIdValue(Integer idValue) {
		this.idValue = idValue;
	}

	@Column(name = "user_name", nullable = false, length = 60)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "content", nullable = false, length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "comment_rank", nullable = false)
	public Short getCommentRank() {
		return this.commentRank;
	}

	public void setCommentRank(Short commentRank) {
		this.commentRank = commentRank;
	}

	@Column(name = "add_time", nullable = false, length = 19)
	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	@Column(name = "status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "parent_id", nullable = false)
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}