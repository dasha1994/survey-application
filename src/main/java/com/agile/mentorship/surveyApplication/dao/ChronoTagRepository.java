package com.agile.mentorship.surveyApplication.dao;

import com.agile.mentorship.surveyApplication.model.ChronoTag;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChronoTagRepository extends MongoRepository<ChronoTag, String> {
}
