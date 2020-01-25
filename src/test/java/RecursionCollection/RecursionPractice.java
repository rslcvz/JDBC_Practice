package RecursionCollection;


public class RecursionPractice {

    public static void main(String[] args) {

        Recursion(0);
        Recursion2(10);
    }

    public static void Recursion(int n) {
        // if you wanna decrease a number 2- 3- 5 go for it
        if (n < 10) {
            Recursion(2 + n);
        }
        System.out.print(n + " ");
    }


    public static void Recursion2(int m) {
        //If you wanna increase a number.
        if (m > 0) {
            Recursion2(m - 1);
        }
        System.out.print(m + " \n");
    }

}