package com.agile.mentorship.surveyApplication.service;

import com.agile.mentorship.surveyApplication.dto.SurveyDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyService {
    public List<SurveyDto> getAll() {
        return generateDtos();
    }

    private List<SurveyDto> generateDtos() {
        List<SurveyDto> dtos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SurveyDto dto = new SurveyDto();
            dto.setId(i);
            dto.setName("Survey " + i);
            dto.setShortName("Survey " + i);
            dtos.add(dto);
        }
        return dtos;
    }
}
