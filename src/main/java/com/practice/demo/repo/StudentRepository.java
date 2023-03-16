package com.practice.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

	List<Student> findAll();
}
