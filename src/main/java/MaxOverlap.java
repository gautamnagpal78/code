/**
 * Created by gnagpal on 10/4/16.
 */
public class MaxOverlap {
    public static void main(String[] args) {
        //sort([ai,bi])

        int a[] = {1,3,4};
        int b[] = {5,10,17};
        int x  = a[0];
        int y = b[0];

        int maxLen = 0;

        for(int i = 1 ; i < a.length; i++){
            int len = getMaxOverlap(x,y,a[i],b[i]);
            if(len > maxLen)
                    maxLen = len;

            x = a[i];
            y = Math.max(y,b[i]);
        }
        System.out.println(maxLen);
    }

    public static int getMaxOverlap(int x1, int y1, int x2, int y2){
        return Math.min(y1, y2) - Math.max(x1,x2) > 0 ? Math.min(y1, y2) - Math.max(x1,x2) : 0;
    }
}

