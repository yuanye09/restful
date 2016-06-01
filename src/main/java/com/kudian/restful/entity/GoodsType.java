package com.kudian.restful.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GoodsType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goods_type")
public class GoodsType implements java.io.Serializable {

	// Fields

	private Short gtId;
	private String gtName;
	private Boolean enabled;
	private String attrGroup;
	private String pic;

	// Constructors

	/** default constructor */
	public GoodsType() {
	}

	/** full constructor */
	public GoodsType(String gtName, Boolean enabled, String attrGroup,
			String pic) {
		this.gtName = gtName;
		this.enabled = enabled;
		this.attrGroup = attrGroup;
		this.pic = pic;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "gt_id", unique = true, nullable = false)
	public Short getGtId() {
		return this.gtId;
	}

	public void setGtId(Short gtId) {
		this.gtId = gtId;
	}

	@Column(name = "gt_name", nullable = false, length = 60)
	public String getGtName() {
		return this.gtName;
	}

	public void setGtName(String gtName) {
		this.gtName = gtName;
	}

	@Column(name = "enabled", nullable = false)
	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "attr_group", nullable = false)
	public String getAttrGroup() {
		return this.attrGroup;
	}

	public void setAttrGroup(String attrGroup) {
		this.attrGroup = attrGroup;
	}

	@Column(name = "pic", nullable = false, length = 32)
	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
}