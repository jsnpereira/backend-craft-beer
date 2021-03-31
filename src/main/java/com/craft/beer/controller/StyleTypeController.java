package com.craft.beer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.craft.beer.model.request.StyleTypeRequest;
import com.craft.beer.service.StyleTypeService;

@RestController
@RequestMapping("/api/style")
public class StyleTypeController {

	private StyleTypeService styleTypeService;

	@Autowired
	public StyleTypeController(StyleTypeService styleTypeService) {
		super();
		this.styleTypeService = styleTypeService;
	}

	@PostMapping
	public ResponseEntity<StyleTypeRequest> save(@RequestBody StyleTypeRequest styleTypeRequest) {
		StyleTypeRequest st = styleTypeService.save(styleTypeRequest);
		return new ResponseEntity<StyleTypeRequest>(st, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<StyleTypeRequest>> getAll(){
		List<StyleTypeRequest> list = styleTypeService.getAllFinds();
		return new ResponseEntity<List<StyleTypeRequest>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StyleTypeRequest> getFindById(@PathVariable("id") String id){
		StyleTypeRequest st = styleTypeService.getFindById(id);
		return new ResponseEntity<StyleTypeRequest>(st, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StyleTypeRequest> update(@PathVariable("id")String id, @RequestBody StyleTypeRequest styleTypeRequest){
		StyleTypeRequest st = styleTypeService.update(id, styleTypeRequest);
		return new ResponseEntity<StyleTypeRequest>(st,HttpStatus.ACCEPTED);
	}

}
