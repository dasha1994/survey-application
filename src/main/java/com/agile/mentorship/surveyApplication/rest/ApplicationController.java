package com.agile.mentorship.surveyApplication.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ApplicationController {
    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "Home page";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String survey() {
        return "Survey page commit";
    }
}
