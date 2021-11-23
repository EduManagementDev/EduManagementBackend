package com.fzu.edumanagement.dao.mongo;

import com.fzu.edumanagement.model.entity.mongo.LogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends MongoRepository<LogEntity, Long> {
}
