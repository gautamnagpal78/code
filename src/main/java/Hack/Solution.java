package Hack;

/**
 * Created by gnagpal on 10/22/16.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        int min = Integer.MAX_VALUE;
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            if(arr[arr_i] < min)
                min = arr[arr_i];
        }

        for(int j =0; j<arr.length; j++){
            if(arr[j] < min)
                min = arr[j];
        }

        int count = n;
        List<Integer> output = new ArrayList<>();
        while(count > 0){
            output.add(count);
            int newMin = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                if(arr[i] == 0)
                    continue;
                else{
                    if(arr[i] - min == 0) {arr[i] = 0;count--;}
                    else{
                        arr[i] = arr[i] - min;
                        if(arr[i] < newMin)
                            newMin = arr[i];
                    }
                }
            }
            min = newMin;
        }

        int outpt[] = new int[output.size()];
        for(int k = 0; k < outpt.length; k++){
            outpt[k] = output.get(k);
        }

        //return outpt;
    }
}
