/**
 * Created by gnagpal on 10/26/16.
 */
public class Sample {
    public static void main(String[] args) {
        System.out.println(isPalindrome(".,"));
        System.out.println(4^6^6^3^3);
        int a  = 'a' + 'c';
        System.out.println(a);
    }

    public static  boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;
        s =s.toLowerCase();

        while(l < r){
            while(l < s.length() && !((s.charAt(l) >= 'a' && s.charAt(l) <= 'z') || (s.charAt(l) >= '0' && s.charAt(l) <= '9')) ){
                l++;
            }
            while( r >=0 &&!((s.charAt(r) >= 'a' && s.charAt(r) <= 'z') || (s.charAt(r) >= '0' && s.charAt(r) <= '9')) ){
                r--;
            }
            if(l > r || l>s.length()-1 || r <0)
                return true;
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
}
