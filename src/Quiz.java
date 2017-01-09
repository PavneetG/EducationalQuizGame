import java.util.ArrayList;

/* 
 * Date: January 9 2016
 * Author: Janujan Gathieswaran and Kevin Subhash
 * Description: The quiz class for creating quizzes, contributing questions and 
 * 				changing previously made quizzes and questions. 
 * Method List: 
 * 
 */

public class Quiz {

	//array list of questions
	private ArrayList<Question> questions = new ArrayList<Question>();

	//variables for size, max size, min size, number of questions correct and wrong
	private int size, maxSize, minSize = 2, numCorrect, numWrong;

	//variable for the average time taken on questions
	private double averageTime; 

	//variables for category name, quiz name, record and, and quiz ID 
	private String category, quizName, record, quizID;

	//default constructor
	public Quiz () {
//		quizID = "";
//		category = "";
//		quizName = "";
		this ("", "", ""); //call overloaded constructor
	}
	public Quiz (String quizName) {
		this ("", "", quizName);
	}
	//overloaded constructor
	public Quiz (String quizID, String category, String quizName) {
//		this.quizID = quizID;
//		this.category = category;
//		this.quizName = quizName;
		
		setQuizID (quizID);
		setCategory(category);
		changeQuizName(quizName);
	}


	public boolean add (Question newQuestion) {
		if (size < maxSize) {
			questions.add(newQuestion);
			size++;
			return true;
		}
		return false;
	}
	public boolean change (Question oldQuestion, Question newQuestion) {
		if (questions.contains(oldQuestion))
		{
			questions.set(questions.indexOf(oldQuestion), newQuestion);
			return true;
		}
		return false;	
	}
	public boolean remove (Question question) {
		//		if (questions.contains(question)) {
		if (size < minSize) {
			questions.remove(question);
			size--;
			return true;
		}
		return false;
	}
	public boolean changeQuizName (String newQuizName) {
		this.quizName = newQuizName;
		//need to store the quiz names onto file and check if quiz name already exists
	}
	public int search (String searchType, String searchKey) {
		for (int i = 0; i<size; i++) {
			if (questions.get(i).equals(searchKey)) {
				return i;
			}
		}
		return -1;
	}
	public String createRecord () {

	}
	public void saveRecord () {

	}

	//setter methods
	public void setQuizID (String quizID) {
		this.quizID = quizID;
	}
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	//getter methods 
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	public int maxSize() {
		return maxSize;
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
