/**
 * Created by gnagpal on 9/19/16.
 */
public class Move {
    public static void main(String[] args) {
        char arr[] = {'C', 'D', 'E', 'F', 'G'};
        int  ind[] = {3, 0, 4, 1, 2};

        for(int i = 0; i < arr.length; i++){
            int index = i;
            char temp = arr[i];
            while(ind[index] >= 0){
                int finalTogo = ind[index];
                ind[index] = -1;
                char save = arr[finalTogo];
                arr[finalTogo] = temp;
                temp = save;
                index = finalTogo;
            }

        }

        for(char c : arr){
            System.out.println(c + " ");
        }

    }
}
