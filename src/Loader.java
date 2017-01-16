import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Loader {

	/**
	 * Author: Pavneet Gill
	 * Date: January 15,2016
	 * Description: Loads the information from file
	 * @param args
	 */

	public String [] loadFile (String fileName) throws IOException {

		// open file for reading
		FileReader fr = new FileReader (fileName);
		
		BufferedReader inputFile = new BufferedReader (fr);

		int size = Integer.parseInt(inputFile.readLine()); // Reading length of file

		String fileInfo [] = new String [size]; // declare and create string

		for (int i = 0; i < fileInfo.length; i++) 
		{
			fileInfo[i] = inputFile.readLine(); // Reading lines from file
		}

		inputFile.close();// closing file
		
		return fileInfo;
	}

	public static void main(String[] args)throws IOException {
		//testing =======================================
		String output[];

		//create a LoaderClass object
		Loader loader = new Loader();

		String fileN = JOptionPane.showInputDialog(null, "file", "PhrasesDecrypted.txt"); // displays input dialog for .txt file

		output = loader.loadFile(fileN);

		for (int i = 0; i < output.length; i++) 
		{
			System.out.println(output[i]); // displays the output of phrases
		}
		//==============================================
	}

}

