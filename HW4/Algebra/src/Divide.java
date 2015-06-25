/*
 * Filename: Divide.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 4
 * Deadline: 06/26/2012
 * Description: Represent divide operation node 
 * 				Perform devision of left and right children
 * 				subclass of Binop
 */

public class Divide extends Binop {
	//use constructor of Binop class
	public Divide(Node l, Node r) {
		super(l, r);
	}
    
	//perform division of child nodes
	public double eval(double[] data) {
		if (rChild.eval(data) == 0){
			System.out.println("Divisor = 0");
			System.exit(0);
		}
		return lChild.eval(data) / rChild.eval(data);
	}

	//return string of division operation  
	public String toString() {   
		String Sresult = "(" + lChild.toString() + " / " + rChild.toString() + ")";
		return Sresult;   
	}
}
