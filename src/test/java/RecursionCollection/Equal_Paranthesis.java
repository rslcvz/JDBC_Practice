package RecursionCollection;

public class Equal_Paranthesis {
    public static void main(String[] args) {

        // Requirement: Open Close parentheses must be equal
        String str = "))))((( ";
        String container = "";
        int count = 0;
        int count2 = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            if ( str.charAt(i) == ')' ) {
                count++;
            }
                if (str.charAt(i) == '(') {
                    count2++;
                }
            }
      if(count == count2){
          System.out.println(true);
      }else {
          System.out.println(false);
      }
        }
}