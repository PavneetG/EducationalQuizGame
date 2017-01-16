/*
 * Author: Lily Liu
 * Date: Monday, January 9, 2016
 * Description: Checkbox question class.
 */

import java.util.ArrayList;

public class QuestionCB extends Question {
	
	private ArrayList<String> options;
	private ArrayList<String> answers;
	private int oSize; // options
	private int oMinSize;
	private int oMaxSize;
	private int aSize; // answers

	public QuestionCB(String q) {
		super(q);
		options = new ArrayList<String>();
		answers = new ArrayList<String>();
		oSize = 0;
		oMinSize = 3;
		oMaxSize = 5;
		aSize = 0;
	}
	
	public static void main(String[] args) {
		// self-testing
		QuestionCB q = new QuestionCB("What are the branches of government?");
		System.out.println(q.getQuestion());
		
		// add options
		String[] options = {"Executive", "Legislative", "Judicial", "Municipal"};
		int oSize = options.length;
		for (int i = 0; i < oSize; i++) {
			q.addOption(options[i]);
		}
		System.out.println("\nOptions: " + q.getOptions());
		
		/*
		// remove option
		System.out.println("    remove municipal: " + q.removeOption("Municipal"));
		System.out.println("    remove federal: " + q.removeOption("Federal"));
		System.out.println("Options: " + q.getOptions());
		*/
		
		// add answers
		String[] answers = {"Executive", "Legislative", "Judicial"};
		int aSize = answers.length;
		for (int i = 0; i < aSize; i++) {
			q.addAnswer(answers[i]);
		}
		System.out.println("\nAnswers: " + q.getAnswers());
		
		// user input
		ArrayList<String> input = new ArrayList<String>();
		input.add("Executive");
		input.add("Legislative");
		input.add("Judicial");
		System.out.println("Input: " + input);
		
		System.out.println("\nIs correct: " + q.checkAnswer(input));
		System.out.println("To string: " + q.toString());
	}
	
	public boolean addOption(String o) {
		if (oSize < oMaxSize) {
			options.add(o);
			oSize++;
			return true;
		}
		
		return false;
	}
	
	public boolean removeOption(String o) {
		if (oSize > oMinSize) {
			options.remove(o);
			oSize--;
			return true;
		}
		
		return false;
	}
	
	public boolean addAnswer(String a) {
		if (aSize < oMaxSize) {
			answers.add(a);
			aSize++;
			return true;
		}
		
		return false;
	}
	
	public boolean checkAnswer(ArrayList<String> input) {
		int numCorrect = 0;
		int size = input.size();
		
		for (int i = 0; i < aSize; i++) {
			for (int j = 0; j < size; j++) {
				if (answers.get(i).equals(input.get(j))) {
					numCorrect++;
					break;
				}
			}
			// break will take you here
		}
		
		return numCorrect == answers.size();
	}
	
	public String toString() {
		// example: 3What are the branches of government?[Executive,Legislative,Judicial,Municipal]|[Executive,Legislative,Judicial]
		
		String s = 3 + getQuestion() + "[" + options.get(0);
		
		for (int i = 1; i < oSize; i++) {
			s += "," + options.get(i);
		}
		
		s += "]|[" + answers.get(0);
		
		for (int i = 1; i < aSize; i++) {
			s += "," + answers.get(i);
		}
		
		return s += "]";
	}
	
	/*
	 * ==============================
	 * Getters
	 * ==============================
	 */
	
	public ArrayList<String> getOptions() {
		return options;
	}
	
	public ArrayList<String> getAnswers() {
		return answers;
	}
	
	public int getOSize() {
		return oSize;
	}
	
	public int getOMinSize() {
		return oMinSize;
	}
	
	public int getOMaxSize() {
		return oMaxSize;
	}
	
	/*
	 * ==============================
	 * Setters
	 * ==============================
	 */
	
	public void setOptions(ArrayList<String> o) {
		options = o;
	}
	
	public void setAnswer(ArrayList<String> a) {
		answers = a;
	}
	
	public void setOSize(int s) {
		oSize = s;
	}
	
	public void setMinSize(int s) {
		oMinSize = s;
	}
	
	public void setMaxSize(int s) {
		oMaxSize = s;
	}

}
