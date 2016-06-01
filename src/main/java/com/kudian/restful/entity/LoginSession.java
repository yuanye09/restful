package com.kudian.restful.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LoginSession entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "login_session")
public class LoginSession implements java.io.Serializable {

	// Fields

	private String accessToken;
	private Integer userId;
	private Timestamp loginTime;
	private Timestamp lastTime;

	// Constructors

	/** default constructor */
	public LoginSession() {
	}

	/** full constructor */
	public LoginSession(Integer userId, Timestamp loginTime, Timestamp lastTime) {
		this.userId = userId;
		this.loginTime = loginTime;
		this.lastTime = lastTime;
	}

	// Property accessors
	@Id
	@Column(name = "access_token", unique = true, nullable = false, length = 32)
	public String getAccessToken() {
		return this.accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "login_time", nullable = false, length = 19)
	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	@Column(name = "last_time", nullable = false, length = 19)
	public Timestamp getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

}