package com.agile.mentorship.surveyApplication.service;

import com.agile.mentorship.surveyApplication.dao.IAvailableSurveysRepository;
import com.agile.mentorship.surveyApplication.dao.ISurveyTransactionRepository;
import com.agile.mentorship.surveyApplication.dto.SurveyCompletionByUnitDto;
import com.agile.mentorship.surveyApplication.dto.SurveyCompletionDto;
import com.agile.mentorship.surveyApplication.model.aggregation.SurveyCompletion;
import com.agile.mentorship.surveyApplication.model.aggregation.AvailableSurveys;
import com.agile.mentorship.surveyApplication.model.aggregation.SurveyCompletionByUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SurveyCompletionService {
    private ISurveyTransactionRepository transactionRepository;
    private IAvailableSurveysRepository surveyAmountsRepository;

    @Autowired
    public SurveyCompletionService(ISurveyTransactionRepository transactionRepository, IAvailableSurveysRepository surveyAmountsRepository) {
        this.transactionRepository = transactionRepository;
        this.surveyAmountsRepository = surveyAmountsRepository;
    }

    public List<SurveyCompletionDto> getSurveysCompletion() {
        List<SurveyCompletion> surveyCompletions = transactionRepository.getSurveyCompletion();
        Map<Integer, Long> availableSurveys = getAvailableSurveysById();

        List<SurveyCompletionDto> completionDtos = surveyCompletions.stream().map(
                completion -> toSurveyCompletionDto(completion, availableSurveys.get(completion.getSurveyId()))
        ).collect(Collectors.toList());

        completionDtos.add(createTotalCompletionDto(completionDtos));

        return completionDtos;
    }

    //TODO: resolve integer division in floating-point context
    private SurveyCompletionDto createTotalCompletionDto(List<SurveyCompletionDto> completionDtos) {
        SurveyCompletionDto surveyCompletion = new SurveyCompletionDto();
        surveyCompletion.setSurveyName("All");

        int totalCompleted = completionDtos.stream()
                .map(SurveyCompletionDto::getCompleted).mapToInt(Integer::intValue).sum();

        int totalAvailable = completionDtos.stream()
                .map(SurveyCompletionDto::getTotalCount).mapToInt(Integer::intValue).sum();

        surveyCompletion.setTotalCount(totalAvailable);
        surveyCompletion.setCompleted(totalCompleted);
        surveyCompletion.setPercentage(totalCompleted * 100 / totalAvailable);
        return surveyCompletion;
    }

    public List<SurveyCompletionByUnitDto> getSurveysCompletionByUnit() {
        List<SurveyCompletionByUnit> completionByUnit = transactionRepository.getSurveyCompletionByUnit();
        Map<Integer, Long> availableSurveys = getAvailableSurveysById();

        return completionByUnit.stream().map(
                item -> new SurveyCompletionByUnitDto()
                        .setUnitName(item.getUnitName())
                        .setSurveysCompletion(item.getSurveyCompletion().stream().map(
                                completion -> toSurveyCompletionDto(completion, availableSurveys.get(completion.getSurveyId()))
                        ).collect(Collectors.toList()))
        ).collect(Collectors.toList());
    }

    private Map<Integer, Long> getAvailableSurveysById() {
        return surveyAmountsRepository.getAvailableSurveysGroupedBySurveyId()
                .stream().collect(Collectors.toMap(AvailableSurveys::getSurveyId,
                        AvailableSurveys::getSurveysAvailable));
    }

//    private SurveyCompletionByUnit toSurveyCompletionByUnitDto(SurveyCompletionByUnit completionByUnit, ) {
//
//    }

    private SurveyCompletionDto toSurveyCompletionDto(SurveyCompletion surveyCompletion, long availableSurveys) {
        SurveyCompletionDto dto = new SurveyCompletionDto();
        dto.setCompleted(Integer.parseInt(String.valueOf(surveyCompletion.getCompleted())));
        dto.setSurveyName(surveyCompletion.getSurveyName());
        dto.setTotalCount(Math.toIntExact(availableSurveys));
        dto.setPercentage(surveyCompletion.getCompleted() * 100 / availableSurveys);
        return dto;
    }
}
