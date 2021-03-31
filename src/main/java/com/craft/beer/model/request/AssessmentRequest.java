package com.craft.beer.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = "{id}", allowGetters = true)
public class AssessmentRequest {
	private String id;
	private int rate;
	private String comment;
	@JsonProperty("beer_id")
	private String beerId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getBeerId() {
		return beerId;
	}

	public void setBeerId(String beerId) {
		this.beerId = beerId;
	}
}
