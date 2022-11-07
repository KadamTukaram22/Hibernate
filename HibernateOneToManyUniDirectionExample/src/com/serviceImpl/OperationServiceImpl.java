package com.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.Product;
import com.model.User;
import com.service.OperationService;
import com.util.HibernateUtil;

import net.bytebuddy.asm.Advice.Enter;

public class OperationServiceImpl implements OperationService {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addUserWithMultipleProduct() {
		Session session = sf.openSession();
		User user = new User();

		System.out.println("Enter User Name :");
		user.setName(sc.next());

		System.out.println("Enter User Address :");
		user.setAddress(sc.next());

		System.out.println("Enter how many product buying :");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			Product product = new Product();

			System.out.println("Enter product name :");
			product.setPname(sc.next());

			System.out.println("Enter Product price :");
			product.setPrice(sc.nextDouble());

			user.getPlist().add(product);
		}
		session.save(user);
		session.beginTransaction().commit();
		System.out.println("Data stored");
	}

	@Override
	public void ShowAllUserWithMultipleProductData() {
		Session session = sf.openSession();
		Query<User> query = session.createQuery("from User");
		
		List<User> ulist = query.getResultList();
		
		for (User user : ulist) {
			//System.out.println(user);
			System.out.println("User Id :"+user.getUid());
			System.out.println("User Name :"+user.getName());
			System.out.println("User Address :"+user.getAddress());
			
			List<Product> plist = user.getPlist();
			
			for (Product p : plist) {
				//System.out.println(p);
				System.out.println("Product Id :"+p.getPid());
				System.out.println("Product Name :"+p.getPname());
				System.out.println("Product Price :"+p.getPrice());
			}
		}
	}

	@Override
	public void getSingleUserWithMultipleProductData() {
		Session session = sf.openSession();
		System.out.println("Enter user id ");
		int id = sc.nextInt();
		User user = session.get(User.class, id);
		if (user != null) {
			System.out.println(user);
		} else {
			System.out.println("user is not found :");
			getSingleUserWithMultipleProductData();
		}
	}

	@Override
	public void UpdateUser() {
		Session session = sf.openSession();
		System.out.println("Enter user id :");
		int id = sc.nextInt();
		User user = session.get(User.class, id);
		if (user != null) {
			System.out.println("Enter user name :");
			user.setName(sc.next());

			System.out.println("Enter user address");
			user.setAddress(sc.next());
			session.update(user);
			session.beginTransaction().commit();
		}
	}

	@Override
	public void UpdatePerticularProductDataUsingUserid() {
		Session session = sf.openSession();
		System.out.println("Enter User Id");
		int id = sc.nextInt();
		User user = session.get(User.class, id);
		if (user != null) {
			List<Product> plist = user.getPlist();

			System.out.println("Enter You want to update product id");
			int pid = sc.nextInt();

			for (Product p : plist) {
				if (p.getPid() == pid) {
					System.out.println("Enter product name");
					p.setPname(sc.next());

					System.out.println("Enter product price");
					p.setPrice(sc.nextDouble());
					session.update(user);
					session.beginTransaction().commit();
				}
			}
		}

	}

	@Override
	public void DeleatePerticularProductDataUsingUserId() {

		Session session = sf.openSession();

		System.out.println("Enter User Id  you want to deleate product");
		int id = sc.nextInt();
		User user = session.get(User.class, id);

		List<Product> plist = user.getPlist();
		System.out.println("Enter product id you want to deleate");
		int pid = sc.nextInt();
		for (Product p : plist) {
			if (p != null && (p.getPid() == pid)) {

				session.delete(p);
				session.beginTransaction().commit();

			} else {
				System.out.println("User not found try again leter");
				DeleatePerticularProductDataUsingUserId();
			}
		}
	}

	@Override
	public void DeleateUser() {
		Session session = sf.openSession();
		System.out.println("Enter user id");
		int id = sc.nextInt();

		User user = session.get(User.class, id);
		if (user != null) {

			session.delete(user);
			session.beginTransaction().commit();
			System.out.println("Deleate user successfully");
		}
	}

	@Override
	public void addProductDataToExistingUser() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter user id");
		int id = sc.nextInt();
		User user = session.get(User.class, id);
		if (user != null) {
			Product product = new Product();

			System.out.println("Enter product name");
			product.setPname(sc.next());

			System.out.println("Enter Product price ");
			product.setPrice(sc.nextDouble());
			// List<Product> plist = user.getPlist();
			// plist.add(product);
			user.getPlist().add(product);

			session.save(user);
			session.beginTransaction().commit();
		}
	}
}
