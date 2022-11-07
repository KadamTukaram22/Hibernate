package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;

	private String pname;

	private String paddress;
@OneToOne(cascade = CascadeType.ALL)
	private AdharCardNo adharno;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getPaddress() {
	return paddress;
}
public void setPaddress(String paddress) {
	this.paddress = paddress;
}
public AdharCardNo getAdharno() {
	return adharno;
}
public void setAdharno(AdharCardNo adharno) {
	this.adharno = adharno;
}
@Override
public String toString() {
	return "Person [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress + ", adharno=" + adharno + "]";
}

	
	

}
