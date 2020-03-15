package RecursionCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class List_WhileLoop {
    public static void main(String[] args) {


        int num =0;

        while (num < 5 ){
            num++;
            System.out.println("Resul 5 defa yazilacak");
        }

        List<Integer> number = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7, 9));
        number.add(2, 10);
        number.add(null);
        System.out.println(number);

        String str = "AAASSDDDSSSS";
        String depo = "";

        for(int i =0; i < str.length(); i++){
            if(!depo.contains("" + str.charAt(i))){

                depo += str.charAt(i);
            }
        }
        System.out.println(depo);

    }
}
