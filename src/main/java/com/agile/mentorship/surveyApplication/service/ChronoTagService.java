package com.agile.mentorship.surveyApplication.service;

import com.agile.mentorship.surveyApplication.converter.MongoDbConverter;
import com.agile.mentorship.surveyApplication.dao.ChronoTagRepository;
import com.agile.mentorship.surveyApplication.dto.ChronoTagDto;
import com.agile.mentorship.surveyApplication.model.ChronoTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChronoTagService {
    private ChronoTagRepository repository;
    private MongoDbConverter<ChronoTag, ChronoTagDto> converter;

    @Autowired
    public ChronoTagService(ChronoTagRepository repository, MongoDbConverter<ChronoTag, ChronoTagDto> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public List<ChronoTagDto> getAll() {
        List<ChronoTagDto> requestRuleDtos = repository.findAll().stream()
                .map(converter::convertToDto)
                .collect(Collectors.toList());
        return requestRuleDtos;
    }

    public ChronoTag create(String name, int order) throws Exception {
        ChronoTag tag = new ChronoTag();
        tag.setDefault(false);
        tag.setDisplayOrder(order);
        tag.setSetupId(1);
        tag.setValue(name);
        return Optional.of(repository.insert(tag))
                .orElseThrow(() -> new Exception("Can't persist order entity"));
    }

    private List<ChronoTagDto> generateDtos() {
        List<ChronoTagDto> dtos = new ArrayList<>();
        for (int i = 2018; i < 2023; i++) {
            ChronoTagDto dto = new ChronoTagDto();
            dto.setId(String.valueOf(i));
            dto.setValue("Fall " + i);
            dtos.add(dto);
        }
        return dtos;
    }
}
