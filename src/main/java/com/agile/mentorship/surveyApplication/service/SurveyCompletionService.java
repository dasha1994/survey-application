package com.agile.mentorship.surveyApplication.service;

import com.agile.mentorship.surveyApplication.dto.SurveyCompletionByUnitDto;
import com.agile.mentorship.surveyApplication.dto.SurveyCompletionDto;
import com.agile.mentorship.surveyApplication.dto.SurveyTransactionDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SurveyCompletionService {
    int totalCountSurvey = 5000;
    public List<SurveyCompletionDto> getSurveysCompletion() {
        List<SurveyTransactionDto> transactions = new SurveyTransactionService().generateSurveyTransactions();
        Map<String, Long> surveyCompleted = transactions.stream()
                .filter(t -> t.getDateSubmitted() != null)
                .collect(Collectors.groupingBy(SurveyTransactionDto::getSurveyName, Collectors.counting()));

        List<SurveyCompletionDto> completionDtos = surveyCompleted.entrySet()
                .stream()
                .map(stringLongEntry -> transactionToSurveyCompletion(stringLongEntry.getKey(), stringLongEntry.getValue()))
                .collect(Collectors.toList());
        completionDtos.add(
                createTotalCompletionDto(surveyCompleted.size(),
                (int) surveyCompleted.values().stream().mapToLong(Long::longValue).sum()));

        return completionDtos;
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

    //TODO: resolve integer division in floating-point context
    private SurveyCompletionDto transactionToSurveyCompletion(String surveyName, long completed) {
        double percentage =  completed * 100 / totalCountSurvey;
        SurveyCompletionDto surveyCompletion = new SurveyCompletionDto();
        surveyCompletion.setSurveyName(surveyName);
        surveyCompletion.setTotalCount(totalCountSurvey);
        surveyCompletion.setCompleted((int)completed);
        surveyCompletion.setPercentage(percentage);
        return surveyCompletion;
    }

    private SurveyCompletionDto transactionToSurveyCompletion(String surveyName, long completed, int totalAmount) {
        SurveyCompletionDto surveyCompletion = new SurveyCompletionDto();
        surveyCompletion.setSurveyName(surveyName);
        surveyCompletion.setTotalCount(totalAmount);
        surveyCompletion.setCompleted((int)completed);
        surveyCompletion.setPercentage(completed * 100 / totalAmount);
        return surveyCompletion;
    }

    //TODO: resolve integer division in floating-point context
    private SurveyCompletionDto createTotalCompletionDto(int amountOfSurveys, int totalCompleted) {
        SurveyCompletionDto surveyCompletion = new SurveyCompletionDto();
        surveyCompletion.setSurveyName("All");
        surveyCompletion.setTotalCount(totalCountSurvey);
        surveyCompletion.setCompleted(totalCompleted);
        surveyCompletion.setPercentage(totalCompleted * 100 / (totalCountSurvey*amountOfSurveys));
        return surveyCompletion;
    }


}
