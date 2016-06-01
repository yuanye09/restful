package com.kudian.restful.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * OrderGoods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "order_goods")
public class OrderGoods implements java.io.Serializable {

	// Fields

	private Integer recId;
	private Integer orderId;
	private Integer goodsId;
	private String goodsName;
	private String goodsSn;
	private Short goodsNumber;
	private Double goodsPrice;
	private String goodsAttr;
	private Short sortOrder;

	// Constructors

	/** default constructor */
	public OrderGoods() {
	}

	/** full constructor */
	public OrderGoods(Integer orderId, Integer goodsId, String goodsName,
			String goodsSn, Short goodsNumber, Double goodsPrice,
			String goodsAttr, Short sortOrder) {
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsSn = goodsSn;
		this.goodsNumber = goodsNumber;
		this.goodsPrice = goodsPrice;
		this.goodsAttr = goodsAttr;
		this.sortOrder = sortOrder;
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

	@Column(name = "order_id", nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "goods_id", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "goods_name", nullable = false, length = 120)
	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Column(name = "goods_sn", nullable = false, length = 60)
	public String getGoodsSn() {
		return this.goodsSn;
	}

	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}

	@Column(name = "goods_number", nullable = false)
	public Short getGoodsNumber() {
		return this.goodsNumber;
	}

	public void setGoodsNumber(Short goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	@Column(name = "goods_price", nullable = false, precision = 10)
	public Double getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	@Column(name = "goods_attr", nullable = false, length = 65535)
	public String getGoodsAttr() {
		return this.goodsAttr;
	}

	public void setGoodsAttr(String goodsAttr) {
		this.goodsAttr = goodsAttr;
	}

	@Column(name = "sort_order", nullable = false)
	public Short getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Short sortOrder) {
		this.sortOrder = sortOrder;
	}

}