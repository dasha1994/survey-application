package com.agile.mentorship.surveyApplication.model.aggregation;

public class SurveyCompletion {
    private
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