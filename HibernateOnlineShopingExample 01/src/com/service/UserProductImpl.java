package com.service;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.util.HibernateUtil;

import model.AddToChart;
import model.Product;
import model.ProductOrder;
import model.User;

public class UserProductImpl implements UserRegister, ProductRegister {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addListOfProducts() {

		User user = new User();
		Session session = sf.openSession();

		System.out.println("How Many Product U Want TO Add: ");

		try {

			int n = sc.nextInt();

			for (int i = 1; i <= n; i++) {

				Product product = new Product();
				System.out.println("Enter Product Name: ");
				product.setProduct_Name(sc.next());

				System.out.println("Enter Product Type: ");
				product.setProduct_Type(sc.next());

				System.out.println("Enter Product Price: ");
				product.setProduct_Price(sc.nextLong());

				user.getProduct_list().add(product);

				session.save(product);

			}
			session.beginTransaction().commit();

			System.out.println("Products Add SuscessFully.....");

		} catch (InputMismatchException e) {

			System.out.println("Try Again........");

		}

	}

	@Override
	public void searchProductByName() {

		Session session = sf.openSession();
		try {
			System.out.println("Enter Product Name: ");
			String pname = sc.next();

			Query<Product> query = session.createNamedQuery("singleProduct");
			query.setParameter("pname", pname);
			Product s = query.getSingleResult();
			System.out.println(s.getProduct_Id() + " " + s.getProduct_Name() + " " + "Price: " + s.getProduct_Price());

		} catch (NoResultException e) {

			System.out.println("No Such A Product Found........");
		}

	}

	@Override
	public void searchProductByPrice() {
		// TODO Auto-generated method stub

		Session session = sf.openSession();
		try {
			System.out.println("Enter Product Price: ");
			Long price = sc.nextLong();

			Query<Product> query = session.createNamedQuery("singleProduct2");
			query.setParameter("price", price);
			Product s = query.getSingleResult();
			System.out.println(s.getProduct_Id() + " " + s.getProduct_Name() + " " + "Price: " + s.getProduct_Price());

		} catch (Exception e) {
			System.out.println("No Such A Product Found....");
		}

	}

	@Override
	public void productRegister() {

		Session session = sf.openSession();

		try {

			System.out.println("Enter User Id: ");
			int uid1 = sc.nextInt();

			User user2 = session.get(User.class, uid1);

			if (user2 != null) {

				System.out.println("1. BUY NOW");
				System.out.println("2. ADD TO CART");
				int n = sc.nextInt();

				switch (n) {
				case 1:

					Query<Product> query = session.createQuery("from Product");

					List<Product> plist = query.getResultList();

					for (Product product : plist) {
						System.out.println(product.getProduct_Id() + " " + product.getProduct_Name() + " " + "Price: "
								+ product.getProduct_Price());

					}

					System.out.println("Choose Product From Above List With Product Id: ");

					int id = sc.nextInt();

					Product product = session.get(Product.class, id);

					if (product != null) {

						Date date = new Date();

						ProductOrder p = new ProductOrder();

						p.setOrder_date(date);
						p.setProduct(product);
						p.setUser(user2);
						p.setOrder_Id(id);
						session.save(p);

						session.beginTransaction().commit();
						System.out.println("Product Buy Completed ........");
					} else {
						System.out.println("Product Not Available At this Id...");
						productRegister();
					}

					break;

				case 2:

					Query<Product> query1 = session.createQuery("from Product");

					List<Product> plist1 = query1.getResultList();

					for (Product product1 : plist1) {
						System.out.println(product1.getProduct_Id() + " " + product1.getProduct_Name() + " " + "Price: "
								+ product1.getProduct_Price());

					}

					System.out.println("Choose Product From Above List With Product Id: ");

					int id3 = sc.nextInt();

					Product product5 = session.get(Product.class, id3);

					if (product5 != null) {

						Date date = new Date();

						AddToChart a = new AddToChart();

						a.setPurchase_Date(date);
						a.setProduct(product5);
						a.setUser(user2);
						session.save(a);

						session.beginTransaction().commit();

						System.out.println("Add To Cart Suscessfully.....");
					} else {
						System.out.println("Product Not Available At this Id...");
						productRegister();
					}

					break;

				default:
					System.out.println("OOPS....You Choose Wrong Option... ");

					break;
				}

			} else {
				System.out.println("First Registered To Avail .....");
				// addUser();

			}
		} catch (Exception e) {

			System.out.println("Try Again....");

		}
	}

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		User user = new User();
		Session session = sf.openSession();

		try {

			System.out.println("Enter First Name:  ");
			user.setFirst_Name(sc.next());

			System.out.println("Enter Last Name:  ");
			user.setLast_Name(sc.next());

			System.out.println("Enter Mobile No:  ");
			user.setMobile_Number(sc.nextLong());

			System.out.println("Enter Email:  ");
			user.setEmail_Id(sc.next());

			session.save(user);
			session.beginTransaction().commit();
		} catch (Exception e) {
			System.out.println("Try Again....");
		}

	}

	@Override
	public void deleteParticulatCart() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		try {

			System.out.println("Enter Cart Id: ");
			int cid = sc.nextInt();

			AddToChart cart = session.get(AddToChart.class, cid);

			if (cart != null) {

				session.delete(cart);
				session.beginTransaction().commit();

				System.out.println("Cart Removed From User Suscessfully...");

			} else {
				System.out.println("Cart Not Found...");

			}

		} catch (Exception e) {
			System.out.println("Try Again .....");
		}
	}

}
