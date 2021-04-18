package com.javainuse.service;

import java.util.List;

import com.javainuse.model.*;

public interface MarksService {

	public Marks addMarks(Marks marks, Integer stu_id, Integer sub_id);
	public List<Marks> getall();
	public List<MarksDTO> getRanks();
	public void deleteMarks(Integer marks_id);
	public Marks getMarksById(Integer id);
	public Marks updateMarks(Marks marks,Integer student_id, Integer subject_id);
	//public List<> save(MarksDTO e);
}
