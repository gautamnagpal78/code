package CareerCup;

/**
 * Created by gnagpal on 10/23/16.
 */
public class BinaryXor {
    public static void main(String[] args) {
        int xor = 1;
        System.out.println(1  + " :: " + xor);
        for(int i =2; i < 20; i++){

            xor = xor ^ i;
            System.out.println(i  + " :: " + xor);
        }
    }
}
