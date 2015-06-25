/* Filename: TerminalFactory.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 5 Question 1
 * Deadline: 07/17/2012
 * Description: Factory class to randomly generate constant/variable node
 * 				
 */

import java.util.*;

public class TerminalFactory {
	private int numIndepVars;
	TerminalFactory(int n){
		numIndepVars = n;	//number of variables in the variable list
	}
	
	//randomly generate and return variable or constant node
	public Node getTerminal(Random rand){
		//randomly generate integer in [0,numIndepVars]
		int randomTerminalIndex = rand.nextInt(numIndepVars+1);
		if(randomTerminalIndex == numIndepVars){
			return new Const(rand.nextDouble());
		}
		else{
			return new Variable(randomTerminalIndex);
		}
	}
	
	//get number of variables
	public int getNumIndepVars(){
		return numIndepVars;
	}
}
