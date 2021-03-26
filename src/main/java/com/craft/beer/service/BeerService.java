package com.craft.beer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.craft.beer.expcetions.IdRequiredPathException;
import com.craft.beer.expcetions.ResourceNotFoundException;
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
		Beer b = new Beer();
		b.setName(beerRequest.getName());
		b.setOrigem(beerRequest.getOrigem());
		b.setStyle(beerRequest.getStyle());
		b.setIbu(beerRequest.getIbu());
		b.setAbv(beerRequest.getAbv());
		b = beerRepository.save(b);
		beerRequest.setId(b.getId());
		return beerRequest;
	}

	public List<BeerRequest> getAllBeers() {
		List<BeerRequest> requestsList = new ArrayList<>();
		List<Beer> lists = beerRepository.findAll();
		for (Beer beer : lists) {
			requestsList.add(new BeerRequest(beer));
		}
		return requestsList;
	}

	public BeerRequest getBeerById(String id) {
		Optional<Beer> beer = beerRepository.findById(id);

		if (beer.isPresent()) {
			return new BeerRequest(beer.get());
		}
		return null;
	}

	public BeerRequest updateBeer(String id, BeerRequest beerRequest) {
		Optional<Beer> b = Optional.of(beerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id[" + id + "] not found in our database")));

		if (b.isPresent()) {
			Beer beer = b.get();
			beer.setName(beerRequest.getName());
			beer.setOrigem(beerRequest.getOrigem());
			beer.setStyle(beerRequest.getStyle());
			beer.setIbu(beerRequest.getIbu());
			beer.setAbv(beerRequest.getAbv());
			beerRepository.save(beer);
			beerRequest.setId(beer.getId());
			return beerRequest;
		}
		return null;

	}
}
