package com.craft.beer.model.commons;

import org.modelmapper.ModelMapper;

import com.craft.beer.model.entity.StyleType;
import com.craft.beer.model.request.StyleTypeRequest;

public class StyleTypeDTO {
	
	public static StyleType convertToEntity(StyleTypeRequest styleTypeRequest) {
		ModelMapper mapper = new ModelMapper();
		StyleType s = mapper.map(styleTypeRequest, StyleType.class);
		return s;
	}
	
	public static StyleTypeRequest convertToRequest(StyleType styleType) {
		ModelMapper mapper = new ModelMapper();
		StyleTypeRequest s = mapper.map(styleType, StyleTypeRequest.class);
		return s;
	}

}
