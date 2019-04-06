import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class FindMinMaxElement {

    public static void main(String[] args) {

        int[] array = {4, 1, 2, 7, 23, 8, 12};
        System.out.println("Find min/max element from an array : " + Arrays.toString(array));
        //Using Java 8 - min/max element from an array
        OptionalInt max = IntStream.of(array)
                .max();
        System.out.println("Max element : " + max.getAsInt());

        System.out.println("Min element : " + IntStream.of(array)
                .min().getAsInt());

        System.out.println("Using summary statistics : ");
        System.out.println("Min : " + IntStream.of(array).summaryStatistics().getMin());
        System.out.println("Max : " + IntStream.of(array).summaryStatistics().getMax());
        System.out.println("Sum : " + IntStream.of(array).summaryStatistics().getSum());
        System.out.println("Average : " + IntStream.of(array).summaryStatistics().getAverage());
        System.out.println("Count : " + IntStream.of(array).summaryStatistics().getCount());

        int maxElement = 0;
        int minElement = array[0];
        for (int i : array) {
            if (i > maxElement) {
                maxElement = i;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] < minElement) {
                minElement = array[i];
            }
        }
        System.out.println("by iterating max element : " + maxElement);
        System.out.println("by iterating min element : " + minElement);
    }
}
