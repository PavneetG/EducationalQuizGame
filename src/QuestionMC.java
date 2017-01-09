/*
 * Author: Lily Liu
 * Date: Monday, January 9, 2016
 * Description: Multiple-choice question class.
 */

import java.util.ArrayList;

public class QuestionMC extends Question {

	private ArrayList<String> options;
	private String answer;
	private int size;
	private int minSize;
	private int maxSize;
	
	public QuestionMC(String q) {
		super(q);
		options = new ArrayList<String>();
		answer = "";
		size = 0;
		minSize = 3;
		maxSize = 5;
	}

	public static void main(String[] args) {
		// self-testing
		QuestionMC q = new QuestionMC("What is the length of term for the POTUS?");
		System.out.println("Question: " + q.getQuestion());
		
		String[] options = {"3 years", "4 years", "5 years", "8 years"};
		int oSize = options.length;
		for (int i = 0; i < oSize; i++) {
			q.addOption(options[i]);
		}
		System.out.println("\nOptions: " + q.getOptions());

		System.out.println("    remove 2 years: " + q.removeOption("2 years"));
		System.out.println("    remove 8 years: " + q.removeOption("8 years"));
		System.out.println("Options: " + q.getOptions());
		
		q.setAnswer("4 years"); // correct answer
		System.out.println("\nAnswer: " + q.getAnswer());
		
		String input = "5 years"; // user input
		System.out.println("Input: " + input);
		
		System.out.println("\nIs correct: " + q.checkAnswer(input));
		System.out.println("To string: " + q.toString());
	}
	
	public boolean addOption(String o) {
		boolean isAdded = false;
		
		if (size < maxSize) {
			options.add(o);
			size++;
			isAdded = true;
		}
		
		return isAdded;
	}
	
	public boolean removeOption(String o) {
		boolean isRemoved = false;
		
		int index = searchOptions(o);
		
		if (index > -1 && size > minSize) {
			options.remove(index);
			size--;
			isRemoved = true;
		}
		
		return isRemoved;
	}
	
	public boolean checkAnswer(String a) {
		return answer == a;
	}
	
	public int searchOptions(String o) {
		int index = -1;
		
		for (int i = 0; i < size; i++) {
			if (options.get(i).equals(o)) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	public String toString() {
		String s = "";
		
		// **** define format ****
		
		return s;
	}
	
	/*
	 * ==============================
	 * Getters
	 * ==============================
	 */
	
	public ArrayList<String> getOptions() {
		return options;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getMinSize() {
		return minSize;
	}
	
	public int getMaxSize() {
		return maxSize;
	}
	
	/*
	 * ==============================
	 * Setters
	 * ==============================
	 */
	
	public void setOptions(ArrayList<String> o) {
		options = o;
	}
	
	public void setAnswer(String a) {
		answer = a;
	}
	
	public void setSize(int s) {
		size = s;
	}
	
	public void setMinSize(int s) {
		minSize = s;
	}
	
	public void setMaxSize(int s) {
		maxSize = s;
	}

}
