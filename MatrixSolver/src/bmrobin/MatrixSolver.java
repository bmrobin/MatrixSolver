package bmrobin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MatrixSolver {

	public static void main(String[] args) {
		loadData("testInput.txt");
	}
	
	
	private static void loadData(String filename) {
		BufferedReader buffer = null;
		String str = null;
		try {
			buffer = new BufferedReader(new FileReader(filename));
			str = buffer.readLine();
			while (str != null) {
				System.out.println(str);
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
	
}
