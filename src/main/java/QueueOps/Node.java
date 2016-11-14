package QueueOps;

/**
 * Created by gautam on 8/8/16.
 */
public class Node {
    private int data;
    private Node ptr;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getPtr() {
        return ptr;
    }

    public void setPtr(Node ptr) {
        this.ptr = ptr;
    }
}
