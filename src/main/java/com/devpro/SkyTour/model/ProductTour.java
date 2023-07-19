package com.devpro.SkyTour.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_product_tour")
public class ProductTour extends BaseEntity{
    @Column(name="code", length=45, nullable=false)
    private String code;
    @Column(name="name", length=200, nullable=false)
    private String name;
    @Column(name="time", length=300, nullable=false)
    private String time;
    @Column(name="time_start", length=45, nullable=false)
    private String timeStart;
    @Column(name="vehicle", length=45, nullable=false)
    private String vehicle;
    @Column(name="address_start", length=100, nullable=false)
    private String addressStart;
	@Column(name = "price", precision = 13, scale = 2, nullable = false)
	private BigDecimal price;
	@Column(name = "price_sale", precision = 13, scale = 2, nullable = true)
	private BigDecimal priceSale;
    @Column(name="avatar", length=200, nullable=false)
    private String avatar;
	@Column(name = "assess", nullable=false) 
	private Float assess;
	@Lob
	@Column(name = "highlight_tour", nullable = false, columnDefinition = "LONGTEXT")
	private String highlightTour;
	@Lob
	@Column(name = "service_tour", nullable = false, columnDefinition = "LONGTEXT")
	private String serviceTour;
	@Column(name = "is_hot", nullable = true)
	private Boolean isHot = Boolean.TRUE;
	@Column(name = "is_sale", nullable = true)
	private Boolean isSale = Boolean.TRUE;
    @Column(name="seo", length=1000, nullable=true)
    private String seo;
	
	@OneToMany(cascade = CascadeType.ALL,
				fetch = FetchType.EAGER,
				mappedBy = "productTour")
	private Set<ProductTourImages> productTourImages = new HashSet<ProductTourImages>();
	public void addProductTourImages(ProductTourImages _proProductTourImages) {
		_proProductTourImages.setProductTour(this);
		productTourImages.add(_proProductTourImages);
	}
	public void deleteProductTourImages(ProductTourImages _proProductTourImages) {
		_proProductTourImages.setProductTour(null);
		productTourImages.remove(_proProductTourImages);
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private CategoryTour categoryTour;
	
	
	
	public Set<ProductTourImages> getProductTourImages() {
		return productTourImages;
	}
	public void setProductTourImages(Set<ProductTourImages> productTourImages) {
		this.productTourImages = productTourImages;
	}
	public CategoryTour getCategoryTour() {
		return categoryTour;
	}
	public void setCategoryTour(CategoryTour categoryTour) {
		this.categoryTour = categoryTour;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public String getAddressStart() {
		return addressStart;
	}
	public void setAddressStart(String addressStart) {
		this.addressStart = addressStart;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getPriceSale() {
		return priceSale;
	}
	public void setPriceSale(BigDecimal priceSale) {
		this.priceSale = priceSale;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Float getAssess() {
		return assess;
	}
	public void setAssess(Float assess) {
		this.assess = assess;
	}
	public String getHighlightTour() {
		return highlightTour;
	}
	public void setHighlightTour(String highlightTour) {
		this.highlightTour = highlightTour;
	}
	public String getServiceTour() {
		return serviceTour;
	}
	public void setServiceTour(String serviceTour) {
		this.serviceTour = serviceTour;
	}
	public Boolean getIsHot() {
		return isHot;
	}
	public void setIsHot(Boolean isHot) {
		this.isHot = isHot;
	}
	public Boolean getIsSale() {
		return isSale;
	}
	public void setIsSale(Boolean isSale) {
		this.isSale = isSale;
	}
	public String getSeo() {
		return seo;
	}
	public void setSeo(String seo) {
		this.seo = seo;
	}
	
    
}
