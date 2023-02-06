package com.agile.mentorship.surveyApplication.service;

import com.agile.mentorship.surveyApplication.dao.IAvailableSurveysRepository;
import com.agile.mentorship.surveyApplication.dao.ISurveyTransactionRepository;
import com.agile.mentorship.surveyApplication.dto.SurveyCompletionByUnitDto;
import com.agile.mentorship.surveyApplication.dto.SurveyCompletionDto;
import com.agile.mentorship.surveyApplication.dto.SurveyTransactionDto;
import com.agile.mentorship.surveyApplication.model.aggregation.SurveyCompletion;
import com.agile.mentorship.surveyApplication.model.aggregation.AvailableSurveys;
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

    //TODO: resolve integer division in floating-point context
    public List<SurveyCompletionDto> getSurveysCompletion() {
        List<SurveyCompletion> surveyCompletions = transactionRepository.getSurveyCompletion();
        Map<Integer, Long> availableSurveys = surveyAmountsRepository.getAvailableSurveysGroupedBySurveyId()
                .stream().collect(Collectors.toMap(AvailableSurveys::getSurveyId,
                        AvailableSurveys::getSurveysAvailable));

        List<SurveyCompletionDto> completionDtos = surveyCompletions.stream().map(
                surveyCompletion -> {
                    SurveyCompletionDto dto = new SurveyCompletionDto();
                    dto.setCompleted(Integer.parseInt(String.valueOf(surveyCompletion.getCompleted())));
                    dto.setSurveyName(surveyCompletion.getSurveyName());
                    long totalAmount = availableSurveys.get(surveyCompletion.getSurveyId());
                    dto.setTotalCount(Math.toIntExact(totalAmount));
                    dto.setPercentage(surveyCompletion.getCompleted() * 100 / totalAmount);
                    return dto;
                }).collect(Collectors.toList());

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
        List<SurveyTransactionDto> transactions = new SurveyTransactionService().generateSurveyTransactions();

        Map<String, List<SurveyTransactionDto>> surveyCompletionByUnit = transactions.stream()
                .filter(t -> t.getDateSubmitted() != null)
                .collect(Collectors.groupingBy(SurveyTransactionDto::getUnitName, Collectors.toList()));

        return surveyCompletionByUnit.entrySet()
                .stream()
                .map(entry -> new SurveyCompletionByUnitDto()
                        .setUnitName(entry.getKey())
                        .setSurveysCompletion(toSurveyCompletionDto(entry.getValue()))
                ).collect(Collectors.toList());
    }

    private List<SurveyCompletionDto> toSurveyCompletionDto(List<SurveyTransactionDto> transactions) {
        Map<String, Long> surveyCompleted = transactions.stream()
                .filter(t -> t.getDateSubmitted() != null)
                .collect(Collectors.groupingBy(SurveyTransactionDto::getSurveyName, Collectors.counting()));

        List<SurveyCompletionDto> completionDtos = surveyCompleted.entrySet()
                .stream()
                .map(stringLongEntry -> transactionToSurveyCompletion(stringLongEntry.getKey(), stringLongEntry.getValue(), 100))
                .collect(Collectors.toList());
        return completionDtos;
    }

    private SurveyCompletionDto transactionToSurveyCompletion(String surveyName, long completed, int totalAmount) {
        SurveyCompletionDto surveyCompletion = new SurveyCompletionDto();
        surveyCompletion.setSurveyName(surveyName);
        surveyCompletion.setTotalCount(totalAmount);
        surveyCompletion.setCompleted((int)completed);
        surveyCompletion.setPercentage(completed * 100 / totalAmount);
        return surveyCompletion;
    }

}
