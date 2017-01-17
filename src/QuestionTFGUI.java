import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/*
 * Author: Kevin Subhash
 */

public class QuestionTFGUI extends JFrame implements ActionListener{

	private JButton btnTrue, btnFalse; // private variables for true and false buttons
	private JLabel lblNewLabel_1; // private variable for label
	QuestionTF tfQ; // tfQ object created

	public QuestionTFGUI() {
		setSize(500,700);
		getContentPane().setLayout(null);

		tfQ = new QuestionTF ("Seth Rollins cashed in MITB at WrestleMania to become the WWE World Heavyweight Champion.", true); // initializing object

		JLabel lblTitle = new JLabel(""); // Created JLabel for question
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Dialog", Font.PLAIN, 23)); // Setting font for title
		lblTitle.setBounds(10, 90, 464, 139); // Setting bounds for title
		getContentPane().add(lblTitle); // Adding title


		btnTrue = new JButton("True"); // initializing btnTrue
		btnTrue.setFont(new Font("Tahoma", Font.PLAIN, 38)); // setting font for btnTrue
		btnTrue.setBounds(57, 298, 374, 94); // setting bounds for btnTrue
		getContentPane().add(btnTrue); // adding btnTrue
		btnTrue.addActionListener(this); // adding actionlistener for btnTrue

		btnFalse = new JButton("False"); // initializing btnFalse
		btnFalse.setFont(new Font("Tahoma", Font.PLAIN, 38)); // setting font for btnFalse
		btnFalse.setBounds(57, 461, 374, 94); // setting bounds for btnFalse
		getContentPane().add(btnFalse); // adding btnFalse
		btnFalse.addActionListener(this); // adding actionlistener for btnTrue

		lblTitle.setText("<html>" + tfQ.getQuestion() + "</html>"); // Wrappinh title text in order to fit

		lblNewLabel_1 = new JLabel("Timer"); // initializing label
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15)); // setting font for label
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER); 
		lblNewLabel_1.setBounds(218, 31, 61, 16); // setting bounds for label
		getContentPane().add(lblNewLabel_1); // adding label

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		QuestionTFGUI tfGUI = new QuestionTFGUI();
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnTrue) { 
			if(tfQ.checkAnswer(true)){
				JOptionPane.showMessageDialog(null, "Correct!");
			}
			else{
				JOptionPane.showMessageDialog(null, "incorrect.");
			}
		}
		if (e.getSource() == btnFalse) {
			if(tfQ.checkAnswer(false)){
				JOptionPane.showMessageDialog(null, "Correct!");
			}
			else{
				JOptionPane.showMessageDialog(null, "incorrect.");
			}
		}

	}

}
