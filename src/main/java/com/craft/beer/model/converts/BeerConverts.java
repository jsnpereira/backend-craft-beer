package com.craft.beer.model.converts;

import com.craft.beer.model.entity.Beer;
import com.craft.beer.model.entity.Company;
import com.craft.beer.model.request.BeerRequest;

public class BeerConverts {
	
	public static Beer convertToEntity(BeerRequest beerRequest)  {
		Beer b = new Beer();
		b.setName(beerRequest.getName());
		b.setOrigem(beerRequest.getOrigem());
		b.setStyle(beerRequest.getStyle());
		b.setIbu(beerRequest.getIbu());
		b.setAbv(beerRequest.getAbv());
		b.setVolume(beerRequest.getVolume());
		
		if (beerRequest.getCompanyId() != null && !beerRequest.getId().isEmpty()) {
			Company c = new Company();
			c.setId(beerRequest.getCompanyId());
			b.setCompany(c);
		}
		
		return b;
	}
	
	public static BeerRequest convertToRequest(Beer beer) {
		BeerRequest br = new BeerRequest();
		br.setName(beer.getName());
		br.setOrigem(beer.getOrigem());
		br.setStyle(beer.getStyle());
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
		beer.setStyle(beerRequest.getStyle());
		beer.setIbu(beerRequest.getIbu());
		beer.setAbv(beerRequest.getAbv());
		beer.setVolume(beerRequest.getVolume());
	}

}
