package RecursionCollection;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {

//        String [] str = {"A", "D", "A", "D", "D"};

        String yasin = "ABBCDDDEEE";
        String [] ddd = yasin.split("");

        List<String> abc = Arrays.asList(ddd);

        Set<String> hashSet = new HashSet<String>(abc);
        System.out.println("Hashset " + hashSet);



    }
}
