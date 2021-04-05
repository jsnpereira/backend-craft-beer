package com.craft.beer.model.commons;

import org.modelmapper.ModelMapper;

import com.craft.beer.model.entity.Beer;
import com.craft.beer.model.entity.Company;
import com.craft.beer.model.entity.StyleType;
import com.craft.beer.model.request.BeerRequest;

public class BeerDTO {
	
	public static Beer convertToEntity(BeerRequest beerRequest)  {
		ModelMapper mapper = new ModelMapper();
		Beer b = mapper.map(beerRequest, Beer.class);
		
		if (beerRequest.getCompanyId() != null || !beerRequest.getCompanyId().isEmpty()) {
			Company c = new Company();
			c.setId(beerRequest.getCompanyId());
			b.setCompany(c);
		}
		
		if(beerRequest.getStyleId() != null || !beerRequest.getStyleId().isEmpty()) {
			StyleType st = new StyleType();
			st.setId(beerRequest.getStyleId());
			b.setStyle(st);
		}
		return b;
	}
	
	public static BeerRequest convertToRequest(Beer beer) {
		ModelMapper mapper = new ModelMapper();
		
		BeerRequest beerRequest = mapper.map(beer, BeerRequest.class);
		
		if (beer.getCompany().getId() != null || !beer.getCompany().getId().isEmpty()) {
			beerRequest.setCompanyId(beer.getCompany().getId());
		}
		
		if(beer.getStyle().getId() != null || !beer.getStyle().getId().isEmpty()) {
			beerRequest.setStyleId(beer.getStyle().getId());
		}
		return beerRequest;
	}

}
