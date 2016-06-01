package com.kudian.restful.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Shipping entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "shipping")
public class Shipping implements java.io.Serializable {

	// Fields

	private Short shippingId;
	private String shippingCode;
	private String shippingName;
	private String shippingDesc;
	private Boolean enabled;
	private Short shippingOrder;

	// Constructors

	/** default constructor */
	public Shipping() {
	}

	/** full constructor */
	public Shipping(String shippingCode, String shippingName,
			String shippingDesc, Boolean enabled, Short shippingOrder) {
		this.shippingCode = shippingCode;
		this.shippingName = shippingName;
		this.shippingDesc = shippingDesc;
		this.enabled = enabled;
		this.shippingOrder = shippingOrder;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "shipping_id", unique = true, nullable = false)
	public Short getShippingId() {
		return this.shippingId;
	}

	public void setShippingId(Short shippingId) {
		this.shippingId = shippingId;
	}

	@Column(name = "shipping_code", nullable = false, length = 20)
	public String getShippingCode() {
		return this.shippingCode;
	}

	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
	}

	@Column(name = "shipping_name", nullable = false, length = 120)
	public String getShippingName() {
		return this.shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	@Column(name = "shipping_desc", nullable = false)
	public String getShippingDesc() {
		return this.shippingDesc;
	}

	public void setShippingDesc(String shippingDesc) {
		this.shippingDesc = shippingDesc;
	}

	@Column(name = "enabled", nullable = false)
	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "shipping_order", nullable = false)
	public Short getShippingOrder() {
		return this.shippingOrder;
	}

	public void setShippingOrder(Short shippingOrder) {
		this.shippingOrder = shippingOrder;
	}

}