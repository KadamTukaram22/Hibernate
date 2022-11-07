package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String sName;
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "s_f_Id")
	private Faculty faculty;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "s_c_Id")
	private Course course;
	
	

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sName=" + sName + ", faculty=" + faculty + ", course=" + course + "]";
	}


	
	
}
