package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gnagpal on 11/13/16.
 */
public class InorderIterative {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode node = root;
        List<Integer> inorder = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(node!=null){
            stack.addFirst(node);
            node = node.left;
        }

        while(stack.size()!=0){
            TreeNode n = stack.getFirst();
            stack.removeFirst();
            inorder.add(n.val);
            if(n.right!=null){
                n = n.right;
                while(n!=null){
                    stack.addFirst(n);
                    n = n.left;
                }
            }
        }
        return inorder;
    }
}
