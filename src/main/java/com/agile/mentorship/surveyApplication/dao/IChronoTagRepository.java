package com.agile.mentorship.surveyApplication.dao;

import com.agile.mentorship.surveyApplication.model.ChronoTag;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IChronoTagRepository extends MongoRepository<ChronoTag, String> {
}
