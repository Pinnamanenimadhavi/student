package com.madhavi.student.Dao;

import java.util.List;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.madhavi.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	/*
	 * @Query(nativeQuery=true, value="select * from Student where e_Mail=?") public
	 * List<Student> isEmailExist(String eMail);
	 */
	
	
	public boolean existsByeMail(String eMail);
	 
	  @Query(nativeQuery = true, value = "select * from student")
	  public List<Student> getAll();
	  
	  public void deleteById(Long id);
	  
	  //public List<Student> findByColumnName(String columnName, String value);
	  
	  
	  @Query(nativeQuery=true, value="select * from student where upper(first_name) like ? OR upper(last_name) like ? OR upper(e_mail) like ? OR upper(college_id) like ?") 
	  public List<Student> searchWithText(String fName,String lName,String eMail,String college_id);
	  
	  @Query(nativeQuery=true, value="select * from student where (upper(first_name) like ? OR upper(last_name) like ? OR upper(e_mail) like ?) AND upper(college_id) like ?")
	  public List<Student> searchWithTextAndCollege_Id(String fName,String lName,String eMail,String college_id);
	  
	  public List<Student> findByFirstName(String firstName);
	  
	  public List<Student> findByLastName(String lastName);
	  
	  public List<Student> findByeMail(String eMail);
	  
	  public List<Student> findByCollegeId(Long collegeId);
	  
	  @Query(nativeQuery=true, value="select s.college_id, s.first_name, s.last_name, s.e_mail, s.phone_number, c.college_name from college c, student s  where c.college_id=s.college_id")
	  public List<StudentDetails> getStudentDetails();
	  public static interface StudentDetails{
			String getCollege_name(); 
			String getFirst_name();
			String getLast_name();
			String getE_mail();
            String getPhone_number();
			Long getCollege_id();
			
	 }
}
