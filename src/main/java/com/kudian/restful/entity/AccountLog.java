package com.kudian.restful.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AccountLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "account_log")
public class AccountLog implements java.io.Serializable {

	// Fields

	private Integer logId;
	private Integer userId;
	private Double userMoney;
	private Double frozenMoney;
	private Timestamp changeTime;
	private String changeDesc;
	private Short changeType;

	// Constructors

	/** default constructor */
	public AccountLog() {
	}

	/** full constructor */
	public AccountLog(Integer userId, Double userMoney, Double frozenMoney,
			Timestamp changeTime, String changeDesc, Short changeType) {
		this.userId = userId;
		this.userMoney = userMoney;
		this.frozenMoney = frozenMoney;
		this.changeTime = changeTime;
		this.changeDesc = changeDesc;
		this.changeType = changeType;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "log_id", unique = true, nullable = false)
	public Integer getLogId() {
		return this.logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "user_money", nullable = false, precision = 10)
	public Double getUserMoney() {
		return this.userMoney;
	}

	public void setUserMoney(Double userMoney) {
		this.userMoney = userMoney;
	}

	@Column(name = "frozen_money", nullable = false, precision = 10)
	public Double getFrozenMoney() {
		return this.frozenMoney;
	}

	public void setFrozenMoney(Double frozenMoney) {
		this.frozenMoney = frozenMoney;
	}

	@Column(name = "change_time", nullable = false, length = 19)
	public Timestamp getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(Timestamp changeTime) {
		this.changeTime = changeTime;
	}

	@Column(name = "change_desc", nullable = false)
	public String getChangeDesc() {
		return this.changeDesc;
	}

	public void setChangeDesc(String changeDesc) {
		this.changeDesc = changeDesc;
	}

	@Column(name = "change_type", nullable = false)
	public Short getChangeType() {
		return this.changeType;
	}

	public void setChangeType(Short changeType) {
		this.changeType = changeType;
	}

}