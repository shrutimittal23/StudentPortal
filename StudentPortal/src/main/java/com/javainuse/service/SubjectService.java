package com.javainuse.service;

import java.util.List;

import com.javainuse.model.Subject;

public interface SubjectService {
	public Subject add(Subject subject);
	public Subject getSubById(Integer id);

	public List<Subject> getSubList();

	public Subject update(Subject subject);

	public void delete(Integer id);
}
