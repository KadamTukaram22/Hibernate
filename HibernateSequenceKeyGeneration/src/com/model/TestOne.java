package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestOne {
public static void main(String[] args) {
SessionFactory sf=	HibernateUtil.getSessionFactory();
 Session session =sf.openSession();

 Customer customer = new Customer();
 customer.setCid(12);
 customer.setCname("Tukaram  kadam");
 customer.setCemail("KadamTukaram344@gimail.com");
 
 System.out.println(customer);
 session.saveOrUpdate(customer);
 session.beginTransaction().commit();
 System.out.println("SUCCESS");
}
}
