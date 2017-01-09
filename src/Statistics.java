import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Pavneet Gill 
 * Date: December 28 2016
 * Description: This class keeps track of the player stats 
 */
public class Statistics {

	//creating private variables 
	private int numQuizzes, numTotal, numCorrect; 
	
	private double overallPercentage; 
	
	private double averageTime; 
	
	private ArrayList<String> quizRecords = new ArrayList<String>(); 
	
	private String quizName; 
	
	

	public Statistics() {
		// TODO Auto-generated constructor stub
	}

	//getter and setter methods 
	public int getNumQuizzes() 
	{
		return numQuizzes;
	}
	
	public void setNumQuizzes(int numQuizzes) 
	{
		this.numQuizzes = numQuizzes;
	}

	public int getNumCorrect() 
	{
		return numCorrect;
	}

	public void setNumCorrect(int numCorrect) {
		this.numCorrect = numCorrect;
	}
	
	public int getNumTotal() {
		return numTotal;
	}
	
	public void setNumTotal(int numTotal) {
		this.numTotal = numTotal;
	}
	
	public double getOverallPercentage() {
		return overallPercentage;
	}

	public void setOverallPercentage(double overallPercentage) {
		this.overallPercentage = overallPercentage;
	}

	public double getAverageTime() {
		return averageTime;
	}

	public void setAverageTime(double averageTime) {
		this.averageTime = averageTime;
	}

	public String getQuizName() {
		return quizName;
	}


	public void setQuizName(String quizName) 
	{
		this.quizName = quizName;
	}

	public String[] getQuizRecords() 
	{
		return quizRecords;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
