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

	private JPanel contentPane;
	JComboBox comboBox; 
	JRadioButton trueButton = new JRadioButton ("true");
	JRadioButton falseButton = new JRadioButton ("false");
	JLabel lblOptions = new JLabel("Options");
	JLabel lblAnswer = new JLabel("Answer");
	Border blackline = BorderFactory.createLineBorder(Color.BLACK); 
	Border redline = BorderFactory.createLineBorder(Color.RED,10); 
	JTextField textField= new JTextField();
	JTextField textField_1= new JTextField();;
	JTextField textField_2= new JTextField();
	JTextField textField_3=new JTextField();
	JCheckBox checkBox = new JCheckBox("");
	JCheckBox checkBox_1 = new JCheckBox("");
	JCheckBox checkBox_2 = new JCheckBox("");
	JCheckBox checkBox_3 = new JCheckBox("");
	JTextArea textArea = new JTextArea();
	String correctAnswer; 
	String [] optionsAnswer = new String [4]; 
	JButton btnPrevious = new JButton("Previous");
	JButton btnNext = new JButton("Next");
	String question; 
	JScrollPane scrollBar;
	private String selectedItem;
	private int questionType = 0;
	private ArrayList<String> questions = new ArrayList();
	private Quiz q = new Quiz("Hello", "Hello");
	private int questionNum = 0;
	private int size = 10;
	private String questionTitle;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public QuestionCreation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize (500,700);
		getContentPane().setLayout(null);

		JLabel lblQuestionType = new JLabel("Question Type");
		lblQuestionType.setBounds(30, 178, 86, 20);
		getContentPane().add(lblQuestionType);
		String options [] = {"Select", "True or False", "Multiple Choice", "Check Box", "Ranking"};
		comboBox = new JComboBox(options);
		comboBox.setBounds(126, 178, 112, 20);
		comboBox.setActionCommand("hello");
		comboBox.addActionListener(this);
		comboBox.setSelectedIndex (0);
		getContentPane().add(comboBox);

		lblAnswer.setBounds(30, 238, 47, 20);

		lblOptions.setBounds(31, 209, 86, 20);

		getContentPane().add(lblOptions);

		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setOpaque(false);
		textArea.setText("Untitled Question");

		 scrollBar = new JScrollPane(textArea);

		scrollBar.setVerticalScrollBarPolicy( JScrollPane. VERTICAL_SCROLLBAR_ALWAYS); 
		scrollBar.setBorder(blackline);

		scrollBar.setBounds(22, 81, 437, 64);
		getContentPane().add(scrollBar);
		getContentPane().add (trueButton); 
		getContentPane().add(lblAnswer);


		getContentPane().add (falseButton);

		getContentPane().add(textField);

		getContentPane().add(textField_1);

		getContentPane().add(textField_2);

		getContentPane().add(textField_3);

		getContentPane().add(checkBox);

		getContentPane().add(checkBox_1);

		getContentPane().add(checkBox_2);

		getContentPane().add(checkBox_3);

		checkBox.addActionListener(this);
		checkBox_1.addActionListener (this); 
		checkBox_2.addActionListener(this);
		checkBox_3.addActionListener(this);
		trueButton.addActionListener(this);
		falseButton.addActionListener(this);
		btnNext.addActionListener(this);
		btnPrevious.addActionListener(this);

		btnNext.setBounds(241, 382, 89, 23);
		getContentPane().add(btnNext);


		btnPrevious.setBounds(126, 382, 89, 23);
		getContentPane().add(btnPrevious);
		setLocationRelativeTo (null);
		setVisible (true); 
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("hello"))
		{
			selectedItem = (String) comboBox.getSelectedItem(); 

			switch (selectedItem)
			{
			case "True or False":
			{
				questionType = 1; 
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

			}

			}
		}
		else if (e.getSource().equals(checkBox))
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
			questionNum ++;
			if (questionNum>size) {
				btnNext.setEnabled(false);
			}
			
			if (selectedItem.equals("True or False")) {
				//get question title
				 questionTitle = textArea.getText();
				
				if (questionTitle.equals("Untitled Question")) {
					scrollBar.setBorder(redline);
					//btnNext.setEnabled(false);
					
				}
				else{
					String answer = correctAnswer;

					//create new true false question
					QuestionTF tf = new QuestionTF(questionTitle, Boolean.parseBoolean(answer));
					
					//add question to quiz
					q.addTF(tf);
					
					System.out.println(q.getQuestionsTF());
					System.out.println(questionNum);
					
					
//					//format to string
//					String question = questionType + "|" + questionTitle + "|" + answer;

//					//add question to array list
//					questions.add(question);	
				}
				
			}
			//if (!questionTitle.equals("") || !questionTitle.equals("Untitled Question")) {
				super.dispose();
				main(null);	
			//}
			
		}
		else if (e.getSource().equals(btnPrevious))
		{
			if (questionNum<0) {
				btnPrevious.setEnabled(false);
			}
			questionNum --;
			q.getQuestions().get(questionNum).getQuestion(); 
			
			
		}

	}


	
public static void main(String[] args) {
		

		QuestionCreation question = new QuestionCreation (); 
	}


}