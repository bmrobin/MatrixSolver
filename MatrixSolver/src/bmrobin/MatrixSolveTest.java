package bmrobin;

import java.util.ArrayList;

public class MatrixSolveTest {
	
	static ArrayList<ArrayList<String>> matrix = null;
	static int sum = 0;
	
	public static void main(String[] args) {
		try {
			String file = new String(args[0]);
			MatrixSolverImpl solve = new MatrixSolverImpl();
			matrix = solve.loadMatrix(file);
			sum = solve.solveMatrix(matrix);
			solve.toString();
			System.out.println("\n" + sum);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("No input file specified. Exiting...");
			System.exit(1);
		}
		
	}
	
}
