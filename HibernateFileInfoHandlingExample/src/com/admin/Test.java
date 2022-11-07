package com.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.util.HibernateUtil;

import model.FileInfo;

public class Test {

	public static void main(String[] args) throws IOException {
		
		SessionFactory  sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		FileInfo fileinfo = new FileInfo();
		
		File file = new File("E:\\B19File\\College.txt");
		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.length());
		
		Path path = Paths.get(file.getAbsolutePath());
		byte[] b = Files.readAllBytes(path);
		
		System.out.println(Arrays.toString(b));
		fileinfo.setFname(file.getAbsolutePath());
		fileinfo.setFdata(b);
		fileinfo.setFsize(file.length());
		
		Date date = new Date(System.currentTimeMillis());
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:sss");
		String strDate = simpleDateFormat.format(date);
		
		fileinfo.setFileUploadDate(strDate);
		
		session.save(fileinfo);
		session.beginTransaction().commit();
	}
}
