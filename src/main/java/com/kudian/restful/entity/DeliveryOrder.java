package com.kudian.restful.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DeliveryOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "delivery_order")
public class DeliveryOrder implements java.io.Serializable {

	// Fields

	private Integer deliveryId;
	private String deliverySn;
	private String orderSn;
	private Integer orderId;
	private String invoiceNo;
	private Timestamp addTime;
	private Short shippingId;
	private String shippingName;
	private Integer userId;
	private String consignee;
	private String address;
	private Short country;
	private Short province;
	private Short city;
	private Short district;
	private String zipcode;
	private String tel;
	private String mobile;
	private String bestTime;
	private String howOos;
	private Double shippingFee;
	private Timestamp updateTime;
	private Boolean status;

	// Constructors

	/** default constructor */
	public DeliveryOrder() {
	}

	/** minimal constructor */
	public DeliveryOrder(String deliverySn, String orderSn, Integer orderId,
			Boolean status) {
		this.deliverySn = deliverySn;
		this.orderSn = orderSn;
		this.orderId = orderId;
		this.status = status;
	}

	/** full constructor */
	public DeliveryOrder(String deliverySn, String orderSn, Integer orderId,
			String invoiceNo, Timestamp addTime, Short shippingId,
			String shippingName, Integer userId, String consignee,
			String address, Short country, Short province, Short city,
			Short district, String zipcode, String tel, String mobile,
			String bestTime, String howOos, Double shippingFee,
			Timestamp updateTime, Boolean status) {
		this.deliverySn = deliverySn;
		this.orderSn = orderSn;
		this.orderId = orderId;
		this.invoiceNo = invoiceNo;
		this.addTime = addTime;
		this.shippingId = shippingId;
		this.shippingName = shippingName;
		this.userId = userId;
		this.consignee = consignee;
		this.address = address;
		this.country = country;
		this.province = province;
		this.city = city;
		this.district = district;
		this.zipcode = zipcode;
		this.tel = tel;
		this.mobile = mobile;
		this.bestTime = bestTime;
		this.howOos = howOos;
		this.shippingFee = shippingFee;
		this.updateTime = updateTime;
		this.status = status;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "delivery_id", unique = true, nullable = false)
	public Integer getDeliveryId() {
		return this.deliveryId;
	}

	public void setDeliveryId(Integer deliveryId) {
		this.deliveryId = deliveryId;
	}

	@Column(name = "delivery_sn", nullable = false, length = 20)
	public String getDeliverySn() {
		return this.deliverySn;
	}

	public void setDeliverySn(String deliverySn) {
		this.deliverySn = deliverySn;
	}

	@Column(name = "order_sn", nullable = false, length = 20)
	public String getOrderSn() {
		return this.orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	@Column(name = "order_id", nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "invoice_no", length = 50)
	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	@Column(name = "add_time", length = 19)
	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	@Column(name = "shipping_id")
	public Short getShippingId() {
		return this.shippingId;
	}

	public void setShippingId(Short shippingId) {
		this.shippingId = shippingId;
	}

	@Column(name = "shipping_name", length = 120)
	public String getShippingName() {
		return this.shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "consignee", length = 60)
	public String getConsignee() {
		return this.consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	@Column(name = "address", length = 250)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "country")
	public Short getCountry() {
		return this.country;
	}

	public void setCountry(Short country) {
		this.country = country;
	}

	@Column(name = "province")
	public Short getProvince() {
		return this.province;
	}

	public void setProvince(Short province) {
		this.province = province;
	}

	@Column(name = "city")
	public Short getCity() {
		return this.city;
	}

	public void setCity(Short city) {
		this.city = city;
	}

	@Column(name = "district")
	public Short getDistrict() {
		return this.district;
	}

	public void setDistrict(Short district) {
		this.district = district;
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

	@Column(name = "mobile", length = 60)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "best_time", length = 120)
	public String getBestTime() {
		return this.bestTime;
	}

	public void setBestTime(String bestTime) {
		this.bestTime = bestTime;
	}

	@Column(name = "how_oos", length = 120)
	public String getHowOos() {
		return this.howOos;
	}

	public void setHowOos(String howOos) {
		this.howOos = howOos;
	}

	@Column(name = "shipping_fee", precision = 10)
	public Double getShippingFee() {
		return this.shippingFee;
	}

	public void setShippingFee(Double shippingFee) {
		this.shippingFee = shippingFee;
	}

	@Column(name = "update_time", length = 19)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "status", nullable = false)
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}