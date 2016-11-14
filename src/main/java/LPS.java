class LPS
{

    // A utility function to get max of two integers
    static int max (int x, int y) { return (x > y)? x : y; }

    // Returns the length of the longest palindromic subsequence in seq
    static int lps(String seq)
    {
        int n = seq.length();
        int i, j, cl;
        int L[][] = new int[n][n];  // Create a table to store results of subproblems
        int Way[][] = new int[n][n];

        // Strings of length 1 are palindrome of lentgh 1
        for (i = 0; i < n; i++) {
            L[i][i] = 1;
            Way[i][i]=0;
        }

        for(int len = 2; len <= n; len++){
            for(i = 0; i < n-len+1; i++){
                j = i+len-1;
                //DOnt't need because for i > j all values are 0
                if (seq.charAt(i) == seq.charAt(j) && len == 2)
                {
                    L[i][j] = 2;
                    Way[i][j] = 0;
                    //System.out.println("i+1 : " + (i+1)  + " and " +"j-1 : " + (j-1));
                }
                else if(seq.charAt(i) == seq.charAt(j)){
                    L[i][j] = L[i+1][j-1] + 2;

                    Way[i][j] = 0;
                }
                else if (seq.charAt(i) != seq.charAt(j)){
                    L[i][j] = Math.max(L[i][j-1],L[i+1][j]);
                    if(L[i][j-1] > L[i+1][j])
                        Way[i][j] = 2;
                    else Way[i][j] = 1;
                }
            }
        }

        for(i = 0; i < n; i++) {
            for(j = 0; j < n; j++){
                System.out.print(L[i][j] + " ");
            }
            System.out.println();
        }
        String s = "";
        int start=0,end = n-1;
        while(start<=end){
            if(Way[start][end] == 0 ){
                s= s + seq.charAt(start);
                start++;end--;
            }
            else if(Way[start][end] == 1){
                start++;
            }
            else end--;
        }
        System.out.println(s);
        if(L[0][n-1]%2 == 0){
            s = s.concat(new StringBuilder(s).reverse().toString());
        }else{
            s = s.concat(new StringBuilder(s.substring(0,s.length()-1)).reverse().toString());
        }
        System.out.println(s);
        return L[0][n-1];
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        String seq = "GEEKSFORGEEKS";
        int n = seq.length();
        System.out.println("The length of the lps is "+ lps(seq));
    }
}
/* This code is contributed by Rajat Mishra */