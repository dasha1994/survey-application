package com.agile.mentorship.surveyApplication.dto;

import java.util.List;

public class SurveyCompletionByUnitDto {
    String unitName;
    List<SurveyCompletionDto> surveysCompletion;

    public String getUnitName() {
        return unitName;
    }

    public SurveyCompletionByUnitDto setUnitName(String unitName) {
        this.unitName = unitName;
        return this;
    }

    public List<SurveyCompletionDto> getSurveysCompletion() {
        return surveysCompletion;
    }

    public SurveyCompletionByUnitDto setSurveysCompletion(List<SurveyCompletionDto> surveysCompletion) {
        this.surveysCompletion = surveysCompletion;
        return this;
    }
}
