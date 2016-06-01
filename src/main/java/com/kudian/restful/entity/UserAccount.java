package com.kudian.restful.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserAccount entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_account")
public class UserAccount implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private Double amount;
	private Boolean processType;
	private String payment;
	private Boolean isPaid;
	private String adminUser;
	private Timestamp addTime;
	private Timestamp paidTime;

	// Constructors

	/** default constructor */
	public UserAccount() {
	}

	/** full constructor */
	public UserAccount(Integer userId, Double amount, Boolean processType,
			String payment, Boolean isPaid, String adminUser,
			Timestamp addTime, Timestamp paidTime) {
		this.userId = userId;
		this.amount = amount;
		this.processType = processType;
		this.payment = payment;
		this.isPaid = isPaid;
		this.adminUser = adminUser;
		this.addTime = addTime;
		this.paidTime = paidTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "amount", nullable = false, precision = 10)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name = "process_type", nullable = false)
	public Boolean getProcessType() {
		return this.processType;
	}

	public void setProcessType(Boolean processType) {
		this.processType = processType;
	}

	@Column(name = "payment", nullable = false, length = 90)
	public String getPayment() {
		return this.payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	@Column(name = "is_paid", nullable = false)
	public Boolean getIsPaid() {
		return this.isPaid;
	}

	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}

	@Column(name = "admin_user", nullable = false)
	public String getAdminUser() {
		return this.adminUser;
	}

	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}

	@Column(name = "add_time", nullable = false, length = 19)
	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	@Column(name = "paid_time", nullable = false, length = 19)
	public Timestamp getPaidTime() {
		return this.paidTime;
	}

	public void setPaidTime(Timestamp paidTime) {
		this.paidTime = paidTime;
	}

}