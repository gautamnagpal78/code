///**
// * Created by gnagpal on 9/14/16.
// */
//public class TreeOps {
//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(4);
//
//        insert(root, root, 2);
//        insert(root, root, 6);
//        insert(root, root, 1);
//        insert(root, root, -1);
//        insert(root, root, 3);
//
//        postorder(root);
//
//    }
//
//    public static void insertInTree(int arr[]){
//        TreeNode root = new TreeNode(arr[arr.length - 1]);
//        arr[arr.length - 1] = -1;
//        int max = 0;
//        for(int i = arr.length - 2; i >=0; i++){
//            if(arr[i] > max){
//                arr[i] = -1;
//                max = arr[i];
//            }
//            insert(root, root, arr[i], arr);
//        }
//
//    }
//
//    public static void insert(TreeNode node, TreeNode pnode, int val, int arr[]){
//        if(node == null){
//            if(val > pnode.getVal()) {
//                pnode.setRight(new TreeNode(val));
//            }
//            else pnode.setLeft(new TreeNode(val));
//
//            return;
//        }
//        if(val < node.getVal()){
//            insert(node.getLeft(), node, val, arr);
//        }
//        else insert(node.getRight(), node, val, arr);
//    }
//
//    public static void print(TreeNode node){
//        if(node == null){ return; }
//        print(node.getLeft());
//        System.out.println(node.getVal());
//        print(node.getRight());
//    }
//
//    public static void preorder(TreeNode node){
//        if(node == null){ return; }
//        System.out.println(node.getVal());
//
//        preorder(node.getLeft());
//        preorder(node.getRight());
//
//    }
//
//    public static void postorder(TreeNode node){
//        if(node == null){ return; }
//
//        postorder(node.getLeft());
//        postorder(node.getRight());
//
//        System.out.println(node.getVal());
//
//    }
//}
