package datastructure.binarysearch;

public class BinarySearch {

    public static void main(String args[]) {
        int arr[] = {2, 3, 5, 7, 13, 34, 56};
        int key = 13;
        int result = binarySearch(arr, 0, arr.length - 1, key);
        if (result == -1) {
            System.out.println("Element Not found ");
        } else {
            System.out.println("Element found at index " + result);
        }
    }

    private static int binarySearch(int arr[], int l, int r, int key) {

        if (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            return arr[mid] > key ? binarySearch(arr, l, mid - 1, key) : binarySearch(arr, mid + 1, r, key);
        }
        return -1;
    }
}
