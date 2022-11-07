package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Product;
import com.util.HibernateUtil;

public class Test {
public static void main(String[] args) {
	
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session =sf.openSession();
	
//	Product product =new Product();
//	product.setName("Laptop");
//	product.setPtype("Electronic");
//	product.setPrice(55000);
//	
//	session.save(product);
//	session.beginTransaction().commit();

	Product product = session.get(Product.class, 2);
	product.setName("vivo");
	session.update(product);
	session.beginTransaction().commit();
}
}
