package com.agile.mentorship.surveyApplication.dto;

public class ResponseDto {
    private int questionId;
    private String questionText;
    private int responseScore;
    private String response;

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setResponseScore(int responseScore) {
        this.responseScore = responseScore;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
