package com.javainuse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.*;
import com.javainuse.service.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	private static final Logger log = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@PostMapping(value = "/add")
	public Student addStudent(@RequestBody Student student) {
		log.info("-----{Called add Student Method}------");
		return studentService.addStudent(student);
	}

	@GetMapping(value = "/get/{id}")
	public Student getStudentById(@PathVariable Integer id) {
		log.info("-----{Called get Student By Id Method}------");
		return studentService.getStudentById(id);
	}

	@GetMapping(value = "/getall")
	public List<Student> getAllStudents() {
		log.info("-----{Called get all Student Method}------");
		return studentService.getStudentList();
	}

	@PutMapping(value = "/update")
	public Student updateStudent(@RequestBody Student student) {
		log.info("-----{Called update Student Method}------");
		return studentService.updateStudent(student);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable Integer id) {
		log.info("-----{Called delete by id Student Method}------");
		studentService.delete(id);
	}
}
