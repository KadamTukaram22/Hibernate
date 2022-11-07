package Controller;

import java.util.Scanner;

import com.service.OperationService;
import com.serviceImpl.OperationServiceImpl;

public class Test {
public static void main(String[] args) {
	OperationService os = new OperationServiceImpl();
	Scanner sc=new Scanner(System.in);
	
	while (true) {
		System.out.println("1.Add Student and Address");
		System.out.println("2. Show All Details");
		System.out.println("3. Show Single Student with Address");
		System.out.println("4. Update Student");
		System.out.println("5. Update Address Using Student");
		System.out.println("6. Deleate Student");
		
		int ch=sc.nextInt();
		switch (ch) {
		case 1:
			os.insertStudentWithAddress();
			break;
		case 2:
			os.ShowAllData();
			break;
		case 3:
			os.getSingleStudentWithAddress();
			break;
		case 4:
			os.UpdateStudent();
			break;
		case 5:
			os.UpdateAddressUssingStudent();
			break;
		case 6:
			os.DeleateStudent();
			break;

		default:
			break;
		}
	}
}
}
