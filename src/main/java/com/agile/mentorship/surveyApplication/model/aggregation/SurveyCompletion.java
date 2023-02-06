package com.agile.mentorship.surveyApplication.model.aggregation;

import org.springframework.data.annotation.Id;

public class SurveyCompletion {
    private @Id
    String surveyName;
    private int surveyId;
    private Long completed;

    public String getSurveyName() {
        return surveyName;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public Long getCompleted() {
        return completed;
    }
}