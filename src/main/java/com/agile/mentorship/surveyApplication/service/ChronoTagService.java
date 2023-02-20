package com.agile.mentorship.surveyApplication.service;

import com.agile.mentorship.surveyApplication.converter.MongoDbConverter;
import com.agile.mentorship.surveyApplication.dao.IChronoTagRepository;
import com.agile.mentorship.surveyApplication.dto.ChronoTagDto;
import com.agile.mentorship.surveyApplication.model.ChronoTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChronoTagService {
    private IChronoTagRepository repository;
    private MongoDbConverter<ChronoTag, ChronoTagDto> converter;

    @Autowired
    public ChronoTagService(IChronoTagRepository repository, MongoDbConverter<ChronoTag, ChronoTagDto> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public List<ChronoTagDto> getAll() {
        return repository.findAll().stream()
                .map(converter::convertToDto)
                .collect(Collectors.toList());
    }
}
