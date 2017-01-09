import java.util.ArrayList;

/* 
 * Date: January 9 2016
 * Author: Janujan Gathieswaran
 * Description: The quiz class for creating quizzes, contributing questions and 
 * 				changing previously made quizzes and questions. 
 * Method List: 
 */

public class Quiz {

	//array list of questions
	private ArrayList<Question> questions = new ArrayList<Question>();

	//variables for max size, number of questins correct and wrong
	private int maxSize, numCorrect, numWrong;

	//variable for the average time taken on questions
	private double averageTime; 

	//variables for category name, quiz name, record and and quiz ID
	private String category, quizName, record, quizID;


	public boolean add (Question question) {
		if (questions.size() > maxSize) {
			return false;
		}
		else {
			questions.add(question);
			return true;
		}
	}
	public boolean change (Question question) {

	}
	public boolean remove (Question question) {

	}
	public boolean changeQuizName (String name) {

	}
	public Question search (String searchType, String searchKey) {

	}
	public String createRecord () {

	}
	public void saveRecord () {
		
	}
	
	
	//getter methods 
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	public int getSize() {
		return size;
	}
	public int getNumCorrect() {
		return numCorrect;
	}
	public int getNumWrong() {
		return numWrong;
	}
	public double getAverageTime() {
		return averageTime;
	}
	public String getCategory() {
		return category;
	}
	public String getQuizName() {
		return quizName;
	}
	public String getRecord() {
		return record;
	}
	public String getQuizID() {
		return quizID;
	}
	
	
	//self-testing main
	public static void main (String [] args) {

	}
	
}
