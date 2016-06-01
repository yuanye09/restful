package com.kudian.restful.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Storage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "storage")
public class Storage implements java.io.Serializable {

	// Fields

	private Integer storageId;
	private Integer userId;
	private String ke;
	private String va;
	private Timestamp lastTime;

	// Constructors

	/** default constructor */
	public Storage() {
	}

	/** full constructor */
	public Storage(Integer userId, String ke, String va, Timestamp lastTime) {
		this.userId = userId;
		this.ke = ke;
		this.va = va;
		this.lastTime = lastTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "storage_id", unique = true, nullable = false)
	public Integer getStorageId() {
		return this.storageId;
	}

	public void setStorageId(Integer storageId) {
		this.storageId = storageId;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "ke", nullable = false, length = 50)
	public String getKe() {
		return this.ke;
	}

	public void setKe(String ke) {
		this.ke = ke;
	}

	@Column(name = "va", nullable = false, length = 65535)
	public String getVa() {
		return this.va;
	}

	public void setVa(String va) {
		this.va = va;
	}

	@Column(name = "last_time", nullable = false, length = 19)
	public Timestamp getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

}