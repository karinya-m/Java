import java.util.*;

public class TestArithmetic {
    static int numIndepVars = 3;
	static Random r = new Random();
    public static Node randOperator() {
    	Node n;
        int i = r.nextInt(4);
        switch(i) {
            case 0: n = new Plus(); break;
            case 1: n = new Minus(); break;
            case 2: n = new Mult(); break;
            case 3: n = new Divide(); break;
            default: n = new Plus(); break;
        }
        return n;
    }
    public static Node randConst() {
        Node n;
        int i = r.nextInt(20) + 1;
       	n = new Const(i);
        return n;
    }
    public static Node randVariable() {
        Node n;
        int i = r.nextInt(numIndepVars);
		n = new Variable(i);
        return n;
    }
    public static Node randConstOrVariable() {
        Node n;
        int i = r.nextInt(2);
        if ( i == 0)
			n = randConst();
        else
            n = randVariable();
        return n;
    }
    /*
    public static Node randAnyNode() {
        Node n;
        int i = r.nextInt(6);
        switch(i) {
            case 0: n = new Plus(); break;
            case 1: n = new Minus(); break;
            case 2: n = new Mult(); break;
            case 3: n = new Divide(); break;
        	case 4: n = randConst(); break;
        	case 5: n = randVariable(); break;
            default: n = randConst(); break;
        }
        return n;
    }
	*/
    public static void main(String[] args) {
        double[] data = new double[3];
        data[0] = 3.14;
        data[1] = 2.78;
        data[2] = 1.0;
        for (int i = 0; i < 5; i++) {
        	Node root = randOperator();

        	Node n1 = randOperator();
        	n1.setChild(1, randConstOrVariable());
        	n1.setChild(2, randConstOrVariable());

        	Node n2 = randOperator();
        	n2.setChild(1, randConstOrVariable());
        	n2.setChild(2, randConstOrVariable());

        	root.setChild(1, n1);
        	root.setChild(2, n2);

        	String s = root.toString();
        	System.out.println(s + " = " + root.eval(data));
        }
    }
}
