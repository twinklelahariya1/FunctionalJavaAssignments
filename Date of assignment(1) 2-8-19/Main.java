
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 
 * @author twinkle.lahariya :::program to sort given arraylist and to remove
 *         duplicates from the array
 */

public class Main {

	public static void main(String[] args) {

		System.out.print("Get set...\n");

		List<Integer> arraySort = Arrays.asList(5, 89, 6, 23, 68);

		List<Integer> arrayDistinct = Arrays.asList(5, 5, 6, 6, 2, 2, 2, 2, 3, 3, 6, 2, 2, 6, 8, 9, 5, 3, 2, 1);

		System.out.println("SOrted list is::");
		arraySort.sort((s1, s2) -> s1.compareTo(s2));
		arraySort.forEach(System.out::println);

		System.out.println("After removing duplicates the array is::");

		Stream<Integer> arr = arrayDistinct.stream().distinct();

		arr.forEach(System.out::println);
	}

}
