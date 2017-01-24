import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextArea;

public class QuestionMCGUI extends JFrame implements ActionListener{

	private JButton [] btnOptions;
	private QuestionMC mcQ;
	private int optionSize = 0;
	String answer;
	boolean close = false; 

	private JLabel lblTimer;
	JProgressBar progress;


	public QuestionMCGUI(QuestionMC mcQ) throws InterruptedException {
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
		this.mcQ = mcQ;

		//Reference for JProgressBar 
		//https://docs.oracle.com/javase/8/docs/api/javax/swing/JProgressBar.html
		progress = new JProgressBar();
		progress.setBounds(150,5,200,30);
		add(progress);
		//Reference for initializing array list in one line
		//http://stackoverflow.com/questions/21696784/how-to-declare-an-arraylist-with-values
		//ArrayList<String> options = new ArrayList(Arrays.asList("Brandon", "Kevin", "Jeffrey", "Campos"));

		//mcQ = new QuestionMC("What is Jonathan's middle name", options, "Campos");


		JLabel lblTitle = new JLabel("Question Title");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTitle.setBounds(32, 86, 443, 139);
		getContentPane().add(lblTitle);

		btnOptions = new JButton [5] ;


		//
		lblTitle.setText("<html>" + mcQ.getQuestion()  + "</html>");

		lblTimer = new JLabel("");
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setBounds(218, 31, 61, 16);
		getContentPane().add(lblTimer);

		optionSize = mcQ.getOptions().size();

		JPanel bPanel = new JPanel();
		bPanel.setLayout(new GridLayout (optionSize,1,5,5));
		bPanel.setBounds(32, 237, 443, 393);
		getContentPane().add(bPanel);


		btnOptions[0] = new JButton("New 1");
		//btnOptions[0].setBounds(61, 218, 142, 94);
		bPanel.add(btnOptions[0]);

		btnOptions[1] = new JButton("New 2");
		//btnOptions[1].setBounds(61, 355, 142, 94);
		bPanel.add(btnOptions[1]);

		btnOptions[2] = new JButton("New 3");
		//btnOptions[2].setBounds(283, 218, 142, 94);
		bPanel.add(btnOptions[2]);

		if (optionSize == 4) {
			btnOptions[3] = new JButton("New 4");
			bPanel.add(btnOptions[3]);
		}

		else if (optionSize == 5) {
			btnOptions[3] = new JButton("New 4");
			bPanel.add(btnOptions[3]);

			btnOptions[4] = new JButton("New 5");
			bPanel.add(btnOptions[4]);
		}


		for (int i = 0; i<optionSize; i++) {
			btnOptions[i].setText(mcQ.getOptions().get(i));
			btnOptions[i].addActionListener(this);
		}

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
		for (int i = 0; i < optionSize; i++) {
			if (e.getSource()==btnOptions[i]) {

				if (mcQ.checkAnswer(btnOptions[i].getText())) {
					System.out.println("Correct answer");
					close = true;

					//enhanced if statement (if timer is greater than 20 seconds add 10 points, else 5 points
					Data.addPoints(Integer.parseInt(lblTimer.getText())>20? 10: 5);

				}
				else {
					System.out.println("Wrong answer");
					close = false;
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ArrayList<String> options = new ArrayList(Arrays.asList("Brandon", "Kevin", "Jeffrey", "Campos"));
		QuestionMC q = new QuestionMC("Hello", options, "Kevin");
		QuestionMCGUI qGUI = new QuestionMCGUI(q);
	}
}
