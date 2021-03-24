package com.craft.beer.model.request;

import com.craft.beer.model.entity.Beer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(value = { "id" },allowGetters = true)
public class BeerRequest {
	private String id;
	private String name;
	private String style;
	private String origem;
	private double abv;
	private int ibu;
	
	public BeerRequest() {
		
	}

	public BeerRequest(Beer beer) {
		this.id = beer.getId();
		this.name = beer.getName();
		this.style = beer.getStyle();
		this.origem = beer.getOrigem();
		this.abv = beer.getAbv();
		this.ibu = beer.getIbu();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public double getAbv() {
		return abv;
	}

	public void setAbv(double abv) {
		this.abv = abv;
	}

	public int getIbu() {
		return ibu;
	}

	public void setIbu(int ibu) {
		this.ibu = ibu;
	}

}