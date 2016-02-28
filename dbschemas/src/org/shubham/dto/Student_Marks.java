package org.shubham.dto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student_Marks {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer id;
	
	private Double totalMarks;
	private String grade;
	
	/*@ManyToOne
	private Student_Information studentInformationMarks;
	
	
	public Student_Information getStudentInformation() {
		return studentInformationMarks;
	}
	public void setStudentInformation(Student_Information studentInformation) {
		this.studentInformationMarks = studentInformation;
	}*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(Double totalMarks) {
		this.totalMarks = totalMarks;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String double1) {
		this.grade = double1;
	}
	
}
