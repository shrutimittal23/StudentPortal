package com.javainuse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javainuse.dao.SubjectRepository;
import com.javainuse.model.Subject;
import com.javainuse.service.*;

@Service
public class SubjectServiceImpl implements SubjectService {

	
	@Autowired
	SubjectRepository subjectRepository;
	
	public Subject add(Subject subject) {
		return subjectRepository.save(subject);
	}
	public Subject getSubById(Integer id) {
		return subjectRepository.findBySubid(id);
	}

	public List<Subject> getSubList() {
		return (List<Subject>) subjectRepository.findAll();
	}

	public Subject update(Subject subject) {
		return subjectRepository.save(subject);
	}

	public void delete(Integer id) {
		subjectRepository.deleteById(id);
	}
}
