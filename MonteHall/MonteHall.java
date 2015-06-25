/*
 * Filename: MonteHall.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 2 Question 3 
 * Deadline: 06/05/2012
 * Description: Simulate Monte Hall paradox.
 *              Get input from user whether he wants to "always switch" or "never switch"
 *              Print out fraction of times the user wins
 */

import java.math.*;
import java.util.*;

public class MonteHall {
	private static final int NUM_OF_TESTS = 10000;
	private static final int NUM_OF_DOORS = 3;

	public static void main(String[] args){
		System.out.println("------------- Monte Hall Paradox -------------");
		System.out.println("Please enter a number from the options below");
		System.out.println("1. \"always switch\"");
		System.out.println("2. \"never switch\"");
		
		//get choice from user
		Scanner keyboard = new Scanner(System.in);
		String sChoice = keyboard.nextLine();
		Integer iChoice = -1;
		boolean switchChoice = false;
		try{
			iChoice = Integer.valueOf(sChoice);	
		}
		catch (NumberFormatException e){
			System.out.println("Error: Invalid input");
			System.exit(0);
		}
		switch(iChoice){
		case 1:
			switchChoice = true;
			break;
			
		case 2:
			switchChoice = false;
			break;
			
		default: 
			System.out.println("Error: Invalid input");
			System.exit(0);
		}
		
		//play game NUM_OF_TESTS times and count time that contestant won
		int numWon = 0;
		for(int z = 0; z < NUM_OF_TESTS; z++){			
			if(playGame(switchChoice)){
				numWon++;
			}
		}
		
		//calculate probablity that contestant will win from selected choice
		double winProb = (double)numWon / (double)NUM_OF_TESTS;
		System.out.println("Probability to win = " + winProb);
	}
	
	//play game 
	//if win, return true. if lose, return false 
	static boolean playGame(boolean switchChoice){
		Game theGame = new Game();
		theGame.setUpGame();
		theGame.contestantChooseDoor();
		theGame.hostOpenDoor();
		if(switchChoice){
			theGame.switchDoor();
		}	
		return theGame.isWin();	
	}
}
