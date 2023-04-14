package com.madhavi.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhavi.student.Dao.CollegeRepository;
import com.madhavi.student.entity.College;

@Service
public class CollegeService {
	
	@Autowired
	private CollegeRepository collegeRepo;
	
	public String createCollegeDetails(College college){
		if(college!= null) {
		  collegeRepo.save(college);
		  return "Successfully college details created";
		
	}
		else {
			return "Please enter the required details";
		}
	}
}
