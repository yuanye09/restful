package com.kudian.restful.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DeliveryGoods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "delivery_goods")
public class DeliveryGoods implements java.io.Serializable {

	// Fields

	private Integer recId;
	private Integer deliveryId;
	private Integer goodsId;
	private String goodsName;
	private String goodsSn;
	private Boolean isReal;
	private String extensionCode;
	private Short sendNumber;

	// Constructors

	/** default constructor */
	public DeliveryGoods() {
	}

	/** minimal constructor */
	public DeliveryGoods(Integer deliveryId, Integer goodsId) {
		this.deliveryId = deliveryId;
		this.goodsId = goodsId;
	}

	/** full constructor */
	public DeliveryGoods(Integer deliveryId, Integer goodsId, String goodsName,
			String goodsSn, Boolean isReal, String extensionCode,
			Short sendNumber) {
		this.deliveryId = deliveryId;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsSn = goodsSn;
		this.isReal = isReal;
		this.extensionCode = extensionCode;
		this.sendNumber = sendNumber;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "rec_id", unique = true, nullable = false)
	public Integer getRecId() {
		return this.recId;
	}

	public void setRecId(Integer recId) {
		this.recId = recId;
	}

	@Column(name = "delivery_id", nullable = false)
	public Integer getDeliveryId() {
		return this.deliveryId;
	}

	public void setDeliveryId(Integer deliveryId) {
		this.deliveryId = deliveryId;
	}

	@Column(name = "goods_id", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "goods_name", length = 120)
	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Column(name = "goods_sn", length = 60)
	public String getGoodsSn() {
		return this.goodsSn;
	}

	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}

	@Column(name = "is_real")
	public Boolean getIsReal() {
		return this.isReal;
	}

	public void setIsReal(Boolean isReal) {
		this.isReal = isReal;
	}

	@Column(name = "extension_code", length = 30)
	public String getExtensionCode() {
		return this.extensionCode;
	}

	public void setExtensionCode(String extensionCode) {
		this.extensionCode = extensionCode;
	}

	@Column(name = "send_number")
	public Short getSendNumber() {
		return this.sendNumber;
	}

	public void setSendNumber(Short sendNumber) {
		this.sendNumber = sendNumber;
	}

}