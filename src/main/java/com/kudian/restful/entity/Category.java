package com.kudian.restful.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "category")
public class Category implements java.io.Serializable {

	// Fields

	private Integer catId;
	private Integer sellerId;
	private String catName;
	private String keywords;
	private String catDesc;
	private Integer parentId;
	private Short sortOrder;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** minimal constructor */
	public Category(String catName, String keywords, String catDesc,
			Integer parentId, Short sortOrder) {
		this.catName = catName;
		this.keywords = keywords;
		this.catDesc = catDesc;
		this.parentId = parentId;
		this.sortOrder = sortOrder;
	}

	/** full constructor */
	public Category(Integer sellerId, String catName, String keywords,
			String catDesc, Integer parentId, Short sortOrder) {
		this.sellerId = sellerId;
		this.catName = catName;
		this.keywords = keywords;
		this.catDesc = catDesc;
		this.parentId = parentId;
		this.sortOrder = sortOrder;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cat_id", unique = true, nullable = false)
	public Integer getCatId() {
		return this.catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	@Column(name = "seller_id")
	public Integer getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	@Column(name = "cat_name", nullable = false, length = 90)
	public String getCatName() {
		return this.catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	@Column(name = "keywords", nullable = false)
	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Column(name = "cat_desc", nullable = false)
	public String getCatDesc() {
		return this.catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	@Column(name = "parent_id", nullable = false)
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "sort_order", nullable = false)
	public Short getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Short sortOrder) {
		this.sortOrder = sortOrder;
	}

}