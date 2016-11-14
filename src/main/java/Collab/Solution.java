package Collab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gnagpal on 10/19/16.
 */
class Solution{

    int left;
    int right;

    Solution(int l, int r){this.left = l; this.right = r;}

    public static void main(String[] args){
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < 10; i++){
            map.put("Gautam" + i, i);
        }

        for(Map.Entry<String,Integer> e : map.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }


        List<Integer> list = new ArrayList<>();
        int arr[][] = new int[10][10];
        Solution tree = new Solution(2,3);
    }
}
