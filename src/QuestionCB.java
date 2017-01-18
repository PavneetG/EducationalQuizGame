/*
 * Author: Lily Liu
 * Date: Monday, January 9, 2016
 * Description: Checkbox question class.
 */

import java.util.ArrayList;

public class QuestionCB extends Question {
	
	/*
	 * ==============================
	 * Variables
	 * ==============================
	 */
	
	private ArrayList<String> options; // all possible options
	private ArrayList<String> answers; // correct answers
	private int oSize; // number of options
	private int oMinSize; // minimum number of options
	private int oMaxSize; // maximum number of options
	private int aSize; // number of answers
	
	/*
	 * ==============================
	 * Constructors
	 * ==============================
	 */
	
	// constructor for new question
	public QuestionCB(String q) {
		super(q);
		options = new ArrayList<String>();
		answers = new ArrayList<String>();
		oSize = 0;
		oMinSize = 3;
		oMaxSize = 5;
		aSize = 0;
		setQuestionType(3);
	}
	
	// constructor for existing question
	public QuestionCB(String q, ArrayList<String> o, ArrayList<String> a) {
		super(q);
		options = o;
		answers = a;
		oSize = o.size();
		oMinSize = 3;
		oMaxSize = 5;
		aSize = a.size();
		setQuestionType(3);
	}
	
	// constructor for reading from file
	public QuestionCB(String[] info) {
		/*
		 * example: 3|What are the branches of government?|[Executive,Legislative,Judicial,Municipal]|[Executive,Legislative,Judicial]
		 * [0] � type
		 * [1] ��question
		 * [2] � options
		 * [3] ��answers
		 */
				
		super(info[1]);
		options = new ArrayList<String>();
		answers = new ArrayList<String>();
			
		// add options to array list
		String[] option = info[2].substring(1, info[2].length() - 1).split(","); // get array of options
		oSize = option.length;
		
		for (int i = 0; i < oSize; i++) {
			options.add(option[i]); // add each option to array list
		}
		
		// add answers to array list
		String str = info[3].substring(1, info[3].length() - 1); // remove first and last character
		String[] answer = str.split(","); // get array of answers
		aSize = answer.length;
				
		for (int i = 0; i < aSize; i++) {
			answers.add(answer[i]); // add each answer to array list
		}
		setQuestionType(3);
	}
	
	/*
	 * ==============================
	 * Functions
	 * ==============================
	 */
	
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
		// example: 3|What are the branches of government?|[Executive,Legislative,Judicial,Municipal]|[Executive,Legislative,Judicial]
		
		String s = 3 + "|" + getQuestion() + "|[" + options.get(0);
		
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
	
	/*
	 * ==============================
	 * Self-Testing Main
	 * ==============================
	 */
	
	public static void main(String[] args) {
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

}
