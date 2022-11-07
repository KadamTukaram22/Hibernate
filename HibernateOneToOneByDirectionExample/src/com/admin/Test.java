package com.admin;

import java.util.Scanner;

import com.service.OperationService;
import com.serviceImpl.OperationServiceImpl;

public class Test {
	public static void main(String[] args) {

		OperationService op = new OperationServiceImpl();
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("1. insertAllPersonwithAdharDetails");
			System.out.println("2. show all person");
			System.out.println("3. Show single Person with adhar");
			System.out.println("4.update single person");
			System.out.println("5.update Adhar using person ");
			System.out.println("6.insert all adhar wiht Person Details");
			System.out.println("7.show all adharDeta");
			System.out.println("8.show single adhar with person");
			System.out.println("9.update single adharData");
			System.out.println("10.update person with adhar");

			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				op.insertPersonDetailsWithAdharData();
				break;
			case 2:
				op.ShowAllPersonDatawithAdharData();
				break;
			case 3:
				op.ShowSinglePersonWithAdharData();
				break;
			case 4:
				op.UpdatePerson();
				break;
			case 5:
				op.UpdateAdharWithUsingPerson();
				break;
			case 6:
				op.insertAdharDetailsWithPersonData();
				break;
			case 7:
				op.ShowAllAdharDetawithPersonData();
				;
				break;
			case 8:
				op.ShowSingleAdharWithPersonData();
				break;
			case 9:
				op.UpdateAdhar();
				break;
			case 10:
				op.UpdatePersonWithUsingAdharData();
				break;

			default:
				break;
			}

		}
	}
}