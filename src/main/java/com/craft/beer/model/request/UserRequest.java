package com.craft.beer.model.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonIgnoreProperties(value = "{id}", allowGetters = true)
public class UserRequest {
	private String id;
	@JsonProperty(value = "first.name")
	private String firstName;
	@JsonProperty(value = "last.name")
	private String lastName;
	private String email;
	private String credential;

}
