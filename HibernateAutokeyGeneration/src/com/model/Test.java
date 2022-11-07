package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
public static void main(String[] args) {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	
	Session session =sf.openSession();
	
	Product product = new Product();
	Customer customer =new Customer();
	
	customer.setCname("Tukaram");
	customer.setCaddress("nanded");
	
	product.setPname("Mobile");
	product.setPaddress("mumbai");
	
	
	System.out.println(customer);
	System.out.println(product);
	session.save(product);
	session.save(customer);
	session.beginTransaction().commit();
}
}
