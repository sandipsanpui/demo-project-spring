package com.practice.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.demo.dto.StudentDto;
import com.practice.demo.model.Student;
import com.practice.demo.repo.StudentRepository;
import com.practice.demo.service.exception.StudentNotFoundException;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public void createStudent(String firstName, String lastName, String email, String phoneNo, Long dob, Integer rollNo, String department, String year, Boolean married) {

		studentRepository.save(new Student(firstName, lastName, email, phoneNo, dob, rollNo, department, year, married));

	}
	
	public List<StudentDto> getList() {
		List<Student> studentList = studentRepository.findAll();
		List<StudentDto> list = new ArrayList<>();
		studentList.forEach(p -> list.add(new StudentDto(p.getId(), p.getFirstName(), p.getLastName(), p.getEmail(), p.getPhoneNo(), p.getDob(), p.getRollNo(), p.getDepartment(), p.getYear(), p.isMarried())));	
		return list;
		
	}
	
	public Student getbyId(String id) throws StudentNotFoundException {

		Optional<Student> studentOptional = studentRepository.findById(id);
		
		if(!studentOptional.isPresent()) {
			throw new StudentNotFoundException(id);
		}
		
		return studentOptional.get();

	}
	
	public void updateStudent(String id, String firstName, String lastName, String email, String phoneNo, Long dob, Integer rollNo, String department, String year, Boolean married) throws StudentNotFoundException {
		Optional<Student> studentOptional = studentRepository.findById(id);
		
		if(!studentOptional.isPresent()) {
			throw new StudentNotFoundException(id);
		}
		
		Student student = studentOptional.get();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setPhoneNo(phoneNo);
		student.setDob(dob);
		student.setRollNo(rollNo);
		student.setDepartment(department);
		student.setYear(year);
		student.setMarried(married);
		studentRepository.save(student);
	}
	
}
