package com.agile.mentorship.surveyApplication.service;

import com.agile.mentorship.surveyApplication.dto.DualFactorRiskDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class DualFactorRiskService {
    public List<DualFactorRiskDto> getAll() {
        return generateDtos();
    }

    List<String> names = Arrays.asList(
            "Highest Risk", "Moderate Risk", "Vulnerable", "Languishing",
            "Getting By", "Moderate Thriving", "High Thriving", "Inconsistent-H", "Inconsistent-M"
    );

    List<String> coviCategories = Arrays.asList("Low", "Low Average", "High", "Average");
    List<String> psyDistress = Arrays.asList("Elevated", "Normal", "At-Risk");

    private List<DualFactorRiskDto> generateDtos() {
        final Random random = new Random();
        List<DualFactorRiskDto> dtos = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            DualFactorRiskDto dto = new DualFactorRiskDto();
            dto.setCoviCategory(coviCategories.get(random.nextInt(coviCategories.size())));
            dto.setName(names.get(i));
            dto.setPsyDistress(psyDistress.get(random.nextInt(psyDistress.size())));
            dto.setValue(random.nextInt(12));
            dtos.add(dto);
        }
        return dtos;
    }
}
