package Leetcode;

import java.util.LinkedList;

/**
 * Created by gnagpal on 11/11/16.
 */
public class SlidingWindow {
    public static void main(String[] args) {
        int a[] = {1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(a,3);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return new int[0];
        int ans[] = new int[nums.length - k+1];
        int counter = 0;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(queue.size()>0 && queue.getFirst() == i-k)
                queue.removeFirst();
            while(queue.size()>0 && nums[i] > nums[queue.getLast()]){
                queue.removeLast();
            }

            queue.addLast(i);

            if(i+1 >= k)
            {
                ans[counter++] = nums[queue.getFirst()];
                // System.out.println(nums[queue.getFirst()]);
            }
        }

        return ans;
    }
}
