package com.kudian.restful.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GoodsPic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goods_pic")
public class GoodsPic implements java.io.Serializable {

	// Fields

	private Integer goodsPicId;
	private Integer goodsId;
	private String mediaId;
	private Short sortOrder;
	private Boolean isDelete;
	private Timestamp lastTime;
	private Short direction;

	// Constructors

	/** default constructor */
	public GoodsPic() {
	}

	/** full constructor */
	public GoodsPic(Integer goodsId, String mediaId, Short sortOrder,
			Boolean isDelete, Timestamp lastTime) {
		this.goodsId = goodsId;
		this.mediaId = mediaId;
		this.sortOrder = sortOrder;
		this.isDelete = isDelete;
		this.lastTime = lastTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "goods_pic_id", unique = true, nullable = false)
	public Integer getGoodsPicId() {
		return this.goodsPicId;
	}

	public void setGoodsPicId(Integer goodsPicId) {
		this.goodsPicId = goodsPicId;
	}

	@Column(name = "goods_id", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "media_id", nullable = false, length = 32)
	public String getMediaId() {
		return this.mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
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

	@Column(name = "last_time", nullable = false, length = 19)
	public Timestamp getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

	@Column(name = "direction", nullable = false)
	public Short getDirection() {
		return direction;
	}

	public void setDirection(Short direction) {
		this.direction = direction;
	}
}