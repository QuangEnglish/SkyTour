package com.devpro.SkyTour.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_saleorder")
public class SaleOrder extends BaseEntity {
	@Column(name = "code",length = 45, nullable = false)
	private String code;

	@Column(name = "total", precision = 13, scale = 2, nullable = false)
	private BigDecimal total;

	@Column(name = "customer_name",length = 100, nullable = false)
	private String customerName;

	@Column(name = "customer_phone",length = 100, nullable = false)
	private String customerPhone;

	@Column(name = "customer_email",length = 100, nullable = false)
	private String customerEmail;
	
	@Column(name = "note",length = 200, nullable = true)
	private String note;
	
	@Column(name = "number_adult", nullable = false)
	private Integer numberAdult;
	
	@Column(name = "number_children_big", nullable = false)
	private Integer numberChildrenBig;
	
	@Column(name = "number_children_normal", nullable = false)
	private Integer numberChildrenNormal;
	
	@Column(name = "number_children_small", nullable = false)
	private Integer numberChildrenSmall;
	
	@Column(name = "seo",length = 200, nullable = true)
	private String seo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getNumberAdult() {
		return numberAdult;
	}

	public void setNumberAdult(Integer numberAdult) {
		this.numberAdult = numberAdult;
	}

	public Integer getNumberChildrenBig() {
		return numberChildrenBig;
	}

	public void setNumberChildrenBig(Integer numberChildrenBig) {
		this.numberChildrenBig = numberChildrenBig;
	}

	public Integer getNumberChildrenNormal() {
		return numberChildrenNormal;
	}

	public void setNumberChildrenNormal(Integer numberChildrenNormal) {
		this.numberChildrenNormal = numberChildrenNormal;
	}

	public Integer getNumberChildrenSmall() {
		return numberChildrenSmall;
	}

	public void setNumberChildrenSmall(Integer numberChildrenSmall) {
		this.numberChildrenSmall = numberChildrenSmall;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	
}
