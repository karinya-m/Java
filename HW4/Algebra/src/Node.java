/*
 * Filename: Node.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 4
 * Deadline: 06/26/2012
 * Description: Represent node in a tree, inherited by subclasses
 */
public interface Node {
	//public Node();
	//will be overridden by subclass
	public double eval(double[] data);
}
