import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by gnagpal on 10/13/16.
 */
public class g {
    public static void main(String[] args) {
    //pascalTriangle(4);
        System.out.println(palindromes("aabaa").size());
    }

    /*
 * Complete the function below.
 */

    public static Set<String> palindromes(final String input) {

        final Set<String> result = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            // expanding even length palindromes:
            expandPalindromes(result,input,i,i+1);
            // expanding odd length palindromes:
            expandPalindromes(result,input,i,i);
        }
        return result;
    }

    public static void expandPalindromes(final Set<String> result, final String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            result.add(s.substring(i,j+1));
            i--; j++;
        }


    }

    ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }



}
