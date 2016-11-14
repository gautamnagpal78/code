package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gnagpal on 11/11/16.
 */
public class LCABinaryTree {

    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p) return p;
        if(root == q) return q;
        TreeNode left  = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null)
            return root;
        else return left!=null ? left : right;
    }

}
