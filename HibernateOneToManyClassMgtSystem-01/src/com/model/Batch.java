package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity()
public class Batch {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;
	private String bName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "b_c_Id")
    private Course course;
	
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "b_s_Id")
	private List<Student> slist = new ArrayList<>();

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public List<Student> getSlist() {
		return slist;
	}

	public void setSlist(List<Student> slist) {
		this.slist = slist;
	}

	@Override
	public String toString() {
		return "Batch [bid=" + bid + ", bName=" + bName + ", course=" + course + "]";
	}

	
}
