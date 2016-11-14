package Trees;

/**
 * Created by gnagpal on 11/5/16.
 */
public class DoubleLinkedList {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(4);
        binaryTree.getRoot().setLeft(new Node(1));
        binaryTree.getRoot().setRight(new Node(8));

        binaryTree.getRoot().getRight().setLeft(new Node(6));

//        binaryTree.getRoot().getRight().getLeft().setLeft(new Node(5));
//        binaryTree.getRoot().getRight().getLeft().getLeft().setLeft(new Node(2));

        binaryTree.getRoot().getRight().setRight(new Node(9));
//        binaryTree.getRoot().getRight().getRight().setRight(new Node(10));
//        binaryTree.getRoot().getRight().getRight().getRight().setRight(new Node(11));

        Node n = binaryTree.getRoot().flatten(binaryTree.getRoot());

        while(n != null){
            System.out.print(n.getVal() + " ");
            n = n.right;
        }
        System.out.println();

        Double d = Math.log(Math.exp(2147483647) * Math.exp(-2147483648));
        System.out.println(d.intValue());

        System.out.println(1&3);

    }

}
