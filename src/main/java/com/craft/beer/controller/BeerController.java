package com.craft.beer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.craft.beer.model.request.BeerRequest;
import com.craft.beer.service.BeerService;

@RestController
@RequestMapping("/api/beer")
public class BeerController {
	
	private final BeerService beerService;
	
	@Autowired
	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}
	
	@GetMapping
	public List<BeerRequest> getBeer() {
		return beerService.getAllBeers();
	}
	
	@GetMapping("/{id}")
	public BeerRequest getBeerById(@PathVariable(value = "id") String requestId) {
		return beerService.getBeerById(requestId);
	}
	
	@PostMapping
	public BeerRequest save(@RequestBody BeerRequest beerRequest) {
		return beerService.save(beerRequest);
	}
	
	@PutMapping("/{id}")
	public BeerRequest updateBeerById(@PathVariable(value = "id")String requestId, @RequestBody BeerRequest beerRequest) {
		return beerService.updateBeer(requestId, beerRequest);
	}

}
