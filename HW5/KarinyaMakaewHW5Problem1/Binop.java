/* Filename: Binop.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 5 Question 1
 * Deadline: 07/17/2012
 * Description: Based on the class given in Blackboard
 * 				Added addRandomKids() method and modified setChild() method
 * 				Represent binop in the tree
 * 				
 */

import java.util.Random;


public abstract class Binop extends Node {
	private static final int LEFT = 1;
	private static final int RIGHT = 0;
    protected Node lChild, rChild;
    public Binop() {
    	lChild = null; rChild = null;
    }
    public Binop(Node l, Node r) {
    	lChild = l; rChild = r;
    }
    public void setChild(int position, Node n) {
    	//set depth of child node
    	n.depth = depth + 1;
        if (position == LEFT)
        	lChild = n;
        else
            rChild = n;
    }
    
    //randomly add children to the binop node until its child is constant/variable or reach max depth
    public void addRandomKids(OperatorFactory o, TerminalFactory t, int maxDepth, Random rand){
    	//if the tree reached max depth, stop growing it and add variable/constant to its children
    	if(maxDepth == depth){
    		setChild(LEFT, t.getTerminal(rand));
    		setChild(RIGHT, t.getTerminal(rand));
    	}
    	else{
    		//randomly add operators/variable/constant to the tree
    		addOneRandomKid(LEFT, rand, o, t);
    		//recursively add child of left child until it reaches constant/variable node (addRandomKids there do nothing)
    		lChild.addRandomKids(o, t, maxDepth, rand);
    		
    		//do the same thing with right child
    		addOneRandomKid(RIGHT, rand, o, t);
    		rChild.addRandomKids(o, t, maxDepth, rand);
    	}
    }
    
    //randomly add operators/variable/constant to the tree
    public void addOneRandomKid(int leftOrRight, Random rand, OperatorFactory o, TerminalFactory t){
    	int randomKid = rand.nextInt(o.getNumOps() + t.getNumIndepVars() + 1);
		if(randomKid < o.getNumOps()){
			setChild(leftOrRight, o.getOperator(rand));
		}
		else{
			setChild(leftOrRight, t.getTerminal(rand));
		}
    }
}
