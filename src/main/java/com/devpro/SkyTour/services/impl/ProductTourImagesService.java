package com.devpro.SkyTour.services.impl;

import org.springframework.stereotype.Service;

import com.devpro.SkyTour.model.ProductTourImages;
import com.devpro.SkyTour.services.BaseService;

@Service
public class ProductTourImagesService extends BaseService<ProductTourImages>{

	@Override
	protected Class<ProductTourImages> clazz() {
		// TODO Auto-generated method stub
		return ProductTourImages.class;
	}

}
