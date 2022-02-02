package demo;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

//https://courses.in28minutes.com/courses/621478/lectures/11111648
//Predicate accepts one input and returns true or false - filter
class EvenNumberPredicate implements Predicate<Integer> {
    @Override
    public boolean test(Integer number) {
        return number % 2 == 0;
    }
}

//Consumer accepts one input and consumes - no return value
class SystemOutConsumer implements Consumer<Integer>{
    @Override
    public void accept(Integer number) {
        System.out.println(number);
    }
}

// Function accepts one input and gives output. Applies the function to the input
class NumberSquareMapper implements Function<Integer, Integer>{
    @Override
    public Integer apply(Integer num) {
        return num * num;
    }
}
public class FP02PredicateInterface {
    public static void main(String[] args) {
        /*
        Compiler creates an impl of FunctionalInterface( Predicate<Integer>)
        FunctionalInterface will have one method without any definition ( test )
        Lambda expression provides an impl for the specific method
         */
        List.of(2, 3, 4, 5, 6).stream()
                .filter(n -> n % 2 == 0)
                .map(n->n*n)
                .forEach(e -> System.out.println(e));

        List.of(2, 3, 4, 5, 6).stream()
                .filter(new EvenNumberPredicate()) //    Stream<T> filter(Predicate<? super T> predicate);
                .forEach(e -> System.out.println(e));

        List.of(2, 3, 4, 5, 6).stream()
                .filter(n -> n % 2 == 0)
                .forEach(new SystemOutConsumer());//     void forEach(Consumer<? super T> action);

        List.of(2, 3, 4, 5, 6).stream()
                .filter(n -> n % 2 == 0)
                .map(new NumberSquareMapper()) //     <R> Stream<R> map(Function<? super T, ? extends R> mapper);
                .forEach(e -> System.out.println(e));

    }
}
