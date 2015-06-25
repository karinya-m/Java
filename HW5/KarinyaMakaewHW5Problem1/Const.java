 /* Filename: Const.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 5 Question 1
 * Deadline: 07/17/2012
 * Description: Based on the class given in Blackboard
 * 				Represent constant in algebra expression
 * 				
 */

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class Const extends Node {
    private double value;
    public Const(double d) {value = d; }
    public void setChild(int position, Node n) {}
    public double eval(double[] data) { return value; }
    public String toString() {
        String s = new String();
        //display only 4 decimal digits
        NumberFormat formatter = new DecimalFormat("#.####");
        s += formatter.format(value);   
        return s;
    }
    
    //do not add any child to the node
	public void addRandomKids(OperatorFactory o, TerminalFactory t, int maxDepth, Random rand){}
}
