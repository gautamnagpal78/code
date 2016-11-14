// Java program to find a pair with the given difference
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class PairDifference
{
    // The function assumes that the array is sorted
    static int findPair(int arr[],int n)
    {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : arr) map.put(x,1);

        for(int x : arr){
            if(map.containsKey(x - n)) count+=map.get(x-n);
            if(map.containsKey(x + n)) count+=map.get(x+n);

            map.remove(x);
        }
        return count;
    }

    // Driver program to test above function
    public static void main (String[] args)
    {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int n = s.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            if (s.hasNextInt()) {
                arr[i] = s.nextInt();
            }
        }
        System.out.println(findPair(arr, n));
    }
}
/*This code is contributed by Devesh Agrawal*/