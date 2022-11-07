package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("Hibernet.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		Employee employee = new Employee();
		employee.setId(101);
		employee.setName("vaibhav");
		employee.setAddress("marlak bk");

		session.save(employee);
		session.beginTransaction().commit();
		System.out.println("data stored...");
	}
}
