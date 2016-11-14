package Leetcode;

/**
 * Created by gnagpal on 11/8/16.
 */
public class Leetcode1 {
    public static void main(String[] args) {
        productArray();
    }

    public static int[] productArray(){
        int nums[] = {1,2,3,4};
        int left[]  = new int[nums.length];
        int right[] = new int[nums.length];
        int p = 1;
        for(int i = 0; i < nums.length; i++){
            left[i] = p;
            p = p*nums[i];
        }

        p = 1;
        for(int i = nums.length -1; i >= 0; i--){
            right[i] = p;
            p = p*nums[i];
        }

        for(int i = 0; i < nums.length; i++){
            nums[i] = left[i]*right[i];
        }
        return nums;
    }
}
