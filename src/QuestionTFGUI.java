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
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

/*
 * Author: Kevin Subhash, Janujan and Pavneet
 */

public class QuestionTFGUI extends JFrame implements ActionListener{

	private JButton btnTrue, btnFalse; // private variables for true and false buttons
	private JLabel lblNewLabel_1; // private variable for label
	private boolean correctAnswer; 
	private boolean close = false;
	QuestionTF tfQ; // tfQ object created
	private int seconds = 20;
	private Thread timer;
	private JLabel lblTimer;

	JProgressBar progress;


	public QuestionTFGUI(QuestionTF questionTF) throws InterruptedException {
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
		this.tfQ = questionTF;

		//Reference for JProgressBar 
		//https://docs.oracle.com/javase/8/docs/api/javax/swing/JProgressBar.html
		progress = new JProgressBar();
		progress.setBounds(150,5,200,30);
		add(progress);

		lblTimer = new JLabel("");
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setBounds(218, 31, 61, 16);
		getContentPane().add(lblTimer);

		//tfQ = new QuestionTF ("Seth Rollins cashed in MITB at WrestleMania to become the WWE World Heavyweight Champion.", true); // initializing object

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

		lblTitle.setText("<html>" + questionTF.getQuestion() + "</html>"); // Wrappinh title text in order to fit

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);


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
	public boolean getClose () {
		return close;
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnTrue) { 
			//if (checkAnswer)
			if(tfQ.checkAnswer(true)){
				JOptionPane.showMessageDialog(null, "Correct!");
				dispose();
				close = true;	

				//enhanced if statement (if timer is greater than 20 seconds add 10 points, else 5 points
				Data.addPoints(Integer.parseInt(lblTimer.getText())>20? 10: 5);
			}
			else{
				JOptionPane.showMessageDialog(null, "incorrect.");
				close = false;
			}
		}
		if (e.getSource() == btnFalse) {
			if(tfQ.checkAnswer(false)){
				JOptionPane.showMessageDialog(null, "Correct!");
				//dispose();
				close = true;		

				//enhanced if statement (if timer is greater than 20 seconds add 10 points, else 5 points
				Data.addPoints(Integer.parseInt(lblTimer.getText())>20? 10: 5);

			}
			else{
				JOptionPane.showMessageDialog(null, "incorrect.");
				close = false;
			}
		}

	}
	public static void main(String[] args)throws InterruptedException {
		QuestionTF tF = new QuestionTF ("Hello", true);
		QuestionTFGUI tfGUI = new QuestionTFGUI(tF);
	}

}
