package bmrobin;

import java.util.ArrayList;

public abstract class Matrix {

	public ArrayList<ArrayList<String>> matrix;
	private String filename;
	
	public abstract ArrayList<ArrayList<String>> loadMatrix(String filename);
	public abstract Integer solveMatrix(ArrayList<ArrayList<String>> input);
	
	public Matrix() {
		filename = null;
		matrix = new ArrayList<ArrayList<String>>();
	}
	public Matrix(String file) {
		this.filename = file;
		matrix = new ArrayList<ArrayList<String>>();
	}
	
	public void setFilename(String file) {
		this.filename = file;
	}
	
	public String toString() {
		
		
		return null;
	}
	
}
