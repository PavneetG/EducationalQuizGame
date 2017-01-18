/* 
 * Authors: Janujan Gathieswaran, Kevin Subhash and Lily Liu
 * Date: Monday, January 9, 2016
 * Description: The quiz class for creating quizzes, contributing questions and 
 * 				changing previously made quizzes and questions. 
 * Method List:
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class Quiz {

	/*
	 * ==============================
	 * Variables
	 * ==============================
	 */

	// variables for quiz basic information
	private long quizID;
	private String category;
	private String quizName;
	private int size; // number of total questions
	private ArrayList<Question> questions; // list of questions

	// variables for quiz results
	private int numCorrect;
	private int numWrong;
	private double averageTime;

	/*
	 * ==============================
	 * Constructors
	 * ==============================
	 */

	// constructor for new quiz
	public Quiz(String category, String quizName) {
		this.quizID = generateQuizID();
		this.category = category;
		this.quizName = quizName;
		this.size = 0;
		this.questions = new ArrayList<Question>();
	}

	// constructor for existing quiz
	public Quiz(long quizID, String category, String quizName, int size, ArrayList<Question> questions) {
		this.quizID = quizID;
		this.category = category;
		this.quizName = quizName;
		this.size = size;
	}

	/*
	 * ==============================
	 * Functions
	 * ==============================
	 */

	public void addQuestion(Question q) {
		questions.add(q); // add question
		size++; // increase size counter
	}

<<<<<<< HEAD
	public void addMC(QuestionMC q) {
		questions.add(q); // add question
		
		//		questionsMC.add(q); // add question
		order.add(2); // 2 means multiple-choice question
		size++; // increase size counter
	}

	public void addCB(QuestionCB q) {
		questions.add(q); // add question
		//questionsCB.add(q); // add question
		order.add(3); // 3 means check box question
		size++; // increase size counter
	}

	/*
	 * ==============================
	 * Change Question for Quiz
	 * ==============================
	 */

	public boolean changeTF(String question, QuestionTF newQ) {
		int index = searchTF(question);

		if (index > -1) { // previous question found
			questions.set(index, newQ); // replace old question with new question
			//questionsTF.set(index, newQ); // replace old question with new question
			return true;
		}

		return false;	
	}

	public boolean changeMC(String question, QuestionMC newQ) {
		int index = searchMC(question);

		if (index > -1) { // previous question found
			questions.set(index, newQ); // replace old question with new question
			//questionsMC.set(index, newQ); // replace old question with new question
			return true;
		}

		return false;	
	}

	public boolean changeCB(String question, QuestionCB newQ) {
		int index = searchCB(question);

		if (index > -1) { // previous question found
			questions.set(index, newQ); // replace old question with new question
			//questionsCB.set(index, newQ); // replace old question with new question
			return true;
		}

		return false;	
	}

	/*
	 * ==============================
	 * Remove Question from Quiz
	 * ==============================
	 */

	public boolean removeTF(String question) {
		int index = searchTF(question);

		if (index > -1) { // previous question found
			questions.remove(index);// remove question
			//questionsTF.remove(index); // remove question
			order.remove(index); // remove from order list
			size--; // decrease size counter
			return true;
		}

		return false;
	}

	public boolean removeMC(String question) {
		int index = searchMC(question);
=======
	public boolean removeQuestion(String question) {
		int index = searchQuestion(question);
>>>>>>> origin/master

		if (index > -1) { // previous question found
			questions.remove(index);// remove question
			size--; // decrease size counter
			return true;
		}

		return false;
	}
<<<<<<< HEAD

	public boolean removeCB(String question) {
		int index = searchCB(question);

		if (index > -1) { // previous question found
			questions.remove(index);// remove question
			//questionsCB.remove(index); // remove question
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
		//int sizeTF = questionsTF.size();
		int sizeTF = questions.size();

		for (int i = 0; i < sizeTF; i++) {
			//if (questionsTF.get(i).getQuestion().equals(q)) {
			if (questions.get(i).getQuestion().equals(q)) {
				return i;
			}
		}

		return -1;
	}

	public int searchMC(String q) {
		//int sizeMC = questionsMC.size();
		int sizeMC = questions.size();

		for (int i = 0; i < sizeMC; i++) {
			//if (questionsMC.get(i).getQuestion().equals(q)) {
			if (questions.get(i).getQuestion().equals(q)) {
				return i;
			}
		}

		return -1;
	}

	public int searchCB(String q) {
		//int sizeCB = questionsCB.size();
		int sizeCB = questions.size();

		//Reference for accessing child method and using an array of parent class
		//http://stackoverflow.com/questions/11466441/call-a-child-class-method-from-a-parent-class-object
		//http://stackoverflow.com/questions/26045831/inheritance-in-java-accessing-child-methods-and-using-an-array-of-parent-class
		((QuestionMC)questions.get(2)).checkAnswer("hello");
		
		for (int i = 0; i < sizeCB; i++) {
//			if (questionsCB.get(i).getQuestion().equals(q)) {
=======
	
	public int searchQuestion(String q) {
		for (int i = 0; i < size; i++) {
>>>>>>> origin/master
			if (questions.get(i).getQuestion().equals(q)) {
				return i;
			}
		}

		return -1;
	}

<<<<<<< HEAD
	/*
	 * ==============================
	 * Other Functions
	 * ==============================
	 */
=======
>>>>>>> origin/master
	public boolean changeQuizName(String newQuizName) {
		Category c = new Category(category); // read and load data from file
		c.readFromFile(c.getCategory() + ".txt");

		if (c.change(quizName, newQuizName)) { // change quiz name and update category file successful
			this.quizName = newQuizName;
			return true;
		}
		
		return false;
	}

	public long generateQuizID() {
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
		
		// http://stackoverflow.com/questions/5392693/java-random-number-with-given-length
		Random r = new Random(); // used to generate random numbers
		return 100000000 + r.nextInt(900000000); // generate random numbers from 100000000 to 999999999
	}

	public String toString() {
		String s = quizID + "\n" + category + "\n" + quizName + "\n" + size + "\n";

		for (int i = 0; i < size; i++) {
			s += questions.get(i).toString() + "\n";
		}

		return s;
	}

	/*
	 * ==============================
	 * Reading and Writing
	 * ==============================
	 */

	public boolean readFromFile(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));

			// read and load basic header information
			quizID = Long.parseLong(br.readLine());
			category = br.readLine();
			quizName = br.readLine();
			// size = Integer.parseInt(br.readLine());
			br.readLine(); // discard size

			String line = br.readLine();

			while (line != null) {
				// http://stackoverflow.com/questions/10796160/splitting-a-java-string-by-the-pipe-symbol-using-split
				String[] info = line.split("\\|");

				switch(Integer.parseInt(info[0])) { // switch based on question type
				case 1: // true or false
					QuestionTF qTF = new QuestionTF(info);
					addQuestion(qTF);
					break;

				case 2: // multiple-choice
					QuestionMC qMC = new QuestionMC(info);
					addQuestion(qMC);
					break;

				case 3: // check box
					QuestionCB qCB = new QuestionCB(info);
					addQuestion(qCB);
					break;

				default:
					System.err.println("Error: Quiz readFromFile()");
				}

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

	/*
	 * ==============================
	 * Getters
	 * ==============================
	 */
<<<<<<< HEAD

//	public ArrayList<QuestionTF> getQuestionsTF() {
//		return questionsTF;
//	}
//
//	public ArrayList<QuestionMC> getQuestionsMC() {
//		return questionsMC;
//	}
//
//	public ArrayList<QuestionCB> getQuestionsCB() {
//		return questionsCB;
//	}

	public ArrayList<Question> getQuestions () {
		return questions;
	}
=======
	
>>>>>>> origin/master
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
	
	public ArrayList<Question> getQuestions () {
		return questions;
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

	public void setQuestions (ArrayList<Question> questions) {
		this.questions = questions;
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
		boolean keepGoing = true;
		String[] button = {"Add", "Print", "Delete", "Change", "Load", "Save", "Quit"}; // array of button actions

		Quiz quiz = new Quiz("History", "American History");

		while(keepGoing) {
			// asks user some options with buttons
			int command = JOptionPane.showOptionDialog(null, 
					"What would you like to do with the quiz?","Quiz", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, button, button[0]);

			switch(button[command].charAt(0)) {
			case 'A': { // add
				int typeAdd = Integer.parseInt(JOptionPane.showInputDialog(null, 
						"Type of question: (1 � TF, 2 � MC, 3 � CB)"));

				switch(typeAdd) {
				case 1: // true or false
					// get question
					String questionTF = JOptionPane.showInputDialog(null, 
							"Enter a true or false question to add:");

					// get answer
					boolean answerTF = java.lang.Boolean.parseBoolean(JOptionPane.showInputDialog(null, 
							"Enter the answer: (true or false)"));

					// create question and add to list
					QuestionTF qTF = new QuestionTF(questionTF, answerTF);
					quiz.addQuestion(qTF);
					break;

				case 2: // multiple-choice
					// get question
					String questionMC = JOptionPane.showInputDialog(null, 
							"Enter a multiple-choice question to add:");

					// get options
					int sizeMC = Integer.parseInt(JOptionPane.showInputDialog(null, 
							"Enter the number of options:"));
					ArrayList<String> optionsMC = new ArrayList<String>();
					for (int i = 0; i < sizeMC; i++) {
						String option = JOptionPane.showInputDialog(null, 
								"Enter option #" + (i + 1) + ":");
						optionsMC.add(option);
					}

					// get answer
					String answerMC = JOptionPane.showInputDialog(null, 
							"Enter the answer:");

					// create question and add to list
					QuestionMC qMC = new QuestionMC(questionMC, optionsMC, answerMC);
					quiz.addQuestion(qMC);
					break;

				case 3: // check box
					// get question
					String questionCB = JOptionPane.showInputDialog(null, 
							"Enter a check box question to add:");

					// get options
					int oSizeCB = Integer.parseInt(JOptionPane.showInputDialog(null, 
							"Enter the number of options:"));
					ArrayList<String> optionsCB = new ArrayList<String>();
					for (int i = 0; i < oSizeCB; i++) {
						String option = JOptionPane.showInputDialog(null, 
								"Enter option #" + (i + 1) + ":");
						optionsCB.add(option);
					}

					// get answers
					int aSizeCB = Integer.parseInt(JOptionPane.showInputDialog(null, 
							"Enter the number of answers:"));
					ArrayList<String> answersCB = new ArrayList<String>();
					for (int i = 0; i < aSizeCB; i++) {
						String answer = JOptionPane.showInputDialog(null, 
								"Enter answer #" + (i + 1) + ":");
						answersCB.add(answer);
					}

					// create question and add to list
					QuestionCB qCB = new QuestionCB(questionCB, optionsCB, answersCB);
					quiz.addQuestion(qCB);
					break;

				default:
					System.err.println("Error: Quiz main()");
				}
				break;
			}

			case 'P': // print
				JOptionPane.showMessageDialog(null, quiz.toString());
				break;

			case 'D': // delete
				String question = JOptionPane.showInputDialog(null, 
						"Enter a question to delete:");
				
				if (quiz.removeQuestion(question)) {
					JOptionPane.showMessageDialog(null, "Done");
				}
				else {
					JOptionPane.showMessageDialog(null, "Fail");
				}
				break;

			case 'C': // change
				String oldQuestion = JOptionPane.showInputDialog(null, 
						"Enter a question to change:");
				
				int index = quiz.searchQuestion(oldQuestion);
				if (index > -1) {
					switch(quiz.questions.get(index).getType()) {
					case 1: // true or false
						// get new question
						String questionTF = JOptionPane.showInputDialog(null, 
								"Enter new true or false question:");

						// get answer
						boolean answerTF = java.lang.Boolean.parseBoolean(JOptionPane.showInputDialog(null, 
								"Enter the answer: (true or false)"));

						// create question to replace old question
						QuestionTF qTF = new QuestionTF(questionTF, answerTF);
						quiz.questions.set(index, qTF);
						break;

					case 2: // multiple-choice
						// get new question
						String questionMC = JOptionPane.showInputDialog(null, 
								"Enter new multiple-choice question:");

						// get options
						int sizeMC = Integer.parseInt(JOptionPane.showInputDialog(null, 
								"Enter the number of options:"));
						ArrayList<String> optionsMC = new ArrayList<String>();
						for (int i = 0; i < sizeMC; i++) {
							String option = JOptionPane.showInputDialog(null, 
									"Enter option #" + (i + 1) + ":");
							optionsMC.add(option);
						}

						// get answer
						String answerMC = JOptionPane.showInputDialog(null, 
								"Enter the answer:");

						// create question to replace old question
						QuestionMC qMC = new QuestionMC(questionMC, optionsMC, answerMC);
						quiz.questions.set(index, qMC);
						break;

					case 3: // check box
						// get new question
						String questionCB = JOptionPane.showInputDialog(null, 
								"Enter new check box question:");

						// get options
						int oSizeCB = Integer.parseInt(JOptionPane.showInputDialog(null, 
								"Enter the number of options:"));
						ArrayList<String> optionsCB = new ArrayList<String>();
						for (int i = 0; i < oSizeCB; i++) {
							String option = JOptionPane.showInputDialog(null, 
									"Enter option #" + (i + 1) + ":");
							optionsCB.add(option);
						}

						// get answers
						int aSizeCB = Integer.parseInt(JOptionPane.showInputDialog(null, 
								"Enter the number of answers:"));
						ArrayList<String> answersCB = new ArrayList<String>();
						for (int i = 0; i < aSizeCB; i++) {
							String answer = JOptionPane.showInputDialog(null, 
									"Enter answer #" + (i + 1) + ":");
							answersCB.add(answer);
						}

						// create question to replace old question
						QuestionCB qCB = new QuestionCB(questionCB, optionsCB, answersCB);
						quiz.questions.set(index, qCB);
						break;
	
					default:
						System.err.println("Error: Quiz main()");
					}
				}
				break;

			case 'L': // load
				if (quiz.readFromFile(quiz.quizName + ".txt")) {
					JOptionPane.showMessageDialog(null, "Done");
				}
				else {
					JOptionPane.showMessageDialog(null, "Fail");
				}
				break;

			case 'S': // save
				if (quiz.writeToFile(quiz.quizName + ".txt", quiz.toString(), false)) {
					JOptionPane.showMessageDialog(null, "Done");
				}
				else {
					JOptionPane.showMessageDialog(null, "Fail");
				}
				break;

			case 'Q': // quit
				keepGoing = false; // break out of while loop
				break;

			default:
				System.err.println("Error: Quiz main()");
			}
		}
	}
}