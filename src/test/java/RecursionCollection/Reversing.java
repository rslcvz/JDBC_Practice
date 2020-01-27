package RecursionCollection;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Reversing {

    @Test
    public void stringBuilderReverse() {
        // Get reverse with String Builder
        // Create two string variable and compare
        String abc = "ey edipA adAnadA pide ye".toLowerCase();
        String str = "ey edipA AdAnadA pide ye".toLowerCase();
        StringBuilder reversing = new StringBuilder(str);

// Ask the first String if its Equal as content
        System.out.println("reverse = " + reversing.reverse());
        if (abc.contentEquals((reversing.reverse()))) {
            System.out.println("This shit is palindrome");
        } else {
            System.out.println("This shit is not a palindrome");

        }
    }

    @Test
    public static void reverseWithForLoop() {
        // Another way of getting reverse is
        String abc = "ama".toLowerCase();

        String reversed = "";

        for (int i = abc.length() - 1; i >= 0; i--) {
            reversed += abc.charAt(i);
        }
            if (reversed.equalsIgnoreCase(abc)) {
                System.out.println("This is a palindrome");
            } else {
                System.out.println("This is not a palindrome");
            }
            System.out.println("reversed = " + reversed);
             Assert.assertEquals(abc, reversed);

        }


    }



