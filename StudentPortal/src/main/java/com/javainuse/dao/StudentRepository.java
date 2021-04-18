package com.javainuse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javainuse.model.*;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	Student findByStuid(int stuid);
}
