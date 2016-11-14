package Heap;

/**
 * Created by gnagpal on 10/17/16.
 */
public class MinHeap {
    int arr[];
    int size;
    int capacity;

    public int parent(int i){
        return (i-1)/2;
    }

    public int left(int i){
        return 2*i+1;
    }

    public int right(int i){
        return 2*i+2;
    }

    public MinHeap(int capacity) {
        this.size = 0;
        this.arr = new int[capacity];
        this.capacity = capacity;
    }

    public void insert(int val){
        int ind = size;
        arr[size++] = val;

        while(arr[ind] < arr[parent(ind)]){
            int temp = arr[ind];
            arr[ind] = arr[parent(ind)];
            arr[parent(ind)] = temp;
            ind = parent(ind);
        }
    }

    public void heapify(int i){
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if(l < size && arr[i] > arr[left(i)]){
            smallest = l;
        }
        if(r < size && arr[r] < arr[smallest]){
            smallest = r;
        }
        if(smallest!=i){
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            heapify(smallest);
        }
    }

    public int extractMin(){
        if(size == 1){
            size--;
            return arr[0];
        }

        int root = arr[0];
        arr[0] = arr[size-1];
        size--;
        heapify(0);
        return root;

    }

    public void print(){
        for(int i = 0; i<size ; i++){
            System.out.print(arr[i] + " ");
        }
    }


}
