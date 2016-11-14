import java.util.HashMap;
import java.util.Map;

/**
 * Created by gnagpal on 9/26/16.
 */
public class PhoneAnagrams {
    final static String hashTable[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        int num = 234;

        printAnagrams("", "234");

    }

    public static void printAnagrams(String string, String num){
        if(num.length() == 0) {System.out.print(string + " "); return;}
        String str = hashTable[num.charAt(0) - '0'];
        String newNum = num.substring(1);
        for(int i = 0; i < str.length(); i++){
            printAnagrams(string.concat(String.valueOf(str.charAt(i))), newNum);
        }
    }
}
