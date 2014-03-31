package bmrobin;

import java.util.ArrayList;

public class MatrixSolveTest {
	
	static ArrayList<ArrayList<String>> matrix = null;
	static int sum = 0;
	
	public static void main(String[] args) {
		try {
			String file = new String(args[0]);
			Matrix myMatrix = new Matrix();
			matrix = myMatrix.loadMatrix(file);
			sum = myMatrix.solveMatrix(matrix);
			myMatrix.toString();
			System.out.println("\n" + sum);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("No input file specified. Exiting...");
			System.exit(1);
		}
		
	}
	
}
