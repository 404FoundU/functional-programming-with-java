package demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FP04CreateStreams {
    public static void main(String[] args) {

        // Wrapper class
        Integer seven = Integer.valueOf("111", 2);
        System.out.println(Integer.toString(seven, 2));
        Integer integer = 5;
        Integer integer1 = Integer.valueOf("5");



        //Stream.Of
        long count = Stream.of(1, 2, 4, 5, 6, 7).count();

        //Creating int stream using wrapper classes
        List<Integer> numbers = List.of(1, 2, 3, 5, 6, 7);
        System.out.println(numbers.stream()); //java.util.stream.ReferencePipeline$Head@43a25848
        Stream<Integer> stream1 = Stream.of(1, 2, 4, 5, 6, 7);
        System.out.println(stream1);// auto boxing - Integer wrapper class elements created from int
        int sum = Stream.of(1, 2, 4, 5, 6, 7).reduce(0, Integer::sum); //box and unbox - inefficient
        System.out.println("Primitive values");
        //Create streams with primitive values
        int[] num = {1, 3, 4, 5, 6, 6};
        IntStream stream2 = Arrays.stream(num);
        System.out.println(stream2); //java.util.stream.IntPipeline$Head@6bf256fa
        System.out.println(stream2.sum());// run direct ops

        //Intstream
        System.out.println("Intstream");
        IntStream stream3 = IntStream.range(1, 11);
        System.out.println(stream3);
        //Iterate
        IntStream stream4 = IntStream.iterate(1, e -> e + 1).limit(10);// infinite
        int stream5 = IntStream.iterate(1, e -> e + 1).limit(10).peek(System.out::println).sum();// infinite
        System.out.println(stream5);
        //Boxed - cannot run collect on primitive streams
        List<Integer> list = IntStream.iterate(1, e -> e + 1).limit(10).boxed().collect(Collectors.toList());
        System.out.println(list);

        //Join strings
        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");
        //Join strings
        String strJoin = courses.stream()
                .collect(Collectors.joining(" "));
        System.out.println(strJoin);
        //SPlit - flatMap
        List<String> strList = courses.stream()
                .map(course -> course.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(strList);

    }
}
