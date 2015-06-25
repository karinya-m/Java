/*
 * Filename: TestTwoWayTable.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 3 Question 3 
 * Deadline: 06/12/2012
 * Description: Test TwoWayTable class
 * 
 */

public class TestTwoWayTable {
	public static void main(String[] args) {
		int[][] testArray = {
				{2, 5, 6, 3}, {9, 4, 4, 7}, 
				{1, 10, 2, 3}, {8, 4, 5, 3} };

		TwoWayTable t = new TwoWayTable(testArray);        
		System.out.println(t);
		}
	}
