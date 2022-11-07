package com.controlar;

import java.util.Scanner;

import com.service.OperationService;
import com.serviceImpl.OperationServiceImp;

public class Test {
	public static void main(String[] args) {

		OperationService os = new OperationServiceImp();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1.Add Course");
			System.out.println("2. Deleate course");
			System.out.println("3. update Course");
			System.out.println("4. Display Course");
			System.out.println("5. Add Faculty");
			System.out.println("6. Deleate Faculty");
			System.out.println("7. update Faculty");
			System.out.println("8. Display faculty");
			System.out.println("9. Add Batch");
			System.out.println("10. Deleate Batch");
			System.out.println("11. update Batch");
			System.out.println("12.Display Batch");
			System.out.println("13. Add Student");
			System.out.println("14. Deleate student");
			System.out.println("15.update student");
			System.out.println("16.display Student");

			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				os.addCource();
				break;
			case 2:
				os.DeleateCource();
				break;
			case 3:
				os.UpdateCource();
				break;
			case 4:
				os.displayCource();
				break;
			case 5:
				os.addfaculty();
				break;
			case 6:
				os.DeleateFaculty();
				break;
			case 7:
				os.UpdateFaculty();
				break;
			case 8:
				os.DisplayFaculty();
				break;
			case 9:
				os.addBatch();
				break;
			case 10:
				os.DeleateBatch();
				break;
			case 11:
				os.UpdateBatch();
				break;
			case 12:
				os.DisplayBatch();
				break;
			case 13:
				os.addStudentDetail();
				break;
			case 14:
				os.DeleateStudent();
			case 15:
				os.updateStudent();
				break;
			case 16:
				os.displayStudentDetail();
				break;

			default:
				break;

			}
		}
	}
}
