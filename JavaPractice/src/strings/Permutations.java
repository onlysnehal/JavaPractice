package strings;

/**
 * Java program to find out all permutations of a string.
 */
public class Permutations {

    public static void main(String args[]) {
        //Take a small string to understand better
        String str = "ABC";
        permuteString(str);
    }

    public static void permuteString(String str) {
        permuteString("", str);
    }

    public static void permuteString(String prefix, String str) {
        int length = str.length();
        if (length == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < length; i++) {
                permuteString(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, length));
            }
        }
    }
}
