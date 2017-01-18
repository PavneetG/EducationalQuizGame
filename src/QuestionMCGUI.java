import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class QuestionMCGUI extends JFrame implements ActionListener{

	private JButton [] btnOptions;
	private QuestionMC mcQ;

	public QuestionMCGUI() {
		setSize(500,700);
		getContentPane().setLayout(null);

		//Reference for initializing array list in one line
		//http://stackoverflow.com/questions/21696784/how-to-declare-an-arraylist-with-values
		ArrayList<String> options = new ArrayList(Arrays.asList("Brandon", "Kevin", "Jeffrey", "Campos"));

		mcQ = new QuestionMC("What is Jonathan's middle name", options, "Campos");


		JLabel lblTitle = new JLabel("Question Title");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTitle.setBounds(32, 86, 443, 139);
		getContentPane().add(lblTitle);

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
			btnOptions[i].setText(mcQ.getOptions().get(i));
			btnOptions[i].addActionListener(this);
		}

		//
		lblTitle.setText("<html>" + mcQ.getQuestion() + "asdfasdasdfdf" + "</html>");



		JLabel lblNewLabel_1 = new JLabel("Timer");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(218, 31, 61, 16);
		getContentPane().add(lblNewLabel_1);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 4; i++) {
			if (e.getSource()==btnOptions[i]) {
				
				if (mcQ.checkAnswer(btnOptions[i].getText())) {
					System.out.println("Correct answer");
				}
				else {
					System.out.println("Wrong answer");
				}
			}
		}
	}

	public static void main(String[] args) {
		QuestionMCGUI qGUI = new QuestionMCGUI();
	}


}
