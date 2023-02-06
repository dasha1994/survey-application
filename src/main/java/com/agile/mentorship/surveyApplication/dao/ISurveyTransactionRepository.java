package com.agile.mentorship.surveyApplication.dao;

import com.agile.mentorship.surveyApplication.model.Transaction;
import com.agile.mentorship.surveyApplication.model.aggregation.SurveyCompletion;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ISurveyTransactionRepository extends CrudRepository<Transaction, String> {
    @Aggregation(pipeline = {"{ $group: {\n" +
            "  _id: \"$surveyName\",\n" +
            "  surveyId: {\n" +
            "    $first: \"$surveyId\",\n" +
            "  },\n" +
            "  completed: {\n" +
            "    $sum: 1,\n" +
            "  },\n" +
            "}},\n" +
            "{$project: {\n" +
            "  surveyName: \"$_id\",\n" +
            "  surveyId: \"$surveyId\",\n" +
            "  completed: \"$completed\",\n" +
            "  _id: 0,\n" +
            "}}"})
    List<SurveyCompletion> getSurveyCompletion();
}

