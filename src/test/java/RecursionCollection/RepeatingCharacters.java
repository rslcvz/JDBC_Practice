package RecursionCollection;

public class RepeatingCharacters {
    public static void main(String[] args) {
        String str = "ABCAADCDD";
        String container = "";
        for (int i=0; i < str.length()-1; i++){
                if(str.charAt(i) == str.charAt(i+1)){
                    container += str.charAt(i);
                }
            }
            System.out.println("container = " + container);
        //new changes
        }



    }



