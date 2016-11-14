package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by gnagpal on 11/9/16.
 */
public class Anagrams {
    public static void main(String[] args) {
        int a[] = {};
        System.out.println(minMoves(a));
    }

    public static int minMoves(int[] nums) {
        int counter = 0;
        while(!allequal(nums)){

            int max = Integer.MIN_VALUE;
            int maxInd = 0;
            for(int i = 0; i <nums.length ; i++){
                if(nums[i] > max){
                    max = nums[i];
                    maxInd = i;
                }
            }


            int min = minArray(nums);
            for(int i = 0; i <= nums.length - 1; i++)
            {
                if(i!=maxInd) nums[i]+=max-min;
            }
            counter+=max-min;
        }
        return counter;
    }

    public static int minArray(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <arr.length ; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }


    public static boolean allequal(int[] nums){
        int a = nums[0];
        for(int i = 1; i<nums.length; i++){
            if(nums[i]!=a) return false;
        }
        return true;
    }
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList();
            int l = 0;
            if(s.length() < p.length()) return ans;
            while(l<=(s.length() - p.length())){
                if(isAnagram(s.substring(l,l+p.length()), p)){
                    ans.add(l);
                }
                l++;
            }
            return ans;
        }

        public boolean isAnagram(String x, String p){
            char[] xar = x.toCharArray();
            char[] par = p.toCharArray();
            char[] container1 = new char[26];
            char[] container2 = new char[26];

            Arrays.sort(xar);
            Arrays.sort(par);

            for(int i=0; i<xar.length; i++){
                container1[xar[i] - 'a']++;
                container2[par[i] - 'a']++;
            }

            for(int i=0; i<26; i++){
                if(container1[i] != container2[i])
                    return false;
            }
            return true;
        }

}
