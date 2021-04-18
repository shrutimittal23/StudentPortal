package com.javainuse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javainuse.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>{
	Subject findBySubid(int subid);
}
