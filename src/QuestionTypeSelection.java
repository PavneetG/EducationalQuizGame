import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class QuestionTypeSelection extends JFrame {
	
	private JTextField txtSelectFromFollowing;


	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public QuestionTypeSelection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JButton btnA = new JButton("A");
		btnA.setEnabled(false);
		btnA.setBounds(118, 74, 96, 36);
		getContentPane().add(btnA);
		
		JButton btnC = new JButton("C");
		btnC.setEnabled(false);
		btnC.setBounds(118, 121, 96, 36);
		getContentPane().add(btnC);
		
		JButton btnB = new JButton("B");
		btnB.addActionListener(new ActionListener() {
		btnB.setEnabled(false);
		btnB.setBounds(235, 74, 96, 36);
		getContentPane().add(btnB);
		
		JButton btnD = new JButton("D");
		btnD.setEnabled(false);
		btnD.setBounds(235, 121, 96, 36);
		getContentPane().add(btnD);
		
		JCheckBox chckbxSelect = new JCheckBox("Mutiple Choice");
		chckbxSelect.setBounds(15, 104, 97, 23);
		getContentPane().add(chckbxSelect);
		
		txtSelectFromFollowing = new JTextField();
		txtSelectFromFollowing.setHorizontalAlignment(SwingConstants.CENTER);
		txtSelectFromFollowing.setText("Select From Following");
		txtSelectFromFollowing.setBounds(0, 0, 484, 36);
		getContentPane().add(txtSelectFromFollowing);
		txtSelectFromFollowing.setColumns(10);
		
		JCheckBox chckbxTrueOrFalse = new JCheckBox("True or False");
		chckbxTrueOrFalse.setBounds(15, 217, 97, 23);
		getContentPane().add(chckbxTrueOrFalse);
		
		JButton btnTrue = new JButton("True");
		btnTrue.setEnabled(false);
		btnTrue.setBounds(174, 193, 91, 29);
		getContentPane().add(btnTrue);
		
		JButton btnFalse = new JButton("False");
		btnFalse.setEnabled(false);
		btnFalse.setBounds(174, 233, 91, 29);
		getContentPane().add(btnFalse);
		
		JCheckBox chckbxCheckbox = new JCheckBox("CheckBox");
		chckbxCheckbox.setBounds(15, 331, 97, 23);
		getContentPane().add(chckbxCheckbox);
		
		JCheckBox chckbxRandom = new JCheckBox("Random");
		chckbxRandom.setBounds(168, 396, 97, 23);
		getContentPane().add(chckbxRandom);
		
		JCheckBox chckbxA = new JCheckBox("A");
		chckbxA.setEnabled(false);
		chckbxA.setBounds(139, 331, 45, 23);
		getContentPane().add(chckbxA);
		
		JCheckBox chckbxB = new JCheckBox("B");
		chckbxB.setEnabled(false);
		chckbxB.setBounds(188, 331, 45, 23);
		getContentPane().add(chckbxB);
		
		JCheckBox chckbxC = new JCheckBox("C");
		chckbxC.setEnabled(false);
		chckbxC.setBounds(235, 331, 45, 23);
		getContentPane().add(chckbxC);
		
		JCheckBox chckbxD = new JCheckBox("D");
		chckbxD.setEnabled(false);
		chckbxD.setBounds(282, 331, 45, 23);
		getContentPane().add(chckbxD);
		setVisible (true); 
	}
	
public static void main(String[] args) {
		
	QuestionTypeSelection qtsGUI = new QuestionTypeSelection ();
	
	}
}
