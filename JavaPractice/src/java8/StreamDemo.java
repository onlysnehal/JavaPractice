package java8;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {

        //Creating stream
        System.out.println("Stream.of for creating stream");
        String letters = Stream.of("A","B","C","D","E","F","G")
                                .collect(Collectors.joining(", "));
        System.out.println(letters);

        //Iterate method
        System.out.println("Stream.iterate to iterate stream");
        Stream.iterate(LocalDate.now(),ld->ld.plusDays(1L))
                .limit(5)
                .forEach(System.out::println);

        // Stream.generate method to generate random number stream
        System.out.println("Stream.generate to generate random stream");
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        //range and rangedClosed
        /**
         * rangeClosed includes the end value
         * range doesn’t. Each returns a sequential, ordered stream that starts at the
         * first argument and increments by one after that
         */
        System.out.println("range and rangeClosed method");
        List<Integer> integers1 = IntStream.range(1,5)
                                            .boxed() //use of the boxed method to convert the int values to Integer instances
                                            .collect(Collectors.toList());
        System.out.println("with range : "+integers1);

        List<Long> longs  = LongStream.rangeClosed(1,5)
                                        .boxed()
                                        .collect(Collectors.toList());
        System.out.println("with rangeClosed : "+longs);

        //Using the boxed method to work with stream of primitives
        System.out.println("Using the boxed method");
        List<Integer> integers2 = IntStream.of(1,2,3,4,5)
                                            .boxed() //Converts int to Integer
                                            //.mapToObj(Integer::valueOf)  - this is an alternative to boxed
                                            .collect(Collectors.toList());
        System.out.println(integers2);

        //Converting Int stream to an array
        System.out.println("Convert an IntStream to an int array");
        int [] intArr = IntStream.of(1,2,3,4,5)
                                .toArray();
        System.out.println(Arrays.toString(intArr));

        //reduce operation
        //Reduction operations on IntStream
        System.out.println("Reduction operations on IntStream");
        String [] strings = "Hi This is a Java8 Stream demo".split(" ");

        //count is a Stream method, so no need to map to IntStream
        long count = Arrays.stream(strings).map(String::length).count();

        //max and min without Comparator only on primitive streams
        OptionalInt max = Arrays.stream(strings).mapToInt(String::length).max();
        OptionalInt min = Arrays.stream(strings).mapToInt(String::length).min();

        //sum and average are on the primitive streams only
        OptionalDouble average = Arrays.stream(strings).mapToInt(String::length).average();
        int total = Arrays.stream(strings).mapToInt(String::length).sum();

        System.out.println("Count : "+count +" Min : " +min+" Max : "+max+""+" total : "+total+" Average : "+average);

        //Summing numbers using reduce
        int sum = IntStream.rangeClosed(1,10)
                            .reduce((x,y) -> x+y).orElse(0);
        System.out.println("Sum using reduce : "+sum);

        //Performing a reduce with a binary operator
        int sumWithBinOperator = IntStream.rangeClosed(1,10)
                                            .reduce(0,Integer::sum);
        System.out.println("sum using reduce with binary operator "+sumWithBinOperator);

        //Sorting
        //Sorting strings by length
        List<String> sortedStrings = Arrays.stream(strings)
                                            .sorted(Comparator.comparingInt(String::length))
                                            .collect(Collectors.toList());

        List<String> naturalOrderStrings = Arrays.stream(strings)
                                                    .sorted(String::compareToIgnoreCase)
                                                    .collect(Collectors.toList());

        System.out.println("Without sorting strings : "+Arrays.toString(strings));
        System.out.println("Sorted Strings by length : "+sortedStrings);
        System.out.println("Sorted Strings by alphaetical order : "+naturalOrderStrings);

        //Counting string partitioned by length
        Map<Boolean,Long> numberLengthMap = Arrays.stream(strings)
                                            .collect(Collectors.partitioningBy(
                                                    s -> s.length()%2==0,
                                                    Collectors.counting()
                                            ));
        System.out.println("Counting string partitioned by length : "+numberLengthMap);
    }
}
