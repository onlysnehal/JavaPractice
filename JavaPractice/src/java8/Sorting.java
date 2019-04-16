import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {
    public static void main(String[] args) {

        List<String> sampleStrings =
                Arrays.asList("hi", "this", "is", "strings", "sorting", "demo");
        System.out.println("Original list : " + sampleStrings);
        //Natural order sorting
        List<String> naturalSorting = sampleStrings.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted by natural order : " + naturalSorting);

        //Using comparator
        List<String> comparatorSorting = sampleStrings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("Sorting by length : " + comparatorSorting);

        //Sorting by length, then equal lengths lexicographically
        List<String> lengthSortThenAlphaOrder = sampleStrings.stream()
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
        System.out.println("Sort by length, then equal-length strings alphabetically : " + lengthSortThenAlphaOrder);

    }
}
