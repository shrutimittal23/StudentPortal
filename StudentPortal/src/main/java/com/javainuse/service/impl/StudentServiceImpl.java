package com.javainuse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javainuse.dao.*;
import com.javainuse.model.*;
import com.javainuse.service.*;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
	public Student getStudentById(Integer id) {
		return studentRepository.findByStuid(id);
	}

	public List<Student> getStudentList() {
		return (List<Student>) studentRepository.findAll();
	}

	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	public void delete(Integer id) {
		studentRepository.deleteById(id);
	}
}
