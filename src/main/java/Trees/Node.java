package Trees;

/**
 * Created by gnagpal on 9/21/16.
 */
public class Node {
    public Node left, right;
    public int val;

    public Node(){
        left = null;
        right = null;
        val = 0;
    }

    public Node(int data){
        left = null;
        right = null;
        val = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node createDll(Node n){
        if(n == null) return n;

        n = createDllUtil(n);

        while(n.left != null){
            n = n.left;
        }

        return n;

    }

    private Node createDllUtil(Node node) {
        if(node == null) return null;

        if(node.left != null){
            Node temp = createDllUtil(node.left);
            while (temp.right != null){
                temp = temp.right;
            }

            temp.right = node;
            node.left = temp;
        }

        if(node.right != null){
            Node temp = createDllUtil(node.right);
            while (temp.left != null){
                temp = temp.left;
            }

            temp.left = node;
            node.right = temp;
        }

        return node;
    }

    public Node flatten(Node node){
        if(node == null) return null;
        Node templ = null;
        Node tempr = null;
        if(node.left != null){
            templ = flatten(node.left);
        }

        if(node.right != null){
            tempr = flatten(node.right);
        }

        if(templ != null){
            node.right = templ;
            while(templ.right != null){
                templ = templ.right;
            }
            templ.right = tempr;
        }
        else{
            node.right = tempr;
        }

        return node;
    }

}
