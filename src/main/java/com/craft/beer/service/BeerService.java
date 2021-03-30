package com.craft.beer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.craft.beer.expcetions.IdMandatoryException;
import com.craft.beer.expcetions.IdRequiredPathException;
import com.craft.beer.expcetions.ResourceNotFoundException;
import com.craft.beer.model.converts.BeerConverts;
import com.craft.beer.model.entity.Beer;
import com.craft.beer.model.request.BeerRequest;
import com.craft.beer.repository.BeerRepository;

@Service
public class BeerService {
	private final BeerRepository beerRepository;

	@Autowired
	public BeerService(BeerRepository beerRepository) {
		this.beerRepository = beerRepository;
	}

	public BeerRequest save(BeerRequest beerRequest) {
		if(beerRequest.getCompanyId() == null || beerRequest.getCompanyId().isEmpty()) {
			throw new IdMandatoryException("Company ID attribute is mandatory");
		}
		Beer b = beerRepository.save(BeerConverts.convertToEntity(beerRequest));
		beerRequest.setId(b.getId());
		return beerRequest;
	}

	public List<BeerRequest> getAllBeers() {
		List<BeerRequest> requestsList = new ArrayList<>();
		List<Beer> lists = beerRepository.findAll();
		for (Beer beer : lists) {
			requestsList.add(BeerConverts.convertToRequest(beer));
		}
		return requestsList;
	}

	public BeerRequest getBeerById(String id) {
		Optional<Beer> beer = beerRepository.findById(id);

		if (beer.isPresent()) {
			return BeerConverts.convertToRequest(beer.get());
		}
		return null;
	}

	public BeerRequest updateBeer(String id, BeerRequest beerRequest) {
		Optional<Beer> b = Optional.of(beerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id[" + id + "] not found in our database")));

		if (b.isPresent()) {
			Beer beer = b.get();
			BeerConverts.setUpUpdate(beer, beerRequest);
			beerRepository.save(beer);
			beerRequest.setId(beer.getId());
			return beerRequest;
		}
		return null;

	}
}
