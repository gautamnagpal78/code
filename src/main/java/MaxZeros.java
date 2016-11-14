/**
 * Created by gnagpal on 9/18/16.
 */
public class MaxZeros {
    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 0, 1, 1, 0};
        int max = 0;
        int maxSoFar = 0;
        int zeros = 0;
        for(int i = 0; i < arr.length; i++){

            if(arr[i] == 1)
                maxSoFar += arr[i];
            else {maxSoFar = maxSoFar - 1; zeros++; }
            if(maxSoFar < 0) maxSoFar = 0;
            if(maxSoFar > max) max = maxSoFar;
        }

        System.out.println(max+zeros);
    }
}
