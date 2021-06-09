package com.craft.beer.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(value = { "id" }, allowGetters = true)
public class BeerRequest {
	private String id;
	private String name;
	@JsonProperty(value = "style.id")
	private String styleId;
	private String origem;
	private double abv;
	private int ibu;
	private int volume;
	private int temperature;
	@JsonProperty(value = "company.id")
	private String companyId;

}
