package Main;

import java.io.IOException;
import java.util.Scanner;
import Worker.FileData;

public class Launcher {

	public static void main(String[] args) throws IOException {		//kuch nai chahiye---> invoke method

		System.out.println(
				"Operations::\n1: List names of files in directory.\n2: List files with specific extension");
		Scanner sr = new Scanner(System.in);//supplier<int>....... interface 
		int choice = sr.nextInt();//enums
		switch (choice) {         ///mp<enum,fn>  --> replaces switch case--->conditions are bad for coding practice
		case 1:
			FileData.listName();
			break;
			
		case 2:
			FileData.extensionSpecificFile();
			break;
			
		default:
			System.out.println("Wrong choice!!");

		}
		sr.close();
	}
}
