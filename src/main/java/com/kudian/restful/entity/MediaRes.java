package com.kudian.restful.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MediaRes entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "media_res")
public class MediaRes implements java.io.Serializable {

	// Fields

	private String mediaId;
	private String fileName;
	private Long fileSize;
	private Integer userId;
	private Timestamp lastTime;

	// Constructors

	/** default constructor */
	public MediaRes() {
	}

	/** minimal constructor */
	public MediaRes(Long fileSize, Integer userId, Timestamp lastTime) {
		this.fileSize = fileSize;
		this.userId = userId;
		this.lastTime = lastTime;
	}

	/** full constructor */
	public MediaRes(String fileName, Long fileSize, Integer userId,
			Timestamp lastTime) {
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.userId = userId;
		this.lastTime = lastTime;
	}

	// Property accessors
	@Id
	@Column(name = "media_id", unique = true, nullable = false, length = 32)
	public String getMediaId() {
		return this.mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	@Column(name = "file_name", length = 100)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "file_size", nullable = false)
	public Long getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "last_time", nullable = false, length = 19)
	public Timestamp getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

}