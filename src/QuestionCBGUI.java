import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;

public class QuestionCBGUI extends JFrame implements ActionListener{

	private JCheckBox [] checkBox;
	private int optionSize, answerSize;
	ArrayList<String> options, answers, input;
	QuestionCB cbQ;
	/**
	 * Create the frame.
	 */
	public QuestionCBGUI() {
		setSize(500,700);
		getContentPane().setLayout(null);

		options = new ArrayList(Arrays.asList("Red","Orange","Caloon","Babarotu","Green"));
		answers = new ArrayList(Arrays.asList("Red","Orange","Green"));

		optionSize = options.size();
		System.out.println(optionSize);
		cbQ = new QuestionCB ("Which of the follow are colours?", options, answers);

		checkBox = new JCheckBox [optionSize];

		checkBox[0] = new JCheckBox(options.get(0));
		checkBox[0].setBounds(220, 232, 97, 23);
		getContentPane().add(checkBox[0]);
		checkBox[0].addActionListener(this);

		checkBox[1] = new JCheckBox(options.get(1));
		checkBox[1].setBounds(220, 252, 97, 23);
		getContentPane().add(checkBox[1]);
		checkBox[1].addActionListener(this);

		checkBox[2] = new JCheckBox(options.get(2));
		checkBox[2].setBounds(220, 272, 97, 23);
		getContentPane().add(checkBox[2]);
		checkBox[2].addActionListener(this);

		if(optionSize == 4){
			checkBox[3] = new JCheckBox(options.get(3));
			checkBox[3].setBounds(220, 292, 97, 23);
			getContentPane().add(checkBox[3]);
			checkBox[3].addActionListener(this);
		}
		else if(optionSize == 5){
			checkBox[3] = new JCheckBox(options.get(3));
			checkBox[3].setBounds(220, 292, 97, 23);
			getContentPane().add(checkBox[3]);
			checkBox[3].addActionListener(this);

			checkBox[4] = new JCheckBox(options.get(4));
			checkBox[4].setBounds(220, 312, 97, 23);
			getContentPane().add(checkBox[4]);
			checkBox[4].addActionListener(this);
		}

		JLabel lblTitle = new JLabel("");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTitle.setBounds(32, 86, 443, 139);
		getContentPane().add(lblTitle);
		lblTitle.setText("<html>" + cbQ.getQuestion() + "</html>");

		JLabel lblNewLabel_1 = new JLabel("Timer");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(218, 31, 61, 16);
		getContentPane().add(lblNewLabel_1);


		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		QuestionCBGUI cbGUI = new QuestionCBGUI();
	}

	public void actionPerformed(ActionEvent e) {
		
		input = new ArrayList();
//		for (int f = 0; f<input.size();f++) {
//			System.out.print(input.get(f) + ", ");
//			System.out.println();
//		}
		
		for(int i = 0; i < optionSize; i++){
			if(e.getSource() == checkBox[i]){
				if(checkBox[i].isSelected()){
					input.add(options.get(i));
					
					
					//enhanced if statement
//					"The checkbox is "+(cb.isSelected()?"":"not ")+"selected");}});
				}

			}
		}
		
		//System.out.println(input);
	}

}
