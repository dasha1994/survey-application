package com.agile.mentorship.surveyApplication.rest;

import com.agile.mentorship.surveyApplication.dto.DualFactorRiskDto;
import com.agile.mentorship.surveyApplication.dto.SurveyDto;
import com.agile.mentorship.surveyApplication.service.DualFactorRiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/dual-factor-risks")
public class DualFactorRiskController {
    private DualFactorRiskService dualFactorRiskService;

    @Autowired
    public DualFactorRiskController(DualFactorRiskService dualFactorRiskService) {
        this.dualFactorRiskService = dualFactorRiskService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<DualFactorRiskDto>> getDualFactorRisks() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(dualFactorRiskService.getAll());
    }
}
