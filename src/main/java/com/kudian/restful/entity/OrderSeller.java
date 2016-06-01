package com.kudian.restful.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * OrderSeller entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "order_seller")
public class OrderSeller implements java.io.Serializable {

	// Fields

	private Integer osId;
	private Integer orderId;
	private Integer sellerId;
	private Boolean isFirst;
	private Double firstAmount;
	private Boolean isFullMinus;
	private Double fullAmount;
	private Double minusAmount;
	private Boolean isShippingFree;
	private Double shippingFee;

	// Constructors

	/** default constructor */
	public OrderSeller() {
	}

	/** minimal constructor */
	public OrderSeller(Integer orderId, Integer sellerId, Double shippingFee) {
		this.orderId = orderId;
		this.sellerId = sellerId;
		this.shippingFee = shippingFee;
	}

	/** full constructor */
	public OrderSeller(Integer orderId, Integer sellerId, Boolean isFirst,
			Double firstAmount, Boolean isFullMinus, Double fullAmount,
			Double minusAmount, Boolean isShippingFree, Double shippingFee) {
		this.orderId = orderId;
		this.sellerId = sellerId;
		this.isFirst = isFirst;
		this.firstAmount = firstAmount;
		this.isFullMinus = isFullMinus;
		this.fullAmount = fullAmount;
		this.minusAmount = minusAmount;
		this.isShippingFree = isShippingFree;
		this.shippingFee = shippingFee;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "os_id", unique = true, nullable = false)
	public Integer getOsId() {
		return this.osId;
	}

	public void setOsId(Integer osId) {
		this.osId = osId;
	}

	@Column(name = "order_id", nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "seller_id", nullable = false)
	public Integer getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
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

}