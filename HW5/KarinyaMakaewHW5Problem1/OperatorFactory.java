/* Filename: OperatorFactory.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 5 Question 1
 * Deadline: 07/17/2012
 * Description: Factory class to randomly generate operator node
 * 				
 */
import java.util.*;

public class OperatorFactory {
	private Node[] currentOps;	//Hold list of operators
	OperatorFactory(Node[] n){
		currentOps = n;
	}
	
	//randomly create and return operator node
	public Node getOperator(Random rand){
		//randomly choose operator
		int randomOperatorIndex = rand.nextInt(currentOps.length);
		//copy and return new Binop operator object
		return (Binop)(currentOps[randomOperatorIndex].clone());
	}
	
	//get number of operators in the list
	public int getNumOps(){
		return currentOps.length;
	}

}
