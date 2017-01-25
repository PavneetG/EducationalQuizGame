import java.awt.*;
import javax.swing.*;
/*
 * Author: Janujan Gathieswaran
 * Date: January 24 2017
 * Description: Quiz GUI to play a game with different kinds of questions: multiple choice, true or false and check box. 
 * 				The GUI displays if the answer chosen is correct and displays the correct answer if incorrect. 
 * 
 * Method List:
 * 		Constructors
 * 			QuizGUI(String filename) //default constructor to run GUI
 * 
 * 		Self-Testing Main
 * 			static void main(String[] args) //create an object of the class
 */
public class QuizGUI extends JFrame {

	//--[Variable Declaration]--------
	//create a quiz object
	private Quiz q = new Quiz(); 

	//variable for type of question
	private int type = 0; 

	//label for title of quiz
	private JLabel lblTitle;

	//variable for current seconds passed
	private int currentSeconds = 0;

	//variable for time limit
	private int timeLimit = 20;

	//create object of true or false, multiple choice and check box GUIs
	private QuestionTFGUI tF;
	private QuestionMCGUI mC;
	private QuestionCBGUI cB;

	//variable for size of questions
	private int sizeOfQuestions; 

	//thread to be used as a timer between questions
	private Thread thread = new Thread();

	//----------------------------------

	//constructor with file name as a parameter to run GUI
	public QuizGUI(String fileName) throws InterruptedException {

		setSize(500,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo (null);
		getContentPane().setLayout(null);

		//Reference to set cross platform look in order for Mac UI to look similar to Windows
		//https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		try {
			UIManager.setLookAndFeel(
					UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		//read the quiz from a file 
		q.readFromFile(fileName);

		//create a quiz title label with the quiz name of the quiz object as an argument
		lblTitle = new JLabel(q.getQuizName());
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTitle.setBounds(67, 200, 379, 230);
		getContentPane().add(lblTitle);

		//display the GUI
		setVisible (true);

		//delay of 10 seconds to display the tile of the quiz and picture
		Thread.sleep(10000);

		//set the size of the questions to the size of the questions array of the quiz object
		sizeOfQuestions = q.getQuestions().size();

		//loop through the questions of the quiz
		for (int i = 0; i < sizeOfQuestions; i++) {

			//get the type of question
			type = q.getQuestions().get(i).getType();

			//switch case to check type of question and perform an action accordingly
			switch(type) {

			//true or false question
			case 1: {

				//call the true and false GUI and pass in the particular true or false question
				tF = new QuestionTFGUI ((QuestionTF) q.getQuestions().get(i));

				//hide the window only for the first iteration
				if (i == 0) 
					setVisible(false);

				//reset current seconds to the time limit 
				currentSeconds = timeLimit;

				//loop to count down from specified time limit
				while (currentSeconds > 0)
				{
					//update the progress bar and the timer title to show a count down
					tF.updateProgressBar(timeLimit, currentSeconds);
					tF.setTimerTitle(Integer.toString(currentSeconds));

					//delay of 1 second
					Thread.sleep(1000);

					/*
					 * if the close boolean in true or false GUI is true, move to the next question
					 * move to the next question when an option is selected
					 */
					if (tF.getCloseState()) {
						break;
					}
					//stop counting down when an answer is chosen and the correct answer is being displayed 
					else if (!tF.getCloseState() && tF.isInTimer()) {
					}
					//count down 
					else 
					{
						currentSeconds--;
					}
				}
				//if no button is pressed in the true or false GUI, display the correct answer with a delay of 2 seconds
				if (!tF.getBtnPressed()) {
					tF.viewAnswer();
					Thread.sleep(2000);
				}
				tF.dispose(); 
				break;
			}
			//multiple choice question
			case 2: {
				//call the multiple choice GUI and pass in the particular multiple choice question
				mC = new QuestionMCGUI ((QuestionMC) q.getQuestions().get(i));

				//hide the window only for the first iteration
				if (i == 0) 
					setVisible(false);

				//reset current seconds to the time limit 
				currentSeconds = timeLimit;

				//loop to count down from specified time limit
				while (currentSeconds > 0)
				{
					//update the progress bar and the timer title to show a count down
					mC.updateProgressBar(timeLimit, currentSeconds);
					mC.setTimerTitle(Integer.toString(currentSeconds));

					//delay of 1 second
					Thread.sleep(1000);

					/*
					 * if the close boolean in the multiple choice GUI is true, move to the next question
					 * move to the next question when an option is selected
					 */
					if (mC.getCloseState()) {
						break;
					}
					//stop counting down when an answer is chosen and the correct answer is being displayed 
					else if (!mC.getCloseState() && mC.isInTimer()) {
					}
					else 
					{
						currentSeconds--;//count down 
					}
				}
				//if no button is pressed in the multiple choice GUI, display the correct answer with a delay of 2 seconds
				if (!mC.getBtnPressed()) {
					mC.viewAnswer();
					Thread.sleep(2000);
				}
				mC.dispose(); 
				break;

			}
			//check box question
			case 3: {
				//call the checkbox GUI and pass in the particular checkbox question
				cB = new QuestionCBGUI ((QuestionCB) q.getQuestions().get(i));

				//hide the window only for the first iteration
				if (i == 0) 
					setVisible(false);

				//reset current seconds to the time limit 
				currentSeconds = timeLimit;

				//loop to count down from specified time limit
				while (currentSeconds > 0)
				{
					//update the progress bar and the timer title to show a count down
					cB.updateProgressBar(timeLimit, currentSeconds);
					cB.setTimerTitle(Integer.toString(currentSeconds));

					//delay of 1 second
					Thread.sleep(1000);

					/*
					 * if the close boolean in the check box GUI is true, move to the next question
					 * move to the next question when an option is selected
					 */
					if (cB.getCloseState()) {
						break;
					}
					//stop counting down when an answer is chosen and the correct answer is being displayed 
					else if (!cB.getCloseState() && cB.isInTimer()) {
					}
					else 
					{
						currentSeconds--;//count down 
					}
				}
				//if no button is pressed in the check box GUI, display the correct answer with a delay of 2 seconds
				if (!cB.getBtnPressed()) {
					cB.viewAnswer();
					Thread.sleep(2000);
				}
				cB.dispose(); 
				break;
			}
			}
		}
		//JOptionPane.showMessageDialog(null, "Total Points: " + Data.getPoints());
	}
	//create an object of the quiz GUI and pass in American test file to test if it works
	public static void main(String[] args) throws InterruptedException {
		QuizGUI qGUI = new QuizGUI ("American History.txt");

	}
}
