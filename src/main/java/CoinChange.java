/**
 * Created by gnagpal on 10/15/16.
 */
class CoinChange{
    public static void main(String[] args) {
        int N = 4;
        int a[] = {1,2,3};

        int ans[][] = new int[a.length][N+1];

        for(int j = 0; j < a.length; j++) {
            ans[j][0] = 1;
        }

        for(int i = 1; i <= N; i++){
            for(int j = 0; j < a.length; j++){
                if(i-a[j] >= 0){
                    ans[j][i] = ans[j][i] + ans[j][i-a[j]];
                }

                if(j>=1)
                ans[j][i] = ans[j][i] + ans[j-1][i];

            }
        }
        System.out.println(ans[a.length-1][N]);
        //System.out.println(ans[N]);

    }
}
