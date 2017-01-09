import java.util.ArrayList;

/*
 * Author: Lily Liu
 * Date: Monday, January 9, 2016
 * Description: Checkbox question class.
 */

public class QuestionCB extends Question {
	
	private ArrayList<String> options;
	private ArrayList<String> answers;
	private int size;
	private int minSize;
	private int maxSize;

	public QuestionCB(String q) {
		super(q);
		options = new ArrayList<String>();
		answers = new ArrayList<String>();
		size = 0;
		minSize = 3;
		maxSize = 5;
	}
	
	public static void main(String[] args) {
		// self-testing
		QuestionCB q = new QuestionCB("What are the branches of government?");
		System.out.println(q.getQuestion());
		
		String[] options = {"Executive", "Legislative", "Judicial", "Municipal"};
		int oSize = options.length;
		for (int i = 0; i < oSize; i++) {
			q.addOption(options[i]);
		}
		System.out.println("\nOptions: " + q.getOptions());

		System.out.println("    remove municipal: " + q.removeOption("Municipal"));
		System.out.println("    remove federal: " + q.removeOption("Federal"));
		System.out.println("Options: " + q.getOptions());
		
		q.getAnswers().add("Executive"); // correct answer
		q.getAnswers().add("Legislative");
		q.getAnswers().add("Judicial");
		System.out.println("\nAnswers: " + q.getAnswers());
		
		ArrayList<String> input = new ArrayList<String>(); // user input
		input.add("Executive");
		input.add("Legislative");
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
		
		if (size > minSize) {
			options.remove(o);
			size--;
			isRemoved = true;
		}
		
		return isRemoved;
	}
	
	public boolean checkAnswer(ArrayList<String> a) {
		int numCorrect = 0;
		int aSize = a.size();
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < aSize; j++) {
				if (answers.get(i).equals(a.get(j))) {
					numCorrect++;
					break;
				}
			}
			// break will take you here
		}
		
		return numCorrect == answers.size();
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
	
	public ArrayList<String> getAnswers() {
		return answers;
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
	
	public void setAnswer(ArrayList<String> a) {
		answers = a;
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
