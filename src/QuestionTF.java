/*
 * Author: Lily Liu
 * Date: Monday, January 9, 2016
 * Description: True or false question class.
 */

public class QuestionTF extends Question {

	private boolean answer;
	
	public QuestionTF(String q) {
		super(q);
		answer = false;
	}

	public static void main(String[] args) {
		// self-testing
		QuestionTF q = new QuestionTF("Barack Obama is the 44th POTUS.");
		System.out.println("Question: " + q.getQuestion());
		
		q.setAnswer(true); // correct answer
		System.out.println("\nAnswer: " + q.getAnswer());
		
		boolean input = true; // user input
		System.out.println("Input: " + input);
		
		System.out.println("\nIs correct: " + q.checkAnswer(input));
		System.out.println("To string: " + q.toString());
	}
	
	public boolean checkAnswer(boolean a) {
		return answer == a;
	}
	
	public String toString() {
		// example: 1George Washington is the first POTUS.true
		
		return 1 + getQuestion() + answer;
	}
	
	/*
	 * ==============================
	 * Getters
	 * ==============================
	 */

	public boolean getAnswer() {
		return answer;
	}
	
	/*
	 * ==============================
	 * Setters
	 * ==============================
	 */
	
	public void setAnswer(boolean a) {
		answer = a;
	}
	
}
