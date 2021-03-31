package com.craft.beer.model.converts;

import com.craft.beer.model.entity.StyleType;
import com.craft.beer.model.request.StyleTypeRequest;

public class StyleTypeConvert {
	
	public static StyleType convertToEntity(StyleTypeRequest styleTypeRequest) {
		StyleType s = new StyleType();
		s.setName(styleTypeRequest.getName());
		s.setDescription(styleTypeRequest.getDescription());
		s.setOrigem(styleTypeRequest.getOrigem());
		s.setCup(styleTypeRequest.getCup());
		return s;
	}
	
	public static StyleTypeRequest convertToRequest(StyleType styleType) {
		StyleTypeRequest s = new StyleTypeRequest();
		s.setName(styleType.getName());
		s.setDescription(styleType.getDescription());
		s.setOrigem(styleType.getOrigem());
		s.setCup(styleType.getCup());
		s.setId(styleType.getId());
		return s;
	}
	
	public static void update(StyleType s, StyleTypeRequest styleTypeRequest) {
		s.setName(styleTypeRequest.getName());
		s.setDescription(styleTypeRequest.getDescription());
		s.setOrigem(styleTypeRequest.getOrigem());
		s.setCup(styleTypeRequest.getCup());
	}

}
