package com.javainuse.service;

import java.util.List;

import com.javainuse.model.*;

public interface StudentService {

	public Student addStudent(Student student);
	public Student getStudentById(Integer id);

	public List<Student> getStudentList();

	public Student updateStudent(Student student);

	public void delete(Integer id);
}
