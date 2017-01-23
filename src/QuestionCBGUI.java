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
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;

public class QuestionCBGUI extends JFrame implements ActionListener{

	private JCheckBox [] checkBox;
	private int optionSize, answerSize;
	private JButton btnOK; 
	ArrayList<String> options, answers, input;
	QuestionCB cbQ;
	boolean close = false;
	private int seconds = 20;
	private Thread timer;
	private JLabel lblTimer;
	JProgressBar progress;


	public QuestionCBGUI(QuestionCB cbQ) throws InterruptedException {
		setSize(500,700);
		getContentPane().setLayout(null);

		//Reference for cross platform look
		//https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		try {
			UIManager.setLookAndFeel(
					UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.cbQ = cbQ;

		//Reference for JProgressBar 
		//https://docs.oracle.com/javase/8/docs/api/javax/swing/JProgressBar.html
		progress = new JProgressBar();
		progress.setBounds(150,5,200,30);
		add(progress);
		//options = new ArrayList(Arrays.asList("Red","Orange","Caloon","Babarotu","Green"));
		//answers = new ArrayList(Arrays.asList("Red","Orange","Green"));

		optionSize = cbQ.getOptions().size();
		System.out.println("Option Size: " + optionSize);

		//cbQ = new QuestionCB ("Which of the follow are colours?", options, answers);

		checkBox = new JCheckBox [optionSize];

		checkBox[0] = new JCheckBox(cbQ.getOptions().get(0));
		checkBox[0].setBounds(220, 232, 97, 23);
		getContentPane().add(checkBox[0]);
		checkBox[0].addActionListener(this);

		checkBox[1] = new JCheckBox(cbQ.getOptions().get(1));
		checkBox[1].setBounds(220, 252, 97, 23);
		getContentPane().add(checkBox[1]);
		checkBox[1].addActionListener(this);

		checkBox[2] = new JCheckBox(cbQ.getOptions().get(2));
		checkBox[2].setBounds(220, 272, 97, 23);
		getContentPane().add(checkBox[2]);
		checkBox[2].addActionListener(this);

		if(optionSize == 4){
			checkBox[3] =  new JCheckBox(cbQ.getOptions().get(3));
			checkBox[3].setBounds(220, 292, 97, 23);
			getContentPane().add(checkBox[3]);
			checkBox[3].addActionListener(this);
		}
		else if(optionSize == 5){
			checkBox[3] =  new JCheckBox(cbQ.getOptions().get(3));
			checkBox[3].setBounds(220, 292, 97, 23);
			getContentPane().add(checkBox[3]);
			checkBox[3].addActionListener(this);

			checkBox[4] =  new JCheckBox(cbQ.getOptions().get(4));
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

		btnOK = new JButton ("OK");
		btnOK.addActionListener(this);
		btnOK.setBounds(250,450,100,50);
		add(btnOK);

		lblTimer = new JLabel("");
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setBounds(218, 31, 61, 16);
		getContentPane().add(lblTimer);


		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//		for (int f = 0; f<20; f++ )
		//		{
		//			seconds --;
		//			timer.sleep(1000);
		//			lblTimer.setText(Integer.toString(seconds));
		//			
		//			if (seconds == 0) {
		//				close = true;
		//			}
		//		}





	}
	public void setTimerTitle (String txt) {
		lblTimer.setText(txt);
	}
	public void updateProgressBar (int maxValue, int currentValue) {
		progress.setMaximum(maxValue);
		progress.setValue(currentValue);
	}
	public static void main(String[] args) throws InterruptedException {
		ArrayList<String> options = new ArrayList(Arrays.asList("Red","Orange","Caloon","Babarotu","Green"));
		ArrayList<String> answers = new ArrayList(Arrays.asList("Red","Orange","Green"));

		QuestionCB cbQ = new QuestionCB ("Which of the follow are colours?", options, answers);
		QuestionCBGUI cbGUI = new QuestionCBGUI(cbQ);
	}

	public boolean getClose () {
		return close;
	}

	public void actionPerformed(ActionEvent e) {
		//input = null;

		ArrayList<String> input = new ArrayList<String>();

		if (e.getSource() == btnOK) {
			for(int i = 0; i < optionSize; i++){
				//if(e.getSource() == checkBox[i]){
				if(checkBox[i].isSelected()){
					input.add(cbQ.getOptions().get(i));
				}
			}
			//enhanced for loop
			for (String f: input) {
				System.out.print(f + ", ");
			}

			//Reference for enhanced if statement
			//enhanced if statement
			//https://www.youtube.com/watch?v=w41D0V-BnKQ&index=31&list=PLFE2CE09D83EE3E28
			System.out.println(cbQ.checkAnswer(input)?"Correct":"Wrong");

			if (cbQ.checkAnswer(input)) {
				close = true;

				//enhanced if statement (if timer is greater than 20 seconds add 10 points, else 5 points
				Data.addPoints(Integer.parseInt(lblTimer.getText())>20? 10: 5);
			}
			else 
				close = false;
		}

		//System.out.println(input);
	}

}
