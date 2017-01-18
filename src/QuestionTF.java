/*
 * Author: Lily Liu
 * Date: Monday, January 9, 2016
 * Description: True or false question class.
 */

public class QuestionTF extends Question {

	/*
	 * ==============================
	 * Variables
	 * ==============================
	 */
	private boolean answer; // correct answer

	/*
	 * ==============================
	 * Constructors
	 * ==============================
	 */

	// constructor for new question
	public QuestionTF(String q) {
		super(q);
		answer = false;
		setQuestionType(1);
	}

	// constructor for existing question
	public QuestionTF(String q, boolean a) {
		super(q);
		answer = a;
		setQuestionType(1);
	}

	// constructor for reading from file
	public QuestionTF(String[] info) {
		/*
		 * example: 1|George Washington is the first POTUS.|true
		 * [0] � type
		 * [1] ��question
		 * [2] � answer
		 */

		super(info[1]);
		answer = java.lang.Boolean.parseBoolean(info[2]);
	}

	/*
	 * ==============================
	 * Functions
	 * ==============================
	 */

	public boolean checkAnswer(boolean a) {
		return answer == a;
	}

	public String toString() {
		// example: 1|George Washington is the first POTUS.|true

		return 1 + "|" + getQuestion() + "|" + answer;
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

	/*
	 * ==============================
	 * Self-Testing Main
	 * ==============================
	 */

	public static void main(String[] args) {
		QuestionTF q = new QuestionTF("Barack Obama is the 44th POTUS.");
		System.out.println("Question: " + q.getQuestion());

		q.setAnswer(true); // correct answer
		System.out.println("\nAnswer: " + q.getAnswer());

		boolean input = true; // user input
		System.out.println("Input: " + input);

		System.out.println("\nIs correct: " + q.checkAnswer(input));
		System.out.println("To string: " + q.toString());
	}

}
