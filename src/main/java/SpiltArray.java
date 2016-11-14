/**
 * Created by gnagpal on 9/13/16.
 */
public class SpiltArray {
    public static void main(String[] args) {
        int arr[] = {6,-2,-3,2,3};

        String a = "Gautamnagpal";
        String b = "am";
        System.out.println(a.indexOf(b));

        int size = arr.length;
        int larr[] = new int[size];
        int rarr[] = new int[size];

        larr[0] = 0;
        for(int i = 1; i < size; i++){
            larr[i] = larr[i-1] + arr[i-1];
        }

        for(int el : larr){
            System.out.print(el + " ");
        }

        System.out.println();


        rarr[size-1] = 0;
        for(int j = size - 2 ; j >= 0  ; j--){
            rarr[j] =  rarr[j+1] + arr[j+1];
        }


        for(int el : rarr){
            System.out.print(el + " ");
        }

        System.out.println();
        for(int i = 0; i < size; i++){
            if(larr[i] == rarr[i])
                System.out.println(arr[i]);
        }
    }
}
