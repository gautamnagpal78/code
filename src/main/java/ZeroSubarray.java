import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gnagpal on 9/18/16.
 */
public class ZeroSubarray {
    public static void main(String[] args) {
        int arr[] = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        int sum = 0;
        Map<Integer, List<Integer>> subarrayList = new HashMap<Integer, List<Integer>>();
        List<Map<Integer, Integer>> finalOutput = new ArrayList<Map<Integer, Integer>>();

        for(int i = 0; i < arr.length ; i++){
            sum += arr[i];

            if(sum == 0){
                Map<Integer, Integer> entry = new HashMap<Integer, Integer>();
                entry.put(0, i);
                finalOutput.add(entry);
            }

            if(!subarrayList.containsKey(sum)){
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                subarrayList.put(sum, list);
            }
            else{
                for(Integer index : subarrayList.get(sum)){
                    Map<Integer, Integer> entry = new HashMap<Integer, Integer>();
                    entry.put(index + 1, i);
                    finalOutput.add(entry);
                }
                subarrayList.get(sum).add(i);

            }
        }

        for(Map<Integer,Integer> map : finalOutput){
            for(Map.Entry<Integer, Integer> entry: map.entrySet()){
              System.out.println(entry.getKey()  + " " + entry.getValue());
            }
        }

    }
}
