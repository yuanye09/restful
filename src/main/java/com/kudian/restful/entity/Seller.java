package com.kudian.restful.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Seller entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "seller")
public class Seller implements java.io.Serializable {

	// Fields

	private Integer sellerId;
	private Short gtId;
	private String name;
	private String tel;
	private String deliveryTime;
	private String mobilePhone;
	private Integer userId;
	private String address;
	private Timestamp regTime;
	private Timestamp modifyTime;
	private Boolean isFirst;
	private Double firstAmount;
	private Boolean isFullMinus;
	private Double fullAmount;
	private Double minusAmount;
	private Boolean isShippingFree;
	private Double shippingFee;
	private Boolean isHoliday;
	private Double discount;
	private String busLicencePics;
	private String corporateIcardPics;
	private String sellerPics;
	private Short sellerStatus;
	private Timestamp auditTime;
	private String deliveryStart;
	private String deliveryEnd;
	private Boolean isopen;
	private String latitudes;
	private String longitudes;

	// Constructors

	/** default constructor */
	public Seller() {
	}

	/** minimal constructor */
	public Seller(Short gtId, String name, String mobilePhone, Integer userId,
			String address, Timestamp regTime, Timestamp modifyTime,
			Double shippingFee, Short sellerStatus) {
		this.gtId = gtId;
		this.name = name;
		this.mobilePhone = mobilePhone;
		this.userId = userId;
		this.address = address;
		this.regTime = regTime;
		this.modifyTime = modifyTime;
		this.shippingFee = shippingFee;
		this.sellerStatus = sellerStatus;
	}

	/** full constructor */
	public Seller(Short gtId, String name, String tel, String deliveryTime,
			String mobilePhone, Integer userId, String address,
			Timestamp regTime, Timestamp modifyTime, Boolean isFirst,
			Double firstAmount, Boolean isFullMinus, Double fullAmount,
			Double minusAmount, Boolean isShippingFree, Double shippingFee,
			Boolean isHoliday, Double discount, String busLicencePics,
			String corporateIcardPics, String sellerPics, Short sellerStatus,
			Timestamp auditTime, String deliveryStart, String deliveryEnd,
			Boolean isopen, String latitudes, String longitudes) {
		this.gtId = gtId;
		this.name = name;
		this.tel = tel;
		this.deliveryTime = deliveryTime;
		this.mobilePhone = mobilePhone;
		this.userId = userId;
		this.address = address;
		this.regTime = regTime;
		this.modifyTime = modifyTime;
		this.isFirst = isFirst;
		this.firstAmount = firstAmount;
		this.isFullMinus = isFullMinus;
		this.fullAmount = fullAmount;
		this.minusAmount = minusAmount;
		this.isShippingFree = isShippingFree;
		this.shippingFee = shippingFee;
		this.isHoliday = isHoliday;
		this.discount = discount;
		this.busLicencePics = busLicencePics;
		this.corporateIcardPics = corporateIcardPics;
		this.sellerPics = sellerPics;
		this.sellerStatus = sellerStatus;
		this.auditTime = auditTime;
		this.deliveryStart = deliveryStart;
		this.deliveryEnd = deliveryEnd;
		this.isopen = isopen;
		this.latitudes = latitudes;
		this.longitudes = longitudes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "seller_id", unique = true, nullable = false)
	public Integer getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	@Column(name = "gt_id", nullable = false)
	public Short getGtId() {
		return this.gtId;
	}

	public void setGtId(Short gtId) {
		this.gtId = gtId;
	}

	@Column(name = "name", nullable = false, length = 60)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "tel", length = 20)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "delivery_time", length = 120)
	public String getDeliveryTime() {
		return this.deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	@Column(name = "mobile_phone", nullable = false, length = 20)
	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "address", nullable = false, length = 120)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "reg_time", nullable = false, length = 19)
	public Timestamp getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	@Column(name = "modify_time", nullable = false, length = 19)
	public Timestamp getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Column(name = "is_first")
	public Boolean getIsFirst() {
		return this.isFirst;
	}

	public void setIsFirst(Boolean isFirst) {
		this.isFirst = isFirst;
	}

	@Column(name = "first_amount", precision = 10)
	public Double getFirstAmount() {
		return this.firstAmount;
	}

	public void setFirstAmount(Double firstAmount) {
		this.firstAmount = firstAmount;
	}

	@Column(name = "is_full_minus")
	public Boolean getIsFullMinus() {
		return this.isFullMinus;
	}

	public void setIsFullMinus(Boolean isFullMinus) {
		this.isFullMinus = isFullMinus;
	}

	@Column(name = "full_amount", precision = 10)
	public Double getFullAmount() {
		return this.fullAmount;
	}

	public void setFullAmount(Double fullAmount) {
		this.fullAmount = fullAmount;
	}

	@Column(name = "minus_amount", precision = 10)
	public Double getMinusAmount() {
		return this.minusAmount;
	}

	public void setMinusAmount(Double minusAmount) {
		this.minusAmount = minusAmount;
	}

	@Column(name = "is_shipping_free")
	public Boolean getIsShippingFree() {
		return this.isShippingFree;
	}

	public void setIsShippingFree(Boolean isShippingFree) {
		this.isShippingFree = isShippingFree;
	}

	@Column(name = "shipping_fee", nullable = false, precision = 10)
	public Double getShippingFee() {
		return this.shippingFee;
	}

	public void setShippingFee(Double shippingFee) {
		this.shippingFee = shippingFee;
	}

	@Column(name = "is_holiday")
	public Boolean getIsHoliday() {
		return this.isHoliday;
	}

	public void setIsHoliday(Boolean isHoliday) {
		this.isHoliday = isHoliday;
	}

	@Column(name = "discount", precision = 3)
	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	@Column(name = "bus_licence_pics", length = 330)
	public String getBusLicencePics() {
		return this.busLicencePics;
	}

	public void setBusLicencePics(String busLicencePics) {
		this.busLicencePics = busLicencePics;
	}

	@Column(name = "corporate_icard_pics", length = 330)
	public String getCorporateIcardPics() {
		return this.corporateIcardPics;
	}

	public void setCorporateIcardPics(String corporateIcardPics) {
		this.corporateIcardPics = corporateIcardPics;
	}

	@Column(name = "seller_pics", length = 330)
	public String getSellerPics() {
		return this.sellerPics;
	}

	public void setSellerPics(String sellerPics) {
		this.sellerPics = sellerPics;
	}

	@Column(name = "seller_status", nullable = false)
	public Short getSellerStatus() {
		return this.sellerStatus;
	}

	public void setSellerStatus(Short sellerStatus) {
		this.sellerStatus = sellerStatus;
	}

	@Column(name = "audit_time", length = 19)
	public Timestamp getAuditTime() {
		return this.auditTime;
	}

	public void setAuditTime(Timestamp auditTime) {
		this.auditTime = auditTime;
	}

	@Column(name = "delivery_start", length = 10)
	public String getDeliveryStart() {
		return this.deliveryStart;
	}

	public void setDeliveryStart(String deliveryStart) {
		this.deliveryStart = deliveryStart;
	}

	@Column(name = "delivery_end", length = 10)
	public String getDeliveryEnd() {
		return this.deliveryEnd;
	}

	public void setDeliveryEnd(String deliveryEnd) {
		this.deliveryEnd = deliveryEnd;
	}

	@Column(name = "isopen")
	public Boolean getIsopen() {
		return this.isopen;
	}

	public void setIsopen(Boolean isopen) {
		this.isopen = isopen;
	}

	@Column(name = "latitudes", length = 30)
	public String getLatitudes() {
		return this.latitudes;
	}

	public void setLatitudes(String latitudes) {
		this.latitudes = latitudes;
	}

	@Column(name = "longitudes", length = 30)
	public String getLongitudes() {
		return this.longitudes;
	}

	public void setLongitudes(String longitudes) {
		this.longitudes = longitudes;
	}
}