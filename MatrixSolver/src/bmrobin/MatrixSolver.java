package bmrobin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MatrixSolver {
	
	public static void main(String[] args) {
		try {
			String file = new String(args[0]);
			solveMatrix(file);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("No input file specified. Exiting...");
			System.exit(1);
		}	
	}
	
	private static void solveMatrix(String filename) {
		
		BufferedReader buffer = null;
		String str = null;
		String[] row = null;
		String[] column = null;
		
		try {
			buffer = new BufferedReader(new FileReader(filename));
			str = buffer.readLine();
			while (str != null) {
				row = str.split("\\s");
				sum(row);
				
				
				
				str = buffer.readLine();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void sum(String[] line) {
		int sum = 0;
		for (String i : line) {
			sum += Integer.parseInt(i);
		}

		System.out.println(sum);
	}
	
}
