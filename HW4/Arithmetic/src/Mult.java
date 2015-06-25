/*
 * Filename: Mult.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 4
 * Deadline: 06/26/2012
 * Description: Represent multiplication operation node 
 * 				Perform multiplication of left and right children
 * 				subclass of Binop
 */

public class Mult extends Binop {
	//use constructor of Binop class
	public Mult(Node l, Node r) {
		super(l, r);
	}
    
	//perform multiplication of child nodes
	public double eval() {
		return lChild.eval() * rChild.eval();
	}
	
	//return string of multiplication operation  
	public String toString() {   
		String Sresult = "(" + lChild.toString() + " * " + rChild.toString() + ")";
		return Sresult;   
	}

}
