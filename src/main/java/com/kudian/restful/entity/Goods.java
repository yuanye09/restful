package com.kudian.restful.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.sql.Timestamp;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goods")
public class Goods implements java.io.Serializable {

	// Fields

	private Integer goodsId;
	private Integer catId;
	private String goodsSn;
	private String goodsName;
	private Integer clickCount;
	private Short brandId;
	private Double shopPrice;
	private String keywords;
	private String goodsBrief;
	private String goodsDesc;
	private Integer inventory;
	private String measureUnit;
	private String unitDesc;
	private Short isReal;
	private Boolean isOnSale;
	private Boolean isShipping;
	private Timestamp addTime;
	private Short sortOrder;
	private Boolean isDelete;
	private Boolean isBest;
	private Boolean isNew;
	private Boolean isHot;
	private Boolean isPromote;
	private Timestamp lastUpdate;
	private String area;
	private Integer sellerId;
	private String sellerNote;
	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** minimal constructor */
	public Goods(Integer catId, String goodsSn, String goodsName,
			Integer clickCount, Short brandId, Double shopPrice,
			String keywords, String goodsBrief, String goodsDesc,
			Integer inventory, String measureUnit, Short isReal,
			Boolean isOnSale, Boolean isShipping, Timestamp addTime,
			Short sortOrder, Boolean isDelete, Boolean isBest, Boolean isNew,
			Boolean isHot, Boolean isPromote, Timestamp lastUpdate,
			String sellerNote) {
		this.catId = catId;
		this.goodsSn = goodsSn;
		this.goodsName = goodsName;
		this.clickCount = clickCount;
		this.brandId = brandId;
		this.shopPrice = shopPrice;
		this.keywords = keywords;
		this.goodsBrief = goodsBrief;
		this.goodsDesc = goodsDesc;
		this.inventory = inventory;
		this.measureUnit = measureUnit;
		this.isReal = isReal;
		this.isOnSale = isOnSale;
		this.isShipping = isShipping;
		this.addTime = addTime;
		this.sortOrder = sortOrder;
		this.isDelete = isDelete;
		this.isBest = isBest;
		this.isNew = isNew;
		this.isHot = isHot;
		this.isPromote = isPromote;
		this.lastUpdate = lastUpdate;
		this.sellerNote = sellerNote;
	}

	/** full constructor */
	public Goods(Integer catId, String goodsSn, String goodsName,
			Integer clickCount, Short brandId, Double shopPrice,
			String keywords, String goodsBrief, String goodsDesc,
			Integer inventory, String measureUnit, String unitDesc,
			Short isReal, Boolean isOnSale, Boolean isShipping,
			Timestamp addTime, Short sortOrder, Boolean isDelete,
			Boolean isBest, Boolean isNew, Boolean isHot, Boolean isPromote,
			Timestamp lastUpdate, String area, Integer sellerId,
			String sellerNote) {
		this.catId = catId;
		this.goodsSn = goodsSn;
		this.goodsName = goodsName;
		this.clickCount = clickCount;
		this.brandId = brandId;
		this.shopPrice = shopPrice;
		this.keywords = keywords;
		this.goodsBrief = goodsBrief;
		this.goodsDesc = goodsDesc;
		this.inventory = inventory;
		this.measureUnit = measureUnit;
		this.unitDesc = unitDesc;
		this.isReal = isReal;
		this.isOnSale = isOnSale;
		this.isShipping = isShipping;
		this.addTime = addTime;
		this.sortOrder = sortOrder;
		this.isDelete = isDelete;
		this.isBest = isBest;
		this.isNew = isNew;
		this.isHot = isHot;
		this.isPromote = isPromote;
		this.lastUpdate = lastUpdate;
		this.area = area;
		this.sellerId = sellerId;
		this.sellerNote = sellerNote;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "goods_id", unique = true, nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "cat_id", nullable = false)
	public Integer getCatId() {
		return this.catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
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

	@Column(name = "click_count", nullable = false)
	public Integer getClickCount() {
		return this.clickCount;
	}

	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}

	@Column(name = "brand_id", nullable = false)
	public Short getBrandId() {
		return this.brandId;
	}

	public void setBrandId(Short brandId) {
		this.brandId = brandId;
	}

	@Column(name = "shop_price", nullable = false, precision = 10)
	public Double getShopPrice() {
		return this.shopPrice;
	}

	public void setShopPrice(Double shopPrice) {
		this.shopPrice = shopPrice;
	}

	@Column(name = "keywords", nullable = false)
	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Column(name = "goods_brief", nullable = false)
	public String getGoodsBrief() {
		return this.goodsBrief;
	}

	public void setGoodsBrief(String goodsBrief) {
		this.goodsBrief = goodsBrief;
	}

	@Column(name = "goods_desc", nullable = false, length = 65535)
	public String getGoodsDesc() {
		return this.goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	@Column(name = "inventory", nullable = false)
	public Integer getInventory() {
		return this.inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	@Column(name = "measure_unit", nullable = false, length = 15)
	public String getMeasureUnit() {
		return this.measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	@Column(name = "unit_desc", length = 50)
	public String getUnitDesc() {
		return this.unitDesc;
	}

	public void setUnitDesc(String unitDesc) {
		this.unitDesc = unitDesc;
	}

	@Column(name = "is_real", nullable = false)
	public Short getIsReal() {
		return this.isReal;
	}

	public void setIsReal(Short isReal) {
		this.isReal = isReal;
	}

	@Column(name = "is_on_sale", nullable = false)
	public Boolean getIsOnSale() {
		return this.isOnSale;
	}

	public void setIsOnSale(Boolean isOnSale) {
		this.isOnSale = isOnSale;
	}

	@Column(name = "is_shipping", nullable = false)
	public Boolean getIsShipping() {
		return this.isShipping;
	}

	public void setIsShipping(Boolean isShipping) {
		this.isShipping = isShipping;
	}

	@Column(name = "add_time", nullable = false, length = 19)
	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	@Column(name = "sort_order", nullable = false)
	public Short getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Short sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Column(name = "is_delete", nullable = false)
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Column(name = "is_best", nullable = false)
	public Boolean getIsBest() {
		return this.isBest;
	}

	public void setIsBest(Boolean isBest) {
		this.isBest = isBest;
	}

	@Column(name = "is_new", nullable = false)
	public Boolean getIsNew() {
		return this.isNew;
	}

	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

	@Column(name = "is_hot", nullable = false)
	public Boolean getIsHot() {
		return this.isHot;
	}

	public void setIsHot(Boolean isHot) {
		this.isHot = isHot;
	}

	@Column(name = "is_promote", nullable = false)
	public Boolean getIsPromote() {
		return this.isPromote;
	}

	public void setIsPromote(Boolean isPromote) {
		this.isPromote = isPromote;
	}

	@Column(name = "last_update", nullable = false, length = 19)
	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Column(name = "area", length = 50)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "seller_id")
	public Integer getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	@Column(name = "seller_note", nullable = false)
	public String getSellerNote() {
		return this.sellerNote;
	}

	public void setSellerNote(String sellerNote) {
		this.sellerNote = sellerNote;
	}

}