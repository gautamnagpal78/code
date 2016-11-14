import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by gnagpal on 9/19/16.
 */
public class Missing2 {
    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int B[] = new int[arr.length];
        maxSlidingWindow(arr, arr.length, 3, B);


    }

    public static  void maxSlidingWindow(int A[], int n, int w, int B[]) {
        Deque Q = new LinkedList<Integer>();
        for (int i = 0; i < w; i++) {
            while (!Q.isEmpty() && A[i] >= A[((Integer) Q.getLast())])
                Q.removeLast();
            Q.addLast(i);
        }
        for (int i = w; i < n; i++) {
            B[i-w] = A[(Integer)Q.getFirst()];
            while (!Q.isEmpty() && A[i] >= A[((Integer) Q.getLast())])
                Q.removeLast();
            while (!Q.isEmpty() && (Integer)Q.getFirst() <= i-w)
                Q.removeFirst();
            Q.addLast(i);
        }
        B[n-w] = A[(Integer)Q.getFirst()];
    }
}
