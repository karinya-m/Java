/*
 * Filename: Game.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 2 Question 3 
 * Deadline: 06/05/2012
 * Description: Represent Monte Hall paradox game
 *              
 */

import java.util.Random;


public class Game {
	private static final int NUM_OF_DOORS = 3;
	static Random r;
	Door[] doors;

	public Game(){	 
		r = new Random();
		doors = new Door[NUM_OF_DOORS];
		for(int i = 0; i < NUM_OF_DOORS; i++){
			doors[i] = new Door();
		}
	}
	
	//randomly put prize to a door
	void setUpGame(){
		int grandPrizeDoor = r.nextInt(NUM_OF_DOORS);
		doors[grandPrizeDoor].hasGrandPrize = true;	
	}
	
	//randomly choose a door
	void contestantChooseDoor(){
		int contestantDoor = r.nextInt(NUM_OF_DOORS);
		doors[contestantDoor].chosenByContestant = true;				
	}
	
	//host randomly opens one door that contestant does not choose and has no prize
	void hostOpenDoor(){
		int openDoor = r.nextInt(NUM_OF_DOORS);
		while(doors[openDoor].chosenByContestant || doors[openDoor].hasGrandPrize){
			openDoor = r.nextInt(NUM_OF_DOORS);
		}
		doors[openDoor].open = true;
	}
	
	//contestant wants to switch door
	//randomly assign to door that is not open and not chosen by contestant
	//set previously chosen door back to false
	void switchDoor(){
		int prevChosenDoor = -1;
		for(int i = 0; i < NUM_OF_DOORS; i++){
			//keep the previous chosen door for later use
			if(doors[i].chosenByContestant){
				prevChosenDoor = i;
				break;
			}				
		}
		
	
		int randomNum = r.nextInt(NUM_OF_DOORS);
		//if the door is not open and not chosen, can switch to that door 
		while(doors[randomNum].open || doors[randomNum].chosenByContestant){
			randomNum = r.nextInt(NUM_OF_DOORS);
		}
		doors[randomNum].chosenByContestant = true;
		//clear the previously chosen door
		doors[prevChosenDoor].chosenByContestant = false;
		
	}
	
	//check if contestant wins
	boolean isWin(){
		for(int i = 0; i < NUM_OF_DOORS; i++){
			//door that is chosen by contestant and has prize
			if(doors[i].chosenByContestant && doors[i].hasGrandPrize){
				return true;
			}
		}
		return false;
	}
	
	//print out state of each door at that moment (for debugging) 
	void printStateOfDoors() {
		for(int i = 0; i<NUM_OF_DOORS; i++){
			System.out.println("Door "+i+" is " +
		            (doors[i].open ? "    open, " : "not open, ") +
		            (doors[i].hasGrandPrize ? "is     the grand prize, and " : "is not the grand prize, and ") +
		            (doors[i].chosenByContestant ? "is     chosen." : "is not chosen.") );	
		}
		System.out.println();
    }

}
