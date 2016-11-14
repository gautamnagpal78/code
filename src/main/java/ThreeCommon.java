/**
 * Created by gnagpal on 9/20/16.
 */
public class ThreeCommon {
    public static void main(String[] args) {
        int a[] = {1, 5, 10, 20, 40, 80};
        int b[] = {6, 7, 20, 80, 100};
        int c[] = {3, 4, 15, 20, 30, 70, 80, 120};

        int i,j,k;
        i=0;j=0;k=0;
        while (i < a.length && j < b.length ){
            if(a[i] > b[j]) j++;
            else if ( a[i] < b[j]) i++;
            else {
                while(c[k] < a[i]) k++;
                if(c[k] == a[i])
                {
                    System.out.println(c[k]);
                }
                i++; j++;
            }
        }
    }
}
