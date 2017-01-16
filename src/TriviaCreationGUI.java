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
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;


public class TriviaCreationGUI extends JFrame {
	private JTextField txtLabel;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TriviaCreationGUI() {
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 11));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		txtLabel = new JTextField();
		txtLabel.setBackground(new Color(255, 255, 255));
		txtLabel.setFont(new Font("Plantagenet Cherokee", Font.PLAIN, 11));
		txtLabel.setHorizontalAlignment(SwingConstants.CENTER);
		txtLabel.setText("Trivia Creation");
		txtLabel.setBounds(0, 0, 484, 48);
		getContentPane().add(txtLabel);
		txtLabel.setColumns(10);
		
		JLabel lblTriviaName = new JLabel("Trivia Name");
		lblTriviaName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTriviaName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTriviaName.setBounds(10, 87, 115, 20);
		getContentPane().add(lblTriviaName);
		
		textField = new JTextField();
		textField.setBounds(35, 110, 400, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescription.setBounds(10, 153, 115, 20);
		getContentPane().add(lblDescription);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 53, 89, 23);
		getContentPane().add(btnBack);
		
		JLabel lblNumberOfQuestioms = new JLabel("Number of Question(s):");
		lblNumberOfQuestioms.setBounds(86, 472, 133, 14);
		getContentPane().add(lblNumberOfQuestioms);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(235, 469, 28, 20);
		getContentPane().add(comboBox);
		comboBox.setActionCommand("Question #");
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(160, 544, 139, 36);
		getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(35, 184, 400, 228);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		setVisible (true); 
	}

	public static void main(String[] args) {
		TriviaCreationGUI tcGUI = new TriviaCreationGUI();
	}
}
