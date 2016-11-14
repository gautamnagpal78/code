/**
 * Created by gautam on 8/8/16.
 */
public class Node {
    int data;
    Node prev;

    public Node(int data, Node prev) {
        this.data = data;
        this.prev = prev;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
