/* 
 * Date: Monday, January 9, 2016
 * Author: Janujan Gathieswaran, Kevin Subhash, and Lily Liu
 * Description: The quiz class for creating quizzes, contributing questions and 
 * 				changing previously made quizzes and questions. 
 * Method List:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Quiz {

	// list for questions
	private ArrayList<QuestionTF> questionsTF; // list of true and false questions
	private ArrayList<QuestionMC> questionsMC; // list of multiple choice questions
	private ArrayList<QuestionCB> questionsCB; // list of check box questions
	private ArrayList<Integer> order; // maintain order of questions
	
	// variables for quiz basic information
	private long quizID;
	private String category;
	private String quizName;
	private int size; // number of total questions

	// variables for quiz results
	private int numCorrect;
	private int numWrong;
	private double averageTime;
	
	// constructor for new quiz
	public Quiz(String category, String quizName) {
		this.quizID = generateQuizID();
		this.category = category;
		this.quizName = quizName;
		this.size = 0;
		this.questionsTF = new ArrayList<QuestionTF>();
		this.questionsMC = new ArrayList<QuestionMC>();
		this.questionsCB = new ArrayList<QuestionCB>();
	}
	
	// constructor for existing quiz
	public Quiz(long quizID, String category, String quizName, int size, 
			ArrayList<QuestionTF> questionsTF, 
			ArrayList<QuestionMC> questionsMC, 
			ArrayList<QuestionCB> questionsCB) {
		this.quizID = quizID;
		this.category = category;
		this.quizName = quizName;
		this.size = size;
		this.questionsTF = questionsTF;
		this.questionsMC = questionsMC;
		this.questionsCB = questionsCB;
	}
	
	/*
	 * ==============================
	 * Add Question to Quiz
	 * ==============================
	 */
	
	public void addTF(QuestionTF q) {
		questionsTF.add(q); // add question
		order.add(1); // 1 means true or false question
		size++; // increase size counter
	}
	
	public void addMC(QuestionMC q) {
		questionsMC.add(q); // add question
		order.add(2); // 2 means multiple-choice question
		size++; // increase size counter
	}
	
	public void addCB(QuestionCB q) {
		questionsCB.add(q); // add question
		order.add(3); // 3 means check box question
		size++; // increase size counter
	}
	
	/*
	 * ==============================
	 * Change Question for Quiz
	 * ==============================
	 */
	
	public boolean changeTF(QuestionTF oldQ, QuestionTF newQ) {
		int index = searchTF(oldQ.getQuestion());
		
		if (index > -1) { // previous question found
			questionsTF.set(index, newQ); // replace old question with new question
			return true;
		}
		
		return false;	
	}
	
	public boolean changeMC(QuestionMC oldQ, QuestionMC newQ) {
		int index = searchMC(oldQ.getQuestion());
		
		if (index > -1) { // previous question found
			questionsMC.set(index, newQ); // replace old question with new question
			return true;
		}
		
		return false;	
	}
	
	public boolean changeCB(QuestionCB oldQ, QuestionCB newQ) {
		int index = searchCB(oldQ.getQuestion());
		
		if (index > -1) { // previous question found
			questionsCB.set(index, newQ); // replace old question with new question
			return true;
		}
		
		return false;	
	}
	
	/*
	 * ==============================
	 * Remove Question from Quiz
	 * ==============================
	 */
	
	public boolean removeTF(Question q) {
		int index = searchTF(q.getQuestion());
		
		if (index > -1) { // previous question found
			questionsTF.remove(index); // remove question
			order.remove(index); // remove from order list
			size--; // decrease size counter
			return true;
		}
		
		return false;
	}
	
	public boolean removeMC(Question q) {
		int index = searchMC(q.getQuestion());
		
		if (index > -1) { // previous question found
			questionsMC.remove(index); // remove question
			order.remove(index); // remove from order list
			size--; // decrease size counter
			return true;
		}
		
		return false;
	}
	
	public boolean removeCB(Question q) {
		int index = searchCB(q.getQuestion());
		
		if (index > -1) { // previous question found
			questionsCB.remove(index); // remove question
			order.remove(index); // remove from order list
			size--; // decrease size counter
			return true;
		}
		
		return false;
	}
	
	/*
	 * ==============================
	 * Search Quiz for Question
	 * ==============================
	 */
	
	public int searchTF(String q) {
		int sizeTF = questionsTF.size();
		
		for (int i = 0; i < sizeTF; i++) {
			if (questionsTF.get(i).getQuestion().equals(q)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int searchMC(String q) {
		int sizeMC = questionsMC.size();
		
		for (int i = 0; i < sizeMC; i++) {
			if (questionsMC.get(i).getQuestion().equals(q)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int searchCB(String q) {
		int sizeCB = questionsCB.size();
		
		for (int i = 0; i < sizeCB; i++) {
			if (questionsCB.get(i).getQuestion().equals(q)) {
				return i;
			}
		}
		
		return -1;
	}
	
	/*
	 * ==============================
	 * Other Functions
	 * ==============================
	 */
	
	public boolean changeQuizName(String newQuizName) {
		Category c = new Category(category); // read and load data from file
		c.readFromFile(c.getCategory() + ".txt");
		
		if (c.change(quizName, newQuizName)) { // change quiz name and update category file successful
			// **** update quiz file ****
			this.quizName = newQuizName;
			return true;
		}
		
		return false;
	}
	
	public boolean readFromFile(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			// read and load basic header information
			quizID = Long.parseLong(br.readLine());
			category = br.readLine();
			quizName = br.readLine();
			size = Integer.parseInt(br.readLine());
			
		    String line = br.readLine();
		    
		    while (line != null) {
		    	String[] info = line.split("|");
		    	
		    	switch(Integer.parseInt(info[0])) { // switch based on question type
		    		case 1: // true or false
		    			QuestionTF qTF = new QuestionTF(info);
		    			questionsTF.add(qTF);
		    		case 2: // multiple-choice
		    			QuestionMC qMC = new QuestionMC(info);
		    			questionsMC.add(qMC);
		    		case 3: // check box
		    			QuestionCB qCB = new QuestionCB(info);
		    			questionsCB.add(qCB);
		    		default:
		    			System.err.println("Error: Quiz readFromFile");
		    	}
		    	
		        size++; // increase size
		        line = br.readLine(); // read next line
		    }
		    
		    br.close();
		    
		    return true;
		}
		catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
			
			return false;
		}
	}
	
	public boolean writeToFile(String fileName, String contents, boolean append) {
		try {
		    FileWriter fw = new FileWriter(fileName, append); // true tells to append data
		    BufferedWriter bw = new BufferedWriter(fw);
		    bw.write(contents);
		    bw.close();
		    
		    return true;
		}
		catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
			
			return false;
		}
	}
	
	public long generateQuizID() {
		// http://stackoverflow.com/questions/5392693/java-random-number-with-given-length
		Random r = new Random(); // used to generate random numbers
		return 100000000 + r.nextInt(900000000); // generate random numbers from 100000000 to 999999999

		/*
		 * basic functionality of random
		 * starts from 0 to 5 for rnd.nexInt(6)
		 * to start from 1, 1 must added to the rnd.nextInt(6)
		 *
		 * to count from 100000000 to 999999999
		 * rnd.nextInt(999999999) won't work as it'll generate a number from 0 to 999999998
		 * adding 100000000 + rnd.nextInt(999999999) would yield 100000000 to 1,099,999,998
		 * so instead, subtract 999999999 - 100000000 and add 1 to get correct range
		 */
	}
	
	public String toString() {
		String s = quizID + "\n" + category + "\n" + quizName + "\n" + size + "\n";
		
		for (int i = 0; i < size; i++) {
			
		}
		
		return s;
	}
	
	/*
	 * ==============================
	 * Getters
	 * ==============================
	 */
	
	public ArrayList<QuestionTF> getQuestionsTF() {
		return questionsTF;
	}
	
	public ArrayList<QuestionMC> getQuestionsMC() {
		return questionsMC;
	}
	
	public ArrayList<QuestionCB> getQuestionsCB() {
		return questionsCB;
	}
	
	public long getQuizID() {
		return quizID;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getQuizName() {
		return quizName;
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
	
	/*
	 * ==============================
	 * Setters
	 * ==============================
	 */
	
	public void setQuestionsTF(ArrayList<QuestionTF> questionsTF) {
		this.questionsTF = questionsTF;
	}
	
	public void setQuestionsMC(ArrayList<QuestionMC> questionsMC) {
		this.questionsMC = questionsMC;
	}
	
	public void setQuestionsCB(ArrayList<QuestionCB> questionsCB) {
		this.questionsCB = questionsCB;
	}

	public void setQuizID (long quizID) {
		this.quizID = quizID;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public void setNumCorrect(int numCorrect) {
		this.numCorrect = numCorrect;
	}
	
	public void setNumWrong(int numWrong) {
		this.numWrong = numWrong;
	}
	
	public void setAverageTime(int averageTime) {
		this.averageTime = averageTime;
	}
	
	/*
	 * ==============================
	 * Self-Testing Main
	 * ==============================
	 */

	public static void main(String[] args) {
		Quiz test = new Quiz("Physics", "Kinematics");

		String[] button = {"Add", "Print", "Delete", "Change", "File Input", "Save", "Quit"}; // string array of buttons

		while(true) {
			// asks user some options with buttons
			char command = (char) JOptionPane.showOptionDialog(null,
					"What Would You Like To Do With The Account Records?","Account Records",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, button, button[0]);

			if (button[command].charAt(0) == 'Q'){ // starting switch case for each button
				break;
			}
			switch (button[command].charAt(0)){
				case 'A':{ // inserts customer info manually 
					String q = JOptionPane.showInputDialog(null, "Enter a Question to add","How old is Janujan?");
					QuestionTF questionTF = new QuestionTF(q);
					
					/* if(!test.addQuestionTF(questionTF)){
						System.out.println("Question not Added.");
					} */
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
	
					/* if(!test.remove(question1)){ // performs when record cannot be found
						JOptionPane.showMessageDialog(null, "Record Not Found.");
						break;
					} */
					break;
				}
				case 'C':{ // changes a customer record into another
					String oldRecord = JOptionPane.showInputDialog(null, "Enter Record to Change", "How old is Janujan?"); // prompts user for old account info
					QuestionTF oldInfo = new QuestionTF(oldRecord);
	
					String newRecord = JOptionPane.showInputDialog(null, "Enter Record to Change to", "Is Pavneet a Snake?"); // prompts user for new account info
					QuestionTF newInfo = new QuestionTF(newRecord);
	
					if(test.changeQuestionTF(oldInfo, newInfo)){ // calls method to change the old record to new record
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