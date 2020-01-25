package RecursionCollection;

import java.util.*;

public class Occurences {
    public static void main(String[] args) {

         String container="";
        String[] occurance = {"dks", "dks", "dks", "dsh", "sgsg", "shsh"};

        List asList = Arrays.asList(occurance);
        Set<String> mySet = new HashSet<String>(asList);
        for(String  s :mySet){
            System.out.println(s + " " + Collections.frequency(asList, s));

        }



    }
}
