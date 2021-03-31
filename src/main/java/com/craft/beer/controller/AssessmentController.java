package com.craft.beer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.craft.beer.model.request.AssessmentRequest;
import com.craft.beer.service.AssessmentService;

@Controller
@RequestMapping("/api/assessment")
public class AssessmentController {
	private AssessmentService assessmentService;

	@Autowired
	public AssessmentController(AssessmentService assessmentService) {
		super();
		this.assessmentService = assessmentService;
	}

	@PostMapping
	public ResponseEntity<AssessmentRequest> save(@RequestBody AssessmentRequest assessmentRequest) {
		AssessmentRequest ar = assessmentService.save(assessmentRequest);
		return new ResponseEntity<AssessmentRequest>(ar, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<AssessmentRequest>> getAllFinds() {
		List<AssessmentRequest> list = assessmentService.getAllFinds();
		return new ResponseEntity<List<AssessmentRequest>>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AssessmentRequest> getFindById(@PathVariable("id") String id) {
		AssessmentRequest assessmentRequest = assessmentService.getFindsById(id);
		return new ResponseEntity<AssessmentRequest>(assessmentRequest, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AssessmentRequest> update(@PathVariable("id") String id,
			@RequestBody AssessmentRequest assessmentRequest) {
		AssessmentRequest asRequest = assessmentService.update(id, assessmentRequest);
		return new ResponseEntity<AssessmentRequest>(asRequest, HttpStatus.ACCEPTED);
	}

}
