import java.util.ArrayList;

public class QuestionMC extends Question {
	
	private String correctAnswer;
	private ArrayList<String> options;
	private int size;
	private int minSize;
	private int maxSize;
	
	public QuestionMC(String q) {
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
	
	public boolean checkAnswer(String a) {
		boolean isCorrect = false;
		int size = options.size();
		
		for (int i = 0; i < size; i++) {
			if (options.get(i).equals(a)) {
				isCorrect = true;
				break;
			}
		}
		
		return isCorrect;
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
	
	public String getAnswer() {
		return correctAnswer;
	}
	
	public ArrayList<String> getOptions() {
		return options;
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
	
	public void setAnswer(String a) {
		correctAnswer = a;
	}
	
	public void setOptions(ArrayList<String> o) {
		options = o;
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
