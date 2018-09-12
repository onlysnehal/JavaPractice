package arrays;

public class FindFirstUniqueElement {

    public static void main(String args[]) {
        int arr[] = {3, 6, 9, 6, 4, 3};
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int j;
            for (j = 0; j < n; j++) {
                if (i != j && arr[i] == arr[j]) {
                    break;
                }

            }
            if (j == n) {
                System.out.println("First non repeating element : " + arr[i]);
                break;
            }
        }
    }
}
