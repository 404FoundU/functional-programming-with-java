package demo;

import java.util.List;
import java.util.stream.IntStream;

public class FP01Functional {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
//        printAllNumbers(numbers);
//        printEvenNumbers(numbers);
//        printEvenSquare(numbers);
//        printSum(numbers);
        printMax(numbers);

    }
    private static void printAllNumbers(List<Integer> numbers) {
        numbers.stream().forEach(System.out::println);// Method reference
    }
    private static void printEvenNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(num -> num % 2 == 0)
                .forEach(System.out::println);
    }
    //Map
    private static void printEvenSquare(List<Integer> numbers) {
        numbers.stream()
                .map(num -> num * num)
                .forEach(System.out::println);
    }
    //Reduce
    private static void printSum(List<Integer> numbers) {
        int sum = numbers.stream()
                .reduce(0, (num1, num2) -> num1 + num2);
        System.out.println(sum);
    }
    /*
    Identity – an element that is the initial value of the reduction operation and the default result if the stream is empty
Accumulator – a function that takes two parameters: a partial result of the reduction operation and the next element of the stream
Combiner – a function used to combine the partial result of the reduction operation when the reduction is parallelized or when
there's a mismatch between the types of the accumulator arguments and the types of the accumulator implementation

    List<User> users = Arrays.asList(new User("John", 30), new User("Julie", 35));
    int result = users.stream()
            .reduce(0, (partialAgeResult, user) -> partialAgeResult + user.getAge(), Integer::sum);
*/

    //Max
    private static void printMax(List<Integer> numbers) {
        int max = numbers.stream()
                .reduce(0,(n1, n2) -> {
                    if (n1 > n2) {
                        return n1;
                    }
                    return n2;
                });
        System.out.println(max);
        int max2 = numbers.stream()
                .max((n1, n2) -> Integer.compare(n1, n2)).get();
        System.out.println(max2);
        numbers.stream()
                .max((n1, n2) -> Integer.compare(n1, n2)).ifPresent(System.out::println);
    }









}
