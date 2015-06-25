/*
 * Filename: Node.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 5 Question 1
 * Deadline: 07/17/2012
 * Description: Based on the class given in Blackboard
 * 				Added clone() method
 * 				Represent node in the tree
 * 				
 */

import java.util.*;

public abstract class Node implements Cloneable{
	int depth;
	
    //will be implement in subclasses
    abstract void setChild(int position, Node n);
    abstract double eval(double[] data);
    public abstract void addRandomKids(OperatorFactory o, TerminalFactory t, int maxDepth, Random rand);

    //default depth is 0
    public Node(){depth = 0;}
    
    //create new, copy and return node (as an object)
    public Object clone() {
    	Object o = null;
    	try{
    		o = super.clone();
    	}
    	catch(CloneNotSupportedException e) {
    		System.out.println("Node can't clone.");
    	}
    	return o;
    }
}
