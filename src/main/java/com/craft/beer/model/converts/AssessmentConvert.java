package com.craft.beer.model.converts;

import com.craft.beer.model.entity.Assessment;
import com.craft.beer.model.entity.Beer;
import com.craft.beer.model.request.AssessmentRequest;

public class AssessmentConvert {

	public static Assessment convertToEntity(AssessmentRequest assessmentRequest) {
		Assessment assessment = new Assessment();
		assessment.setRate(assessmentRequest.getRate());
		assessment.setComment(assessmentRequest.getComment());

		if (assessmentRequest.getBeerId() != null || assessmentRequest.getBeerId().isEmpty()) {
			Beer beer = new Beer();
			beer.setId(assessmentRequest.getBeerId());
			assessment.setBeer(beer);
		}

		return assessment;
	}

	public static AssessmentRequest convertToRequest(Assessment assessment) {
		AssessmentRequest assessmentRequest = new AssessmentRequest();
		assessmentRequest.setRate(assessment.getRate());
		assessmentRequest.setComment(assessment.getComment());
		assessmentRequest.setId(assessment.getId());
		assessmentRequest.setBeerId(assessment.getBeer().getId());		
		return assessmentRequest;
	}

	public static void update(Assessment assessment, AssessmentRequest assessmentRequest) {
		assessment.setRate(assessmentRequest.getRate());
		assessment.setComment(assessmentRequest.getComment());
	}

}
