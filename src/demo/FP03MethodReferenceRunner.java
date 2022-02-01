package demo;

import java.util.List;

public class FP03MethodReferenceRunner {

    public static void print(Integer num) {
        System.out.println(num);
    }
    public static void main(String[] args) {
        List.of("u", "un", "unni").stream()
                .map(e -> e.length())
                .forEach(FP03MethodReferenceRunner::print);

        List.of("u", "un", "unni").stream()
                .map(String::length) // Instance method
                .forEach(FP03MethodReferenceRunner::print);

        Integer max = List.of(2,3,4,5).stream()
                .filter(e -> e % 2== 0)
                .max((n1, n2) -> Integer.compare(n1, n2))
                .orElse(0);
        System.out.println("Max " + max);

         max = List.of(2,3,4,5).stream()
                .filter(FP03MethodReferenceRunner::isEven)
                .max(Integer::compare)
                .orElse(0);
        System.out.println("Max " + max);

    }
    public static boolean isEven(Integer num) {
        return num%2==0;
    }
}
