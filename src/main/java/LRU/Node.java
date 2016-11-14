package LRU;

/**
 * Created by gnagpal on 11/3/16.
 */
public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}
