package com.kudian.restful.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PayLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pay_log")
public class PayLog implements java.io.Serializable {

	// Fields

	private Integer logId;
	private Integer orderId;
	private Double orderAmount;
	private Boolean orderType;
	private Boolean isPaid;

	// Constructors

	/** default constructor */
	public PayLog() {
	}

	/** full constructor */
	public PayLog(Integer orderId, Double orderAmount, Boolean orderType,
			Boolean isPaid) {
		this.orderId = orderId;
		this.orderAmount = orderAmount;
		this.orderType = orderType;
		this.isPaid = isPaid;
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

	@Column(name = "order_id", nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "order_amount", nullable = false, precision = 10)
	public Double getOrderAmount() {
		return this.orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	@Column(name = "order_type", nullable = false)
	public Boolean getOrderType() {
		return this.orderType;
	}

	public void setOrderType(Boolean orderType) {
		this.orderType = orderType;
	}

	@Column(name = "is_paid", nullable = false)
	public Boolean getIsPaid() {
		return this.isPaid;
	}

	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}

}