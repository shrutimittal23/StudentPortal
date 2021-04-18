package com.javainuse.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.Subject;
import com.javainuse.service.SubjectService;

@RestController
@RequestMapping("/api/admin1")
public class SubjectController {
	private static final Logger log = LoggerFactory.getLogger(MarksController.class);

	@Autowired
	private SubjectService subjectService;

	@PostMapping(value = "/addSub")
	public Subject add(@RequestBody Subject subject) {
		log.info("-----{Called add Subject Method}------");
		return subjectService.add(subject);
	}
	
	@GetMapping(value = "/get/{id}")
	public Subject getStudentById(@PathVariable Integer id) {
		log.info("-----{Called get by id Subject Method}------");
		return subjectService.getSubById(id);
	}

	@GetMapping(value = "/getall")
	public List<Subject> getAllStudents() {
		log.info("-----{Called get all Subject Method}------");
		return subjectService.getSubList();
	}

	@PutMapping(value = "/update")
	public Subject update(@RequestBody Subject subject) {
		log.info("-----{Called update Subject Method}------");
		return subjectService.update(subject);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable Integer id) {
		log.info("-----{Called delete by id Subject Method}------");
		subjectService.delete(id);
	}

}
