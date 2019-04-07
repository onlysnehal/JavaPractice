import java.util.Scanner;
import java.util.stream.IntStream;

public class FactorialAndPrime {

    public static void main(String[] args) {
        int number = getInputNumber();
        //Calculate factorial of a number
        int factorial = IntStream.rangeClosed(2, number)
                .reduce(1, (x, y) -> x * y);
        System.out.println("Factorial : " + factorial);

        //Prime number
        boolean isPrime = IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);

        if (isPrime) {
            System.out.println("Number : " + number + " is a prime number");
        } else {
            System.out.println("Number : " + number + " is not a prime number");
        }
    }

    private static int getInputNumber() {
        Scanner scanner = new Scanner(System.in);
        //get input number
        System.out.println("Enter number : ");
        return scanner.nextInt();
    }
}
