//Name: Pavneet Gill 
//Date: 2017-01-23
//Description: This is a triviaCreationGUI which creates the quiz and sets the quiz name 

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;


public class TriviaCreationGUI extends JFrame implements ActionListener {
	
	//creating variabiles for txt fields, options, lables 
	private JTextField txtLabel;
	private JTextField textField;
	private JButton btnBack, btnCreate;
	private String options [] = {"","5","6","7","8","9","10"}; 
	private JComboBox comboBox = new JComboBox(options);
	private JTextField textField_1;
	private JLabel lblError; 
	private JLabel lblCategoryError; 
	private JLabel lblErrorUnselected;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TriviaCreationGUI() {
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 11));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,420);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		lblError = new JLabel("");
		lblCategoryError = new JLabel("");
		lblErrorUnselected = new JLabel(""); 
		
		txtLabel = new JTextField();
		txtLabel.setEditable(false);
		txtLabel.setBackground(new Color(255, 255, 255));
		txtLabel.setFont(new Font("Yu Gothic Light", Font.PLAIN, 16));
		txtLabel.setHorizontalAlignment(SwingConstants.CENTER);
		txtLabel.setText("Trivia Creation");
		txtLabel.setBounds(0, 0, 484, 42);
		getContentPane().add(txtLabel);
		txtLabel.setColumns(10);
		
		JLabel lblTriviaName = new JLabel("Trivia Name");
		lblTriviaName.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblTriviaName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTriviaName.setBounds(10, 87, 115, 20);
		getContentPane().add(lblTriviaName);
		
		textField = new JTextField();
		textField.setBounds(35, 118, 400, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 53, 89, 23);
		getContentPane().add(btnBack);
		btnBack.addActionListener(this);
		
		JLabel lblNumberOfQuestioms = new JLabel("Number of Question(s):");
		lblNumberOfQuestioms.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		lblNumberOfQuestioms.setBounds(113, 268, 133, 14);
		getContentPane().add(lblNumberOfQuestioms);
		
		comboBox.setBounds(256, 265, 50, 20);
		getContentPane().add(comboBox);
		comboBox.setActionCommand("Question #");
		
		btnCreate = new JButton("Create");
		btnCreate.setBounds(167, 333, 139, 36);
		getContentPane().add(btnCreate);
		btnCreate.addActionListener(this);
		
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategory.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		lblCategory.setBounds(0, 161, 115, 20);
		getContentPane().add(lblCategory);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(35, 192, 400, 32);
		getContentPane().add(textField_1);
		
		
		lblError.setForeground(Color.RED);
		lblError.setBackground(Color.RED);
		getContentPane().add(lblError);
		
		lblCategoryError.setForeground(Color.RED);
		lblCategoryError.setBackground(Color.RED);
		getContentPane().add(lblCategoryError);
		
		lblErrorUnselected.setForeground(Color.RED);
		lblErrorUnselected.setBackground(Color.RED);
		getContentPane().add(lblErrorUnselected);
		setVisible (true); 
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnBack){
			
			try {
			new HomeMenuGUI();
			} catch (Exception f) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			dispose();
		}
		else if(e.getSource() == btnCreate){
			
			String selectedItem = (String) comboBox.getSelectedItem();//getting selected item on comboBox box 
			
			String categoryName = textField_1.getText(); 
			
			int maxlength = 20; 
			
			String quizName = textField.getText(); 
			
			
			if ((categoryName.length() > maxlength) || (quizName.length() > maxlength) || selectedItem == "" || (categoryName.isEmpty()) || (quizName.isEmpty()))
			{
				if (quizName.length() > maxlength)
				{
					lblError.setText("Shorten QuizName to 20 characters");
					
					lblError.setBounds(167, 104, 268, 14);
				}
				
				if (categoryName.isEmpty())
				{
					lblCategoryError.setText("Empty Category Name");
					
					lblCategoryError.setBounds(280, 178, 155, 14);
				}
				
				if (quizName.isEmpty())
				{
					lblError.setText("EmptyQuizName");
					
					lblError.setBounds(320, 104, 115, 14);
				}
				
				if (categoryName.length() > maxlength)
				{
					lblCategoryError.setText("Shorten CategoryName to 20 characters");
					
					lblCategoryError.setBounds(181, 178, 254, 14);
				}
				
				if (selectedItem.equalsIgnoreCase (""))
				{
					lblErrorUnselected.setText("Unselected Questions");
					
					lblErrorUnselected.setBounds(220, 293, 158, 14);
				}
			}
			else  
			{
				Data.q.getQuestions().clear();
				
				Data.q.setQuizName(textField.getText());
				
				Data.q.setCategory(textField_1.getText());
				
				Data.totalQuestions = Integer.parseInt(selectedItem);
				
				new QuestionCreation();
				
				dispose();
			}
		}
	}

	public static void main(String[] args) {
		TriviaCreationGUI tcGUI = new TriviaCreationGUI();
	}
}
