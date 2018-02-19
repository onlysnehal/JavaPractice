package strings;

/**
 * Java program to reverse a String using recursion.
 */
public class StringReverseUsingRecursion {

    public static void main(String args[]) {
        String str = "JAVA";
        System.out.println("Original string : " + str);
        System.out.println("Reverse string : " + reverse(str));
    }

    private static String reverse(String str) {
        if (str == null || str.length() < 1) {
            return str;
        } else {
            return reverse(str.substring(1)) + str.charAt(0);
        }
    }
}
