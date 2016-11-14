import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by gnagpal on 10/18/16.
 */
public class WordBreak {
    public static final Set<String> dict = new HashSet<String>(Arrays.asList("mobile","samsung","sam","sung","man","mango", "icecream","and","go","i","like","ice","cream"));

    public static void main(String[] args) {
        String input = "samsungandmangok";

        boolean arr[] = new boolean[input.length()];

        for(int i = 0; i < input.length(); i++){
            if(dict.contains(input.substring(0,i+1))){
                arr[i] = true;
            }
            else{
                int l = i-1;
                while(l >= 0){
                    if(arr[l] && dict.contains(input.substring(l+1,i+1))){
                        arr[i] = true;
                        break;
                    }
                    if(l < 0){arr[l] = false;}
                    l--;
                }
            }
        }

        for(boolean val : arr) System.out.print(val + " ");

    }
}
