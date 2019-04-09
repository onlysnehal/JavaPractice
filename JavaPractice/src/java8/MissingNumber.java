import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 6, 7, 8, 9, 0};

        System.out.println(Arrays.toString(array));

        //Step 1 : get size of an array
        int size = array.length;
        //Step 2 : get expected sum of element using formula (N*(N+1))/2
        int idealSum = (size * (size + 1)) / 2;
        //Step 3 : Get sum of all elements of an array
        int sum = Arrays.stream(array).sum();
        //Step 4 : missing number = step 2 sum - step 3 sum
        int missingNumber = idealSum - sum;

        System.out.println("Missing number from an array : " + missingNumber);
    }
}
