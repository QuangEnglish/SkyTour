package com.devpro.SkyTour.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "tbl_day")
public class DayTour extends BaseEntity{
	
	
	@Column(name = "day_number", nullable = false)
	private Integer dayNumber;
	
	@Column(name = "day_name", length = 200, nullable = false)
	private String dayName;
	
	@Lob
	@Column(name = "day_content", nullable = false, columnDefinition = "LONGTEXT")
	private String dayContent;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_tour_id")
	private ProductTour productTour;

	public Integer getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(Integer dayNumber) {
		this.dayNumber = dayNumber;
	}

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public String getDayContent() {
		return dayContent;
	}

	public void setDayContent(String dayContent) {
		this.dayContent = dayContent;
	}

	public ProductTour getProductTour() {
		return productTour;
	}

	public void setProductTour(ProductTour productTour) {
		this.productTour = productTour;
	}
	

}
