package com.agile.mentorship.surveyApplication.rest;

import com.agile.mentorship.surveyApplication.converter.MongoDbConverter;
import com.agile.mentorship.surveyApplication.dao.ChronoTagRepository;
import com.agile.mentorship.surveyApplication.dao.ISurveyTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ApplicationController {

    @Autowired
    public ApplicationController() {

    }


    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "Home page";
    }
}
