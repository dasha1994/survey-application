package com.agile.mentorship.surveyApplication.dto;

import java.util.Objects;

public class SurveyDto {
    private int id;
    private String name;
    private String shortName;

    @Override
    public String toString() {
        return "SurveyDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurveyDto surveyDto = (SurveyDto) o;
        return id == surveyDto.id &&
                name.equals(surveyDto.name) &&
                shortName.equals(surveyDto.shortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
