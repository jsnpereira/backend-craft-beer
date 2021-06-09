package com.craft.beer.model.request;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(value = { "id", "beers" }, allowGetters = true)
public class CompanyRequest {
	private String id;
	private String name;
	private String addressLine;
	private String country;
	private String city;
	private int year;
	private String url;
	private String email;
	private String phoneNumber;
	private List<BeerRequest> beers;
}
