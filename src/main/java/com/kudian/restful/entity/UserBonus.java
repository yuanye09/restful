package com.kudian.restful.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserBonus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_bonus", catalog = "restful")
public class UserBonus implements java.io.Serializable {

	// Fields

	private Integer bonusId;
	private Short bonusTypeId;
	private Long bonusSn;
	private Integer userId;
	private Short typeId;
	private Integer usedTime;
	private Integer orderId;
	private Short emailed;

	// Constructors

	/** default constructor */
	public UserBonus() {
	}

	/** minimal constructor */
	public UserBonus(Short bonusTypeId, Long bonusSn, Integer userId,
			Integer usedTime, Integer orderId, Short emailed) {
		this.bonusTypeId = bonusTypeId;
		this.bonusSn = bonusSn;
		this.userId = userId;
		this.usedTime = usedTime;
		this.orderId = orderId;
		this.emailed = emailed;
	}

	/** full constructor */
	public UserBonus(Short bonusTypeId, Long bonusSn, Integer userId,
			Short typeId, Integer usedTime, Integer orderId, Short emailed) {
		this.bonusTypeId = bonusTypeId;
		this.bonusSn = bonusSn;
		this.userId = userId;
		this.typeId = typeId;
		this.usedTime = usedTime;
		this.orderId = orderId;
		this.emailed = emailed;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "bonus_id", unique = true, nullable = false)
	public Integer getBonusId() {
		return this.bonusId;
	}

	public void setBonusId(Integer bonusId) {
		this.bonusId = bonusId;
	}

	@Column(name = "bonus_type_id", nullable = false)
	public Short getBonusTypeId() {
		return this.bonusTypeId;
	}

	public void setBonusTypeId(Short bonusTypeId) {
		this.bonusTypeId = bonusTypeId;
	}

	@Column(name = "bonus_sn", nullable = false)
	public Long getBonusSn() {
		return this.bonusSn;
	}

	public void setBonusSn(Long bonusSn) {
		this.bonusSn = bonusSn;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "type_id")
	public Short getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Short typeId) {
		this.typeId = typeId;
	}

	@Column(name = "used_time", nullable = false)
	public Integer getUsedTime() {
		return this.usedTime;
	}

	public void setUsedTime(Integer usedTime) {
		this.usedTime = usedTime;
	}

	@Column(name = "order_id", nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "emailed", nullable = false)
	public Short getEmailed() {
		return this.emailed;
	}

	public void setEmailed(Short emailed) {
		this.emailed = emailed;
	}

}