package com.javainuse.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javainuse.dao.*;
import com.javainuse.model.*;
import com.javainuse.service.*;

@Service
public class MarksServiceImpl implements MarksService {

	private static final Logger log = LoggerFactory.getLogger(MarksServiceImpl.class);

	@Autowired
	private MarksRepository marksRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	public Marks addMarks(Marks marks, Integer student_id, Integer subject_id) {
		log.info("--- adding marks ---");
		Student student = studentRepository.findByStuid(student_id);
		Subject subject = subjectRepository.findBySubid(subject_id);

		marks.setStudent(student);
		marks.setSubject(subject);
		return marksRepository.save(marks);
	}

	@Override
	public List<Marks> getall() {
		log.info("--- returning all marks ---");
		return marksRepository.findAll();
	}

	public List<MarksDTO> getRanks() {
		log.info("--- returning ranks ---");
		return marksRepository.fetchWithRank2();
	}

	public void deleteMarks(Integer id) {
		log.info("--- deleting marks ---");
		marksRepository.deleteById(id);
	}

	public Marks getMarksById(Integer id) {
		log.info("--- getting marks by id ---");
		return marksRepository.findBymarksid(id);
	}

	public Marks updateMarks(Marks marks, Integer student_id, Integer subject_id) {
		log.info("--- updating marks ---");

		Student student = studentRepository.findByStuid(student_id);
		Subject subject = subjectRepository.findBySubid(subject_id);

		marks.setStudent(student);
		marks.setSubject(subject);
		return marksRepository.save(marks);
	}

}
