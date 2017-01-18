

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class QuestionCBGUI extends JFrame {

	JButton [] btnOptions;
	/**
	 * Create the frame.
	 */
	public QuestionCBGUI() {
		setSize(500,700);
		getContentPane().setLayout(null);
		
		ArrayList<String> options = new ArrayList(Arrays.asList("Red","Orange","Caloon","Babarotu","Green"));
		ArrayList<String> answers = new ArrayList(Arrays.asList("Red","Orange","Green"));
		
		QuestionCB cbQ = new QuestionCB ("Which of the follow are colours?", options, answers);
		
		
		JLabel lblTitle = new JLabel("Question Title");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTitle.setBounds(32, 86, 443, 139);
		getContentPane().add(lblTitle);
		
		
		if(options.)
			
			
			
			
			
			
			
			
			
		btnOptions = new JButton [4] ;
		btnOptions[0] = new JButton("New 1");
		btnOptions[0].setBounds(61, 218, 142, 94);
		getContentPane().add(btnOptions[0]);
		
		btnOptions[1] = new JButton("New 2");
		btnOptions[1].setBounds(61, 355, 142, 94);
		getContentPane().add(btnOptions[1]);
		
		btnOptions[2] = new JButton("New 3");
		btnOptions[2].setBounds(283, 218, 142, 94);
		getContentPane().add(btnOptions[2]);
		
		btnOptions[3] = new JButton("New 4");
		btnOptions[3].setBounds(283, 355, 142, 94);
		getContentPane().add(btnOptions[3]);
		
		
		for (int i = 0; i<4; i++) {
			btnOptions[i].setText(cbQ.getOptions().get(i));
		}
		
		//
		lblTitle.setText("<html>" + cbQ.getQuestion() + "asdfasdasdfdf" + "</html>");
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Timer");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(218, 31, 61, 16);
		getContentPane().add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(42, 216, 430, 146);
		getContentPane().add(textArea);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		QuestionCBGUI cbGUI = new QuestionCBGUI();
	}

	public void actionPerformed(ActionEvent e) {

	}

}
