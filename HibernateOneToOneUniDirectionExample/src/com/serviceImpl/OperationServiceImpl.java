package com.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.Address;
import com.model.Student;
import com.service.OperationService;
import com.util.HibernateUtil;

public class OperationServiceImpl implements OperationService {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void insertStudentWithAddress() {
		Session session = sf.openSession();
		Student student = new Student();
		Address address = new Address();

		System.out.println("Enter Student Name :");
		student.setName(sc.next());

		System.out.println("Enter Student Email id :");
		student.setEmail(sc.next());

		System.out.println("Enter Student Password :");
		student.setPass(sc.next());

		System.out.println("Enter Student City :");
		address.setCity(sc.next());

		System.out.println("Enter student dist :");
		address.setDist(sc.next());

		student.setAddress(address);
		session.save(student);
		session.beginTransaction().commit();
	}

	@Override
	public void ShowAllData() {
		Session session = sf.openSession();
		Query<Student> query = session.createQuery("from Student");
		List<Student> slist = query.getResultList();
		System.out.println(slist);

	}

	@Override
	public void getSingleStudentWithAddress() {
		Session session = sf.openSession();

		System.out.println("Enter Student Id :");
		int id = sc.nextInt();

		Student student = session.get(Student.class, id);
		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("Student Not found");
		}

	}

	@Override
	public void UpdateStudent() {
		Session session = sf.openSession();

		System.out.println("Enter Student id :");
		int id = sc.nextInt();
		Student student = session.get(Student.class, id);
		if (student != null) {
			System.out.println("Enter Student name");
			student.setName(sc.next());

			System.out.println("Enter Student Email Id ");
			student.setEmail(sc.next());

			System.out.println("Enter Student password :");
			student.setPass(sc.next());

			session.update(student);
			session.beginTransaction().commit();
		} else {
			System.out.println("Student not found");
		}

	}

	@Override
	public void UpdateAddressUssingStudent() {
		Session session = sf.openSession();
		System.out.println("Enter Student id :");
		int id = sc.nextInt();

		Student student = session.get(Student.class, id);
		if (student != null) {
			Address address = student.getAddress();
			if (address != null) {
				System.out.println("Enter Student city ;");
				address.setCity(sc.next());

				System.out.println("Enter Student Dist");
				address.setDist(sc.next());

				session.update(student);
				session.beginTransaction().commit();

			} else {
				System.out.println("Address not Found");
			}
		} else {
			System.out.println("Student not Found");
		}

	}

	@Override
	public void DeleateStudent() {
		Session session = sf.openSession();
		System.out.println("Enter Student id :");
		int id = sc.nextInt();
		Student student = session.get(Student.class, id);
		if (student != null) {
			session.delete(student);
			session.beginTransaction().commit();

		} else {
			System.out.println("Student not found");
		}
	}

}
