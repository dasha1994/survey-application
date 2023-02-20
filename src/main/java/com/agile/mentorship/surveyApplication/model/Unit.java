package com.agile.mentorship.surveyApplication.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("units")
public class Unit {
    private ObjectId id;
    private String name;
    private ObjectId parent;
    private int systemSetup;
    private int type;
    private int subtype;
}
