/*
 * Author: Lily Liu
 * Date: Monday, January 9, 2016
 * Description: Multiple-choice question class.
 */

import java.util.ArrayList;

public class QuestionMC extends Question {
	
	/*
	 * ==============================
	 * Variables
	 * ==============================
	 */

	private ArrayList<String> options; // all possible options
	private String answer; // correct answer
	private int size; // number of options
	private int minSize; // minimum number of options
	private int maxSize; // maximum number of options
	
	/*
	 * ==============================
	 * Constructors
	 * ==============================
	 */
	
	// constructor for new question
	public QuestionMC(String q) {
		super(q);
		options = new ArrayList<String>();
		answer = "";
		size = 0;
		minSize = 3;
		maxSize = 5;
	}
	
	// constructor for existing question
	public QuestionMC(String q, ArrayList<String> o, String a) {
		super(q);
		options = o;
		answer = a;
		size = o.size();
		minSize = 3;
		maxSize = 5;
	}
	
	// constructor for reading from file
	public QuestionMC(String[] info) {
		/*
		 * example: 2|In what year was the Declaration of Independence signed?|[1776,1789,1800]|1776
		 * [0] Ð type
		 * [1] ÐÊquestion
		 * [2] Ð options
		 * [3] ÐÊanswer
		 */
			
		super(info[1]);
		options = new ArrayList<String>();
		answer = info[3];
		
		// add options to array list
		String[] option = info[2].substring(1, info[2].length() - 1).split(","); // get array of options
		int length = option.length;
		
		for (int i = 0; i < length; i++) {
			options.add(option[i]); // add each option to array list
		}
	}
	
	/*
	 * ==============================
	 * Functions
	 * ==============================
	 */
	
	public boolean addOption(String o) {
		if (size < maxSize) {
			options.add(o);
			size++;
			return true;
		}
		
		return false;
	}
	
	public boolean removeOption(String o) {
		int index = searchOptions(o);
		
		if (index > -1 && size > minSize) {
			options.remove(index);
			size--;
			return true;
		}
		
		return false;
	}
	
	public boolean checkAnswer(String a) {
		return answer == a;
	}
	
	public int searchOptions(String o) {
		for (int i = 0; i < size; i++) {
			if (options.get(i).equals(o)) {
				return i; // found
			}
		}
		
		return -1; // not found
	}
	
	public String toString() {
		// example: 2|In what year was the Declaration of Independence signed?|[1776,1789,1800]|1776
		
		String s = 2 + getQuestion() + "[" + options.get(0);
		
		for (int i = 1; i < size; i++) {
			s += "," + options.get(i);
		}
		
		return s += "]|" + answer;
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
	
	/*
	 * ==============================
	 * Self-Testing Main
	 * ==============================
	 */
	
	public static void main(String[] args) {
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

}
