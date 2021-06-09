package com.craft.beer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.craft.beer.expcetions.ResourceNotFoundException;
import com.craft.beer.model.commons.CompanyDTO;
import com.craft.beer.model.entity.Beer;
import com.craft.beer.model.entity.Company;
import com.craft.beer.model.request.CompanyRequest;
import com.craft.beer.repository.CompanyRepository;

@Service
public class CompanyService {
	private String ID_NOT_FOUND = "Company id[XXX] not found in our database";
	
	private final CompanyRepository companyRepository;

	@Autowired
	public CompanyService(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	public CompanyRequest save(CompanyRequest companyRequest) {
		Company company = companyRepository.save(CompanyDTO.convertToEntity(companyRequest));
		return CompanyDTO.convertToRequest(company);
	}

	public List<CompanyRequest> getAllList() {
		List<Company> list = companyRepository.findAll();

		List<CompanyRequest> lcr = new ArrayList<>();
		for (Company company : list) {
			lcr.add(CompanyDTO.convertToRequest(company));
		}
		return lcr;
	}

	public CompanyRequest getFoundById(String id) {
		Company company = companyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(ID_NOT_FOUND.replace("XXX", id)));
		return CompanyDTO.convertToRequest(company);
	}
	
	public CompanyRequest update(String id, CompanyRequest companyRequest) {
		Optional<Company> company = Optional.of(companyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(ID_NOT_FOUND.replace("XXX", id))));
			
		if (company.isPresent()) {
			Company c = CompanyDTO.convertToEntity(companyRequest);
			c.setId(company.get().getId());
			return CompanyDTO.convertToRequest(companyRepository.save(c));
		}
		return null;		
	}

}
