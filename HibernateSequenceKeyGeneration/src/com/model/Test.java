package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Student student = new Student();
		student.setSname("Tukaram kadam");
		student.setSemail("kadamtukaram2249@gmail.com");

		System.out.println(student);
		session.save(student);
		session.beginTransaction().commit();
		System.out.println("Scucess");
	}
}
