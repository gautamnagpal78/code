package CSE202.HW1;

/**
 * Created by gnagpal on 9/25/16.
 */
public class ArraySearch {
    public static void main(String[] args) {
        int arr[][] = {{1,8,17,27},{2,10,21,30},{6,13,24,33},{7,16,26,37}};
        System.out.println(findElement(arr, 30));
    }

    private static boolean findElement(int[][] arr, int key) {
        int mid = (arr[0].length - 1)/2;
        int column = binarySearch(arr[0], 0 ,arr[0].length - 1 ,key);

        System.out.println(column);

        return false;
    }

    private static int binarySearch(int arr[],int low, int high, int key){
        int mid = low + (high - low)/2;

        if(arr[mid] == key ) return mid;
        else if(key > arr[mid] && (mid + 1) <= arr.length - 1){
            if(key < arr[mid + 1])
                return mid;
            else return binarySearch(arr, mid + 1, high, key);
        }
        else if (key < arr[mid] && (mid - 1) >= 0){
            if(key > arr[mid - 1])
                return mid - 1;
            else return binarySearch(arr, low, mid - 1, key);
        }
        else return -1;

    }
}
