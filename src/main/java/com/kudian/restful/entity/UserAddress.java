package com.kudian.restful.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserAddress entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_address")
public class UserAddress implements java.io.Serializable {

	// Fields

	private Integer addressId;
	private Integer userId;
	private String consignee;
	private String email;
	private Short country;
	private Integer province;
	private Integer city;
	private Integer district;
	private String address;
	private String zipcode;
	private String mobile;
	private String bestTime;

	// Constructors

	/** default constructor */
	public UserAddress() {
	}

	/** full constructor */
	public UserAddress(Integer userId, String consignee, String email,
			Short country, Integer province, Integer city, Integer district,
			String address, String zipcode, String mobile, String bestTime) {
		this.userId = userId;
		this.consignee = consignee;
		this.email = email;
		this.country = country;
		this.province = province;
		this.city = city;
		this.district = district;
		this.address = address;
		this.zipcode = zipcode;
		this.mobile = mobile;
		this.bestTime = bestTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "address_id", unique = true, nullable = false)
	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "consignee", nullable = false, length = 60)
	public String getConsignee() {
		return this.consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	@Column(name = "email", nullable = false, length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "country", nullable = false)
	public Short getCountry() {
		return this.country;
	}

	public void setCountry(Short country) {
		this.country = country;
	}

	@Column(name = "province", nullable = false)
	public Integer getProvince() {
		return this.province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}

	@Column(name = "city", nullable = false)
	public Integer getCity() {
		return this.city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	@Column(name = "district", nullable = false)
	public Integer getDistrict() {
		return this.district;
	}

	public void setDistrict(Integer district) {
		this.district = district;
	}

	@Column(name = "address", nullable = false, length = 120)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "zipcode", nullable = false, length = 60)
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "mobile", nullable = false, length = 60)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "best_time", nullable = false, length = 120)
	public String getBestTime() {
		return this.bestTime;
	}

	public void setBestTime(String bestTime) {
		this.bestTime = bestTime;
	}

}