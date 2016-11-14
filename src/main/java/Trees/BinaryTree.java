package Trees;

import java.util.*;

/**
 * Created by gnagpal on 9/21/16.
 */
public class BinaryTree {
    private Node root;

    public void insert(int data){
        root = insert(root, data);
        int x = 9;
        x += 4;
    }

    public Node getRoot() {
        return root;
    }

    private Node insert(Node node, int data) {
        if(node == null){
             node = new Node(data);
        }
        else{
            if(node.getLeft() == null){
                node.setLeft(insert(node.getLeft(), data));
            }
            else {
                node.setRight(insert(node.getRight(), data));
            }
        }

        return node;
    }

    public void print(){
        print(root);
    }

    private void print(Node node) {
        if(node == null) return;
        System.out.println(node.getVal());
        print(node.getLeft());
        print(node.getRight());
    }

    public void levelPrint(){
        Map<Integer, List<Integer>> levelMap = new HashMap<Integer, List<Integer>>();
        levelPrint(root, 0, levelMap);
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<Integer, List<Integer>>(levelMap);
        for(Map.Entry<Integer, List<Integer>> entry : levelMap.entrySet()){
            System.out.print("level :: " + entry.getKey());
            for(Integer val : entry.getValue()){
                System.out.print(val + " ");
            }
            System.out.println();
        }

    }

    private void levelPrint(Node node, int level, Map<Integer, List<Integer>> levelMap) {
        if(node == null) return;
        insertInMap(level, node.getVal(), levelMap);
        levelPrint(node.getLeft(), level + 1, levelMap);
        levelPrint(node.getRight(), level + 1, levelMap);
    }

    private void insertInMap(int level, int val, Map<Integer, List<Integer>> levelMap) {
        if(levelMap.containsKey(level)){
            levelMap.get(level).add(val);
        }
        else{
            List<Integer> valueList = new ArrayList<Integer>();
            valueList.add(val);
            levelMap.put(level, valueList);
        }

    }

    public boolean lca(Node node, int val1, int val2){
        if(node == null) return false;

        if(node.getVal() == val1 || node.getVal() == val2) return true;

        if(lca(node.getLeft(),val1, val2) && lca(node.getRight(),val1, val2)){
            System.out.println(node.getVal());
        }

        return lca(node.getLeft(), val1, val2) || lca(node.getRight(), val1, val2);

    }

    public Node bstLca(Node node, int n1, int n2){
        if (node == null)
            return null;

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.getVal() > n1 && node.getVal() > n2)
            return bstLca(node.getLeft(), n1, n2);

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.getVal() < n1 && node.getVal() < n2)
            return bstLca(node.getRight(), n1, n2);

        return node;
    }

    public boolean isBalanced(Node node, int height){
        boolean l = false;
        boolean r = false;

        int lh = 0, rh = 0;

        return false;

    }

    public int diameter(Node node,int hiit){//} Height hiit){
//        Height lh = new Height(0);
//        Height rh = new Height(0);

        int lh = 0,rh = 0;
        if (node == null)
        {
            //hiit.h = 0;
            hiit = 0;
            return 0; /* diameter is also 0 */
        }


        //lh.h++;rh.h++;
        lh++; rh++;
        int ld = diameter(node.getLeft(), lh);
        int rd = diameter(node.getRight(), rh);

        hiit = Math.max(lh, rh) + 1;
        return Math.max(lh + rh + 1,Math.max(ld,rd));

//        hiit.h = Math.max(lh.h, rh.h) + 1;
//        return Math.max(lh.h + rh.h + 1,Math.max(ld,rd));

    }

    private int height(Node node) {
        if(node == null) return 0;
       // if(node.getLeft() == null && node.getRight() == null) return 0;
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    public void bfs(){
        LinkedList<Node> queue = new LinkedList<>();
        LinkedList<Integer> level = new LinkedList<>();

        queue.addLast(this.getRoot());
        level.addLast(1);
        int lastLev = 1;
        while (queue.size()!=0){
            Node n = queue.removeFirst();
            Integer lev = level.removeFirst();
            if(lev > lastLev) {System.out.println();System.out.print(n.getVal());lastLev = lev;}
            else System.out.print(n.getVal());
            if(n.getLeft()!=null) {
                queue.addLast(n.getLeft());
                level.addLast(lev+1);
            }
            if(n.getRight()!=null) {
                queue.addLast(n.getRight());
                level.addLast(lev+1);
            }
        }
    }

}
