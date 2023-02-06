package com.agile.mentorship.surveyApplication.model.aggregation;

import org.springframework.data.annotation.Id;

public class AvailableSurveys {
    private @Id int surveyId;
    private Long availableSurveys;

    public int getSurveyId() {
        return surveyId;
    }

    public Long getSurveysAvailable() {
        return availableSurveys;
    }
}
