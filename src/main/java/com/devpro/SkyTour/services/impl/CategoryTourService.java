package com.devpro.SkyTour.services.impl;

import org.springframework.stereotype.Service;

import com.devpro.SkyTour.model.CategoryTour;
import com.devpro.SkyTour.services.BaseService;

@Service
public class CategoryTourService extends BaseService<CategoryTour>{

	@Override
	protected Class<CategoryTour> clazz() {
		return CategoryTour.class;
	}
	

}
