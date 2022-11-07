package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestOne {
public static void main(String[] args) {
	Configuration cfg = new Configuration().configure("Hibernet.cfg.xml");
	
	SessionFactory sf = cfg.buildSessionFactory();
	
	Session session = sf.openSession();
	
	Employee employee = session.get(Employee.class, 101);
	
	System.out.println(employee);
}
}
