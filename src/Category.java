/*
 * Name: Pavneet Gill & Lily Liu
 * Date: Monday, January 9, 2017
 * Description: This class separates the quizzes into different categories with the option to add delete and change them.
 */

import java.io.BufferedWriter;
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
	
	public static void main(String[] args) {
		// self-testing
		Category c = new Category("Science");
		String title = "Astronomy";
		System.out.println(c.add(title));
	}
	
	public String add(String title) {
		/*
		while (search(title) > -1) { // duplicate title
			// change title
		}
		*/
		
		list.add(title);
		writeToFile(category + ".txt", "\n" + title);
		
		return title;
	}
	
	public boolean change(String title) {
		return true;
	}
	
	public boolean remove(String title) {
		return true;
	}
	
	public boolean writeToFile(String fileName, String contents) {
		try {
		    FileWriter fstream = new FileWriter(fileName, true); // true tells to append data
		    BufferedWriter out = new BufferedWriter(fstream);
		    out.write(contents);
		    out.close();
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