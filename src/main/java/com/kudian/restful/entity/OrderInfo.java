package com.kudian.restful.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * OrderInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "order_info")
public class OrderInfo implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private String orderSn;
	private Integer userId;
	private Short orderStatus;
	private Short shippingStatus;
	private Short payStatus;
	private String consignee;
	private Short country;
	private Integer province;
	private Integer city;
	private Integer district;
	private String address;
	private String zipcode;
	private String tel;
	private String mobile;
	private String email;
	private String bestTime;
	private String postscript;
	private Double goodsAmount;
	private Double shippingFee;
	private Double orderAmount;
	private Timestamp addTime;
	private Timestamp confirmTime;
	private Timestamp payTime;
	private Timestamp shippingTime;
	private String payNote;

	// Constructors

	/** default constructor */
	public OrderInfo() {
	}

	/** minimal constructor */
	public OrderInfo(String orderSn, Integer userId, Short orderStatus, Short shippingStatus, Short payStatus, String consignee,
			Short country, Integer province, Integer city, Integer district,
			String address, String mobile, String bestTime, Double goodsAmount,
			Double shippingFee, Double orderAmount, Timestamp addTime,
			Timestamp confirmTime, Timestamp payTime, Timestamp shippingTime,
			String payNote) {
		this.orderSn = orderSn;
		this.userId = userId;
		this.orderStatus = orderStatus;
		this.shippingStatus = shippingStatus;
		this.payStatus = payStatus;
		this.consignee = consignee;
		this.country = country;
		this.province = province;
		this.city = city;
		this.district = district;
		this.address = address;
		this.mobile = mobile;
		this.bestTime = bestTime;
		this.goodsAmount = goodsAmount;
		this.shippingFee = shippingFee;
		this.orderAmount = orderAmount;
		this.addTime = addTime;
		this.confirmTime = confirmTime;
		this.payTime = payTime;
		this.shippingTime = shippingTime;
		this.payNote = payNote;
	}

	/** full constructor */
	public OrderInfo(String orderSn, Integer userId, Short orderStatus, Short shippingStatus, Short payStatus, String consignee,
			Short country, Integer province, Integer city, Integer district,
			String address, String zipcode, String tel, String mobile,
			String email, String bestTime, String postscript,
			Double goodsAmount, Double shippingFee, Double orderAmount,
			Timestamp addTime, Timestamp confirmTime, Timestamp payTime,
			Timestamp shippingTime, String payNote) {
		this.orderSn = orderSn;
		this.userId = userId;
		this.orderStatus = orderStatus;
		this.shippingStatus = shippingStatus;
		this.payStatus = payStatus;
		this.consignee = consignee;
		this.country = country;
		this.province = province;
		this.city = city;
		this.district = district;
		this.address = address;
		this.zipcode = zipcode;
		this.tel = tel;
		this.mobile = mobile;
		this.email = email;
		this.bestTime = bestTime;
		this.postscript = postscript;
		this.goodsAmount = goodsAmount;
		this.shippingFee = shippingFee;
		this.orderAmount = orderAmount;
		this.addTime = addTime;
		this.confirmTime = confirmTime;
		this.payTime = payTime;
		this.shippingTime = shippingTime;
		this.payNote = payNote;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "order_id", unique = true, nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "order_sn", nullable = false, length = 20)
	public String getOrderSn() {
		return this.orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "order_status", nullable = false)
	public Short getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(Short orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "shipping_status", nullable = false)
	public Short getShippingStatus() {
		return this.shippingStatus;
	}

	public void setShippingStatus(Short shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	@Column(name = "pay_status", nullable = false)
	public Short getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(Short payStatus) {
		this.payStatus = payStatus;
	}

	@Column(name = "consignee", nullable = false, length = 60)
	public String getConsignee() {
		return this.consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
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

	@Column(name = "address", nullable = false)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "zipcode", length = 60)
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "tel", length = 60)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "mobile", nullable = false, length = 60)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "email", length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "best_time", nullable = false, length = 120)
	public String getBestTime() {
		return this.bestTime;
	}

	public void setBestTime(String bestTime) {
		this.bestTime = bestTime;
	}

	@Column(name = "postscript")
	public String getPostscript() {
		return this.postscript;
	}

	public void setPostscript(String postscript) {
		this.postscript = postscript;
	}

	@Column(name = "goods_amount", nullable = false, precision = 10)
	public Double getGoodsAmount() {
		return this.goodsAmount;
	}

	public void setGoodsAmount(Double goodsAmount) {
		this.goodsAmount = goodsAmount;
	}

	@Column(name = "shipping_fee", nullable = false, precision = 10)
	public Double getShippingFee() {
		return this.shippingFee;
	}

	public void setShippingFee(Double shippingFee) {
		this.shippingFee = shippingFee;
	}

	@Column(name = "order_amount", nullable = false, precision = 10)
	public Double getOrderAmount() {
		return this.orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	@Column(name = "add_time", nullable = false, length = 19)
	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	@Column(name = "confirm_time", nullable = false, length = 19)
	public Timestamp getConfirmTime() {
		return this.confirmTime;
	}

	public void setConfirmTime(Timestamp confirmTime) {
		this.confirmTime = confirmTime;
	}

	@Column(name = "pay_time", nullable = false, length = 19)
	public Timestamp getPayTime() {
		return this.payTime;
	}

	public void setPayTime(Timestamp payTime) {
		this.payTime = payTime;
	}

	@Column(name = "shipping_time", nullable = false, length = 19)
	public Timestamp getShippingTime() {
		return this.shippingTime;
	}

	public void setShippingTime(Timestamp shippingTime) {
		this.shippingTime = shippingTime;
	}

	@Column(name = "pay_note", nullable = false)
	public String getPayNote() {
		return this.payNote;
	}

	public void setPayNote(String payNote) {
		this.payNote = payNote;
	}

}