package com.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.Student;
import com.model.Subject;
import com.util.HibernateUtil;

public class OpetationServiceIMpl implements OperationService {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addStudentWithMultipleSubject() {

		System.out.println("Add Student with Subject\n");
		Session session = sf.openSession();
		Student student = new Student();
		System.out.println("Enter Student Name  : ");
		student.setSname(sc.next());

		System.out.println("Enter How Many Subject to register by Student : ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			Subject subject = new Subject();
			System.out.println("Enter Subject Name :");
			subject.setSubName(sc.next());

			student.getSlist().add(subject);
			subject.setStudent(student);

			// session.save(subject);

			System.out.println(i + " student added successfully...");
		}
		session.save(student);

		session.beginTransaction().commit();
	}

	@Override
	public void showAllStudentDataWithMultipleSubject() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		List<Student> slist = session.createQuery("from Student").getResultList();
		for (Student s : slist) {
			System.out.println("Student Id : " + s.getSid());
			System.out.println("Student Name : " + s.getSname());

			List<Subject> slist1 = s.getSlist();

			for (Subject s1 : slist1) {
				System.out.println("Subject Id : " + s1.getSubId());
				System.out.println("Subject Name : " + s1.getSubName());

			}

		}
	}

	@Override
	public void getSingleStudentWithMultipleSubject() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		System.out.println("enter student Id :");
		int id = sc.nextInt();
		Student student = session.get(Student.class, id);

		if (student != null) {

			System.out.println(student);

		}

	}

	@Override
	public void updateStudent() {
		// TODO Auto-generated method stub

		Session session = sf.openSession();
		System.out.println("Enter student Id you want to update student :");
		int id = sc.nextInt();
		Student student = session.get(Student.class, id);

		if (student != null) {
			System.out.println("Enter Student Name  : ");
			student.setSname(sc.next());
			session.update(student);
			session.beginTransaction().commit();
			System.out.println("Update successfully...\n");
		}

	}

	@Override
	public void updatePerticularSubjectusingStudentId() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Student Id :");
		int id = sc.nextInt();
		Student student = session.get(Student.class, id);
		if (student != null) {

			List<Subject> slist = student.getSlist();

			System.out.println(" Enter You want to update  Sub Id");
			int sid = sc.nextInt();
			
			//Subject subject = session.get(Subject.class, id);
			//if (subject != null) {
				
				for (Subject s : slist) {
					if (s != null && s.getSubId() == sid) {
						System.out.println("Enter subject name :");
						s.setSubName(sc.next());

						// student.setSlist(slist);

						session.update(s);
						session.beginTransaction().commit();
					}
					
				}
			}

		}

	

	@Override
	public void deleteStudent() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Student Id you want to delete ");
		int id = sc.nextInt();
		Student student = session.get(Student.class, id);

		if (student != null) {
			session.delete(student);
			session.beginTransaction().commit();
		} else {
			System.out.println("Student not found ");
			deleteStudent();
		}
	}

	@Override
	public void addMultipleSubjectToSingleStudent() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter student Id ");
		int id = sc.nextInt();
		Student student = session.get(Student.class, id);

		if (student != null) {

			System.out.println("Enter How Many Subject to register by Student : ");
			int n = sc.nextInt();

			for (int i = 1; i <= n; i++) {
				Subject subject = new Subject();
				System.out.println("Enter Subject Name :");
				subject.setSubName(sc.next());

				student.getSlist().add(subject);
				subject.setStudent(student);

				// session.save(subject);

				System.out.println(i + " student added successfully...");
			}
			session.update(student);
			session.beginTransaction().commit();
		}

	}

	@Override
	public void showAllSubjectWithStudentData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		Query<Subject> query = session.createQuery("from Subject");
		List<Subject> sublist = query.getResultList();
		// System.out.println(sublist);

		for (Subject s : sublist) {
			System.out.println(s.getStudent().getSname() + " " + s.getStudent().getSid());
			System.out.println(s.getSubName());

		}

	}

	@Override
	public void getSingleSubjectWithStudentData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter subject Id :");
		int id = sc.nextInt();
		Subject subject = session.get(Subject.class, id);
		if (subject != null) {
			System.out.println(subject + "  Student Id : " + subject.getStudent().getSid() + "  student name : "
					+ subject.getStudent().getSname());
		}

	}

	@Override
	public void updateSubject() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter subject Id you want to update subject ");
		int id = sc.nextInt();
		Subject subject = session.get(Subject.class, id);

		if (subject != null) {
			System.out.println("Enter subject :");
			subject.setSubName(sc.next());

			session.update(subject);
			session.beginTransaction().commit();
		}

	}

	@Override
	public void updateStudentUsingSubject() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSubject() {
		// TODO Auto-generated method stub

		Session session = sf.openSession();
		System.out.println("Enter subject Id you want to update ");
		int id = sc.nextInt();

		Subject subject = session.get(Subject.class, id);

		if (subject.getSubId() == id) {
			session.delete(subject);
			System.out.println(" this subject deleted successfully");

			session.beginTransaction().commit();

		}
	}

}
