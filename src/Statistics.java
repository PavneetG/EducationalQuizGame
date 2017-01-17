/*
 * Authors: Lily Liu and Pavneet Gill 
 * Date: Wednesday, December 28, 2016
 * Description: This class keeps track of the player stats. 
 */

import java.util.ArrayList;

public class Statistics {
	
	/*
	 * ==============================
	 * Variables
	 * ==============================
	 */
	
	private int numQuizzes; // total number of quizzes played
	private int numTotal; // total number of questions
	private int numCorrect; // total number of correct questions
	
	private double overallPercentage; 
	private double averageTime; 
	
	private int size; // number of most recent quizzes
	private ArrayList<String> quizHistory; // stores name of most recent quizzes 
	
	/*
	 * ==============================
	 * Constructors
	 * ==============================
	 */

	// constructor for new statistics
	public Statistics() {
		numQuizzes = 0;
		numTotal = 0;
		numCorrect = 0;
		overallPercentage = 0;
		averageTime = 0;
		size = 0;
		quizHistory = new ArrayList<String>();
	}
	
	// constructor for reading from file
	public Statistics(String[] info) {
		/*
		 * example: 3|20|18|90.0|3.5|3|[American History, European History, World History]
		 * [0] Ð numQuizzes
		 * [1] ÐÊnumTotal
		 * [2] Ð numCorrect
		 * [3] ÐÊoverallPercentage
		 * [4] Ð averageTime
		 * [5] ÐÊsize
		 * [6] Ð quizHistory
		 */
		
		numQuizzes = Integer.parseInt(info[0]);
		numTotal = Integer.parseInt(info[1]);
		numCorrect = Integer.parseInt(info[2]);
		overallPercentage = Double.parseDouble(info[3]);
		averageTime = Double.parseDouble(info[4]);
		size = Integer.parseInt(info[5]);
		quizHistory = new ArrayList<String>();
		
		String str = info[6].substring(1, info[6].length() - 1); // remove first and last character
		String[] quizzes = str.split(","); // get array of quizzes
		
		for (int i = 0; i < size; i++) {
			quizHistory.add(quizzes[i]); // add each quiz to array list
		}
	}
	
	/*
	 * ==============================
	 * Functions
	 * ==============================
	 */
	
	public String toString() {
		// example: 3|20|18|90.0|3.5|3|[American History, European History, World History]
		
		String s = numQuizzes + "|" + numTotal + "|" + numCorrect + "|" 
				+ overallPercentage + "|" + averageTime + "|" + size + "|[" + quizHistory.get(0);
		
		for (int i = 1; i < size; i++) {
			s += "," + quizHistory.get(i);
		}
		
		return s += "]";
	}
	
	/*
	 * ==============================
	 * Getters
	 * ==============================
	 */

	public int getNumQuizzes() {
		return numQuizzes;
	}
	
	public int getNumCorrect() {
		return numCorrect;
	}
	
	public int getNumTotal() {
		return numTotal;
	}
	
	public double getOverallPercentage() {
		return overallPercentage;
	}
	
	public double getAverageTime() {
		return averageTime;
	}
	
	public ArrayList<String> getQuizHistory() {
		return quizHistory;
	}
	
	/*
	 * ==============================
	 * Setters
	 * ==============================
	 */
	
	public void setNumQuizzes(int numQuizzes) {
		this.numQuizzes = numQuizzes;
	}

	public void setNumCorrect(int numCorrect) {
		this.numCorrect = numCorrect;
	}
	
	public void setNumTotal(int numTotal) {
		this.numTotal = numTotal;
	}

	public void setOverallPercentage(double overallPercentage) {
		this.overallPercentage = overallPercentage;
	}
	
	public void setAverageTime(double averageTime) {
		this.averageTime = averageTime;
	}

	public void setQuizHistory(ArrayList<String> quizHistory) {
		this.quizHistory = quizHistory;
	}
	
	/*
	 * ==============================
	 * Self-Testing Main
	 * ==============================
	 */
	
	public static void main(String[] args) {
		String str = "3|20|18|90.0|3.5|3|[American History, European History, World History]";
		String[] info = str.split("\\|");
		
		Statistics stats = new Statistics(info);
		System.out.println("Percentage: " + stats.getOverallPercentage() + "%");
		System.out.println("Time: " + stats.getAverageTime() + "s");
	}

}
