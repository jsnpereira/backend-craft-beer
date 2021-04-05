package com.craft.beer.model.commons;

import org.modelmapper.ModelMapper;

import com.craft.beer.model.entity.Company;
import com.craft.beer.model.request.CompanyRequest;

public class CompanyDTO {

	public static Company convertToEntity(CompanyRequest companyRequest) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(companyRequest, Company.class);
	}
	
	public static CompanyRequest convertToRequest(Company company) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(company, CompanyRequest.class);
	}
	
}
