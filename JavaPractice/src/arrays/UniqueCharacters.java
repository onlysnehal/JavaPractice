package arrays;

/**
 * Program to find out a string has all unique characters
 */
public class UniqueCharacters {

    public static void main(String args[]) {
        UniqueCharacters uniqueCharacters = new UniqueCharacters();
        String firstStr = "Hello Java";
        String secondStr = "Abc";

        System.out.println("String 1 has unique characters :" + uniqueCharacters.isUniqueCharacters(firstStr));
        System.out.println("String 2 has unique characters :" + uniqueCharacters.isUniqueCharacters(secondStr));
    }

    private boolean isUniqueCharacters(String str) {

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
