package Heap;

/**
 * Created by gnagpal on 10/17/16.
 */
public class HeapMain {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap(11);
        for(int i = 10; i >= 0; i--){
            heap.insert(i);
        }

        System.out.println(heap.extractMin());

        heap.print();


    }
}
