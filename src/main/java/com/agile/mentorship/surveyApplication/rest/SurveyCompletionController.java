package com.agile.mentorship.surveyApplication.rest;

import com.agile.mentorship.surveyApplication.dto.SurveyCompletionByUnitDto;
import com.agile.mentorship.surveyApplication.dto.SurveyCompletionDto;
import com.agile.mentorship.surveyApplication.service.SurveyCompletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/completion")
public class SurveyCompletionController {
    private SurveyCompletionService service;

    @Autowired
    public SurveyCompletionController(SurveyCompletionService surveyCompletionService) {
        this.service = surveyCompletionService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SurveyCompletionDto>> getSurveyCompletion() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(service.getSurveysCompletion());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/by-unit")
    public ResponseEntity<List<SurveyCompletionByUnitDto>> getSurveyCompletionByUnit() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(service.getSurveysCompletionByUnit());
    }
}
