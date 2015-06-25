/*
 * Filename: Variable.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 4
 * Deadline: 06/26/2012
 * Description: Represent variable in algebra expression
 * 				Subclass of Node
 */
public class Variable implements Node {
	private int index;
	public Variable(int variableIndex) { index = variableIndex; }
	public double eval(double[] data) { return data[index]; }	
	public String toString() {   
		return "X" + Integer.toString(index);   
	}

}
