/*
 * Author: Lily Liu
 * Date: Monday, January 9, 2016
 * Description: Generic question class.
 */

public class Question {
	
	/*
	 * ==============================
	 * Variables
	 * ==============================
	 */
	
	private String question;
	private double time;
	private int questionType; 
	
	/*
	 * ==============================
	 * Constructors
	 * ==============================
	 */
	
	public Question(String q) {
		this.question = q;
		this.time = 0;
	}

	/*
	 * ==============================
	 * Getters
	 * ==============================
	 */
	
	public int getQuestionType() {
		return questionType;
	}
	public String getQuestion() {
		return question;
	}
	
	public double getTime() {
		return time;
	}
	
	/*
	 * ==============================
	 * Setters
	 * ==============================
	 */
	
	public void setQuestion(String q) {
		this.question = q;
	}
	public void setQuestionType(int questionType) {
		this.questionType =  questionType;
	}
	public void setTime(double t) {
		this.time = t;
	}
	
	public String toString(){ // method to change inputed variable to full form and return a string record
		return getQuestion();
	}

	
	
	
	/*
	 * ==============================
	 * Self-Testing Main
	 * ==============================
	 */
	
	public static void main(String[] args) {
		Question q = new Question("Is George Washington the first POTUS?");
		System.out.println("Question 1: " + q.getQuestion());
		
		q.setQuestion("Is John Adams the second POTUS?");
		System.out.println("Question 2: " + q.getQuestion());
	}

}
