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
public class User {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int uid;
	
	private String name;
	
	private String address;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="u_p_id")
	private List<Product>plist = new ArrayList<Product>();
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Product> getPlist() {
		return plist;
	}
	public void setPlist(List<Product> plist) {
		this.plist = plist;
	}
	@Override
	public String toString() {
		String s = "User Id : "+getUid()+"\nUser Name : "+getName()+"\nUser Address : "+getAddress()+"\nProduct List : "+getPlist();
		return s;
	}
	
	
}
