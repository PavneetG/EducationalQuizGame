/*
 * Author: Lily Liu
 * Date: Monday, January 9, 2016
 * Description: Generic question class.
 */

public class Question {
	
	private String question;
	private double time;
	
	public Question(String q) {
		question = q;
		time = 0;
	}

	public static void main(String[] args) {
		// self-testing
		Question q = new Question("Is George Washington the first POTUS?");
		System.out.println("Question 1: " + q.getQuestion());
		
		q.setQuestion("Is John Adams the second POTUS?");
		System.out.println("Question 2: " + q.getQuestion());
	}
	
	/*
	 * ==============================
	 * Getters
	 * ==============================
	 */
	
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
		question = q;
	}
	
	public void setTime(double t) {
		time = t;
	}
	
	public String toString(){ // method to change inputed variable to full form and return a string record
		return getQuestion();
	}

}
