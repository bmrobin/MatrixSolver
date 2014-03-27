package bmrobin;

import java.util.ArrayList;

public interface MatrixSolver {

	public ArrayList<ArrayList<String>> loadMatrix(String filename);
	public Integer solveMatrix(ArrayList<ArrayList<String>> input);
	
}
