/*
 * Filename: Binop.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 4
 * Deadline: 06/26/2012
 * Description: Represent node that have left and right children
 */
public class Binop implements Node {
	protected Node lChild, rChild;
	
	//constructor set left and right child node
	public Binop(Node l, Node r) {
		lChild = l; rChild = r;    
	}
	
	public double eval(double[] data){
		System.out.println("Error: eval Node");   
		return 0;
	}
}
