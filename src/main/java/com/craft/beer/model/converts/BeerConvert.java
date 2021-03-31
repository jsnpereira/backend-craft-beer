package com.craft.beer.model.converts;

import com.craft.beer.model.entity.Beer;
import com.craft.beer.model.entity.Company;
import com.craft.beer.model.entity.StyleType;
import com.craft.beer.model.request.BeerRequest;

public class BeerConvert {
	
	public static Beer convertToEntity(BeerRequest beerRequest)  {
		Beer b = new Beer();
		b.setName(beerRequest.getName());
		b.setOrigem(beerRequest.getOrigem());
		
		b.setIbu(beerRequest.getIbu());
		b.setAbv(beerRequest.getAbv());
		b.setVolume(beerRequest.getVolume());
		
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
		BeerRequest br = new BeerRequest();
		br.setName(beer.getName());
		br.setOrigem(beer.getOrigem());
		br.setStyleId(beer.getStyle().getId());
		br.setIbu(beer.getIbu());
		br.setAbv(beer.getAbv());
		br.setId(beer.getId());
		br.setVolume(beer.getVolume());
		br.setCompanyId(beer.getCompany().getId());
		return br;
	}
	
	public static void setUpUpdate(Beer beer, BeerRequest beerRequest) {
		beer.setName(beerRequest.getName());
		beer.setOrigem(beerRequest.getOrigem());
		beer.setIbu(beerRequest.getIbu());
		beer.setAbv(beerRequest.getAbv());
		beer.setVolume(beerRequest.getVolume());
		
		if (beerRequest.getCompanyId() != null || !beerRequest.getCompanyId().isEmpty()) {
			Company c = new Company();
			c.setId(beerRequest.getCompanyId());
			beer.setCompany(c);
		}
		
		if(beerRequest.getStyleId() != null || !beerRequest.getStyleId().isEmpty()) {
			StyleType st = new StyleType();
			st.setId(beerRequest.getStyleId());
			beer.setStyle(st);
		}
	}

}
