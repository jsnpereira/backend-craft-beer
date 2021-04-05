package com.craft.beer.model.commons;

import org.modelmapper.ModelMapper;

import com.craft.beer.model.entity.Assessment;
import com.craft.beer.model.entity.Beer;
import com.craft.beer.model.request.AssessmentRequest;

public class AssessmentDTO {

	public static Assessment convertToEntity(AssessmentRequest assessmentRequest) {
		ModelMapper mapper = new ModelMapper();

		Assessment assessment = mapper.map(assessmentRequest, Assessment.class);
		System.out.println("Beer id [" + assessmentRequest.getBeerId() + "]");
		if (assessmentRequest.getBeerId() != null || assessmentRequest.getBeerId().isEmpty()) {
			Beer beer = new Beer();
			beer.setId(assessmentRequest.getBeerId());
			assessment.setBeer(beer);
		}

		return assessment;
	}

	public static AssessmentRequest convertToRequest(Assessment assessment) {
		ModelMapper mapper = new ModelMapper();
		AssessmentRequest assessmentRequest = mapper.map(assessment, AssessmentRequest.class);
		assessmentRequest.setBeerId(assessment.getBeer().getId());
		return assessmentRequest;
	}

}
