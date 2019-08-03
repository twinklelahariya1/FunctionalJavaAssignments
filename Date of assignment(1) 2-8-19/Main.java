
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		System.out.print("Get set...\n");
		
		List<Integer> array = Arrays.asList(5,89,6,23,68);
		
		array.sort((s1,s2)->s1.compareTo(s2));
		array.forEach(System.out::println);
	}

}
