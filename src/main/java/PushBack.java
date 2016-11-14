import java.util.Arrays;

/**
 * Created by gnagpal on 9/24/16.
 */
public class PushBack {

    public static void main(String[] args) {
        int arr[] = {3,3};
        //System.out.println(removeElement(arr, 3));
        char[][] board =
               {{'.', '8', '7','6','5','4','3','2','1'},
                {'1', '.', '.','.','.','.','.','.','.'},
                {'2', '.', '.','.','.','.','.','.','.'},
                {'.', '.', '.','.','.','.','.','.','.'},
                {'.', '.', '.','.','.','.','.','.','.'},
                {'.', '.', '.','.','.','.','.','.','.'},
                {'.', '.', '.','.','.','.','.','.','.'},
                {'.', '.', '.','.','.','.','.','.','.'},
                {'.', '.', '.','.','.','.','.','.','.'}};
        System.out.println(isValidSudoku(board));
    }
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            } else i++;
        }

        return j;
    }

    public static boolean isValidSudoku(char[][] board) {
        boolean ba[] = new boolean[9];
        for(int i = 0; i < board.length; i++){
            Arrays.fill(ba, Boolean.FALSE);
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j]=='.') continue;
                else {
                    if(ba[board[i][j] - '1']) return false;
                    else ba[board[i][j] - '1'] = true;
                }
            }

        }

        for(int i = 0; i < board.length; i++){
            Arrays.fill(ba, Boolean.FALSE);
            for(int j = 0; j < board[i].length; j++){
                if(board[j][i]=='.') continue;
                else {
                    if(ba[board[j][i] - '1']) return false;
                    else ba[board[j][i] - '1'] = true;
                }
            }

        }


        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                Arrays.fill(ba, Boolean.FALSE);
            for(int i = x*3; i < x*3 + 3; i++){
                    for(int j = y*3; j < y*3+3; j++ ){
                        if(board[j][i]=='.') continue;
                        else {
                            if(ba[board[j][i] - '1']) return false;
                            else ba[board[j][i] - '1'] = true;
                        }
                    }

            }

            }

        }


        return true;


    }
}
