
public class QuestionTF extends Question {

	private boolean answer;
	
	public QuestionTF(String q, boolean a) {
		super(q);
		answer = a;
	}

	public static void main(String[] args) {
		// self-testing
		QuestionTF q = new QuestionTF("Barack Obama is the 44th POTUS.", true);
		boolean a = true;
		System.out.println(q.checkAnswer(a));
	}
	
	public boolean checkAnswer(boolean a) {
		return answer == a;
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
