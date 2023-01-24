package com.agile.mentorship.surveyApplication.converter;

public interface MongoDbConverter<S, T> {
    T convertToDto(S dbEntity);

    S convertToDb(T dto);
}
