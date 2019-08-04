package Worker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileData {

	public static void listName() throws IOException {
		Files.list(Paths.get("D:\\AssignmentDemo")).filter(Files::isRegularFile).forEach(System.out::println);

		displayFileData();
	}

	public static void extensionSpecificFile() throws IOException {
		File directory = new File("D:\\AssignmentDemo");
		Scanner sr = new Scanner(System.in);

		System.out.println("Enter extension choice\n1:.txt\n2:.jpg\n3:.java");
		String extension = sr.nextLine();

		File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(extension));
		for (File f : files)
			System.out.println(f.getName());
		sr.close();
		displayFileData();

	}

	public static void displayFileData() throws IOException {

		Scanner sr = new Scanner(System.in);

		System.out.println("Enter the name of file to display content");
		String fileName = sr.nextLine();
		Stream<String> stream = Files.lines(Paths.get(fileName));
		stream.forEach(System.out::println);
		
		sr.close();
		stream.close();
	}

}
