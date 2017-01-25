import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;

/*
 * Author: Kevin, Janujan and Pavneet
 * Date: January 24 2017
 * Description: True or false GUI to display the questions for true or false questions
 * 
 * Method List:
 * 		Constructors
 * 			QuestionTFGUI(QuestionTF questionTF) //default constructor to pass in a true or false object and run GUI
 * 
 * 		Functions
 * 			setTimerTitle (String txt) //method to set the timer title
 * 			void updateProgressBar (int maxValue, int currentValue) //method to update the progress bar by passing 
 * 																	in the maximum value and the value that should be displayed
 * 			public void viewAnswer () //method to display the correct answer
 *
 * 		Getters
 * 			boolean getCloseState ()
 * 			boolean getBtnPressed ()
 * 			boolean isInTimer () 
 * 
 * 		Self-Testing Main
 * 			static void main(String[] args) //create an object of the class
 */

public class QuestionTFGUI extends JFrame implements ActionListener{

	//---[Variable Declaration]------
	//buttons for true and false
	private JButton btnTrue, btnFalse; // private variables for true and false buttons

	//close state boolean to check if window should be closed in Quiz GUI
	private boolean closeState = false; 

	//inTimer boolean to check if timer is performing an action 
	private boolean inTimer = false; 

	//incorrect boolean to check if answer is incorrect
	private boolean incorrect = false; 

	//btnPressed boolean to check if any button is pressed
	private boolean btnPressed = false; 

	//true or false object for global access throughout the program
	private QuestionTF tfQ; // tfQ object created

	//variable for timer
	private Timer timer;

	//label for count down timer and question title
	private JLabel lblTimer, lblTitle;

	//progress bar to show countdown graphically
	private JProgressBar progress;

	//variables for counter limit and delay for swing timer
	private int counter = 2; 
	private int delay = 500; 
	//-----------------------------------

	//default constructor to run GUI
	public QuestionTFGUI(QuestionTF questionTF) throws InterruptedException {
		setSize(500,700);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.tfQ = questionTF; //set the true or false choice object in this GUI to the object passed in 

		//Reference to make a swing timer with a particular action listener
		//http://stackoverflow.com/questions/13503788/confusion-with-the-java-swing-timer
		ActionListener action = new ActionListener()
		{   
			public void actionPerformed(ActionEvent event)
			{
				//set in timer boolean to true
				inTimer = true;

				//if counter is less than 0, check if the answer is incorrect and display the correct answer
				if(counter < 0)
				{
					if (incorrect) {
						viewAnswer();
						timer.start();
						incorrect = false;
					}
					else {
						timer.stop();
						closeState = true; //window should not be closed
						//System.out.println("Done");
					}
				}
				else
				{
					counter--; //count down
					closeState = false; //window should not be closed
					//System.out.println("Hello");
				}
			}
		};
		timer = new Timer(delay, action); //create a new timer with the delay and particular action
		timer.setInitialDelay(0); 

		//Reference for cross platform look
		//https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		try {
			UIManager.setLookAndFeel(
					UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Reference for JProgressBar 
		//https://docs.oracle.com/javase/8/docs/api/javax/swing/JProgressBar.html
		//create progress bar to show count down timer
		progress = new JProgressBar();
		progress.setBounds(150,5,200,30);
		add(progress);

		//create timer label for count down and center text
		lblTimer = new JLabel("");
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setBounds(218, 31, 61, 16);
		getContentPane().add(lblTimer);

		//create question title and center text
		lblTitle = new JLabel(""); 
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Dialog", Font.PLAIN, 23)); // Setting font for title
		lblTitle.setBounds(10, 90, 464, 139); // Setting bounds for title
		lblTitle.setText("<html>" + questionTF.getQuestion() + "</html>"); //set text label to question title and wrap text to fit
		getContentPane().add(lblTitle); // Adding title

		//create true and false buttons
		btnTrue = new JButton("True"); 
		btnTrue.setFont(new Font("Tahoma", Font.PLAIN, 38)); 
		btnTrue.setBounds(57, 298, 374, 94); 
		getContentPane().add(btnTrue); 
		btnTrue.addActionListener(this); 

		btnFalse = new JButton("False"); 
		btnFalse.setFont(new Font("Tahoma", Font.PLAIN, 38)); 
		btnFalse.setBounds(57, 461, 374, 94); 
		getContentPane().add(btnFalse); 
		btnFalse.addActionListener(this); 

		setVisible(true);
	}

	//method to set the timer title
	public void setTimerTitle (String txt) { 
		lblTimer.setText(txt);
	}

	//method to update the progress bar by passing in the maximum value and the value that should be displayed
	public void updateProgressBar (int maxValue, int currentValue) {
		progress.setMaximum(maxValue);
		progress.setValue(currentValue);
	}

	//method to display the correct answer
	public void viewAnswer () {
		if (tfQ.getAnswer()) 
			btnTrue.setBackground(Color.GREEN);
		else 
			btnFalse.setBackground(Color.GREEN);
	} 

	//getters for the close state, button pressed and in timer booleans
	public boolean getCloseState () {
		return closeState;
	}
	public boolean getBtnPressed () {
		return btnPressed;
	}
	public boolean isInTimer () {
		return inTimer;
	}

	//method to check what buttons pressed
	public void actionPerformed(ActionEvent e) {
		//set button pressed boolean to true as action performed was entered
		btnPressed = true;

		//if true button pressed and answer is true, set incorrect to false and make the true button green
		if (e.getSource() == btnTrue) { 
			if(tfQ.checkAnswer(true)){
				//System.out.println("Correct");
				incorrect = false;
				btnTrue.setBackground(Color.GREEN);
				timer.start(); 

				//enhanced if statement (if timer is greater than 20 seconds add 10 points, else 5 points
				//Data.addPoints(Integer.parseInt(lblTimer.getText())>20? 10: 5);
			}
			else{
				//System.out.println("Incorrect");
				//if answer wrong, make the true button red and delay to see chosen answer
				incorrect = true;
				btnTrue.setBackground(Color.RED);
				timer.start();
			}
		}
		if (e.getSource() == btnFalse) {
			//if false button pressed and answer is false, set incorrect to false and make the false button green
			if(tfQ.checkAnswer(false)){
				//System.out.println("Correct");
				incorrect = false;
				btnFalse.setBackground(Color.GREEN);
				timer.start(); 

				//enhanced if statement (if timer is greater than 20 seconds add 10 points, else 5 points
				//Data.addPoints(Integer.parseInt(lblTimer.getText())>20? 10: 5);
			}
			else{
				//if answer wrong, make the false button red and delay to see chosen answer
				//System.out.println("Incorrect");
				incorrect = true;
				btnFalse.setBackground(Color.RED);
				timer.start();
			}
		}

	}
	//self-testing main
	public static void main(String[] args)throws InterruptedException {

		//create a true or false object and pass into GUI object
		QuestionTF tF = new QuestionTF ("Hello", true);
		QuestionTFGUI tfGUI = new QuestionTFGUI(tF);
	}

}
