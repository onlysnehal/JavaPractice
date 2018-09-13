package arrays;

/**
 * Java program to find out the first non repeating element from an array
 */
public class FindFirstUniqueElement {

    public static void main(String args[]) {
        int arr[] = {3, 1, 6, 3, 6, 4};
        int n = arr.length;
        boolean isUnique = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (arr[i] == arr[j]) {
                        isUnique = false;
                        break;
                    } else {
                        isUnique = true;
                    }
                }

            }
            if (isUnique) {
                System.out.println("First non repeating element : " + arr[i]);
                break;
            }
        }
    }
}
