import java.util.*;

public class Solution {

    public static void main(String[] args) {
        boolean n[] = new boolean[3];
        for(boolean d : n){
            System.out.println(d);
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        Scanner s = new Scanner(System.in);

        int testCase = s.nextInt();

        for (int j = 0; j < testCase; j++) {
            int nodes = s.nextInt();
            int[] numbers = new int[nodes];

            for (int i = 0; i < nodes; i++) {
                if (s.hasNextInt()) {
                    numbers[i] = s.nextInt();
                } else {
                    System.out.println("You didn't provide enough numbers");
                    break;
                }




            }
            if(verify(numbers, nodes)) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static boolean verify(int nodes[], int n){
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addFirst(nodes[0]);
        int currRoot = -2;
        for(int i = 1; i < n; i++) {

            if (currRoot > nodes[i])
                return false;
            else {
                if (stack.getFirst() > nodes[i]) {
                    stack.addFirst(nodes[i]);
                } else {
                    while (stack.size() != 0 && stack.getFirst() < nodes[i]) {
                        currRoot = stack.getFirst();
                        stack.removeFirst();
                    }
                    stack.addFirst(nodes[i]);
                }
            }

        }
        return true;
    }
}
