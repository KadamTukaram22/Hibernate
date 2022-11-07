package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String Name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "c_f_Id")
	private List<Faculty> flist = new ArrayList<>();

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<Faculty> getFlist() {
		return flist;
	}

	public void setFlist(List<Faculty> flist) {
		this.flist = flist;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", Name=" + Name +  "]";
	}

}
