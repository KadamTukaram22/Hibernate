package com.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.Batch;
import com.model.Cource;
import com.model.Faculty;
import com.model.Student;
import com.service.OperationService;
import com.util.HibernateUtil;

public class OperationServiceImp implements OperationService {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addCource() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Cource course = new Cource();
		System.out.println("Enter Course Name : ");
		course.setName(sc.next());
		session.save(course);
		session.beginTransaction().commit();

	}

	@Override
	public void displayCource() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		Query<Cource> query = session.createQuery("from Cource");

		List<Cource> clist = query.getResultList();
		for (Cource c : clist) {
			System.out.println(c.getId());
			System.out.println(c.getName());
			

		}

	}

	@Override
	public void addfaculty() {

		Session session = sf.openSession();
		Faculty faculty = new Faculty();

		System.out.println("Enter Faculty Name :");
		faculty.setFname(sc.next());

		displayCource();
		System.out.println("plese select course id from above List :");
		int userEnteredCId = sc.nextInt();

		Query<Cource> query = session.createQuery("from Cource");

		List<Cource> clist = query.getResultList();
		for (Cource course : clist) {
			if (course.getId() == userEnteredCId) {
				faculty.setCource(course);

				session.save(faculty);
				session.beginTransaction().commit();
			
			}
		}

	}

	@Override
	public void DisplayFaculty() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Query<Faculty> query = session.createQuery("from Faculty");

		List<Faculty> flist = query.getResultList();
		// System.out.println(clist);
		for (Faculty faculty : flist) {

			System.out.println(faculty);

		}
	}

	@Override
	public void addBatch() {
		Batch batch = new Batch();
		Session session = sf.openSession();
		System.out.println("Enter Batch  name :");
		batch.setBname(sc.next());

		DisplayFaculty();
		System.out.println("Enter Faculty Id : ");
		int enteredId = sc.nextInt();
		Query<Faculty> query = session.createQuery("from Faculty");

		List<Faculty> flist = query.getResultList();

		for (Faculty faculty : flist) {
			if (faculty.getFid() == enteredId) {
				batch.setFaculty(faculty);

				session.save(batch);
				session.beginTransaction().commit();
			}
		}

	}

	@Override
	public void DisplayBatch() {

		Session session = sf.openSession();
		System.out.println("Show batch called  :");

		Query<Batch> query = session.createQuery("from Batch");

		List<Batch> blist = query.getResultList();

		for (Batch batch : blist) {
			System.out.println(batch);
		}

	}

	@Override
	public void addStudentDetail() {
		Session session = sf.openSession();
		Student student = new Student();
		System.out.println("Enter Student Name :");
		student.setSname(sc.next());

		DisplayBatch();
		System.out.println("Enter Batch Id : ");
		int enteredId = sc.nextInt();

		Query<Batch> query = session.createQuery("from Batch");

		List<Batch> blist = query.getResultList();
		for (Batch batch : blist) {
			if (batch.getBid() == enteredId) {
				student.setBatch(batch);

				session.save(student);
				session.beginTransaction().commit();
			}
		}
	}

	@Override
	public void displayStudentDetail() {
		Session session = sf.openSession();
		System.out.println("Student datail called ...");

		Query<Student> query = session.createQuery("from Student");

		List<Student> slist = query.getResultList();
		for (Student student : slist) {

			System.out.println(student);
		}
	}

	@Override
	public void DeleateCource() {
		Session session = sf.openSession();
		System.err.println("Enter you want to deleate Course");
		int enterid = sc.nextInt();

		Cource cource = session.get(Cource.class, enterid);
		if (cource != null) {

			session.delete(cource);
			session.beginTransaction().commit();
		}

	}

	@Override
	public void UpdateCource() {
		Session session = sf.openSession();
		System.out.println("Enter you want to update cource id :");
		int id = sc.nextInt();

		Cource cource = session.get(Cource.class, id);
		if (cource != null) {

			System.out.println("Enter Course name :");
			cource.setName(sc.next());

			session.update(cource);
			session.beginTransaction().commit();
		}
	}

	@Override
	public void DeleateFaculty() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter you want to Faculty Deleate :");
		int enterid = sc.nextInt();

		Faculty faculty = session.get(Faculty.class, enterid);
		if (faculty != null) {

			

			session.delete(faculty);
			session.beginTransaction().commit();
		}

	}

	@Override
	public void UpdateFaculty() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter you want to Faculty Update");
		int enterid = sc.nextInt();

		Faculty faculty = session.get(Faculty.class, enterid);
		if (faculty != null) {

			System.out.println("Enter Faculty name :");
			faculty.setFname(sc.next());

			session.update(faculty);
			session.beginTransaction().commit();
		}
	}

	@Override
	public void DeleateBatch() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter you want to deleate Batch id :");
		int enterid = sc.nextInt();

		Batch batch = session.get(Batch.class, enterid);
		if (batch != null) {

			session.delete(batch);
			session.beginTransaction().commit();

		}
	}

	@Override
	public void UpdateBatch() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter update  Batch id :");
		int enterid = sc.nextInt();

		Batch batch = session.get(Batch.class, enterid);
		if (batch != null) {
			System.out.println("Enter Batch name :");
			batch.setBname(sc.next());

			session.update(batch);
			session.beginTransaction().commit();
		}
	}

	@Override
	public void DeleateStudent() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter you want to deleate Student :");
		int enterid = sc.nextInt();

		Student s = session.get(Student.class, enterid);
		if (s != null) {

			session.delete(s);
			session.beginTransaction().commit();
		}
	}

	@Override
	public void updateStudent() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter student update id :");
		int enterid = sc.nextInt();

		Student s = session.get(Student.class, enterid);
		if (s != null) {
			System.out.println("Enter student name :");
			s.setSname(sc.next());
			session.update(s);
			session.beginTransaction().commit();
		}
	}

	@Override
	public void Exist() {

	}

}