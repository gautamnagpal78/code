import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gnagpal on 9/19/16.
 */
public class ColumnarTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

        insert(root, root, 2);
        insert(root, root, 6);
        insert(root, root, 1);
        insert(root, root, -1);
        insert(root, root, 3);
        print(root);
        Map<Integer, List<Integer>> maps = new HashMap<Integer, List<Integer>>();
        prints(root, 0, maps);

        for(Map.Entry<Integer, List<Integer>> entry : maps.entrySet()){
            System.out.println("Column :: " + entry.getKey());
            for(Integer i : entry.getValue()){
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }


    public static void insert(TreeNode node, TreeNode pnode, int val){
        if(node == null){
            if(val > pnode.getVal()) {
                pnode.setRight(new TreeNode(val));
            }
            else pnode.setLeft(new TreeNode(val));

            return;
        }
        if(val < node.getVal()){
            insert(node.getLeft(), node, val);
        }
        else insert(node.getRight(), node, val);
    }


    public static void prints(TreeNode node, int column, Map<Integer, List<Integer>> map){
        if(node == null) return;
        if(map.containsKey(column)){
            map.get(column).add(node.getVal());
        }
        else{
            List<Integer> list = new ArrayList<Integer>();
            list.add(node.getVal());
            map.put(column, list);
        }

        prints(node.getLeft(), column - 1, map);
        prints(node.getRight(), column + 1, map);

    }

    public static void print(TreeNode node){
        if(node == null){ return; }
        print(node.getLeft());
        System.out.println(node.getVal());
        print(node.getRight());
    }
}
