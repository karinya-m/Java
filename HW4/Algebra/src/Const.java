/*
 * Filename: Const.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 4
 * Deadline: 06/26/2012
 * Description: Represent value node in the arithmetic expression
 * 				Subclass of Node
 */

public class Const implements Node {
	private double value;
	public Const(double d) { value = d; }
	public double eval(double[] data) { return value; }	
	public String toString() {   
		return Double.toString(value);   
	}
}

