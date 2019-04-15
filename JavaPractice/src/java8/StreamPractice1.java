import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice1 {
    public static void main(String[] args) {

        //Concatenating strings from a stream using reduce
        String str = Stream.of("This", "is", "stream", "demo")
                .reduce("", String::concat);
        System.out.println(str);

        //Joining strings using Collectors
        String str1 = Stream.of("This", "is", "stream", "demo")
                .collect(Collectors.joining());
        System.out.println(str1);

        //Finding the first even integer
        int firstEven = Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
                .filter(n -> n % 2 == 0)
                .findFirst() // returns Optional<Integer>
                .orElse(0); //get/orElse to return int from Optional<Integer>

        System.out.println("First even number : " + firstEven);
    }
}
