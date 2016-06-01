package com.kudian.restful.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BonusType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bonus_type", catalog = "restful")
public class BonusType implements java.io.Serializable {

	// Fields

	private Short typeId;
	private String typeName;
	private Double typeMoney;
	private Short sendType;
	private Double minAmount;
	private Double maxAmount;
	private Integer sendStartDate;
	private Integer sendEndDate;
	private Integer useStartDate;
	private Integer useEndDate;
	private Double minGoodsAmount;

	// Constructors

	/** default constructor */
	public BonusType() {
	}

	/** full constructor */
	public BonusType(String typeName, Double typeMoney, Short sendType,
			Double minAmount, Double maxAmount, Integer sendStartDate,
			Integer sendEndDate, Integer useStartDate, Integer useEndDate,
			Double minGoodsAmount) {
		this.typeName = typeName;
		this.typeMoney = typeMoney;
		this.sendType = sendType;
		this.minAmount = minAmount;
		this.maxAmount = maxAmount;
		this.sendStartDate = sendStartDate;
		this.sendEndDate = sendEndDate;
		this.useStartDate = useStartDate;
		this.useEndDate = useEndDate;
		this.minGoodsAmount = minGoodsAmount;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "type_id", unique = true, nullable = false)
	public Short getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Short typeId) {
		this.typeId = typeId;
	}

	@Column(name = "type_name", nullable = false, length = 60)
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Column(name = "type_money", nullable = false, precision = 10)
	public Double getTypeMoney() {
		return this.typeMoney;
	}

	public void setTypeMoney(Double typeMoney) {
		this.typeMoney = typeMoney;
	}

	@Column(name = "send_type", nullable = false)
	public Short getSendType() {
		return this.sendType;
	}

	public void setSendType(Short sendType) {
		this.sendType = sendType;
	}

	@Column(name = "min_amount", nullable = false, precision = 10)
	public Double getMinAmount() {
		return this.minAmount;
	}

	public void setMinAmount(Double minAmount) {
		this.minAmount = minAmount;
	}

	@Column(name = "max_amount", nullable = false, precision = 10)
	public Double getMaxAmount() {
		return this.maxAmount;
	}

	public void setMaxAmount(Double maxAmount) {
		this.maxAmount = maxAmount;
	}

	@Column(name = "send_start_date", nullable = false)
	public Integer getSendStartDate() {
		return this.sendStartDate;
	}

	public void setSendStartDate(Integer sendStartDate) {
		this.sendStartDate = sendStartDate;
	}

	@Column(name = "send_end_date", nullable = false)
	public Integer getSendEndDate() {
		return this.sendEndDate;
	}

	public void setSendEndDate(Integer sendEndDate) {
		this.sendEndDate = sendEndDate;
	}

	@Column(name = "use_start_date", nullable = false)
	public Integer getUseStartDate() {
		return this.useStartDate;
	}

	public void setUseStartDate(Integer useStartDate) {
		this.useStartDate = useStartDate;
	}

	@Column(name = "use_end_date", nullable = false)
	public Integer getUseEndDate() {
		return this.useEndDate;
	}

	public void setUseEndDate(Integer useEndDate) {
		this.useEndDate = useEndDate;
	}

	@Column(name = "min_goods_amount", nullable = false, precision = 10)
	public Double getMinGoodsAmount() {
		return this.minGoodsAmount;
	}

	public void setMinGoodsAmount(Double minGoodsAmount) {
		this.minGoodsAmount = minGoodsAmount;
	}

}