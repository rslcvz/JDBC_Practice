package RecursionCollection;

public class Palyndrome {
    public static void main(String[] args) {

        System.out.println(palindrome("lEveL"));
    }

    public static boolean palindrome(String str) {
        String temp = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            temp += str.charAt(i);
        }

            return str.equalsIgnoreCase(temp);

        }
    }


