import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

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
	private int size, maxSize=100, minSize = 2, numCorrect, numWrong;

	//variable for the average time taken on questions
	private double averageTime; 

	//variables for category name, quiz name, record
	private String category, quizName, record;

	private long quizID;

	//default constructor
	public Quiz () {
		generateQuizID();
		category = "";
		quizName = "";
		//		this (0,"", ""); //call overloaded constructor
	}
	public Quiz (String category, String quizName ) {
		generateQuizID();
		this.category = category;
		this.quizName = quizName;
	}
	//overloaded constructor
	public Quiz (long quizID, String category, String quizName) {
		this.quizID = quizID;
		this.category = category;
		this.quizName = quizName;

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
		return false;
	}
	public int search (String searchType, String searchKey) {
		for (int i = 0; i<size; i++) {
			if (questions.get(i).equals(searchKey)) {
				return i;
			}
		}
		return -1;
	}
	//public String createRecord () {

	//}
	public void saveRecord (String file) throws IOException {
		FileOutputStream file2 = new FileOutputStream (file); // writes to inputed file name (by user)
		PrintWriter output = new PrintWriter (file2);

		for (int i = 0; i < size; i++) { // Reads each line of the text file and stores it in arrays
			output.println(questions.get(i));
		}

		file2.close (); // Closes file2
	}

	//setter methods
	public void setQuizID (long quizID) {
		this.quizID = quizID;
	}



	//method to generate account number
	public void generateQuizID (){
		//Reference to generate random 9 digit numbers
		//http://stackoverflow.com/questions/5392693/java-random-number-with-given-length
		Random rnd = new Random(); //used to generate random numbers

		//generate random numbers from 100000000 to 999999999
		this.quizID = 100000000 + rnd.nextInt(900000000);

		/*basic functionality of random
		 * starts from 0 to 5 for rnd.nexInt(6)
		 * to start from 1, 1 must added to the rnd.nextInt(6)
		 * */

		/*to count from 100000000 to 999999999
		 * rnd.nextInt(999999999) won't work as it'll generate a number from 0 to 999999998
		 * adding 100000000 + rnd.nextInt(999999999) would yield 100000000 to 1,099,999,998
		 * so instead, subtract 999999999 - 100000000 and add 1 to get correct range*/
		//System.out.println(accountNum); //debug point for account number
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
	public long getQuizID() {
		return quizID;
	}


	//self-testing main
	public static void main (String [] args) {
		Quiz test = new Quiz("Physics","Kinematics");

		String[] button = {"Add","Print","Delete","Change","File Input","Save","Quit"}; // string array of buttons

		while(true){

			char command = (char) JOptionPane.showOptionDialog(null, "What Would You Like To Do With The Account Records?","Account Records",
					JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,button,button[0]);// Asks user some options with buttons

			if(button[command].charAt(0) == 'Q'){ // starting switch case for each button
				break;
			}
			switch (button[command].charAt(0)){
			case 'A':{ // inserts customer info manually 
				String q = JOptionPane.showInputDialog(null, "Enter a Question to add","How old is Janujan?");
				Question question1 = new Question(q);

				if(!test.add(question1)){
					System.out.println("Question not Added.");
				}
				break;
			}
			case 'P':{ // prints all records
				for (int i = 0; i < test.getSize(); i++) { // loops until all record are printed
					System.out.println("Record #" + (i+1) + " " + test.getQuestions().get(i));
				}
				break;
			}
			case 'D':{ // deletes a customer record

				String record = JOptionPane.showInputDialog(null,"Enter <question> to remove", //prompt user for account info to delete
						"How old is Janujan?");
				Question question1 = new Question(record);

				if(!test.remove(question1)){ // performs when record cannot be found
					JOptionPane.showMessageDialog(null, "Record Not Found.");
					break;
				}
				break;
			}
			case 'C':{ // changes a customer record into another
				String oldRecord = JOptionPane.showInputDialog(null, "Enter Record to Change", "How old is Janujan?"); // prompts user for old account info
				Question oldInfo = new Question(oldRecord);

				String newRecord = JOptionPane.showInputDialog(null, "Enter Record to Change to", "Is Pavneet a Snake?"); // prompts user for new account info
				Question newInfo = new Question(newRecord);

				if(test.change(oldInfo, newInfo)){ // calls method to change the old record to new record
					JOptionPane.showMessageDialog(null,"Success");
				}
				else{
					JOptionPane.showMessageDialog(null, "Fail");
					break;
				}
				break;
			}

			}

		}
	}
}