/*
 * Filename: Plus.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 4
 * Deadline: 06/26/2012
 * Description: Represent plus operation node 
 * 				Perform addition of left and right children
 * 				Subclass of Binop
 */

public class Plus extends Binop {
	//use constructor of Binop class
	public Plus(Node l, Node r) {
		super(l, r);
	}
    
	//perform addition of child nodes
	public double eval() {
		return lChild.eval() + rChild.eval();
	}
	
	//return string of plus operation  
	public String toString() {   
		String Sresult = "(" + lChild.toString() + " + " + rChild.toString() + ")";
		return Sresult;   
	}
}
