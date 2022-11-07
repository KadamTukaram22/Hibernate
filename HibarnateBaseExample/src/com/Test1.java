package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Test1 {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();

		Query<Employee> query = session.createQuery("from Employee");

		List<Employee> list = query.getResultList();

		System.out.println(list);
	}
}
