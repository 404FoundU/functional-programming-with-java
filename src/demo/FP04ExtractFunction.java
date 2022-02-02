package demo;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP04ExtractFunction {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Predicate<Integer> isEvenPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number%2==0;
            }
        };
        Function<Integer, Integer> integerSquare = n -> n * n;
        Function<Integer, Integer> integerSquare2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * integer;
            }
        };
        Consumer<Integer> sysoutConsumer = e -> System.out.println(e);
        List.of(2, 3, 4, 5, 6).stream()
                .filter(getIntegerPredicate())
                .filter(isEvenPredicate)
                .map(integerSquare2)
                .forEach(sysoutConsumer);

        //BinaryOperator
        int sum = List.of(2, 3, 4, 5, 6).stream()
                .reduce(0, Integer::sum);
        BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
        BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };

        sum = List.of(2, 3, 4, 5, 6).stream()
                .reduce(0, sumBinaryOperator);


    }
    private static Predicate<Integer> getIntegerPredicate() {
        return n -> n % 2 == 0;
    }

}
