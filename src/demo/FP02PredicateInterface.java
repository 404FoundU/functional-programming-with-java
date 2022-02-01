package demo;

import java.util.List;
import java.util.function.Predicate;

class EvenNumberPredicate implements Predicate<Integer> {
    @Override
    public boolean test(Integer number) {
        return number % 2 == 0;
    }
}
public class FP02PredicateInterface {
    public static void main(String[] args) {
        List.of(2, 3, 4, 5, 6).stream()
                .filter(n -> n % 2 == 0)
                .forEach(e -> System.out.println(e));
        List.of(2, 3, 4, 5, 6).stream()
                .filter(new EvenNumberPredicate())
                .forEach(e -> System.out.println(e));
    }
}
