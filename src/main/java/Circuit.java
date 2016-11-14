/**
 * Created by gnagpal on 10/16/16.
 */
public class Circuit {
    Circuit left;
    Circuit right;
    int leftVal;
    int rightVal;

    public Circuit(int leftVal, int rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public Circuit(Circuit circuit, int left, int rightVal){

    }
}
