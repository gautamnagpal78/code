/**
 * Created by gnagpal on 9/13/16.
 */
public class Kproduct {
    public static void main(String[] args) {
        int arr[] = {1,5,9,8,2,4,1,8,1,2};
        int k = 6;
        int max = 1;
        for(int j = 0; j < k; j++){
            max = arr[j] * max;
        }
        int curr = max;
        for(int i = k; i < arr.length; i++){
            curr = (curr * arr[i]) / arr[i - k];
            if(curr > max) max = curr;
        }

        System.out.println(max);
    }
}
