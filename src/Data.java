import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Janujan
 *
 */
public class Data {

	/**
	 * 
	 */
	public static int points = 0; 

	public static Quiz q = new Quiz("Hello", "Hello");
	public static int questionNum = 0; 
	public static int totalQuestions =0; 
	public static PlayerAccountList accounts = new PlayerAccountList();
	public static String userName;

	public static int getPoints () {
		return points; 
	}
	public static void addPoints (int newPoints) {
		points += newPoints;
		System.out.println(points);
	}
	public Data() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
