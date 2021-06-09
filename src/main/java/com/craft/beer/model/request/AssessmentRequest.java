package com.craft.beer.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(value = "{id}", allowGetters = true)
public class AssessmentRequest {
	private String id;
	private int rate;
	private String comment;
	@JsonProperty("beer.id")
	private String beerId;

}
