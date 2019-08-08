package Worker;
//convenstions a mustttttttttttt
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileData {
				   //parameterize
	public static void listName() throws IOException {
		Files.list(Paths.get("D:\\AssignmentDemo")).filter(Files::isRegularFile).forEach(System.out::println);
					//never hardcode-->user to choose dir-->
		displayFileData();
	}

	public static void extensionSpecificFile() throws IOException {			//overloading
		File directory = new File("D:\\AssignmentDemo");
		Scanner sr = new Scanner(System.in);
			//ex: inputReader instead of sr
		System.out.println("Enter extension choice\n1:.txt\n2:.jpg\n3:.java");
		String extension = sr.nextLine();

		File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(extension));
		for (File f : files)	//use {} even for single statements
			System.out.println(f.getName());
		sr.close();
		displayFileData();

	}

	public static void displayFileData() throws IOException {

		Scanner sr = new Scanner(System.in);

		System.out.println("Enter the name of file to display content");
		String fileName = sr.nextLine();
		Stream<String> stream = Files.lines(Paths.get(fileName));// large file go for buffer reader
		stream.forEach(System.out::println);
		
		sr.close();
		stream.close();
	}

}
