package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Test {
	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
//
//		Student student = new Student();
//		student.setName("kadam tukaram");
//		student.setAddress("Pune");
//
//		session.save(student);
//		session.beginTransaction().commit();
//
//		System.out.println("Done");

		Query<Student> query = session.createNamedQuery("allData");
			List<Student> slist = query.getResultList();
			System.out.println(slist);
		 	
			Query<Student> query2 = session.createNamedQuery("singleStudent");
			query2.setParameter("id1", 1);
			Student student1 = query2.getSingleResult();
			System.out.println(student1);

	}
}
