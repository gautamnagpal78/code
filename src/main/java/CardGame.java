import java.util.*;

/**
 * Created by gnagpal on 9/23/16.
 */
public class CardGame {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        int n = reader.nextInt();

        int arr[] = new int[n];
        for(int i = 0; i<n ; i++){
            arr[i] = reader.nextInt();
        }

        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum+=arr[i];
        }

        sum/=(n/2);


        Map<Integer, LinkedList<Integer>> storage = new HashMap<Integer, LinkedList<Integer>>();

        for(int j = 0; j < arr.length; j++){
            if(storage.containsKey(arr[j])){
                storage.get(arr[j]).addFirst(j);
            }
            else{
                LinkedList<Integer> queue = new LinkedList<Integer>();
                queue.addFirst(j);
                storage.put(arr[j], queue);
            }

        }

        Map<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();

        boolean arr1[] = new boolean[arr.length];
        for(int j = 0; j<arr.length; j++){
            if(map.containsKey(sum - arr[j])){
                if(map.get(sum - arr[j]).size() == 0){
                    LinkedList<Integer> l = new LinkedList<Integer>();
                    l.addFirst(j);
                    map.put(arr[j], l);                }
                else {
                    int x = map.get(sum - arr[j]).getLast();
                    x++;
                    int vaj = j + 1;
                    System.out.println(x + " " + vaj);
                    map.get(sum - arr[j]).removeLast();
                }
            }
            else{
                LinkedList<Integer> l = new LinkedList<Integer>();
                l.addFirst(j);
                map.put(arr[j], l);
            }
        }
    }


    }

