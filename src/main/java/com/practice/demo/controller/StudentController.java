package com.practice.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.request.StudentCreateRequest;
import com.practice.demo.request.StudentUpdateRequest;
import com.practice.demo.response.ResponseDTO;
import com.practice.demo.service.StudentService;
import com.practice.demo.service.exception.StudentNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("student")
@Api(value = "student data ", description = "Operations pertaining to student Service features")
@RestController
public class StudentController {
	
	private final StudentService studentService;
	
	private StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@ApiOperation(value = "create student data", response = ResponseEntity.class)
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO<?>> createStudent(@RequestBody StudentCreateRequest request) {

		studentService.createStudent(request.getFirstName(), request.getLastName(), request.getEmail(), request.getPhoneNo(), request.getDateOfBirth(), request.getRollNo(), request.getDepartment(), request.getYear(), request.isMarried());

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseDTO.builder().status(HttpStatus.CREATED.toString()).build());

	}
	
	@ApiOperation(value = "List of student", response = ResponseEntity.class)
	@GetMapping("/list")
	public ResponseEntity<ResponseDTO<?>> list() {

		return ResponseEntity.status(HttpStatus.OK)
				.body(ResponseDTO.builder().status(HttpStatus.OK.toString()).body(studentService.getList()).build());
	}
	
	@ApiOperation(value = "data of student", response = ResponseEntity.class)
	@GetMapping("/getById")
	public ResponseEntity<ResponseDTO<?>> get(@RequestParam("id") String id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(
					ResponseDTO.builder().status(HttpStatus.OK.toString()).body(studentService.getbyId(id)).build());
		} catch (StudentNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					ResponseDTO.builder().status(HttpStatus.NOT_FOUND.toString()).message(ex.getMessage()).build());
		}
	}
	
	@ApiOperation(value = "update student data", response = ResponseEntity.class)
	@PostMapping("/update")
	public ResponseEntity<ResponseDTO<?>> updateStudent(@RequestBody StudentUpdateRequest request) {

		try {
			studentService.updateStudent(request.getId(), request.getFirstName(), request.getLastName(), request.getEmail(), request.getPhoneNo(), request.getDateOfBirth(), request.getRollNo(), request.getDepartment(), request.getYear(), request.isMarried());

			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body(ResponseDTO.builder().status(HttpStatus.ACCEPTED.toString()).build());
		} catch (StudentNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					ResponseDTO.builder().status(HttpStatus.NOT_FOUND.toString()).message(ex.getMessage()).build());
		}

	}
}
