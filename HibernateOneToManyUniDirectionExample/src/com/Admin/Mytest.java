package com.Admin;

import java.util.Scanner;

import com.service.OperationService;
import com.serviceImpl.OperationServiceImpl;

public class Mytest {
	public static void main(String[] args) {

		System.out.println("___________main method is started ____________");

		OperationService op = new OperationServiceImpl();
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("1.Add User with Multiple Products");
			System.out.println("2.Show All Data");
			System.out.println("3.Get Single User Data with Multiple product");
			System.out.println("4.Update User");
			System.out.println("5.Update perticular product using User");
			System.out.println("6.Deleate Perticular product Using User");
			System.out.println("7.Deleate User");
			System.out.println("8.AddProductDataToEistingUser");

			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				op.addUserWithMultipleProduct();

				break;
			case 2:
				op.ShowAllUserWithMultipleProductData();
				break;
			case 3:
				op.getSingleUserWithMultipleProductData();
				break;
			case 4:
				op.UpdateUser();

				break;
			case 5:
				op.UpdatePerticularProductDataUsingUserid();
				break;
			case 6:
				op.DeleatePerticularProductDataUsingUserId();
				break;
			case 7:
				op.DeleateUser();
				break;
			case 8:
				op.addProductDataToExistingUser();
				break;

			default:
				break;
			}

		}

	}
}
