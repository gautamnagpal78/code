package CSE202.HW0;

/**
 * Created by gnagpal on 9/25/16.
 */
public class Median {
    public static void main(String[] args) {
        int arr[] = {1,4,5,8,3,10,-1,11,44,55,6};
        kthLargest(arr, 4);

    }

    public static int kthLargest(int arr[], int k){
        int key = arr[0];

        partition(arr, 6);
        return 0;
    }

    public static void partition(int a[], int key){
        int i = 0;
        int j = a.length - 2;
        while(i <= j){
            while(a[i] < key) i++;
            while(a[j] > key) j--;
            if(i<j) {
                swap(a, i, j);
            }
        }

        System.out.println(i);
        System.out.println(j);
        a[a.length - 1] = a[i];
        a[i] = key;
//        a[i] = a[j];
//        a[j] = key;
        for(int element : a){
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
