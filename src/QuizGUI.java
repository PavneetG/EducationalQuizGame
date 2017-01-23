import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class QuizGUI extends JFrame {

	private Quiz q; 
	private int type = 0; 
	JLabel lblTitle;
	private int time = 30;
	//private Timer timer = new Timer();
	//TimerTask task;
	private int seconds = 20;
	QuestionTFGUI tf;
	QuestionMCGUI mc;
	QuestionCBGUI cb;
	int limit = 19;
	int size, questions; 
	private Thread timer = new Thread();


	public QuizGUI() throws InterruptedException {

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
		setSize(500,700);

		q = new Quiz ();
		if (q.readFromFile("American History.txt")) {
			System.out.println("Success");
		}


		lblTitle = new JLabel(q.getQuizName());
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTitle.setBounds(67, 200, 379, 230);
		getContentPane().add(lblTitle);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo (null);
		getContentPane().setLayout(null);
		setVisible (true);

		timer.start();

		timer.sleep(10000);


		size = q.getQuestions().size();

		for (int i = 0; i < size; i++) {

			type = q.getQuestions().get(i).getType();

			System.out.println(type);

			switch(type) {
			case 1: {
				//lblTitle.setText(((QuestionTF) q.getQuestions().get(i)).getQuestion());
				tf = new QuestionTFGUI ((QuestionTF) q.getQuestions().get(i));
				setVisible(false);

				tf.updateProgressBar(size, i+1);
				seconds = 20;
				for (int f = 0; f<20; f++ )
				{
					seconds --;
					timer.sleep(1000);
					tf.setTimerTitle(Integer.toString(seconds));

					System.out.println(seconds);

					if (tf.getClose() || seconds == 0) {
						timer.interrupt();
						tf.dispose();
						//setVisible(true);
						break;
					}
				}
				break;
			}
			case 2: {
				mc = new QuestionMCGUI ((QuestionMC) q.getQuestions().get(i));
				setVisible(false);

				mc.updateProgressBar(size, i+1);
				seconds = 20;
				for (int f = 0; f<20; f++ )
				{
					seconds --;
					timer.sleep(1000);
					mc.setTimerTitle(Integer.toString(seconds));
					System.out.println(seconds);

					if (mc.getClose() || seconds == 0) {
						timer.interrupt();
						mc.dispose();
						//setVisible(true);
						break;
					}
				}
				break;
			}

			case 3: {
				cb = new QuestionCBGUI ((QuestionCB) q.getQuestions().get(i));
				setVisible(false);

				cb.updateProgressBar(size, i+1);
				seconds = 20;
				for (int f = 0; f<20; f++ )
				{
					seconds --;
					timer.sleep(1000);
					cb.setTimerTitle(Integer.toString(seconds));
					System.out.println(seconds);

					if (cb.getClose() || seconds == 0) {
						timer.interrupt();
						cb.dispose();
						//setVisible(true);
						break;
					}
				}
				break;
			}
			}
		}
		JOptionPane.showMessageDialog(null, "Total Points: " + Data.getPoints());
	}
	//	public void startTimer ()
	//	{
	//		timer.scheduleAtFixedRate (new TimerTask ()
	//		{
	//			public void run ()
	//			{
	//				time--;
	//
	//				//				if (tf.getClose()){
	//				//					timer.cancel();;
	//				//				}
	//
	//				//timeDisplay.setText (Integer.toString (time));
	//				System.out.println (time);
	//				if (time == 0)
	//				{
	//					timer.cancel();
	//					System.out.println("Done");
	//					setVisible(true);
	//				}
	//			}
	//		}
	//		, 1000, 1000);
	//	}



	//self-testing main
	public static void main(String[] args) throws InterruptedException {
		QuizGUI qGUI = new QuizGUI ();

	}

}
