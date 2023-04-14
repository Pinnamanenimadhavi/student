package com.madhavi.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.madhavi.student.Dao.StudentRepository;
import com.madhavi.student.entity.College;
import com.madhavi.student.entity.Student;
import com.madhavi.student.service.CollegeService;
import com.madhavi.student.service.StudentService;


@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private CollegeService collegeService;
	@Autowired
	private StudentRepository repo;
	@PostMapping("/createStudentDetails")
	public ResponseEntity<Object> createStudentDetails(@RequestBody Student student) throws Exception{
		List list =studentService.createStudent(student);
		if(list.isEmpty()) {
			//studentService.sendEmail(student.geteMail(), "Welcome to careerTuner"+" "+student.getFirstName()+" "+student.getLastName(), "Account Creation Successful");
			return new ResponseEntity<>("Student Created Successfully", HttpStatus.OK);//student created return 200 OK
			
		}
		return new ResponseEntity(list, HttpStatus.BAD_REQUEST);//return bad request
		}

		/*
		 * @GetMapping("/getAllStudents")
		 *  public List<Student> getAllStudents(){ 
		 *  return studentService.getAllStudentRecords();
		 * 
		 * }
		 * 
		 * @DeleteMapping("/deleteStudentById/{id}") 
		 * public String deleteStudentById(@PathVariable("id") String id) {
		 * studentService.deleteStudent(new Long(id)); return "Record deleted"; }
		 * 
		 * @GetMapping("/getStudentsRecordsByFirstName/{firstName}") public
		 * List<Student> getStudentsRecordsByFirstName(@PathVariable("firstName") String
		 * firstname){ List<Student> studentRecords = new ArrayList<Student>(); try {
		 * if(firstname!= null || !firstname.isEmpty()) { studentRecords =
		 * studentService.getStudentByFirstName(firstname); } }catch(Exception ex) {
		 * System.out.
		 * println("Exception while getting student records based on first name from controller  : "
		 * +ex.getMessage()); } return studentRecords; }
		 * 
		 * @GetMapping("/getStudentsRecordsByLastName/{lastName}") public List<Student>
		 * getStudentsRecordsByLastName(@PathVariable("lastName") String lastname){
		 * List<Student> studentRecords = new ArrayList<Student>(); try {
		 * if(lastname!=null || !lastname.isEmpty()) { studentRecords =
		 * studentService.getStudentByLastName(lastname); } }catch(Exception ex) {
		 * System.out.
		 * println("Exception while getting student records based on last name from controller  : "
		 * +ex.getMessage()); } return studentRecords; }
		 * 
		 * @GetMapping("/getStudentsRecordsByEmail/{eMail}") public List<Student>
		 * getStudentsRecordsByEmail(@PathVariable("eMail") String eMail){ List<Student>
		 * studentRecords = new ArrayList<Student>(); try { if(eMail!=null ||
		 * !eMail.isEmpty()) { studentRecords = studentService.getStudentByEmail(eMail);
		 * } }catch(Exception ex) { System.out.
		 * println("Exception while getting student records based on eMail from controller  : "
		 * +ex.getMessage());
		 * 
		 * } return studentRecords;
		 */
	//}
	
	/*
	 * @GetMapping("/getStudentsRecordsByCollege_id/{college_id}") public
	 * List<Student> getStudentsRecordsByCollege_Id(@PathVariable("college_id")
	 * String college_id){ List<Student> studentRecords = new ArrayList<Student>();
	 * try { if(college_id!=null || !college_id.isEmpty()) { studentRecords =
	 * studentService.getStudentByCollege_Id(college_id); } }catch(Exception ex) {
	 * System.out.
	 * println("Exception while getting student records based on college from controller  : "
	 * +ex.getMessage());
	 * 
	 * } return studentRecords;
	 * 
	 * }
	 * 
	 * @GetMapping("/searchWithText/{searchText}") public List<Student>
	 * searchWithText(@PathVariable("searchText") String searchText){ return
	 * studentService.searchWithText("%"+searchText+"%"); }
	 * 
	 * @GetMapping("/getusersfilterdata") public List<Student>
	 * getusersfilterdata(@RequestParam(required = true) String
	 * searchText, @RequestParam(required = false) String college_id){ return
	 * studentService.searchWithTextAndCollege_Id("%"+searchText+"%",
	 * "%"+college_id+"%"); }
	 * 
	 * @GetMapping("/getByColumName/{columnName}/{value}") public List<Student>
	 * getByColumName(@PathVariable("columnName") String
	 * columnName, @PathVariable("value") String value){ if
	 * (columnName.equals("firstName")) { return
	 * studentService.getStudentByFirstName(value); }
	 * if(columnName.equals("lastName")) { return
	 * studentService.getStudentByLastName(value); } if(columnName.equals("eMail"))
	 * { return studentService.getStudentByEmail(value); }
	 * if(columnName.equals("college_id")) { return
	 * studentService.getStudentByCollege_Id(value); } return new
	 * ArrayList<Student>();
	 * 
	 * }
	 */
	
	@PostMapping("/addCollegeDetails")
	public String addCollegeDetails(@RequestBody College college) {
		return collegeService.createCollegeDetails(college);
		
	}
	
	@GetMapping("/getStudentDetails")
	public Object getStudentDetails() {
		return repo.getStudentDetails();
		
	}
	
}
