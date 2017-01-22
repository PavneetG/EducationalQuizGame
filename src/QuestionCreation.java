// Name: Pavneet Gill 
// Data: 2017-01-22
// Description: This program creates the question for the quiz 


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class QuestionCreation extends JFrame implements ActionListener {

	//creating private variables for buttons, options, textfields and array lists 
	private JPanel contentPane; 
	
	private JRadioButton trueButton = new JRadioButton ("true");
	
	private JRadioButton falseButton = new JRadioButton ("false");
	
	private JLabel lblOptions = new JLabel("Options");
	
	private JLabel lblAnswer = new JLabel("Answer");
	
	private Border blackline = BorderFactory.createLineBorder(Color.BLACK); 
	
	private Border redline = BorderFactory.createLineBorder(Color.RED,10); 
	
	private JTextField textField= new JTextField();
	private JTextField textField_1= new JTextField();;
	private JTextField textField_2= new JTextField();
	private JTextField textField_3=new JTextField();
	
	private JCheckBox checkBox = new JCheckBox("");
	private JCheckBox checkBox_1 = new JCheckBox("");
	private JCheckBox checkBox_2 = new JCheckBox("");
	private JCheckBox checkBox_3 = new JCheckBox("");
	
	private JTextArea textArea = new JTextArea();
	
	private String correctAnswer; 
	
	private String [] optionsAnswer = new String [4]; 
	
	private JButton btnPrevious = new JButton("Previous");
	
	private JButton btnNext = new JButton("Next");
	
	private String question; 
	
	private JScrollPane scrollBar;
	
	private String selectedItem;
	
	private int questionType = 0;
	
	private int size = 10;
	
	private String questionTitle;
	
	private String answer;
	
    private ArrayList<String> optionslist = new ArrayList<String>();
	
	private ArrayList<String> answersCB;
	
	private String boxOptions [] = {"Select", "True or False", "Multiple Choice", "Check Box", "Ranking"}; 
	
	private JComboBox comboBox= new JComboBox(boxOptions);
	
	private int type = 0;
	
	private JLabel lblQuestionType = new JLabel("Question Type");


	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public QuestionCreation() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize (500,700);
		
		setLayout(null);

		lblQuestionType.setBounds(30, 178, 86, 20);
		add(lblQuestionType); 
		
		//adding and setting location of combobox
		comboBox.setBounds(126, 178, 112, 20);
		comboBox.setActionCommand("hello");
		comboBox.addActionListener(this);
		comboBox.setSelectedIndex (0);
		add(comboBox);

		//setting  location of lbl answer and lbloption and btnNext and btn previous
		lblAnswer.setBounds(30, 238, 47, 20);
		lblOptions.setBounds(31, 209, 86, 20);
		btnNext.setBounds(241, 382, 89, 23);
		btnPrevious.setBounds(126, 382, 89, 23);

		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setOpaque(false);
		textArea.setText("Untitled Question");

		scrollBar = new JScrollPane(textArea);

		scrollBar.setVerticalScrollBarPolicy( JScrollPane. VERTICAL_SCROLLBAR_ALWAYS); 
		scrollBar.setBorder(blackline);

		scrollBar.setBounds(22, 81, 437, 64);
		
		//adding things to frame 
		add(lblOptions);
		
		add(scrollBar);
		
		add (trueButton); 
		
		add(lblAnswer);

		add (falseButton);

		add(textField);

		add(textField_1);

		add(textField_2);

		add(textField_3);

		add(checkBox);

	    add(checkBox_1);

		add(checkBox_2);

		add(checkBox_3);
		
		add(btnNext);

		//adding action listener to combox and check boxes and button next and previous 
		checkBox.addActionListener(this);
		checkBox_1.addActionListener (this); 
		checkBox_2.addActionListener(this);
		checkBox_3.addActionListener(this);
		trueButton.addActionListener(this);
		falseButton.addActionListener(this);
		btnNext.addActionListener(this);
		btnPrevious.addActionListener(this);

		getContentPane().add(btnPrevious);
		setLocationRelativeTo (null);
		setVisible (true); 
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("hello"))
		{
			selectedItem = (String) comboBox.getSelectedItem();//getting selected item on combox box 

			//switching depending on selection item
			switch (selectedItem)
			{
			case "True or False":
			{
				questionType = 1; //setting question Type
				
				//setting bounds of new items or moving old items off screen 
				lblOptions.setBounds(1000,1000,1000,1000);

				lblAnswer.setBounds(31, 209, 86, 20);

				trueButton.setBounds(126, 208, 50, 23);

				falseButton.setBounds (178, 208, 60, 23);

				textField.setBounds(0,0,0,0);

				textField_1.setBounds(0,0,0,0);

				textField_2.setBounds(0,0,0,0);

				textField_3.setBounds(0,0,0,0);

				checkBox.setBounds(0,0,0,0);

				checkBox_1.setBounds(0,0,0,0);

				checkBox_2.setBounds(0,0,0,0);

				checkBox_3.setBounds(0,0,0,0);

				break; 
			}
			case "Multiple Choice":
			{
				questionType = 2; 

				//setting bounds of new items or moving old items off screen 
				checkBox.setBounds(324, 206, 26, 23);

				checkBox_1.setBounds(324, 244, 26, 23);

				checkBox_2.setBounds(324, 287, 26, 23);

				checkBox_3.setBounds(324, 333, 26, 23);

				lblAnswer.setBounds(324, 188, 47, 20);

				lblOptions.setBounds(31, 209, 86, 20);

				textField.setBounds(126, 209, 186, 20);

				textField_1.setBounds(126, 250, 186, 20);

				textField_2.setBounds(126, 295, 186, 20);

				textField_3.setBounds(126, 340, 186, 20);

				trueButton.setBounds(0,0,0,0);

				falseButton.setBounds (0,0,0,0);

				break; 
			}
			case "Check Box": {
				questionType = 3;
				
				//setting bounds of new items or moving old items off screen 
				checkBox.setBounds(324, 206, 26, 23);

				checkBox_1.setBounds(324, 244, 26, 23);

				checkBox_2.setBounds(324, 287, 26, 23);

				checkBox_3.setBounds(324, 333, 26, 23);

				lblAnswer.setBounds(324, 188, 47, 20);

				lblOptions.setBounds(31, 209, 86, 20);

				textField.setBounds(126, 209, 186, 20);

				textField_1.setBounds(126, 250, 186, 20);

				textField_2.setBounds(126, 295, 186, 20);

				textField_3.setBounds(126, 340, 186, 20);

				trueButton.setBounds(0,0,0,0);

				falseButton.setBounds (0,0,0,0);
				
				break; 

			}

			}
		}
		else if (e.getSource().equals(checkBox)) //checking selected check box, radiobutton and saving answer
		{
			correctAnswer = textField.getText(); 
		}
		else if (e.getSource().equals(checkBox_1))
		{
			correctAnswer = textField_1.getText(); 
		}
		else if (e.getSource().equals(checkBox_2))
		{
			correctAnswer = textField_2.getText(); 
		}
		else if (e.getSource().equals(checkBox_3))
		{
			correctAnswer = textField_3.getText(); 
		}
		else if (e.getSource().equals(trueButton))
		{
			correctAnswer = "True";
		}
		else if (e.getSource().equals(falseButton))
		{
			correctAnswer = "False"; 
		}
		else if (e.getSource().equals(btnNext))
		{

			//if ()
			Data.questionNum++; //adding to question num 
//			if (Data.questionNum>size) {
//				btnNext.setEnabled(false);
//			}

			if (selectedItem.equals("True or False")) {
				//get question title
				questionTitle = textArea.getText();//getting questionTitle 

				if (questionTitle.equals("Untitled Question")) {
					scrollBar.setBorder(redline); //changing border if someone leaves it blank 
					//btnNext.setEnabled(false);

				}
				else{
					answer = correctAnswer;

					//create new true false question
					QuestionTF tf = new QuestionTF(questionTitle, Boolean.parseBoolean(answer));

					//add question to quiz
					Data.q.addQuestion(tf);
					
					//Data.q.getQuestions().set(Data.questionNum, tf); 
					//Data.q.getQuestions().add (Data.questionNum, tf);
					
					//System.out.println(q.getQuestionsTF());
					//System.out.println(questionNum);
					//System.out.print(Data.q.getQuestions().get(questionNum));


					//System.out.println(((QuestionTF)q.getQuestions().get(0)).getQuestion());
					//					//format to string
					//					String question = questionType + "|" + questionTitle + "|" + answer;

					//					//add question to array list
					//					questions.add(question);	
				}

			}
			else if (selectedItem.equals("Multiple Choice"))
			{
				questionTitle = textArea.getText(); //getting questionTitle
				
				answer = correctAnswer; 
				
				//getting inputs of textFields for different options 
				String optionMC [] = {textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText()}; 
				
				//ArrayList<String> options = new ArrayList<String>(); // all possible options
				
				//adding options to list
				for (int i=0; i< optionMC.length; i++)
				{
					optionslist.add(optionMC[i]);
				}
				
				QuestionMC mc = new QuestionMC (questionTitle, optionslist, answer); //creating new multiple choice question
				
				Data.q.addQuestion(mc);
				
				//Data.q.getQuestions().set(Data.questionNum, mc); 
				
			}
			//if (!questionTitle.equals("") || !questionTitle.equals("Untitled Question")) {
			super.dispose();
			main(null);	
			//}

		}
		else if (e.getSource() == btnPrevious)
		{
			//			if (questionNum<0) {
			//				btnPrevious.setEnabled(false);
			//			}
			Data.questionNum --;//subtracting from question number
			
			type = Data.q.getQuestions().get(Data.questionNum).getType(); //getting type of question

			switch (type) {
					case 1: {
							questionTitle = Data.q.getQuestions().get(Data.questionNum).getQuestion();//getting question title
							boolean answer =((QuestionTF)Data.q.getQuestions().get(Data.questionNum)).getAnswer();//getting answer
							textArea.setText(questionTitle);//setting text of question area 
							comboBox.setSelectedItem("True or False"); 
							if (answer == true)//setting selected answer
							{
								trueButton.setSelected(true);
							}
							else 
							{
								falseButton.setSelected(true);
							}
							break;				
					}
					case 2: {
							questionTitle = ((QuestionMC)Data.q.getQuestions().get(Data.questionNum)).getQuestion();//getting question
							answer = ((QuestionMC)Data.q.getQuestions().get(Data.questionNum)).getAnswer();//getting answer
							optionslist = ((QuestionMC)Data.q.getQuestions().get(Data.questionNum)).getOptions();//getting options
							comboBox.setSelectedItem("Multiple Choice");//setting selected item 
							textArea.setText(questionTitle); //setting question title
							
							//getting options 
							textField.setText(optionslist.get(0).toString()); 
							textField_1.setText(optionslist.get(1).toString());
							textField_2.setText(optionslist.get(2).toString());
							textField_3.setText(optionslist.get(3).toString());
							
							System.out.println(answer);
							
							String optionMC [] = {textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText()}; 
							
							//Depending on answer set selected checkbox
							if (answer.equalsIgnoreCase(optionMC[0]) )
							{
								checkBox.setSelected(true);
							}
							else if (answer.equalsIgnoreCase(optionMC[1]))
							{
								checkBox_1.setSelected(true);
							}
							else if (answer.equalsIgnoreCase(optionMC[2]))
							{
								checkBox_2.setSelected(true);
							}
							else if (answer.equalsIgnoreCase(optionMC[3]))
							{
								checkBox_3.setSelected(true);
							}
							break;
					}
					case 3: {
			//				questionTitle = ((QuestionCB)q.getQuestions().get(0)).getQuestion();
			//				answersCB = ((QuestionCB)q.getQuestions().get(0)).getAnswers();
			//				options = ((QuestionCB)q.getQuestions().get(0)).getOptions();
			//				break;
						}
			}


		}

	}



	public static void main(String[] args) {


		QuestionCreation question = new QuestionCreation (); 
	}


}