package Leetcode;

/**
 * Created by gnagpal on 11/8/16.
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    static class PQsort implements Comparator<Integer> {

        public int compare(Integer one, Integer two) {
            return two - one;
        }
    }

    public static void main(String[] args) {
        int[] ia = { 1, 10, 5, 3, 4, 7, 6, 9, 8 };
        maxSlidingWindow(ia,3);
        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();

        String s = "gautam";
        System.out.println(s.substring(0,2));
        // use offer() method to add elements to the PriorityQueue pq1
        for (int x : ia) {
            pq1.offer(x);
        }

        pq1.remove(7);
        while(pq1.size()!=0)
            System.out.print(pq1.poll() + " ");

        int c[] = {3, 0, 6, 1, 5};
        System.out.println(hIndex(c));
       // System.out.println("pq1: " + pq1);
//
        System.out.println(arrangeCoins(2147483647));

    }

    public static int arrangeCoins(int n) {
        int x = 0;
        long sum = 0;
        while(sum < n){
            x++;
            sum = sum + x;
        }

        if(sum == n)
            return x;
        return x-1;
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i;
        for(i = citations.length-1; i >=0; i--){
            if(citations[i] == citations.length - i){return citations[i];}
        }
        if(citations[i] == citations.length)
            return citations[i];
        else return -1;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int ans[] = new int[nums.length - k + 1];
        int counter = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
        int l = 0, r = 0;

        while(r <= (l+k-1)){
            queue.offer(nums[r++]);
        }
        r--;
        ans[counter++] = queue.peek();

        while(l < nums.length - k){
            queue.remove(nums[l]);
            queue.offer(nums[r+1]);
            ans[counter++] = queue.peek();
            l++; r++;
        }
        return ans;

    }
}