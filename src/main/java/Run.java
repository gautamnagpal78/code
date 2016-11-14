import java.util.Calendar;

/**
 * Created by gautam on 8/5/16.
 */
public class Run {
    public static void main(String[] args) {


        int a[] = {1,2,3,2,3,1,3,3};
        int len = a.length;
        int offset = len-1;
            //int len = sizeof(a)/sizeof(a[0]);
            int startIndex = 0;
            int nextIndex = 0;
            int count = 0;
            int value = 0;
            //cout<<len;
            while(count < len){
                nextIndex = (startIndex + offset)%len;
                value = a[startIndex];
                while(nextIndex != startIndex && count < len){
                    int temp = a[nextIndex];
                    a[nextIndex] = value;
                    value = temp;
                    nextIndex = (nextIndex+offset)%len;
                    count++;
                }
                a[startIndex] = value;count++;
                startIndex++;
            }

            for(int i=0; i<len ; i++){
                System.out.print(a[i] + " ");
            }
        }
}
////        Stack s = new Stack();
////        s.push(8);
////        s.push(6);
////        s.push(3);//        s.push(4);
////        s.push(5);
////        s.push(8);
////        s.push(6);
////        s.push(3);
////        s.push(4);
////        s.push(5);
////        s.push(8);
////        s.push(6);
////        s.push(3);
////        s.push(4);
////        s.push(5);
////        s.push(8);
////        s.push(6);
////        s.push(3);
////        s.push(4);
////        s.push(5);
////        s.push(8);
////        s.push(6);
////        s.push(3);
////        s.push(4);
////        s.push(5);
////        s.push(8);
////        s.push(6);
////        s.push(3);
////        s.push(4);
////        s.push(5);
////        s.push(8);
////        s.push(6);
////        s.push(3);
////        s.push(4);
////        s.push(5);
////        s.push(8);
////        s.push(6);
////        s.push(3);
////        s.push(4);
////        s.push(5);
////        s.push(8);
////        s.push(6);
////        s.push(3);
////        s.push(4);
////        s.push(5);
////        s.push(8);
////        s.push(6);
////        s.push(3);
////        s.push(4);
////        s.push(5);
////        s.push(8);
////        s.push(6);
////        s.push(3);
////        s.push(4);
////        s.push(5);
////        s.push(8);
////        s.push(6);
////        s.push(3);
////        s.push(4);
////        s.push(5);
////        s.push(8);
////        s.push(6);
////        s.push(3);
////        s.push(4);
////        s.push(5);
////
////        long t = Calendar.getInstance().getTimeInMillis();
////        s.sortStack();
////        long t2 = Calendar.getInstance().getTimeInMillis();
////        System.out.println(t2 - t);
//////        System.out.println(t);
//    }
//}
