package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem : Given array of n integers and given a number X, find all the unique pairs of elements (a,b)
 * whose summation is equal to X.
 * Time complexity O(n)
 */
public class FindSumOfPairsInArray {

    public static void main(String args[]) {

        int[] arr = {2, 5, 3, 9, 55, 31, 7, 1, 8};
        int targetNumber = 10;

        printPairs(arr, targetNumber);
    }

    public static void printPairs(int[] arr, int summation) {
        Map<Integer, Integer> pairMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            if (pairMap.containsKey(arr[i])) {
                System.out.println(arr[i] + "," + pairMap.get(arr[i]));
            } else {
                pairMap.put(summation - arr[i], arr[i]);
            }
        }
    }
}
