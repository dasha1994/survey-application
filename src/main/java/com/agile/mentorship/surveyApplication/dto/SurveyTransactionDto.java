package com.agile.mentorship.surveyApplication.dto;

import java.util.Date;
import java.util.List;

public class SurveyTransactionDto {
    private int id;

    public int getSurveyId() {
        return surveyId;
    }

    private int surveyId;
    private String surveyName;

    public int getUnitId() {
        return unitId;
    }

    private int unitId;

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    private String unitName;
    private int chronoOrderTagId;
    private String sessionLinked;
    private Date dateCreated;

    public Date getDateSubmitted() {
        return dateSubmitted;
    }

    private Date dateSubmitted;
    private String contactId;
    private boolean isSuspicious;
    private String studentIdOverride;
    private String controlStudentId;
    private List<ResponseDto> responses;
    private List<CalculatedFieldDto> calculatedFields;


    public void setId(int id) {
        this.id = id;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public void setChronoOrderTagId(int chronoOrderTagId) {
        this.chronoOrderTagId = chronoOrderTagId;
    }

    public void setSessionLinked(String sessionLinked) {
        this.sessionLinked = sessionLinked;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public void setSuspicious(boolean suspicious) {
        isSuspicious = suspicious;
    }

    public void setStudentIdOverride(String studentIdOverride) {
        this.studentIdOverride = studentIdOverride;
    }

    public void setControlStudentId(String controlStudentId) {
        this.controlStudentId = controlStudentId;
    }

    public void setResponses(List<ResponseDto> responses) {
        this.responses = responses;
    }

    public void setCalculatedFields(List<CalculatedFieldDto> calculatedFields) {
        this.calculatedFields = calculatedFields;
    }


    // txn fields
//    private String studentId;
//    private String authCat;
//    private int numStrengths;
//    private int riskGroup;
//    private double pdTScore;
//    private double r4sScore;

    // responses
//    private String gender;
//    private String grade;
//    private String ethnicity;
//    private String race;
//    private String studentName;


}
