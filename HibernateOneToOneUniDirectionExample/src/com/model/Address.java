package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private int aid;

private String city;

private String dist;

public int getAid() {
	return aid;
}

public void setAid(int aid) {
	this.aid = aid;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getDist() {
	return dist;
}

public void setDist(String dist) {
	this.dist = dist;
}

@Override
public String toString() {
	return "Address [aid=" + aid + ", city=" + city + ", dist=" + dist + "]";
}

}
