package com.agile.mentorship.surveyApplication.dao;

import com.agile.mentorship.surveyApplication.model.aggregation.AvailableSurveys;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//TODO: redo query and aggregated model
public interface IAvailableSurveysRepository extends CrudRepository<com.agile.mentorship.surveyApplication.model.AvailableSurveys, String> {
    @Aggregation("{$group: {\n" +
            "  _id: \"$surveyId\",\n" +
            "  availableSurveys: {\n" +
            "    $sum: \"$surveyAmount\"\n" +
            "  }\n" +
            "}}")
    List<AvailableSurveys> getAvailableSurveysGroupedBySurveyId();
}
