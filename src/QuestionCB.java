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
	}
	
	public static void main(String[] args) {
		
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
