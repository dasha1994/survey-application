package com.agile.mentorship.surveyApplication.rest;

import com.agile.mentorship.surveyApplication.dto.ChronoTagDto;
import com.agile.mentorship.surveyApplication.service.ChronoTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/chronotags")
public class ChronoTagController {
    private final ChronoTagService service;

    @Autowired
    public ChronoTagController(ChronoTagService chronoTagService) {
        this.service = chronoTagService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ChronoTagDto>> getAllTags() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(service.getAll());
    }
}
