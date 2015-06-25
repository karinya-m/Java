/*
 * Filename: TestAlgebra.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 5 Question 1
 * Deadline: 07/17/2012
 * Description: Based on TestAlgebra class given in class
 * 				Test the randomly generated algebra tree
 * 				Print out random algebra equation
 */

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class TestAlgebra {
	static int numIndepVars = 3;
	static int maxDepth = 5;	
	static Random rand = new Random();	//random generator used through out the program

	public static void main(String[] args) {
		double[] data = new double[3];
		data[0] = 3.14;
		data[1] = 2.78;
		data[2] = 1.0;
		Node[] ops = {new Plus(), new Minus(), new Mult(), new Divide()};
		OperatorFactory o = new OperatorFactory(ops);
		TerminalFactory t = new TerminalFactory(numIndepVars);
		Node root = o.getOperator(rand);
		root.addRandomKids(o, t, maxDepth, rand);
		String s = root.toString();
		//display only 4 decimal digits
		NumberFormat formatter = new DecimalFormat("#.####");
		try{
			System.out.println(s + " = " + formatter.format(root.eval(data)));
		}
		//if divisor is zero, print out error msg
		catch (ArithmeticException arithmeticException ){
            System.out.println( "Output invalid. Divided by zero." );   
		}
	}
}
