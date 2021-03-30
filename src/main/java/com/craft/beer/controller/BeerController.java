package com.craft.beer.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.craft.beer.expcetions.IdRequiredPathException;
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
	public ResponseEntity<BeerRequest> getBeerById(@PathVariable(value = "id") String requestId) {
		BeerRequest bRequestGet = beerService.getBeerById(requestId);
		if (bRequestGet == null) {
			return ResponseEntity.notFound().build();
		} else {
			return new ResponseEntity<BeerRequest>(bRequestGet, HttpStatus.OK);
		}
	}

	@PostMapping
	public ResponseEntity<BeerRequest> save(@RequestBody BeerRequest beerRequest) {
		System.out.println("Preparing to save");
		BeerRequest bRequestSaved = beerService.save(beerRequest);
		if (bRequestSaved == null) {
			return ResponseEntity.notFound().build();
		} else {
			return new ResponseEntity<BeerRequest>(bRequestSaved, HttpStatus.CREATED);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<BeerRequest> updateBeerById(@PathVariable(value = "id", required = true) String requestId,
			@RequestBody BeerRequest beerRequest) {

		BeerRequest bRequestUpdated = beerService.updateBeer(requestId, beerRequest);
		return new ResponseEntity<BeerRequest>(bRequestUpdated, HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<BeerRequest> updateBeerWithId(@RequestBody BeerRequest beerRequest) {
		throw new IdRequiredPathException("Please put the ID in path");
	}

}
