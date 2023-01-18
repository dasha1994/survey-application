package com.agile.mentorship.surveyApplication.service;

import com.agile.mentorship.surveyApplication.dto.ChronoTagDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChronoTagService {
    public List<ChronoTagDto> getAll() {
        return generateDtos();
    }

    private List<ChronoTagDto> generateDtos() {
        List<ChronoTagDto> dtos = new ArrayList<>();
        for(int i = 2018; i < 2023; i++) {
            ChronoTagDto dto = new ChronoTagDto();
            dto.setId(i);
            dto.setValue("Fall " + i);
            dtos.add(dto);
        }
        return dtos;
    }
}
