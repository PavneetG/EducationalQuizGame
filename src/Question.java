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
	
	/*
	 * Types:
	 * 0 = undefined type
	 * 1 = true or false question
	 * 2 = multiple-choice question
	 * 3 = check box question
	 */
	
	private int type;
	private String question;
	private double time;
	private int questionType; 
	
	/*
	 * ==============================
	 * Constructors
	 * ==============================
	 */
	
<<<<<<< HEAD
	public Question(String q) {
		this.question = q;
		this.time = 0;
=======
	public Question(String q, int t) {
		type = t;
		question = q;
		time = 0;
>>>>>>> origin/master
	}

	/*
	 * ==============================
	 * Getters
	 * ==============================
	 */
	
<<<<<<< HEAD
	public int getQuestionType() {
		return questionType;
	}
=======
	public int getType() {
		return type;
	}
	
>>>>>>> origin/master
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
	
	public void setType(int t) {
		type = t;
	}
	
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
		Question q = new Question("Is George Washington the first POTUS?", 0);
		System.out.println("Question 1: " + q.getQuestion());
		
		q.setQuestion("Is John Adams the second POTUS?");
		System.out.println("Question 2: " + q.getQuestion());
	}

}
