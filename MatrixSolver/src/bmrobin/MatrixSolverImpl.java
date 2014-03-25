package bmrobin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MatrixSolverImpl implements MatrixSolver {
	
	private ArrayList<Integer> allSums = new ArrayList<Integer>();
	
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
		
		for (int k : allSums) {
			if (k >= sum) {
				sum = k;
			}
		}
		
		return sum;
	}
	
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
	
	public Integer sumList(ArrayList<String> line) {
		int sum = 0;
		for (String i : line) {
			sum += Integer.parseInt(i);
		}
		return sum;
	}
	
}
