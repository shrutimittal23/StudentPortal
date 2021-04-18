package com.javainuse.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javainuse.model.Marks;
import com.javainuse.model.MarksDTO;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Integer> {

	@Query(value = "SELECT sub_name,score,stu_name,DENSE_RANK() OVER(PARTITION BY stu_name ORDER BY score DESC) Ranknum FROM marks e  JOIN student d  ON d.stuid = e.stuid JOIN subject s ON s.subid = e.subid ORDER BY Ranknum limit 10", nativeQuery = true)
	
	List<MarksDTO> fetchWithRank2();
	
	List<Marks> findAll();
    Marks findBymarksid(int marksid);
}
