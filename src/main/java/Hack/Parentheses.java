package Hack;

import java.util.LinkedList;

/**
 * Created by gnagpal on 10/22/16.
 */
public class Parentheses {
    public static void main(String[] args) {
        String input[] = {"[{(())}]"};
        String output[] = new String[input.length];
        LinkedList<Character> stack = new LinkedList<>();
        int index = 0;
        for(String s : input){
            for(int j = 0; j < s.length(); j++) {
                if (stack.size() == 0) {
                    stack.addFirst(s.charAt(j));
                }
                else{
                    if(stack.getFirst() == '{' && s.charAt(j) == '}')
                        stack.removeFirst();
                    else if(stack.getFirst() == '[' && s.charAt(j) == ']')
                        stack.removeFirst();
                    else if(stack.getFirst() == '(' && s.charAt(j) == ')')
                        stack.removeFirst();
                    else stack.addFirst(s.charAt(j));
                }
            }
            if(stack.size()!=0) output[index] = "NO";
            else output[index] = "YES";

            while(stack.size()!=0) stack.removeFirst();

        }

        for(String str : output) System.out.println(str);

    }
}
