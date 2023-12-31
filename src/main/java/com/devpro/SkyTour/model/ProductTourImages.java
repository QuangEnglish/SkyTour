package com.devpro.SkyTour.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "tblt_product_tour_images")
public class ProductTourImages extends BaseEntity{
    @Column(name="title", length=500, nullable=false)
    private String title;
    @Column(name="path", length=200, nullable=false)
    private String path;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_tour_id")
	private ProductTour productTour;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public ProductTour getProductTour() {
		return productTour;
	}
	public void setProductTour(ProductTour productTour) {
		this.productTour = productTour;
	}
	
}
