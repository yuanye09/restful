package com.kudian.restful.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "users")
public class Users implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String email;
	private String mobilePhone;
	private String userName;
	private String alias;
	private Short sex;
	private Short isValidated;
	private Double creditLine;
	private String password;
	private Double userMoney;
	private Double frozenMoney;
	private Integer addressId;
	private Timestamp regTime;
	private Timestamp lastLogin;
	private Timestamp lastTime;
	private String lastIp;
	private Short isSpecial;
	private String ecSalt;
	private String salt;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String email, String mobilePhone, String userName,
			String alias, Short sex, Short isValidated, Double creditLine,
			String password, Double userMoney, Double frozenMoney,
			Timestamp regTime, Timestamp lastLogin, Timestamp lastTime,
			String lastIp, Short isSpecial, String salt) {
		this.email = email;
		this.mobilePhone = mobilePhone;
		this.userName = userName;
		this.alias = alias;
		this.sex = sex;
		this.isValidated = isValidated;
		this.creditLine = creditLine;
		this.password = password;
		this.userMoney = userMoney;
		this.frozenMoney = frozenMoney;
		this.regTime = regTime;
		this.lastLogin = lastLogin;
		this.lastTime = lastTime;
		this.lastIp = lastIp;
		this.isSpecial = isSpecial;
		this.salt = salt;
	}

	/** full constructor */
	public Users(String email, String mobilePhone, String userName,
			String alias, Short sex, Short isValidated, Double creditLine,
			String password, Double userMoney, Double frozenMoney,
			Integer addressId, Timestamp regTime, Timestamp lastLogin,
			Timestamp lastTime, String lastIp, Short isSpecial, String ecSalt,
			String salt) {
		this.email = email;
		this.mobilePhone = mobilePhone;
		this.userName = userName;
		this.alias = alias;
		this.sex = sex;
		this.isValidated = isValidated;
		this.creditLine = creditLine;
		this.password = password;
		this.userMoney = userMoney;
		this.frozenMoney = frozenMoney;
		this.addressId = addressId;
		this.regTime = regTime;
		this.lastLogin = lastLogin;
		this.lastTime = lastTime;
		this.lastIp = lastIp;
		this.isSpecial = isSpecial;
		this.ecSalt = ecSalt;
		this.salt = salt;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "email", nullable = false, length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "mobile_phone", nullable = false, length = 20)
	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Column(name = "user_name", nullable = false, length = 60)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "alias", nullable = false, length = 60)
	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Column(name = "sex", nullable = false)
	public Short getSex() {
		return this.sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	@Column(name = "is_validated", nullable = false)
	public Short getIsValidated() {
		return this.isValidated;
	}

	public void setIsValidated(Short isValidated) {
		this.isValidated = isValidated;
	}

	@Column(name = "credit_line", nullable = false, precision = 10)
	public Double getCreditLine() {
		return this.creditLine;
	}

	public void setCreditLine(Double creditLine) {
		this.creditLine = creditLine;
	}

	@Column(name = "password", nullable = false, length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Column(name = "address_id")
	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	@Column(name = "reg_time", nullable = false, length = 19)
	public Timestamp getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	@Column(name = "last_login", nullable = false, length = 19)
	public Timestamp getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Column(name = "last_time", nullable = false, length = 19)
	public Timestamp getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

	@Column(name = "last_ip", nullable = false, length = 15)
	public String getLastIp() {
		return this.lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	@Column(name = "is_special", nullable = false)
	public Short getIsSpecial() {
		return this.isSpecial;
	}

	public void setIsSpecial(Short isSpecial) {
		this.isSpecial = isSpecial;
	}

	@Column(name = "ec_salt", length = 10)
	public String getEcSalt() {
		return this.ecSalt;
	}

	public void setEcSalt(String ecSalt) {
		this.ecSalt = ecSalt;
	}

	@Column(name = "salt", nullable = false, length = 10)
	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}