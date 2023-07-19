package com.devpro.SkyTour.services;

import com.devpro.SkyTour.model.BaseEntity;

public interface MappingCustomEntity<E extends BaseEntity> {
	public E convert(Object[] data);
}
