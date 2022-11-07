package com.controller;

import java.util.Scanner;

import com.service.ProductRegister;
import com.service.UserProductImpl;
import com.service.UserRegister;

public class OnlineShop {

	public static void productRegister() {

		ProductRegister PR = new UserProductImpl();
		
		System.out.println("1. Add Products");
		System.out.println("2. Search Product By Name");
		System.out.println("3. Search Product By Price");


		Scanner sc = new Scanner(System.in);
		String ch = sc.next();
		
		
			switch (ch) {

			case "1":
				PR.addListOfProducts();
				break;

			case "2":
				PR.searchProductByName();
				break;

			case "3":
				PR.searchProductByPrice();
				break;

			default:
				System.out.println("Please Choose Correct Option.....");

				break;
			
		}

	}

	public static void userRegister() {

		UserRegister UR = new UserProductImpl();
		
		System.out.println("1. Add User");
		System.out.println("2. Register Product");
		System.out.println("3. Remove Product From Cart");

		Scanner sc = new Scanner(System.in);
		String ch = sc.next();
	

			switch (ch) {

			case "1":
				UR.addUser();
				break;
				
			case "2":
				UR.productRegister();
				break;

			case "3":
				UR.deleteParticulatCart();
				break;
	
				
			default:
				System.out.println("Please Choose Correct Option.....");

				break;
			
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("=====================Online Shopping App=======================");

		boolean flag = true;

		while (flag) {

			System.out.println("1. PRODUCT REGISTER");
			System.out.println("2. USER REGISTER");

			System.out.println("3. EXIT");

			String ch = sc.next();

			switch (ch) {

			case "1":
				OnlineShop.productRegister();
				break;

			case "2":
				OnlineShop.userRegister();
				break;

			case "3":
				System.out.println(".....You Exit From The Application.....");
				flag = false;
				break;

			default:
				System.out.println("Please Choose Correct Option...");

				break;
			}

		}
	}
}
