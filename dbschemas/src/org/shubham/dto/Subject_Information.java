package org.shubham.dto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Subject_Information {

	@Id
	@GeneratedValue
	private Integer id;
	
	private Double credits;
	private String courseCode;
	private String courseTitle;
	
	@ManyToOne
	private Student_Information studentInformation;
	
	@OneToOne
	private Student_Marks studentmarks;
	
	
	public Student_Marks getStudentmarks() {
		return studentmarks;
	}
	public void setStudentmarks(Student_Marks studentmarks) {
		this.studentmarks = studentmarks;
	}
	
	public Student_Information getStudentInformation() {
		return studentInformation;
	}
	public void setStudentInformation(Student_Information studentInformation) {
		this.studentInformation = studentInformation;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getCredits() {
		return credits;
	}
	public void setCredits(Double credits) {
		this.credits = credits;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	
	
	
	
	
	
}
