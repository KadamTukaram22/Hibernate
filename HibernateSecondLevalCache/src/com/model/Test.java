package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
public static void main(String[] args) {
		
		
		SessionFactory sf = HibernateSecondUtil.getSessionFactory();
		
		Session session =  sf.openSession();
//		
//		Employee employee = new Employee();
//		employee.setEname("Pqrs");
//		employee.setSalary(12345);
//		session.save(employee);
//		session.beginTransaction().commit();
//		System.out.println("Data Stored");
//		
		Employee employee = session.get(Employee.class, 1);
		System.out.println(employee);
		session.clear();
		System.out.println("=====================================");
		
		Session session2 = sf.openSession();
		Employee employee2 =  session2.get(Employee.class, 1);
		System.out.println(employee2);
	}
}
