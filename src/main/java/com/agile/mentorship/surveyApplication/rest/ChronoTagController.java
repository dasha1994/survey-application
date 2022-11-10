package com.agile.mentorship.surveyApplication.rest;

import com.agile.mentorship.surveyApplication.dto.ChronoTagDto;
import com.agile.mentorship.surveyApplication.service.ChronoTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/chronotags")
public class ChronoTagController {
    private ChronoTagService chronoTagService;

    @Autowired
    public ChronoTagController(ChronoTagService chronoTagService) {
        this.chronoTagService = chronoTagService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ChronoTagDto>> getAllTags() {
        return new ResponseEntity<>(chronoTagService.getAll(), HttpStatus.OK);
    }
}
