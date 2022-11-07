package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AdharCardNo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;

	private String aname;

	private int anumber;

	@OneToOne(cascade = CascadeType.ALL)
	private Person person;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public int getAnumber() {
		return anumber;
	}

	public void setAnumber(int anumber) {
		this.anumber = anumber;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "AdharCardNo [aid=" + aid + ", aname=" + aname + ", anumber=" + anumber + "]";
	}

	



}
