import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortingProblems {
    public static void main(String[] args) {

        int[] array = {5, 8, 22, 6, 1, 9, 12, 2, 7};
        System.out.println("Input array : " + Arrays.toString(array));

        //Find out smallest 3 elements from and array
        List<Integer> smallestList = IntStream.of(array)
                .boxed() // to convert primitive int to Integer
                .sorted() //sort y natural order
                .limit(3) // to get first 3 elements
                .collect(Collectors.toList()); //collect results into the list

        System.out.println("Smallest 3 elements : " + smallestList);

        //Find out max 3 elements from an array
        List<Integer> largestList = IntStream.of(array)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Largest 3 elements : " + largestList);
    }
}
