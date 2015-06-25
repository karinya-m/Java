/*
 * Filename: TestArithmetic.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 4
 * Deadline: 06/26/2012
 * Description: Test the arithmetic expression
 * 				Print out 5 random arithmetic problems
 */

import java.util.*;

public class TestArithmetic {
	private static final int CONST_NUM = 4;		//4 numbers in the tree
	private static final int OPERATOR_NUM = 4;	//+ - * /
	
	public static void main(String[] args) {
		
		//print out 5 random arithmetic problems
		for(int j = 0; j < 5; j++){
			randomArithmetic();
		}
	}
	
	//print out random arithmetic problem
	private static void randomArithmetic(){
		//array of random numbers
		Node random_const[] = new Node[CONST_NUM];
		for(int i = 0; i < 4; i++){
			random_const[i] = new Const(random1to20());
		}
		
		//Node contains arithmetic expression of random number from the array and random operation
		Node random_root = randomOperator(randomOperator(random_const[0], random_const[1]), 
				                          randomOperator(random_const[2], random_const[3]));
		
		//print out contents of the node and its value
		System.out.println(random_root.toString() + " = " + random_root.eval());
	}
	
	//randomly select math operation for the 2 numbers in the argument
	private static Node randomOperator(Node left, Node right){
		Node randomOperator = null;
		Random randomGenerator = new Random();
		int randomSign = randomGenerator.nextInt(OPERATOR_NUM);
		switch (randomSign){	
		case 0 : randomOperator = new Plus(left, right);
		break;
		case 1 : randomOperator = new Minus(left, right);
		break;
		case 2 : randomOperator = new Mult(left, right);
		break;
		case 3 : randomOperator = new Divide(left, right);
		break;
		}		
		return randomOperator;
	}
	
	//randomly select integer from 1 to 20
	private static int random1to20(){
		Random randomGenerator = new Random();  
		return randomGenerator.nextInt(20) + 1;  //plus one to make 0-19 range -> 1-20 range
	}
}
