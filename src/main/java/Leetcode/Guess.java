package Leetcode;

import java.text.CollationElementIterator;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gnagpal on 11/5/16.
 */
public class Guess {

    //2126753390
    //        1702766719

    public static final int fix= 1702766719;

    public static void main(String[] args) {
        String s = "aaadd";
        String ss[] = s.split("d");
        char d = '4';
        int f = Integer.parseInt(d+"");
        //System.out.println(findNthDigit(9));
        //System.out.println(guessNumber(2126753390));
        //System.out.println(wordPattern("abba","dog cat cat dog"));
        int a[] = {9};
//        System.out.println(reverseString("efq"));
//        System.out.println(integerBreak(11));
       // System.out.println(isPowerOfTwo(65536));
        //  2147483648 (10000000000000000000000000000000)
        //System.out.println(hamming1Weight(2147483648));
        //System.out.println(plusOne(a));
        System.out.println(1^2^3^4^6^1);
        Arrays.sort(a);
    }
    public static int guess(int n){
        if(fix < n) return -1;
        else if (fix > n) return 1;
        else return 0;
    }


    public static int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length -1; i >=0; i--){
            int x = carry + digits[i];
            digits[i] = (x)%10;
            carry = (x)/10;
            if(carry == 0){
                return digits;
            }
        }

        if(carry >= 1){
            int digit[] = new int[digits.length + 1];
            digit[0] = 1;
            for(int i = 0; i < digits.length; i++){
                digit[i+1] = digits[i];
            }
            return digit;
        }
        else return digits;
    }
    public static boolean wordPattern(String pattern, String str) {
        String arr[] = str.split(" ");
        Map<Character, String> map = new HashMap();
        Map<String, Character> mapV = new HashMap();
        for(int i = 0; i < pattern.length(); i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!arr[i].equals(map.get(pattern.charAt(i)))){
                    return false;
                }
            }else{
                if(mapV.containsKey(arr[i])) return false;
                else {map.put(pattern.charAt(i), arr[i]);mapV.put(arr[i], pattern.charAt(i));}
            }
        }
        return false;
    }


    public static int numberOfArithmeticSlices(int[] A) {
        int l = 0;
        int r = 0;
        int count = 0;
        while(r < A.length - 1){
            int diff = A[r] - A[l];
            while((r+1) < A.length && (A[r+1] - A[r]) == diff){
                r++;
            }
            if((r - l) >= 2){
                count+=calc(r-l+1);
            }
            l = r;
            r++;
        }

        return count;
    }

    public static String reverseString(String s) {
        int l = 0, r = s.length() - 1;
        StringBuilder sr = new StringBuilder();
        while(r >= 0){
            sr.append(s.charAt(r--));
        }

        return sr.toString();
    }

    public static boolean isPowerOfTwo(int n) {
        int m = 2;
        if(n==1) return true;
        while(n >= 0)
        {
            if(m == n) return true;
            if(n%m == 0)
                m = m*2;
            else return false;
        }
        return true;
    }

    public static int integerBreak(int n) {
        int arr[] = new int[n+1];
        arr[1] = 1;
        int counter = 0;
        for(int i = 2; i <= n; i++){
            int max = 0;
            counter = i-1;
            while(counter > 0)
            {
                if((arr[counter] * (i-counter)) > max)
                    max = arr[counter] * (i-counter);
                else if ((counter * (i-counter)) > max)
                    max = counter * (i-counter);
                counter--;
            }
            arr[i] = max;
        }
        return arr[n];
    }

    public static int hamming1Weight(long m) {
        int count = 0;
        long n = m;
        while(n!=0){
            if((n & 1) == 1)
                count++;
            n = n>>1;
        }
        return count;
    }

    public static int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }


    private static  int calc(int i) {
        int count = 0;
        int l = 3;
        while(l <= i){
            count+=(i - l + 1);
            l++;
        }
        return count;
    }

    public static int findNthDigit(int n) {
        int update = 9;
        int base = 9;
        int tenth = 1;
        int c = 1;
        while(n > update){

            tenth = tenth*10;
            c = c+1;
            System.out.println(base*tenth*(c));
            update+=base*tenth*c;
        }

        //update =

        return 0;
    }
    public static long guessNumber(int m) {
        int mid = 0;
        long l = 1;
        long r = m;
        while(l <= r){
            long m1 = (l + r)/2;
            mid = (int)(m1);
            int g = guess(mid);
            if(g == -1){
                r = mid-1;
            }
            else if(g == 1){
                l = mid + 1;
            }else return mid;
        }

        return m;
    }
}
