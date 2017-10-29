package arrays;

import java.util.Arrays;

/**
 * Java program to find out maximum and minimum value
 * from an array.
 */
public class MinMaxFromArray {

    public static void main(String args[]) {

        int[] arr = {6, 2, 8, 1, 23, 9, 3, 5};
        /*
        // Simple way to find out min and max value
        Arrays.sort(arr);
        System.out.println("Min value "+arr[0]);
        System.out.println("Max value "+arr[arr.length-1]);*/

        // Finding min/max by iterating over array
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < min) {
                min = arr[i];
            }

            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Min number : " + min);
        System.out.println("Min number : " + max);
    }
}
