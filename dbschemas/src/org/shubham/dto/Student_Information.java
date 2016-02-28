package org.shubham.dto;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student_Information {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	private String enrollmentNo;
	private String fatherName;
	private String motherName;
	//@Temporal(TemporalType.DATE)
	private String dateOfBirth;
	private String program;
	private String batch;
	private String semester;
	private Double year;
	
	@OneToMany(mappedBy="studentInformation")
	private Collection<Subject_Information> subjects=new ArrayList<Subject_Information>();
	

	@OneToMany(mappedBy="studentInformationMarks")
	private Collection<Student_Marks> marks=new ArrayList<Student_Marks>();
	

	
	public Collection<Student_Marks> getMarks() {
		return marks;
	}
	public void setMarks(Collection<Student_Marks> marks) {
		this.marks = marks;
	}
	public Collection<Subject_Information> getSubjects() {
		return subjects;
	}
	public void setSubjects(Collection<Subject_Information> subjects) {
		this.subjects = subjects;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnrollmentNo() {
		return enrollmentNo;
	}
	public void setEnrollmentNo(String enrollmentNo) {
		this.enrollmentNo = enrollmentNo;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public Double getYear() {
		return year;
	}
	public void setYear(Double year) {
		this.year = year;
	}
	
	
	
}
