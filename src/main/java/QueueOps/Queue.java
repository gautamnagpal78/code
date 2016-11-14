package QueueOps;

/**
 * Created by gautam on 8/8/16.
 */
public class Queue {
    private Node last, first;
    private int size;

    public Queue(){
        size = 0;
        last = null;
        first = null;
    }

    public void enqueue(int data){
        if(first == null){
            Node n = new Node(data);
            first = n;
            last = n;
        }
        else{
            Node n = new Node(data);
            last.setPtr(n);
            last = n;
        }

    }

    public void dequeue(){
        first = first.getPtr();
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }
}
