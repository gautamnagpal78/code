/**
 * Created by gnagpal on 10/16/16.
 */
public class CircuitMain {
    public static void main(String[] args) {
        Circuit circuit = new Circuit(2,1);


        Circuit left = new Circuit(2,2);
        Circuit right = new Circuit(4,1);

        circuit.left = left;
        circuit.right = right;

        Circuit leftleft = new Circuit(1,2);
        Circuit leftright = new Circuit(1,2);

        circuit.left.left = leftleft;
        circuit.left.right = leftright;

        Circuit rightleft = new Circuit(1,2);
        Circuit rightright = new Circuit(1,2);

        circuit.right.left = rightleft;
        circuit.right.right = rightright;

        balance(circuit);
        System.out.println("okay");
    }

    public static int balance(Circuit circuit){
        if(circuit == null) return 0;
        int lh = balance(circuit.left);
        int rh = balance(circuit.right);

        if((circuit.leftVal + lh) > (circuit.rightVal + rh)){
            circuit.rightVal += circuit.leftVal + lh - (circuit.rightVal + rh);
            return circuit.rightVal + rh;
        }
        else if((circuit.leftVal + lh) < (circuit.rightVal + rh)){
            circuit.leftVal += circuit.rightVal + rh - (circuit.leftVal + lh);
            return circuit.leftVal +  lh;
        }
        else return circuit.leftVal + lh;
    }



}
