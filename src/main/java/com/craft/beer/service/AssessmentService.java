package com.craft.beer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.craft.beer.expcetions.ResourceNotFoundException;
import com.craft.beer.model.commons.AssessmentDTO;
import com.craft.beer.model.entity.Assessment;
import com.craft.beer.model.request.AssessmentRequest;
import com.craft.beer.repository.AssessmentRepository;

@Service
public class AssessmentService {

	private AssessmentRepository assessmentRepository;

	@Autowired
	public AssessmentService(AssessmentRepository assessmentRepository) {
		super();
		this.assessmentRepository = assessmentRepository;
	}

	public AssessmentRequest save(AssessmentRequest assessmentRequest) {
		Assessment assessment = assessmentRepository.save(AssessmentDTO.convertToEntity(assessmentRequest));
		return AssessmentDTO.convertToRequest(assessment);
	}

	public List<AssessmentRequest> getAllFinds() {
		List<Assessment> list = assessmentRepository.findAll();
		List<AssessmentRequest> lar = new ArrayList<>();
		for (Assessment assessment : list) {
			lar.add(AssessmentDTO.convertToRequest(assessment));
		}
		return lar;
	}

	public AssessmentRequest getFindsById(String id) {
		Optional<Assessment> assessment = Optional.of(assessmentRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Assessment Id[" + id + "] not found in our database")));
		return AssessmentDTO.convertToRequest(assessment.get());
	}

	public AssessmentRequest update(String id, AssessmentRequest assessmentRequest) {
		Optional<Assessment> assessment = Optional.of(assessmentRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Assessment Id[" + id + "] not found in our database")));

		if (assessment.isPresent()) {
			Assessment assRequest = AssessmentDTO.convertToEntity(assessmentRequest);
			assRequest.setId(id);
			return AssessmentDTO.convertToRequest(assessmentRepository.save(assRequest));
		}
		return null;
	}
}
