package CSE202.HW0;

/**
 * Created by gnagpal on 9/23/16.
 */
public class MaxDiff {
    public static void main(String[] args) {
        int arr[] = {1,9,8,7,6};
        int max = arr[0];
        int maxDiff = -1;

        for(int i = 1; i < arr.length ; i++){
            if(arr[i] < max){
                max = arr[i];
            }
            else{
                if((-max + arr[i]) > maxDiff){
                    maxDiff = - max + arr[i];
                }
            }
        }

        System.out.println(maxDiff);
    }
}
