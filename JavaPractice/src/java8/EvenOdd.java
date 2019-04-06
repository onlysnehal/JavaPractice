import java.util.stream.IntStream;

public class EvenOdd {

    public static void main(String[] args) {
        //Java 8 - to find out even/odd numers from an array
        int[] array = {4, 2, 8, 7, 1, 3, 0, 9, 5};

        //Find out even numbers
        System.out.println("Even numbers");
        IntStream.of(array)
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);

        //Find out odd numbers from an array
        System.out.println("Odd numbers");
        IntStream.of(array)
                .filter(x -> x % 2 == 1)
                .forEach(System.out::println);
    }
}
