/*
 * Filename: Minus.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 4
 * Deadline: 06/26/2012
 * Description: Represent minus operation node 
 * 				Perform subtraction of left and right children
 * 				subclass of Binop
 */

public class Minus extends Binop {
	//use constructor of Binop class
	public Minus(Node l, Node r) {
		super(l, r);
	}
    
	//perform subtraction of child nodes
	public double eval() {
		return lChild.eval() - rChild.eval();
	}
	
	//return string of subtraction operation  
	public String toString() {   
		String Sresult = "(" + lChild.toString() + " - " + rChild.toString() + ")";
		return Sresult;   
	}
}
