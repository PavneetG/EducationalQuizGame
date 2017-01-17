import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class QuestionGUI extends JFrame implements ActionListener{

	
	public QuestionGUI() {
		setSize(500,700);
		getContentPane().setLayout(null);
		
		QuestionMC mcQ = new QuestionMC ("What is Jonathan's middle name?");
		mcQ.addOption("Brandon");
		mcQ.addOption("Kevin");
		mcQ.addOption("Chicken");
		mcQ.addOption("Dog");
		mcQ.setAnswer("Dog");
	
		
		
		
		JLabel lblTitle = new JLabel("Question Title");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTitle.setBounds(32, 86, 443, 139);
		getContentPane().add(lblTitle);
		
		JButton [] btnOptions = new JButton [4] ;
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
			btnOptions[i].setText(mcQ.getOptions().get(i));
		}
		
		//
		lblTitle.setText("<html>" + mcQ.getQuestion() + "asdfasdasdfdf" + "</html>");
		
		
		
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
		QuestionGUI qGUI = new QuestionGUI();
	}

	public void actionPerformed(ActionEvent e) {

	}
}
