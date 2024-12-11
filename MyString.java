
/**
 * A library of string functions.
 */
public class MyString {

    public static void main(String args[]) {
        String hello = "hello";
        // System.out.println(countChar(hello, 'h')); // V
        // System.out.println(countChar(hello, 'l')); // V
        // System.out.println(countChar(hello, 'z')); // V
       // System.out.println(spacedString(hello)); // V
        //System.out.println(randomStringOfLetters(3));
        //System.out.println(subsetOf("pas", "space"));
        System.out.println(remove("abc", "b"));
        //countingChars("meet", "committee");
        //System.out.println(insertRandomly('a', hello));
        //System.out.println(spacedString(""));
    }

    /**
     * Returns the number of times the given character appears in the given
     * string. Example: countChar("Center",'e') returns 2 and
     * countChar("Center",'c') returns 0.
     *
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int count = 0;
        if (str.length() == 0) {
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns true if str1 is a subset string str2, false otherwise Examples:
     * subsetOf("sap","space") returns true subsetOf("spa","space") returns true
     * subsetOf("pass","space") returns false subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return false;
        }
        if (str1.length() <= str2.length()) {
            int tCount = 0;
            String c = "";
            for (int i = 0; i < str1.length(); i++) {
                if ((str2.contains(c + str1.charAt(i)))) {// need to add a check of each char
                    int index = str2.indexOf(str1.charAt(i));
                    if (countChar(str2, str2.charAt(index)) >= countChar(str1, str1.charAt(i))) {
                        tCount++;
                    }
                    else {
                        return false;
                    }
                }
            }
            if (tCount == str1.length()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except for
     * the last character. Example: spacedString("silent") returns "s i l e n t"
     *
     * @param str - a string
     * @return a string consisting of the characters of str, separated by
     * spaces.
     */
    public static String spacedString(String str) {
        String spaceStr = " ";
        if (str.length() == 0) {
            return " ";
        }
        for (int i = 0; i < str.length(); i++) {
            if (i+1 < str.length()) {
                spaceStr += str.charAt(i) + " ";
            }
        }
        spaceStr += str.charAt(str.length() - 1);
        return spaceStr;
    }

    /**
     * Returns a string of n lowercase letters, selected randomly from the
     * English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same letter can
     * be selected more than once.
     *
     * Example: randomStringOfLetters(3) can return "zoo"
     *
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        String rndLetter = "";
        for (int i = 0; i < n; i++) {
            int rnd = (int) ((Math.random()) * abc.length());
            //System.out.println(rnd); // print the random number (0-25)
            //System.out.println(abc.charAt(rnd)); // print the chat at the i place
            rndLetter += abc.charAt(rnd); // concat the char to the string 
            //System.out.println("~"+rndLetter);
        }
        return rndLetter;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters
     * in the string str2. Assumes (without checking) that str2 is a subset of
     * str1. Example: remove("meet","committee") returns "comit"
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        int[] cChar = new int[countingChars(str1)];
        String chars = addOnceChar(str1);
        if (str2 == null) {
            return str1;
        }
        String remStr = "";
        for (int i = 0; i < chars.length(); i++) { // counting each char at str2-str1 -with an array 
            cChar[i] = (countChar(str1, chars.charAt(i)) - countChar(str2, chars.charAt(i)));
            if (cChar[i] != 0) {
                remStr += chars.charAt(i);
            }
        }
        return remStr;
    }

    public static int countingChars(String str2) {  //  return the number of the chars at str2 without duplicates -> will be the length of the array
        int countChar = 1; //counting the first char
        for (int i = 1; i < str2.length(); i++) {
            if (str2.charAt(i - 1) != str2.charAt(i)) {
                countChar++; // count only new chars
            }
        }
        return countChar;
    }

    public static String addOnceChar(String str2) { // return the chars in str2 without duplicates -> 
        String chars = "" + str2.charAt(0); //adding the first char
        for (int i = 1; i < str2.length(); i++) {
            if (str2.charAt(i - 1) != str2.charAt(i)) {
                //System.out.println(str2.charAt(i - 1) + ", " + str2.charAt(i));
                chars += str2.charAt(i); // adding to the String-chatrs only new chars
                //System.out.println(chars);
            }
        }
        return chars;
    }

    /**
     * Returns a string consisting of the given string, with the given character
     * inserted randomly somewhere in the string. For example,
     * insertRandomly("s","cat") can return "scat", or "csat", or "cast", or
     * "cats".
     *
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
        // Generate a random index between 0 and str.length()
        int randomIndex = (int) (Math.random() * (str.length() + 1));
        // Insert the character at the random index
        String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
        return result;
    }
}
