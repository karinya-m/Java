/*
 * Filename: Euclid.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 3 Question 1 
 * Deadline: 06/12/2012
 * Description: Calculate the greatest common divisor of two integers
 * 				and test if the calculated gcd is correct
 */


import java.util.Scanner;


public class Euclid {
	public static void main (String[] args){
		//get numbers to find gcd from user
		System.out.println("Great Common Divisor");
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the first number");
		String aString = keyboard.nextLine();
		System.out.println("Please enter the second number");
		String bString = keyboard.nextLine();
		int a = 0;
		int b = 0;
		
		//convert string input to integer
		try{
			a = Integer.valueOf(aString);	
			b = Integer.valueOf(bString);	
		}
		catch (NumberFormatException e){
			System.out.println("Error: Invalid input");
			System.exit(0);
		}
		
		//calculate and print out gcd result
		int gcdResult = calGcd(a,b);
		System.out.println("The gcd of " + a + " and " + b + " is " + gcdResult);
		System.out.println();
		
		//check and print out if the calculated gcd is correct
		System.out.println("Check if calculated gcd is correct....");
		if (testGcd(a, b, gcdResult)){
			System.out.println("Result is correct.");
		}
		else{
			System.out.println("Result is incorrect.");
		}
	}
	
 
	//check if there is any number greater than "result" that can divide "a" and "b"
	//return true if "result" is gcd of "a" and "b"
	static boolean testGcd(int a, int b, int result){
		//Get minimum value between a and b
		int min = Math.min(a, b);

		//check if both number are divisible by gcd
		if(a % result != 0 && b % result != 0){
			System.out.println("Both numbers are not divisible by gcd");
			return false;
		}
		
		//check if there is no number more than the calculated gcd that can divide both integers.
		for(int i = result + 1; i <= min; i++){
			//if the calculated gcd is correct, if-condition is always false
			if(a % i == 0 && b % i == 0){
				System.out.println("The calulated gcd is wrong. There is other number greater than gcd that can divide both " + a + " and " + b);
				System.out.println(a + " and " + b +" is divisible by " + i);
				return false;
			}
		}
		System.out.println("No other number greater than " + result + " that can divide both " + a + " and " + b);
		return true;
	}
	
	//change sign of negative integers and calculate gcd
	static int calGcd(int a, int b){
		//Always use positive number to find gcd
		int gcdA = Math.abs(a);
		int gcdB = Math.abs(b);
		return gcd(gcdA, gcdB);
	}
	
	//calculate gcd function from the Euclid's algorithm.
	static int gcd(int a, int b){
		return b == 0? a: gcd(b, a % b);
	}

}
