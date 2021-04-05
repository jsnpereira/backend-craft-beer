package com.craft.beer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.craft.beer.expcetions.IdMandatoryException;
import com.craft.beer.expcetions.IdRequiredPathException;
import com.craft.beer.expcetions.ResourceNotFoundException;
import com.craft.beer.model.commons.BeerDTO;
import com.craft.beer.model.entity.Beer;
import com.craft.beer.model.request.BeerRequest;
import com.craft.beer.repository.BeerRepository;

@Service
public class BeerService {
	private String ID_MANDATORY = "Company ID attribute is mandatory";
	private String ID_NOT_FOUND = "Beer Id[XXX] not found in our database";
	
	
	private final BeerRepository beerRepository;

	@Autowired
	public BeerService(BeerRepository beerRepository) {
		this.beerRepository = beerRepository;
	}

	public BeerRequest save(BeerRequest beerRequest) {
		if(beerRequest.getCompanyId() == null || beerRequest.getCompanyId().isEmpty()) {
			throw new IdMandatoryException(ID_MANDATORY);
		}
		Beer b = beerRepository.save(BeerDTO.convertToEntity(beerRequest));
		beerRequest.setId(b.getId());
		return beerRequest;
	}

	public List<BeerRequest> getAllBeers() {
		List<BeerRequest> requestsList = new ArrayList<>();
		List<Beer> lists = beerRepository.findAll();
		for (Beer beer : lists) {
			requestsList.add(BeerDTO.convertToRequest(beer));
		}
		return requestsList;
	}

	public BeerRequest getBeerById(String id) {
		Optional<Beer> beer = Optional.of(beerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(ID_NOT_FOUND.replace("XXX", id))));

		if (beer.isPresent()) {
			return BeerDTO.convertToRequest(beer.get());
		}
		return null;
	}

	public BeerRequest updateBeer(String id, BeerRequest beerRequest) {
		Optional<Beer> b = Optional.of(beerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(ID_NOT_FOUND.replace("XXX", id))));

		if (b.isPresent()) {
			Beer beer = BeerDTO.convertToEntity(beerRequest);
			beerRepository.save(beer);
			beerRequest.setId(beer.getId());
			return beerRequest;
		}
		
		return null;
	}
}
