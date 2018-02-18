package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Java program to find out duplicate element from an array
 */
public class FindDuplicate {
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 5, 3, 6, 7};
        int firstDup = 0;

        //Approach 1 : to iterate over the array
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    firstDup = arr[i];
                }
            }
        }
        System.out.println("Duplicate element using first approach : " + firstDup);

        //Approach 2 : Using Set to find the duplicate
        Set<Integer> set = new HashSet<>();
        int secondDup = 0;
        for (int i : arr) {
            if (set.add(i) == false) {
                secondDup = i;
            }
        }

        System.out.println("Duplicate element using Second approach : " + secondDup);


        /*Approach 3 : optimise way(First sort the array then iterate the array to check
        previous element is same as current one */
        Arrays.sort(arr);
        int thirdDup = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                thirdDup = arr[i];
            }
        }

        System.out.println("Duplicate element using Third approach : " + thirdDup);
    }
}
