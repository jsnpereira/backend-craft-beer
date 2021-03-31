package com.craft.beer.model.converts;

import com.craft.beer.model.entity.Company;
import com.craft.beer.model.request.CompanyRequest;

public class CompanyConvert {

	public static Company convertToEntity(CompanyRequest companyRequest) {
		Company company = new Company();
		company.setName(companyRequest.getName());
		company.setCity(companyRequest.getCity());
		company.setUrl(companyRequest.getUrl());
		company.setEmail(companyRequest.getEmail());
		company.setAddressLine(companyRequest.getAddressLine());
		company.setCountry(companyRequest.getCountry());
		company.setPhoneNumber(companyRequest.getPhoneNumber());
		company.setYear(companyRequest.getYear());
		return company;
	}
	
	public static CompanyRequest convertToRequest(Company company) {
		CompanyRequest cr = new CompanyRequest();
		cr.setName(company.getName());
		cr.setCity(company.getCity());
		cr.setUrl(company.getUrl());
		cr.setEmail(company.getEmail());
		cr.setAddressLine(company.getAddressLine());
		cr.setCountry(company.getCountry());
		cr.setPhoneNumber(company.getPhoneNumber());
		cr.setYear(company.getYear());
		cr.setId(company.getId());
		return cr;
	}
	
	public static void setUpdate(Company company, CompanyRequest companyRequest) {
		company.setName(companyRequest.getName());
		company.setCity(companyRequest.getCity());
		company.setUrl(companyRequest.getUrl());
		company.setEmail(companyRequest.getEmail());
		company.setAddressLine(companyRequest.getAddressLine());
		company.setCountry(companyRequest.getCountry());
		company.setPhoneNumber(companyRequest.getPhoneNumber());
		company.setYear(companyRequest.getYear());
	}

}
