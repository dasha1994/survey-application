package com.agile.mentorship.surveyApplication.dto;

public class DualFactorRiskDto {
    int value;
    String name;
    String coviCategory;
    String psyDistress;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoviCategory() {
        return coviCategory;
    }

    public void setCoviCategory(String coviCategory) {
        this.coviCategory = coviCategory;
    }

    public String getPsyDistress() {
        return psyDistress;
    }

    public void setPsyDistress(String psyDistress) {
        this.psyDistress = psyDistress;
    }
}
