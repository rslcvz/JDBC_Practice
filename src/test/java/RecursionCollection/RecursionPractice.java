package RecursionCollection;


import org.testng.annotations.Test;

import java.util.Map;

public class RecursionPractice {

    public static void main(String[] args) {

        Recursion(0);
        Recursion2(10);
        String str = "Resul";


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
    public void Recurring(){
        String str = "ABCAAD";
        String container = "";
        for (int i=0; i< str.length()-1; i++){
            for (int j=0; j< str.length()-1; i++){
                if(str.charAt(i) == str.charAt(j+1)){
                    container += str.charAt(i);
                }
            }
            System.out.println("container = " + container);
        }



    }

}