package com.madhavi.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.madhavi.student.Dao.CollegeRepository;
import com.madhavi.student.Dao.StudentRepository;
import com.madhavi.student.entity.College;
import com.madhavi.student.entity.Student;

@Service
public class StudentService {

	@Autowired
	private JavaMailSender mailSender; //

	public void sendEmail(String toEmail, String body, String subject) throws MessagingException {
		// creating message
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setFrom("birapunenimadhavi29@gmail.com");
		mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);
		// The send() method of MailSender interface is used here to send the simple
		// mail
		mailSender.send(mimeMessage);
		System.out.printf("Mail sent successfully..");
	}

	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private CollegeRepository collegeRepo;
//in this method validate the entered mail is matching the given pattern or not
	
	  public boolean isValidEmail(String eMail) { String regexPattern =
	  "^(.+)@(\\S+)$"; return
	  Pattern.compile(regexPattern).matcher(eMail).matches(); }
	  
	  public boolean isMailExist(String eMail) { return
	  studentRepo.existsByeMail(eMail); }
	  
	  // in this method validate the entered phone number is matching the given // pattern number or not 
	  public boolean isValidMobileNo(String str) { Pattern
	  ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}"); Matcher match =
	  ptrn.matcher(str); return (match.find() && match.group().equals(str));
	  
	  }
	 

	public List<String> createStudent(Student student) {
		// created empty list and adding error messages to list
		List<String> error = new ArrayList<>();
		if (student.getFirstName() == null) {
			error.add("please enter first name");
		}
		if (student.getLastName() == null) {
			error.add("please enter last name");
		}

		if (student.geteMail() == null) {
			error.add("please enter email");
		}

		// mail not null and not match the given pattern
		if (student.geteMail() != null && !isValidEmail(student.geteMail())) {
			error.add("please enter valid email");
		}

		if (isMailExist(student.geteMail())) {
			error.add("This mail already exist");
		}

		if (student.getPhoneNumber() == null) {
			error.add("please enter phone number");
		}
		// phone number not null and not match the given pattern number
		if (student.getPhoneNumber() != null && !isValidMobileNo(student.getPhoneNumber())) {
			error.add("please enter valid phone number");

		}
		if (student.getCollegeId() == null) {
			error.add("please enter college_id");
		} else {
			Optional<College> college=collegeRepo.findById(student.getCollegeId());
			if(!college.isPresent()){
				error.add("please enter valid college_id.");
			}
		}

		
		//  if (student.getcollege_id() == null) { error.add("please enter college"); }
		  
	  
		  if (!error.isEmpty()) { 
			  return error; 
			  }
		  
		  studentRepo.save(student); // error.add("Student created"); 
		  return error;
		  
		  }
		  
			
			  public List<Student> getAllStudentRecords(){ return studentRepo.getAll(); }
			  
			  public void deleteStudent(Long id) { studentRepo.deleteById(id); }
			  
			  public List<Student> getStudentByFirstName(String firstName){ 
				  List<Student> studentRecords = new ArrayList<Student>(); 
				  try { 
					  if(firstName != null && !firstName .isEmpty()) { 
						  studentRecords = studentRepo.findByFirstName(firstName); 
						  } 
					  }catch(Exception ex) { 
						  System.out.println("Exception while getting student records based on first name from service  : " + ex.getMessage()); 
						  } 
				  return studentRecords; 
				  }
			  
			  public List<Student> getStudentByLastName(String lastName){ 
				  List<Student>studentRecords = new ArrayList<Student>(); 
				  try { if(lastName != null && !lastName .isEmpty()) { 
					  studentRecords = studentRepo.findByLastName(lastName);
					  } 
				  }catch(Exception ex) { 
					  System.out.println("Exception while getting student records based on last name from service  : " + ex.getMessage()); } return studentRecords; }
			  
			  public List<Student> getStudentByEmail(String eMail){ 
				  List<Student>studentRecords = new ArrayList<Student>(); 
				  try { 
					  if(eMail != null && !eMail.isEmpty()) { 
						  studentRecords = studentRepo.findByeMail(eMail);
						  }
			  }catch(Exception ex) {
				  System.out.
			  println("Exception while getting student records based on eMail from service  : "
			  + ex.getMessage()); } return studentRecords;
			  
			  }
			 

	
	  public List<Student> getStudentByCollege(Long college){ List<Student>
	  studentRecords = new ArrayList<Student>(); 
	  try { 
		  if(college != null) { 
			  studentRecords = studentRepo.findByCollegeId(college);
		  } 
	  }catch(Exception ex) { 
		  System.out.println("Exception while getting student records based on college_id from service  : " + ex.getMessage()); } 
	  return studentRecords;
	  }
	 


/*
 * public List<Student> getStudentByColumn(String columnName, String value){
 * 
 * return studentRepo.findByColumnName(columnName, value); }
 */


  public List<Student> searchWithText(String searchText){
  searchText=searchText.toUpperCase(); return
  studentRepo.searchWithText(searchText,searchText,searchText,searchText); }
  
  public List<Student> searchWithTextAndCollege_Id(String searchText, String
  college_id) { searchText=searchText.toUpperCase();
  college_id=college_id.toUpperCase(); return
  studentRepo.searchWithTextAndCollege_Id(searchText,searchText,searchText,
  college_id);
  
  
  } }
 