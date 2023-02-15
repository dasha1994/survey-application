package com.agile.mentorship.surveyApplication.model.aggregation;

import org.springframework.data.annotation.Id;

import java.util.List;

public class SurveyCompletionByUnit {
    private @Id
    String unitName;
    List<SurveyCompletion> surveyCompletion;

    public String getUnitName() {
        return unitName;
    }

    public List<SurveyCompletion> getSurveyCompletion() {
        return surveyCompletion;
    }
}
