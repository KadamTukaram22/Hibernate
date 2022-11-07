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
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid;
	private String fName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "f_b_Id")
	List<Batch> blist = new ArrayList<>();
   
	

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public List<Batch> getBlist() {
		return blist;
	}

	public void setBlist(List<Batch> blist) {
		this.blist = blist;
	}

	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fName=" + fName + ", blist=" + blist + "]";
	}

	
	
	


}
