package com.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.Batch;
import com.model.Course;
import com.model.Faculty;
import com.model.Student;
import com.service.OperationService;
import com.util.HibernateUtil;

public class OperationServiceImpl implements OperationService {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addCourseWithMultipleFaculty() {
		Course course = new Course();
		Session session = sf.openSession();

		System.out.println("Enter Course Name: ");
		course.setName(sc.next());

		System.out.println("How Many Faculties You Want To Add To This Particular Course: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			Faculty faculty = new Faculty();

			System.out.println("Enter Faculty Name: ");
			faculty.setfName(sc.next());

			course.getFlist().add(faculty);

		}

		session.save(course);
		session.beginTransaction().commit();

	}

	@Override
	public void showAllCourseWithMultipleFaculty() {

		Session session = sf.openSession();

		Query<Course> query = session.createQuery("from Course");

		List<Course> plist = query.getResultList();
		for (Course course2 : plist) {
			System.out.println(course2);
		}

	}

	@Override
	public void getSingleCourseWithMultipleFaculty() {
		Session session = sf.openSession();

		System.out.println("Enter Course Id: ");
		int id = sc.nextInt();

		Course course2 = session.get(Course.class, id);
		if (course2 != null) {

			System.out.println(course2);

		} else {
			System.out.println("You Entered Invalid Course Id.............");
			getSingleCourseWithMultipleFaculty();
		}

	}

	@Override
	public void addFacultyToParticularCourse() {

		Session session = sf.openSession();
		Faculty faculty = new Faculty();

		System.out.println("Enter Course Id  U Want To Add Faculty: ");
		int cid = sc.nextInt();

		Course course2 = session.get(Course.class, cid);

		if (course2 != null) {

			System.out.println("Enter Faculty Name: ");
			faculty.setfName(sc.next());

			course2.getFlist().add(faculty);
			session.save(course2);

			session.beginTransaction().commit();
			System.out.println("Faculty Add Suscessfully....");
		} else {
			System.out.println("Please Enter Valid Course Id........");
			addFacultyToParticularCourse();
		}

	}

	@Override
	public void showAllFaculties() {

		Session session = sf.openSession();

		Query<Faculty> query = session.createQuery("from Faculty");

		List<Faculty> flist = query.getResultList();

		for (Faculty faculty : flist) {
			System.out.println(faculty);
		}

	}

	@Override
	public void addBatchWithMultipleStudentsToParticularFacultyAndCourse() {

		Batch batch = new Batch();
		// Faculty f = new Faculty();
		Session session = sf.openSession();

		System.out.println("Enter Batch Name: ");
		batch.setbName(sc.next());

		System.out.println("Enter Course Id Where U Want To Add this Batch: ");
		int cid = sc.nextInt();

		Course course = session.get(Course.class, cid);

		if (course != null) {

			batch.setCourse(course);

			System.out.println("Enter Faculty Id Where U Want Add This Students: ");
			int fid = sc.nextInt();

			Faculty faculty = session.get(Faculty.class, fid);
			if (faculty != null) {

				System.out.println("How Many Students You Want To Add To This Particular Batch: ");
				int n = sc.nextInt();

				for (int i = 1; i <= n; i++) {

					Student student = new Student();

					System.out.println("Enter Student Name: ");
					student.setsName(sc.next());

					faculty.getBlist().add(batch);
					session.save(faculty);
					session.save(batch);

					student.setFaculty(faculty);
					course.getFlist().add(faculty);
					student.setCourse(course);

					batch.getSlist().add(student);

					session.save(batch);
					session.save(course);
					session.save(student);

				}

				session.beginTransaction().commit();

			} else {
				System.out.println("Entered Faculty Id is Not Available.........");
			}
		} else {
			System.out.println("You Entered Invalid Course Id.......Please Enter Present Valid Course Id");
			addBatchWithMultipleStudentsToParticularFacultyAndCourse();
		}

	}

	@Override
	public void showAllBatch() {
		Session session = sf.openSession();

		Query<Batch> query = session.createQuery("from Batch");

		List<Batch> flist = query.getResultList();

		for (Batch batch : flist) {
			System.out.println(batch);
		}

	}

	@Override
	public void getSingleBatch() {
		Session session = sf.openSession();

		Batch batch = new Batch();

		System.out.println("Enter Batch Id: ");
		int id = sc.nextInt();

		Batch batch2 = session.get(Batch.class, id);
		if (batch2 != null) {

			System.out.println(batch2);

		} else {
			System.out.println("You Entered Invalid Batch Id.............");
			getSingleBatch();
		}

	}

	@Override
	public void addStudentToParticaularBatchToPerticularFacultyAndCourse() {

		Session session = sf.openSession();

		Student student = new Student();
		System.out.println("Enter Batch Id Where U Want To Add: ");
		int bid = sc.nextInt();

		Batch batch2 = session.get(Batch.class, bid);

		if (batch2 != null) {

			System.out.println("Enter Faculty Id Where U Want To Add this Students: ");
			int fid = sc.nextInt();

			Faculty faculty2 = session.get(Faculty.class, fid);

			if (faculty2 != null) {

				System.out.println("Enter Course Id Where U Want To Add This Student: ");
				int cid = sc.nextInt();

				Course course2 = session.get(Course.class, cid);

				if (course2 != null) {

					System.out.println("Enter Student Name: ");
					student.setsName(sc.next());

					student.setCourse(course2);
					student.setFaculty(faculty2);
					session.save(student);
					batch2.getSlist().add(student);
					session.save(batch2);

					session.beginTransaction().commit();
					System.out.println("Student Add Suscessfully....");
				} else {

					System.out.println("Entered Course Id Is Not Available");
				}

			} else {
				System.out.println("Entered Faculty Id Is Not Avaialable.....");

			}

		} else {
			System.out.println("Please Enter Valid Batch Id........");
			addStudentToParticaularBatchToPerticularFacultyAndCourse();
		}
	}

	@Override
	public void showAllStudents() {
		Session session = sf.openSession();

		Query<Student> query = session.createQuery("from Student");

		List<Student> slist = query.getResultList();

		for (Student student : slist) {
			System.out.println(student);
		}

	}

	@Override
	public void addFacultyWithMultipleBatchToParticularCourse() {

		Session session = sf.openSession();

		Faculty faculty = new Faculty();

		System.out.println("Enter Faculty Name: ");
		faculty.setfName(sc.next());

		System.out.println("Enter Course Id where U want To Add this Faculty......");
		int cid = sc.nextInt();

		Course course = session.get(Course.class, cid);

		if (course != null) {

			System.out.println("Enter How Many Batch U want to Add to this Faculty...");
			int n = sc.nextInt();

			for (int i = 1; i <= n; i++) {

				Batch batch = new Batch();
				System.out.println("Enter Batch Name: ");
				batch.setbName(sc.next());

				course.getFlist().add(faculty);
				batch.setCourse(course);
				session.save(course);
				faculty.getBlist().add(batch);

				session.save(faculty);

			}

			session.beginTransaction().commit();
			System.out.println("Data Stored Suscessfully.....");
		}
	}

	@Override
	public void getSingleFacultyWithMultipleBatch() {

		Session session = sf.openSession();

		System.out.println("Enter Faculty Id: ");
		int id = sc.nextInt();
		Faculty faculty2 = session.get(Faculty.class, id);

		if (faculty2 != null) {
			System.out.println(faculty2);
		} else {
			System.out.println("You Entered Faculty Id is Not Available.....");
		}

	}
}
