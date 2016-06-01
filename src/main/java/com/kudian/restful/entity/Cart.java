package com.kudian.restful.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Cart entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cart")
public class Cart implements java.io.Serializable {

	// Fields

	private Integer cartId;
	private Integer userId;
	private Integer sellerId;
	private Integer goodsId;
	private String goodsSn;
	private String goodsName;
	private Double goodsPrice;
	private Short goodsNumber;
	private Timestamp addTime;

	// Constructors

	/** default constructor */
	public Cart() {
	}

	/** full constructor */
	public Cart(Integer userId, Integer sellerId, Integer goodsId,
			String goodsSn, String goodsName, Double goodsPrice,
			Short goodsNumber, Timestamp addTime) {
		this.userId = userId;
		this.sellerId = sellerId;
		this.goodsId = goodsId;
		this.goodsSn = goodsSn;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsNumber = goodsNumber;
		this.addTime = addTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cart_id", unique = true, nullable = false)
	public Integer getCartId() {
		return this.cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "seller_id", nullable = false)
	public Integer getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	@Column(name = "goods_id", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "goods_sn", nullable = false, length = 60)
	public String getGoodsSn() {
		return this.goodsSn;
	}

	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}

	@Column(name = "goods_name", nullable = false, length = 120)
	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Column(name = "goods_price", nullable = false, precision = 10)
	public Double getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	@Column(name = "goods_number", nullable = false)
	public Short getGoodsNumber() {
		return this.goodsNumber;
	}

	public void setGoodsNumber(Short goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	@Column(name = "add_time", nullable = false, length = 19)
	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}
}