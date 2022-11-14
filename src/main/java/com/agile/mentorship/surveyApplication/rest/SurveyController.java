package com.agile.mentorship.surveyApplication.rest;

import com.agile.mentorship.surveyApplication.dto.SurveyDto;
import com.agile.mentorship.surveyApplication.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/surveys")
public class SurveyController {
    private SurveyService SurveyService;

    @Autowired
    public SurveyController(SurveyService SurveyService) {
        this.SurveyService = SurveyService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SurveyDto>> getAllSurveys() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        System.out.println("get");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(SurveyService.getAll());
    }
}
