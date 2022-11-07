package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test3 {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Employee employee = session.get(Employee.class, 5);

		session.delete(employee);
	}
}
