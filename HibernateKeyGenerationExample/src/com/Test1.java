package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test1 {
public static void main(String[] args) {
SessionFactory sf=	HibernateUtil.getSessionFactory();

Session session = sf.openSession();

//eager loading
Student student = session.get(Student.class, 1);

System.out.println(student.getId());
System.out.println(student.getName());
System.out.println(student.getAddress());
System.out.println("--------------------");
//lazy loading
Student student1 = session.load(Student.class, 2);
System.out.println(student1.getId());
System.out.println(student1.getName());
System.out.println(student1.getAddress());



}
}
