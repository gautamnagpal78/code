import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gnagpal on 10/21/16.
 */
public class gd {

    public static void main(String[] args) {
        String s = "abc";
        List<String> list = new ArrayList<>();
        sequence("",s,0,list);
        Collections.sort(list);
        for(String se : list) System.out.println(se);
        list.toArray(new String[list.size()]);
    }

    public static void sequence(String ans, String str, int index, List<String> answer){
        if(index == str.length()-1){
            if(ans.length()!=0)
            answer.add(ans);
            answer.add(ans + str.charAt(str.length()-1));
        }
        else {
            sequence(ans, str, index + 1, answer);
            sequence(ans + str.charAt(index), str, index + 1, answer);
        }
    }

}
