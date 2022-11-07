package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
@SuppressWarnings("unchecked")
public class Test {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		//Employee employee = new Employee();
//
//		employee.setName("vaibhav");
//		employee.setAddress("nanded");
//		employee.setSalary(30000);
//
//		session.save(employee);
//		session.beginTransaction().commit();

		// Sellect * from employee;

		Query<Employee> query = session.createQuery("from Employee");
		List<Employee> elist = query.getResultList();
		System.out.println(elist);

		System.out.println("-----------------");
		// Sellect * from where id=?

//		Query<Employee> query2 = session.createQuery("from Employee where id =:i");
//		query2.setParameter("i", 1);
//		Employee employee1 = query2.getSingleResult();
//		System.out.println(employee1);

		// update employee set name =?,address=?,salary =?,where id = ?
        //tukaram change vishal
		Session session2 = sf.openSession();
		session2.beginTransaction();
		Query<Employee> query3 = session2
				.createQuery("update from Employee set name = :n,address=:a,salary =:s where id=:i");
		query3.setParameter("a", "mumbai");
		query3.setParameter("n", "vishal");
		query3.setParameter("s", 40000.0);
		query3.setParameter("i", 1);

		query3.executeUpdate();
		session2.getTransaction().commit();

		// delete *from employee where id=?
		session2.beginTransaction();
		Query<Employee>query4 = session2.createQuery("delete from Employee where id =:id1");
		query4.setParameter("id1", 1);
		query4.executeUpdate();
		
		System.out.println("-----------------------Hql Agreegation function ---------------------");
		
	
	    Query<Long> query5 = session2.createQuery("select count(*) from Employee");
        Long i = query5.getSingleResult();
        System.out.println("Employee Count : "  + i);
        
        Query<Double> query6 = session2.createQuery("select max(salary) from Employee");
        Double maxSalary = query6.getSingleResult();
        System.out.println("maximum Salary : " + maxSalary);
        
        Query<Double> query7 = session2.createQuery("select min(salary) from Employee");
        Double minSalary = query7.getSingleResult();
        System.out.println("minimum Salary : " + minSalary);
        
        Query<Double> query8 =  session2.createQuery("select sum(salary) from Employee");
        Double sumSalary = query8.getSingleResult();
        System.out.println("Salary Sum : " +  sumSalary);
        
        Query<Double> query9 =  session2.createQuery("select avg(salary) from Employee");
        Double avgSalary = query9.getSingleResult();
        System.out.println("Salary Avg : " +  avgSalary);
        session2.getTransaction().commit();
	
	}
}
