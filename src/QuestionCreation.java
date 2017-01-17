import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JComboBox;


public class QuestionCreation extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField questionText;
	JComboBox comboBox; 
	JRadioButton trueButton = new JRadioButton ("true");
	JRadioButton falseButton = new JRadioButton ("false");
	JLabel lblOptions = new JLabel("Options");
	JLabel lblAnswer = new JLabel("Answer");

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
		
		questionText = new JTextField();
		questionText.setFont(new Font("Arial Black", Font.BOLD, 12));
		questionText.setText("Untitled Question");
		questionText.setBounds(31, 29, 386, 26);
		questionText.setBackground (null); 
		questionText.setBorder(null);
		
		getContentPane().add(questionText);
		questionText.setColumns(10);
		
		JLabel lblQuestionType = new JLabel("Question Type");
		lblQuestionType.setBounds(31, 62, 86, 20);
		getContentPane().add(lblQuestionType);
		String options [] = {"Select", "True or False", "Multiple Choice", "Check Box", "Ranking"};
	    comboBox = new JComboBox(options);
		comboBox.setBounds(122, 63, 112, 20);
		comboBox.setActionCommand("hello");
		comboBox.addActionListener(this);
		comboBox.setSelectedIndex (0);
		getContentPane().add(comboBox);
		
		lblAnswer.setBounds(31, 128, 86, 20);
		getContentPane().add(lblAnswer);
		
		lblOptions.setBounds(31, 97, 86, 20);
		getContentPane().add (trueButton); 
		getContentPane().add (falseButton); 
		getContentPane().add(lblOptions);
		setLocationRelativeTo (null);
		setVisible (true); 
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("hello"))
		{
			String selectedItem =(String) comboBox.getSelectedItem(); 
			
			switch (selectedItem)
			{
			case "True or False":
			{
				lblOptions.setBounds(1000,1000,1000,1000);
				
				trueButton.setBounds(120, 96, 57, 23);
				
				falseButton.setBounds (179, 96, 57, 23);
				
				lblAnswer.setBounds(31, 97, 86, 20);
				
			}
			
			}
		}
	}
	
public static void main(String[] args) {
		
		QuestionCreation question = new QuestionCreation (); 
	}
}