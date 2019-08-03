import java.util.stream.IntStream;
//import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		System.out.print("Get set...");
		IntStream.range(1, 4).forEach(i -> System.out.print((i + "...")));
	}

}
