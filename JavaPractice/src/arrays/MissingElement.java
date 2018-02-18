package arrays;

/**
 * Java program to find out missing element from an array
 */
public class MissingElement {

    public static void main(String args[]) {
        int[] originalArr = {2, 3, 5, 7, 9, 4};
        int[] missingArr = {2, 3, 7, 9, 4};

        int missingNumber = 0;

        for (int num : originalArr) {
            missingNumber += num;
        }

        for (int num : missingArr) {
            missingNumber -= num;
        }

        System.out.println(missingNumber);
    }
}
