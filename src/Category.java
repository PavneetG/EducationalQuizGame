/*
 * Name: Pavneet Gill & Lily Liu
 * Date: Monday, January 9, 2017
 * Description: This class separates the quizzes into different categories with the option to add delete and change them.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Category {

	ArrayList<String> list; // titles of quizzes
	String category;
	int size; 
	
	public Category(String c) {
		list = new ArrayList<String>();
		category = c;
		size = 0;
	}
	
	public static void main(String[] args) throws IOException {
		// self-testing
		/*
		Category c = new Category("Science"); // writing
		String title = "Astronomy";
		System.out.println(c.add(title));
		*/
		
		Category c = new Category("History"); // reading
		c.readFromFile(c.getCategory() + ".txt");
		System.out.println(c.getList());
	}
	
	public String add(String title) {
		/*
		while (search(title) > -1) { // duplicate title
			// change title
		}
		*/
		
		list.add(title);
		writeToFile(category + ".txt", title + "\n");
		
		return title;
	}
	
	public boolean change(String title) {
		return true;
	}
	
	public boolean remove(String title) {
		return true;
	}
	
	public boolean readFromFile(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
		    String line = br.readLine();

		    while (line != null) {
		        list.add(line); // add title to list
		        line = br.readLine();
		    }
		    
		    br.close();
		    
		    return true;
		}
		catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
			
			return false;
		}
	}
	
	public boolean writeToFile(String fileName, String contents) {
		try {
		    FileWriter fw = new FileWriter(fileName, true); // true tells to append data
		    BufferedWriter bw = new BufferedWriter(fw);
		    bw.write(contents);
		    bw.close();
		    
		    return true;
		}
		catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
			
			return false;
		}
	}
	
	public int search(String title) {
		for (int i = 0; i < size; i++) {
			if (list.get(i).equals(title)) {
				return i; // found
			}
		}
		
		return -1; // not found
	}
	
	/*
	 * ==============================
	 * Getters
	 * ==============================
	 */
	
	public ArrayList<String> getList() {
		return list;
	}

	public String getCategory() {
		return category;
	}

	public int getSize() {
		return size;
	}
	
	/*
	 * ==============================
	 * Setters
	 * ==============================
	 */

}