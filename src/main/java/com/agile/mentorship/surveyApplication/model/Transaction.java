package com.agile.mentorship.surveyApplication.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("transactions")
public class Transaction {
    @Id
    private ObjectId id;

    private String surveyName;
    private int surveyId;
}
