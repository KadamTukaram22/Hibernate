package com.controlle;

import java.util.Scanner;

import com.service.OperationInterface;
import com.service.OperationInterfaceImpl;

public class Test {
	public static void main(String[] args) {
		OperationInterface op = new OperationInterfaceImpl();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. add Product");
			System.out.println("2. Show all Product");
			System.out.println("3. Get Single Product");
			System.out.println("4. Get single Column Data");
			System.out.println("5. Get Multiple Column data");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				op.addProductData();
				break;
			case 2:
				op.ShowAllDate();
				break;
			case 3:
				op.getSingleProduct();
				break;
			case 4:
				op.getsinglecolumnData();
				break;
			case 5:
				op.getMultipleColumnData();
				break;

			default:
				break;
			}

		}
	}
}
