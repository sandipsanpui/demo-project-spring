package com.practice.demo.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CauseRepository extends MongoRepository<Cause, String> {

}
