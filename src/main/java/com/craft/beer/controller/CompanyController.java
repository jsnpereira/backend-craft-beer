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

import com.craft.beer.model.request.CompanyRequest;
import com.craft.beer.service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	private final CompanyService companyService;

	@Autowired
	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
	
	@PostMapping
	public ResponseEntity<CompanyRequest> save(@RequestBody CompanyRequest companyRequest){
		CompanyRequest cr = companyService.save(companyRequest);
		return new ResponseEntity<CompanyRequest>(cr, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CompanyRequest>> getAll(){
		List<CompanyRequest> list = companyService.getAllList();
		return new ResponseEntity<List<CompanyRequest>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CompanyRequest> getFindById(@PathVariable("id") String id){
		CompanyRequest companyRequest = companyService.getFoundById(id);
		return new ResponseEntity<CompanyRequest>(companyRequest, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CompanyRequest> update(@PathVariable("id") String id, @RequestBody CompanyRequest companyRequest){
		CompanyRequest cr = companyService.update(id, companyRequest);
		return new ResponseEntity<CompanyRequest>(cr, HttpStatus.ACCEPTED);
	}

}
