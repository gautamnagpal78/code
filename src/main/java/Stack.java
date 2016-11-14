/**
 * Created by gautam on 8/8/16.
 */
public class Stack {
    private Node top;
    int min;

    public int getMin(){
        return min;
    }
    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public void push(int data){
        Node n = new Node(data, this.top);
        this.top = n;
    }
//    public void push(int data){
//
//        if(this.top == null)
//        {
//            Node n = new Node(data, this.top);
//            min = data;
//            this.top = n;
//            return;
//        }
//
//        if(data < min){
//            int newMin = data;
//            data = 2*data - min;
//            min = newMin;
//
//        }
//
//        Node n = new Node(data, this.top);
//        this.top = n;
//
//    }

    public void push(Node node){

        Node temp = this.top;
        this.top = node;
        this.top.setPrev(temp);

    }

//    public int getTopData(){
//        if(this.top != null){
//            int topData;
//            if(top.getData() < min){
//                min = 2*min - top.getData();
//            }
//
//            this.top = this.top.getPrev();
//
//        }
//
//        return -1;
//    }


    public void sortStack(){
        print();

        Stack stack2 = new Stack();
        while(!isEmpty()){
            if(stack2.isEmpty()){
                Node top = this.getTop();
                this.pop();
                stack2.push(top);
            }
            else{
                if(this.getTop().getData() >= stack2.getTop().getData()){
                    Node top = this.getTop();
                    this.pop();
                    stack2.push(top);
                }
                else{
                    Node n = this.getTop();
                    this.pop();
                    int counter = 0;
                    while(!stack2.isEmpty() && stack2.getTop().getData() > n.getData()){
                        Node top2 = stack2.getTop();
                        stack2.pop();
                        this.push(top2);
                        counter++;
                    }
                    stack2.push(n);
                    while(counter-- > 0){
                        Node top = this.getTop();
                        this.pop();
                        stack2.push(top);
                    }

                }
            }
        }

        stack2.print();
    }

//    public void pop(){
//        if(this.top != null){
//            if(top.getData() < min){
//                min = 2*min - top.getData();
//            }
//
//            this.top = this.top.getPrev();
//
//        }
//
//    }

    public void pop(){
        if(top != null){
            this.top = this.top.getPrev();
        }

    }

    public boolean isEmpty(){
        if(this.top == null) return true;
        return false;
    }


    public void print() {
        Node n = this.top;
        while(n!=null){
            System.out.println(n.getData());
            n = n.getPrev();
        }

        System.out.println("---------------------------");
    }
}
