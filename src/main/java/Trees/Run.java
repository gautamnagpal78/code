package Trees;

/**
 * Created by gnagpal on 9/21/16.
 */
public class Run {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        //insert into tree
//        for(int i = 0; i < 15; i++){
//            binaryTree.insert(i);
//        }

        binaryTree.insert(4);
        binaryTree.getRoot().setLeft(new Node(1));
        binaryTree.getRoot().setRight(new Node(8));

        binaryTree.getRoot().getRight().setLeft(new Node(6));

        binaryTree.getRoot().getRight().getLeft().setLeft(new Node(5));
        binaryTree.getRoot().getRight().getLeft().getLeft().setLeft(new Node(2));

        binaryTree.getRoot().getRight().setRight(new Node(9));
        binaryTree.getRoot().getRight().getRight().setRight(new Node(10));
        binaryTree.getRoot().getRight().getRight().getRight().setRight(new Node(11));

        binaryTree.bfs();


        // binaryTree.levelPrint();
        //System.out.println(binaryTree.diameter(binaryTree.getRoot(),0));//new Height(0)));
    }
}
