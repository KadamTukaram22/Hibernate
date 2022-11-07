package com.main;

import java.util.Scanner;

import com.service.OperationService;
import com.serviceImpl.OperationServiceImpl;

public class Test {

	private static Scanner sc;

	public static void main(String[] args) {

		OperationService op = new OperationServiceImpl();

		sc = new Scanner(System.in);

		System.out.println("=====================Aplication Start=======================");

		boolean flag = true;

		while (flag) {

			System.out.println("1. Add Course With Multiple Faculty");
			System.out.println("2. Show All Course With Multiple Faculty");
			System.out.println("3. Get Single Course With Multiple Faculty");
			System.out.println("4. Add Faculty To Particular Course ");
			System.out.println("5. Show All Faculties");
			System.out.println("6. Add Batch With Multiple Students To Particular Faculty And Course");
			System.out.println("7. Show All Batch ");
			System.out.println("8. Get Single Batch  ");
			System.out.println("9. Add Student To Particaular Batch To Perticular Faculty And Course");
			System.out.println("10. Show All Students");
			System.out.println("11. Add Faculty With Multiple Batch To Particular Course");
			System.out.println("12. Get Single Faculty With Multiple Batch ");



			System.out.println("13. For Terminate Application");

			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				op.addCourseWithMultipleFaculty();
				break;

			case 2:
				op.showAllCourseWithMultipleFaculty();
				break;

			case 3:
				op.getSingleCourseWithMultipleFaculty();
				break;

			case 4:
				op.addFacultyToParticularCourse();
				break;

			case 5:
				op.showAllFaculties();
				break;

			case 6:
				op.addBatchWithMultipleStudentsToParticularFacultyAndCourse();
				break;

			case 7:
				op.showAllBatch();
				break;

			case 8:
				op.getSingleBatch();
				break;

			case 9:
				op.addStudentToParticaularBatchToPerticularFacultyAndCourse();
				break;

			case 10:
				op.showAllStudents();
				break;
				
				
			case 11:
				op.addFacultyWithMultipleBatchToParticularCourse();
				break;
				
			case 12:
				op.getSingleFacultyWithMultipleBatch();
				break;
				
			case 13:
				System.out.println("Application Is Terminated....");
				flag = false;
				break;

			default:
				System.out.println("Please Enter Correct Input");

				break;
			}

		}
	}
}