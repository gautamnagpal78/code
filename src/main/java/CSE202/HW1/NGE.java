package CSE202.HW1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by gnagpal on 9/25/16.
 */
public class NGE {
    public static void main(String[] args) {
        int arr[] = {4,9,3,5,8,99};
        int finalArray[] = new int[arr.length];

        LinkedList<Integer> stack = new LinkedList<Integer>();

        stack.addFirst(0);
        for(int i = 1; i < arr.length; i++){
                if(arr[i] > arr[stack.getFirst()]){
                    while(stack.size() > 0 && arr[i] > arr[stack.getFirst()]){
                        finalArray[stack.getFirst()] = arr[i];
                        stack.removeFirst();
                    }
                }

                stack.addFirst(i);


        }

        while(stack.size() > 0){
            finalArray[stack.getFirst()] = -1;
            stack.removeFirst();
        }

        //Arrays.stream
        IntStream stream1 = Arrays.stream(finalArray);
        stream1.forEach(x -> System.out.println(x + " "));
        System.out.println();

    }
}
