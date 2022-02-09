package programming;

import java.util.List;
import java.util.stream.LongStream;

public class FP05Parallelizing {
	
	public static void main(String[] args) {
		long time = System.currentTimeMillis();

		//0, 1000000000 869
		//System.out.println(LongStream.range(0,1000000000).sum());//499999999500000000
		
		//601
		System.out.println(LongStream.range(0,1000000000).parallel().sum());
		
		System.out.println(System.currentTimeMillis() - time);
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
		int sum = numbers.stream()
				.parallel() // splits the stream across processor
				.reduce(0, (num1, num2) -> num1 + num2);
	}

}
