/*
 * Filename: TwoWayTable.java
 * Programmer: Karinya Makaew (kmakaew@andrew.cmu.edu)
 * Course: 95-712
 * Assignment: Homework 3 Question 3 
 * Deadline: 06/12/2012
 * Description: Hold and print a 2-D array of integers
 */

public class TwoWayTable {
	int numRows;
	int numCols;
	int[][] cell;
	int[] rowSum;
	int[] colSum;
	int grandTotal;
	String twoWayTableString;
    
	// constructor
	TwoWayTable(int[][] data){
		//prepare the variables numRows, numCols, rowSum, colSum, grandtotal, and twoWayTableString
		numRows = data.length;
		numCols = data[0].length;
		rowSum = new int[numRows];    	
		for(int index = 0; index < numRows; index++){
			rowSum[index] = 0;	
		}
		colSum = new int[numCols]; 	
		for(int index = 0; index < numCols; index++){
			colSum[index] = 0;    	
		}
		grandTotal = 0;
		twoWayTableString = null;
    	
		//prepare data for the array 
		cell = new int[numRows][];
		for(int row = 0; row < numRows; row++){
			cell[row] = new int[numCols];
			for(int column = 0; column < numCols; column++){
				cell[row][column] = data[row][column];
			}
		}
		setMargins();
	}
	
	//set sum of rows, column, and all elements in the array
	void setMargins() {
		// compute the row sums;
		for(int row = 0; row < numRows; row++){
			for(int column = 0; column < numCols; column++){
				rowSum[row] += cell[row][column];
				colSum[column] += cell[row][column];
			}
			grandTotal += rowSum[row];
		}
    	
	}
    
    
	//print out values inside the 2-D array into a table
	public String toString() {		
		//width of each cell in 2-D array
		//set distance between 2 numbers to at least 3
		int valueWidth = Integer.toString(grandTotal).length() + 3;
		String cellPattern = "%" + valueWidth + "s";

		//string of the 2-D array with sum of rows, columns, and grand total
		StringBuilder printOut = new StringBuilder();
    	
		//------------------------ Add value in cell and sum of each row --------------------
		for(int row = 0; row < numRows; row++){
			for(int column = 0; column < numCols; column++){
				//add value of each column into the string
				printOut.append(String.format(cellPattern, cell[row][column]));  
			}
			//add sum of each row at the end of each line
			printOut.append("|" + String.format(cellPattern, rowSum[row])  + "\n");
		}
   
		//---------- Add "-" line to separate between array value and sum of each column---------
		//number of "-" is number of total columns and sum column, time value width, and plus 1 for "|" char
		String linePattern = "%" + ((numCols + 1) * valueWidth +1 )+ "s";
		String temp = String.format(linePattern, "-").replace(' ', '-') + "\n";	
		printOut.append(temp );
    	
		//---------------------------- Add value sum of each column -------------------------
		for(int column = 0; column < numCols; column++){
			printOut.append(String.format(cellPattern, colSum[column]));    	
		}
    	
		//---------------------------- Add value sum of grand total -------------------------
		printOut.append("|" + String.format(cellPattern, grandTotal) + "\n");
		return printOut.toString();
	}
}
