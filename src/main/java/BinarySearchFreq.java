import java.util.HashMap;
import java.util.Map;

/**
 * Created by gnagpal on 9/15/16.
 */
public class BinarySearchFreq {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,3,3,5,5,8,8,8,9,9,10};
        System.out.println(myAtoi("-1"));
    }

    public static void freq(int[] arr) {

    }

    public static int myAtoi(String str) {
        int len = str.length();
        int num = 0;
        int sign = 1;
        for(int i = 0; i  < len ; i++){
            if(str.charAt(i) >= 48 && str.charAt(i) <= 56){
                num = num*10 + (str.charAt(i) - 48);
            }
            else if(str.charAt(i) == '-'){
                sign = sign*-1;
            }
        }
        return num*sign;
    }
}
