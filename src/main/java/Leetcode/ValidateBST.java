package Leetcode;

/**
 * Created by gnagpal on 11/11/16.
 */
public class ValidateBST {
    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root,Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public boolean validate(TreeNode root, double min, double max) {
        if(root == null) return true;

        if(root.val <= min || root.val >= max)
            return false;

        return  validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }

        //List<Integer> vals;
        // public boolean isValidBST(TreeNode root) {
        //     vals = new ArrayList();
        //     inorder(root);
        //     for(int i = 1; i<vals.size(); i++){
        //         if(vals.get(i) <= vals.get(i-1)) return false;
        //     }
        //     return true;

        // }

        // public void inorder(TreeNode node){
        //     if(node == null) return;
        //     inorder(node.left);
        //     vals.add(node.val);
        //     inorder(node.right);
        //}
}
