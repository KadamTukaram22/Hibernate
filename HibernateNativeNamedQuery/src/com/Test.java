package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Test {
	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		session.beginTransaction();
		
		Employee employee = new Employee();
		
		employee.setEname("dnyaneshwar");
		employee.setEaddress("nanded");

		Query<Employee> query = session.getNamedNativeQuery("insert");
		query.setParameter(1, employee.getId());
		query.setParameter(2, employee.getEname());
		query.setParameter(3, employee.getEaddress());
		
		query.executeUpdate();
		session.getTransaction().commit();
		System.out.println("done");
	}
}