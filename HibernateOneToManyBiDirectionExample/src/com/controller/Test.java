package com.controller;

import java.util.Scanner;

import com.service.OperationService;
import com.service.OpetationServiceIMpl;

public class Test {

	public static void main(String[] args) {

		OperationService op = new OpetationServiceIMpl();
		Scanner sc = new Scanner(System.in);

		boolean flag = true;

		System.out.println("\n******--Application started--*****\n");
		while (flag) {

			System.out.println("\n1. add Student With Multiple Subject");
			System.out.println("2.show All Student Data With Multiple Subject");
			System.out.println("3.get Single Student With Multiple Subject");
			System.out.println("4.update Student");
			System.out.println("5.update Perticular Subject using Student Id");
			System.out.println("6.delete Student");
			System.out.println("7.add Multiple Subject To Single Student");
			System.out.println("8.show All Subject With Student Data");
			System.out.println("9.get Single Subject With Student Data");
			System.out.println("10.update Subject");
			System.out.println("11.update Student Using Subject");
			System.out.println("12.delete Subject\n");

			int no = sc.nextInt();
			switch (no) {
			case 1:
				op.addStudentWithMultipleSubject();
				break;
			case 2:
				op.showAllStudentDataWithMultipleSubject();
				break;
			case 3:
				op.getSingleStudentWithMultipleSubject();
				break;
			case 4:
				op.updateStudent();
				break;
			case 5:
				op.updatePerticularSubjectusingStudentId();
				break;
			case 6:
				op.deleteStudent();
				break;
			case 7:
				op.addMultipleSubjectToSingleStudent();
				break;
			case 8:
				op.showAllSubjectWithStudentData();
				break;
			case 9:
				op.getSingleSubjectWithStudentData();
				break;
			case 10:
				op.updateSubject();
				break;
			case 11:
				op.updateStudentUsingSubject();
				break;
			case 12:
				op.deleteSubject();
				break;
			case 22:
				flag = false;
				break;
			default:
				
				System.out.println(no+" : selected No is roung please Enter correct No from above list other wise \n Enter 22 if you want to terminate application ");
				break;
			}

		}

	}

}
