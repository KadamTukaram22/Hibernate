package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test2 {
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		Employee employee = session.get(Employee.class, 2);
		employee.setName("vaibhav");
		employee.setAddress("pune");
		employee.setSalary(25000);

		session.save(employee);
		session.beginTransaction().commit();

	}
}
