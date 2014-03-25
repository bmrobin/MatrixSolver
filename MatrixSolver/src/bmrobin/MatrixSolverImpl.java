package bmrobin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MatrixSolverImpl implements MatrixSolver {
	
	// stores sums of all rows and columns
	private ArrayList<Integer> allSums = new ArrayList<Integer>();
	
	/**
	 * Finds the largest sum of all individual values in rows and columns in the matrix
	 * @param inputMatrix	target matrix to calculate row and column sum for
	 * @return sum		value of largest sum among sum of individual columns and rows
	 */
	public Integer solveMatrix(ArrayList<ArrayList<String>> inputMatrix) {
		int sum = 0;
		int i,j;
		
		ArrayList<String> column = new ArrayList<String>();
		
		for (i=0; i < inputMatrix.size(); i++) {
			
			int rowSum = sumList(inputMatrix.get(i));
			allSums.add(rowSum);
			System.out.println("row" + i + " - " + inputMatrix.get(i).toString() + " = " + rowSum);
			
			for (j=0; j < inputMatrix.get(i).size(); j++) {
				column.add(inputMatrix.get(j).get(i));
			}
			
			int colSum = sumList(column);
			System.out.println("col" + i + " - " + column.toString() + " = " + colSum);
			allSums.add(colSum);
			column.clear();
		}
		
		// find the max sum
		for (int k : allSums) {
			if (k >= sum) {
				sum = k;
			}
		}
		
		return sum;
	}
	
	/**
	 * Loads matrix into ArrayList<ArrayList<String>> from input file
	 * @param filename	name of input file containing matrix data
	 * @return matrix	an ArrayList<ArrayList<String>> representation of the input matrix
	 */
	public ArrayList<ArrayList<String>> loadMatrix(String filename) {
		BufferedReader buffer = null;
		String str = null;
		ArrayList<String> row = null;
		ArrayList<ArrayList<String>> myMatrix = null;
		
		try {
			buffer = new BufferedReader(new FileReader(filename));
			str = buffer.readLine();
			myMatrix = new ArrayList<ArrayList<String>>();
			while (str != null) {
				row = new ArrayList<String>(Arrays.asList(str.split("\\s")));
				myMatrix.add(row);
				str = buffer.readLine();
			}
			buffer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return myMatrix;
	}
	
	/**
	 * Calculates the sum of an ArrayList<String> of integer data 
	 * @param line	an ArrayList<String> representation of integers
	 * @return sum	the integer sum of the input data
	 */
	public Integer sumList(ArrayList<String> line) {
		int sum = 0;
		for (String i : line) {
			sum += Integer.parseInt(i);
		}
		return sum;
	}
	
}
