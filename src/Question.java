/*
 * Author: Lily Liu
 * Date: Monday, January 9, 2016
 * Description: Generic Question class.
 */

public class Question {
	
	private String question;
	private double time;
	
	public Question(String q) {
		question = q;
		time = 0;
	}

	public static void main(String[] args) {
		
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

}
