package arrays;

import java.util.Arrays;

/**
 * Find the kth largest element in an unsorted array.
 * Solution : First sort the array and then find out
 * the nth element
 */
public class FindNthLargestElement {

    public static void main(String args[]) {
        int[] arr = {2, 5, 3, 9, 55, 31, 7, 1, 8};

        System.out.println("Original array values : " + Arrays.toString(arr));
        //Using java api
        System.out.println("3rd largest element in the array : " + findNthLargestByApi(arr, 3));
        //Using sorting algorithm
        System.out.println("2nd largest element in the array : " + findNthLargestByAlgo(arr, 2));
    }

    //Solution 1 : using java api
    public static int findNthLargestByApi(int[] array, int n) {
        Arrays.sort(array);
        return array[array.length - n];
    }

    //Solution 2 : using sort algorithm
    public static int findNthLargestByAlgo(int[] array, int n) {
        int[] arr = sort(array);
        return arr[arr.length - n];
    }

    //Insertion sort algorithm to sort elements
    private static int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;

            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j = j - 1;
            }
            arr[j] = temp;
        }
        return arr;
    }
}
