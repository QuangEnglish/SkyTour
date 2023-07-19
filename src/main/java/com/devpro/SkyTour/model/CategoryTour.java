package com.devpro.SkyTour.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.OneToMany;
import javax.persistence.FetchType;

@Entity
@Table(name = "tbl_category_tour")
public class CategoryTour extends BaseEntity{
    @Column(name="name", length=100, nullable=false)
    private String name;
	@Column(name = "number_guest") // tên colunm mapping với property này
	private Integer numberGuest;
    @Column(name="avatar", length=200, nullable=false)
    private String avatar;
	@Column(name = "is_love", nullable = true)
	private Boolean isLove = Boolean.TRUE;	
	
	@OneToMany(cascade = CascadeType.ALL,
				fetch = FetchType.LAZY, 
				mappedBy = "categoryTour")
	private Set<ProductTour> productTours = new HashSet<ProductTour>();	
	// qui tắc: Trong phía One-To-Many thì cần 2 methods sau:
	public void addProductTour(ProductTour productTour) {
		productTours.add(productTour);
		productTour.setCategoryTour(this);
	}
	public void deleteProductTour(ProductTour productTour) {
		productTours.remove(productTour);
		productTour.setCategoryTour(null);
	}
	public Set<ProductTour> getProductTours() {
		return productTours;
	}
	public void setProductTours(Set<ProductTour> productTours) {
		this.productTours = productTours;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumberGuest() {
		return numberGuest;
	}
	public void setNumberGuest(Integer numberGuest) {
		this.numberGuest = numberGuest;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Boolean getIsLove() {
		return isLove;
	}
	public void setIsLove(Boolean isLove) {
		this.isLove = isLove;
	}


	
    
}
