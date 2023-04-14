package com.madhavi.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class College {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="college_id")
	private Long college_id;
	@Column(name="college_name")
	private String college_name;
	@Column(name="college_address")
	private String college_address;
	@Column(name="college_code")
	private String college_code;
	
	public College() {
		
	}

	public College(Long college_id, String college_name, String college_address, String college_code) {
		super();
		this.college_id = college_id;
		this.college_name = college_name;
		this.college_address = college_address;
		this.college_code = college_code;
	}

	public Long getCollege_id() {
		return college_id;
	}

	public void setCollege_id(Long college_id) {
		this.college_id = college_id;
	}

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}

	public String getCollege_address() {
		return college_address;
	}

	public void setCollege_address(String college_address) {
		this.college_address = college_address;
	}

	public String getCollege_code() {
		return college_code;
	}

	public void setCollege_code(String college_code) {
		this.college_code = college_code;
	}

	
	
	
	

}
