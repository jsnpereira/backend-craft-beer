package com.craft.beer.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(value = { "id" }, allowGetters = true)
public class StyleTypeRequest {
	private String id;
	private String name;
	private String description;
	private String origem;
	private String cup;

}
