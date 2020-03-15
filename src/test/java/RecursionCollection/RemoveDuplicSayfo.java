package RecursionCollection;

public class RemoveDuplicSayfo {
    public static void main(String[] args) {
        System.out.println(reversDigits(12345));

        System.out.println(removeDup("MMMSSSCCCRRK"));
    }

    public static String removeDup(String str){

        String nonDup = "";
        for (int i =0; i < str.length(); i++){
            if(!nonDup.contains(""+ str.charAt(i))){
                nonDup += str.charAt(i);
            }

        }
        return nonDup;

    }
    static int reversDigits(int num)
    {
        int rev_num = 0;
        while(num > 0)
        {
            rev_num = rev_num * 10 + num % 10;
            num = num / 10;
        }
        return rev_num;
    }
}
