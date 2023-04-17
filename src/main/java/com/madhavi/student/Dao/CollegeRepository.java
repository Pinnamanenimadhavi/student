package com.madhavi.student.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.madhavi.student.entity.College;
@Repository
public interface CollegeRepository extends JpaRepository<College, Long>{
	

}
