package com.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();

//		Student student = new Student();
//		student.setName("Ajay");
//		student.setAddress("Pune");
//		session.save(student);
//
//		session.beginTransaction().commit();
//		System.out.println("Data inserted");

		Student student = session.get(Student.class, 1);
		System.out.println(student);
		Student student2 = session.get(Student.class, 2);
		System.out.println(student2);
		// session.evict(student);
		session.clear();
		System.out.println("=========================================");
		Student student1 = session.get(Student.class, 1);
		System.out.println(student1);
		Student student3 = session.get(Student.class, 2);
		System.out.println(student3);
	}
}
