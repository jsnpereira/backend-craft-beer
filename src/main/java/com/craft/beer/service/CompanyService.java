package com.craft.beer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.craft.beer.expcetions.ResourceNotFoundException;
import com.craft.beer.model.converts.CompanyConvert;
import com.craft.beer.model.entity.Company;
import com.craft.beer.model.request.CompanyRequest;
import com.craft.beer.repository.CompanyRepository;

@Service
public class CompanyService {
	private final CompanyRepository companyRepository;

	@Autowired
	public CompanyService(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	public CompanyRequest save(CompanyRequest companyRequest) {
		Company company = companyRepository.save(CompanyConvert.convertToEntity(companyRequest));
		return CompanyConvert.convertToRequest(company);
	}

	public List<CompanyRequest> getAllList() {
		List<Company> list = companyRepository.findAll();

		List<CompanyRequest> lcr = new ArrayList<>();
		for (Company company : list) {
			lcr.add(CompanyConvert.convertToRequest(company));
		}
		return lcr;
	}

	public CompanyRequest getFoundById(String id) {
		Company company = companyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Company Id[" + id + "] not found in our database"));
		return CompanyConvert.convertToRequest(company);
	}
	
	public CompanyRequest update(String id, CompanyRequest companyRequest) {
		Company company = companyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Company Id[" + id + "] not found in our database"));
		
		CompanyConvert.setUpdate(company, companyRequest);
		companyRepository.save(company);
		companyRequest.setId(company.getId());
		return companyRequest;
		
	}

}
