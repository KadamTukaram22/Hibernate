package com.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.util.HibernateUtil;

import model.FileInfo;

public class Test1 {

	public static void main(String[] args) throws IOException {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		String newPath="E:\\";
		
		FileInfo fileinfo = session.get(FileInfo.class, 1);
		System.out.println(fileinfo);
		
		File file = new File(fileinfo.getFname());
		
		Path path = Paths.get(newPath+file.getName());
		
		Files.write(path, fileinfo.getFdata());
	}
}
