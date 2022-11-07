 package com.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.Product;
import com.util.HibernateUtil;

public class OperationInterfaceImpl implements OperationInterface {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addProductData() {

		Session session = sf.openSession();
		Product product = new Product();
		System.out.println("Enter Product name ");
		product.setName(sc.next());

		System.out.println("Enter Product type");
		product.setPtype(sc.next());

		System.out.println("Enter product price");
		product.setPrice(sc.nextDouble());

		session.save(product);
		session.beginTransaction().commit();

	}

	@Override
	public void ShowAllDate() {
		Session session = sf.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();//getCriteriaBuilder helps to create CriteriaBulder
		CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
		Root<Product> root = criteriaQuery.from(Product.class);//root is instance of table without root you cannot be fire Query
		criteriaQuery.select(root);

		Query<Product> query = session.createQuery(criteriaQuery);
		List<Product> plist = query.getResultList();
		System.out.println(plist);
	}

	@Override
	public void getSingleProduct() {
		Session session = sf.openSession();
		System.out.println("Enter Product id :");
		int id = sc.nextInt();

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
		Root<Product> root = criteriaQuery.from(Product.class);
		criteriaQuery.select(root).where(builder.equal(root.get("id"), id));

		Query<Product> query = session.createQuery(criteriaQuery);
		try {
			Product product = query.getSingleResult();
			System.out.println(product);
		} catch (Exception e) {
			System.out.println(new NoResultException("Product Not fount"));
		}

	}

	@Override
	public void getsinglecolumnData() {
		Session session = sf.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);
		Root<Product> root = criteriaQuery.from(Product.class);
		criteriaQuery.select(root.get("name"));
		Query<String> query = session.createQuery(criteriaQuery);
		List<String> slist = query.getResultList();
		System.out.println(slist);

	}

	@Override
	public void getMultipleColumnData() {

		Session session = sf.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);

		Root<Product> root = criteriaQuery.from(Product.class);

		criteriaQuery.multiselect(root.get("name"), root.get("price"));

		Query<Object[]> query = session.createQuery(criteriaQuery);

		List<Object[]> olist = query.getResultList();

		for (Object[] obj : olist) {
			System.out.println("Product Name :" + obj[0]);
			System.out.println("Product price :" + obj[1]);

		}

	}

}
