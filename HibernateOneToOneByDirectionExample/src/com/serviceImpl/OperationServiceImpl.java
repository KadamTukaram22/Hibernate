package com.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.AdharCardNo;
import com.model.Person;
import com.service.OperationService;
import com.util.HibernateUtil;

public class OperationServiceImpl implements OperationService {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void insertPersonDetailsWithAdharData() {
		Session session = sf.openSession();
		Person person = new Person();
		AdharCardNo adhar = new AdharCardNo();

		System.out.println("Enter Person name");
		person.setPname(sc.next());

		System.out.println("Enter Person address");
		person.setPaddress(sc.next());

		System.out.println("Enter Adharcard name");
		adhar.setAname(sc.next());

		System.out.println("Enter AdharNo");
		adhar.setAnumber(sc.nextInt());

		person.setAdharno(adhar);
		//adhar.setPerson(person);
		session.save(person);
		//session.save(adhar);
		session.beginTransaction().commit();
	}

	@Override
	public void ShowAllPersonDatawithAdharData() {
		Session session = sf.openSession();
		Query<Person> query = session.createQuery("from Person");
		List<Person> plist = query.getResultList();
		System.out.println(plist);

	}

	@Override
	public void ShowSinglePersonWithAdharData() {
		Session session = sf.openSession();
		System.out.println("Enter person id");
		int id = sc.nextInt();
		Person person = session.get(Person.class, id);
		if (person != null) {
			System.out.println("Person details is ");
			System.out.println(person);

		} else {
			System.out.println("Person is not found");
		}

	}

	@Override
	public void UpdatePerson() {
		Session session = sf.openSession();
		System.out.println("Enter person id you want to update ");
		int id = sc.nextInt();
		Person person = session.get(Person.class, id);
		if (person != null) {
			System.out.println("Enter your name");
			person.setPname(sc.next());

			System.out.println("Enter your address");
			person.setPaddress(sc.next());

			System.out.println(person);
			session.update(person);
			session.beginTransaction().commit();
			System.out.println("Student is update succesfull");
		}

	}

	@Override
	public void UpdateAdharWithUsingPerson() {
		Session session = sf.openSession();

		System.out.println("Enter id You want to update adhar");
		int id = sc.nextInt();

		Person person = session.get(Person.class, id);
		if (person != null) {
			
			AdharCardNo adhar = person.getAdharno();
			if (adhar != null) {

				System.out.println("Enter Adhar card name");
				adhar.setAname(sc.next());

				System.out.println("Enter adhar card no.");
				adhar.setAnumber(sc.nextInt());

			//	person.setAdharno(adhar);
				session.update(person);
				session.beginTransaction().commit();
				
			} else {
				System.out.println("adhar is not found");
			}

		} else {
			System.out.println("Person is not found");
		}

	}

	@Override
	public void insertAdharDetailsWithPersonData() {

		Session session = sf.openSession();
		AdharCardNo adhar = new AdharCardNo();
		Person person = new Person();
		
		System.out.println("Enter Adhar id");
		adhar.setAid(sc.nextInt());

		System.out.println("Enter Adhar name");
		adhar.setAname(sc.next());
		
		System.out.println("Enter adhar no");
		adhar.setAnumber(sc.nextInt());
		
		System.out.println("Enter person id");
		person.setPid(sc.nextInt());
		
		System.out.println("Enter person name");
		person.setPname(sc.next());
		
		System.out.println("Enter person address");
		person.setPaddress(sc.next());
		
		adhar.setPerson(person);
		person.setAdharno(adhar);
		session.save(adhar);
		session.save(person);
		session.beginTransaction();
		
	}

	@Override
	public void ShowAllAdharDetawithPersonData() {
	Session session = sf.openSession();
	
	Query<AdharCardNo>query = session.createQuery("from AdharCardNo");
	List<AdharCardNo>alist=query.getResultList();
	
	for(AdharCardNo ad:alist) {
		System.out.println(ad.getAid());
		System.out.println(ad.getAname());
		System.out.println(ad.getAnumber());
		System.out.println(ad.getPerson().getPid());
		System.out.println(ad.getPerson().getPname());
		System.out.println(ad.getPerson().getPaddress());
	}

	}

	@Override
	public void ShowSingleAdharWithPersonData() {
		Session session = sf.openSession();
		System.out.println("Enter Adhar id");
		int id = sc.nextInt();
		AdharCardNo Adhar = session.get(AdharCardNo.class, id);
		if (Adhar != null) {
			System.out.println("Adahr details is ");
			System.out.println(Adhar);

		} else {
			System.out.println("Adahr is not found");
		}

	}


	

	@Override
	public void UpdateAdhar() {
		Session session = sf.openSession();
		System.out.println("Enter Adhar id you want to update ");
		int id = sc.nextInt();
		AdharCardNo Adhar = session.get(AdharCardNo.class, id);
		if (Adhar != null) {
			System.out.println("Enter your name");
			Adhar.setAname(sc.next());

			System.out.println("Enter your number");
			Adhar.setAnumber(sc.nextInt());

			System.out.println(Adhar);
			session.update(Adhar);
			session.beginTransaction().commit();
			System.out.println("Student is update succesfull");
		}


	}

	@Override
	public void UpdatePersonWithUsingAdharData() {
		Session session = sf.openSession();

		System.out.println("Enter id You want to update person");
		int id = sc.nextInt();

		AdharCardNo Adhar= session.get(AdharCardNo.class, id);
		if (Adhar != null) {
			
			Person person = Adhar.getPerson();
			if (person != null) {

				System.out.println("Enter person card name");
				person.setPname(sc.next());

				System.out.println("Enter person card no.");
				person.setPaddress(sc.next());

		
				session.update(Adhar);
				session.beginTransaction().commit();
				
			} else {
				System.out.println("person is not found");
			}

		} else {
			System.out.println("Adhar is not found");
		}



	}

}
