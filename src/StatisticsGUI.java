import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;

public class StatisticsGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblPicture, lblPlayerName; 
	private JTable table;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		StatisticsGUI statistics = new StatisticsGUI();
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public StatisticsGUI() throws IOException {
		
		Data.accounts.loadFile("Players.txt");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		String[] columns = {"Quizzes", "Total Questions", "Correct Answers", "Overall %", "Average Time"};
		Object [][] data = {{Data.accounts.getStats(Data.userName).getNumQuizzes(), Data.accounts.getStats(Data.userName).getNumTotal(), Data.accounts.getStats(Data.userName).getNumCorrect(),
			Data.accounts.getStats(Data.userName).getOverallPercentage(), Data.accounts.getStats(Data.userName).getAverageTime()}};
		
		table = new JTable(data, columns);
		table.setBounds(41, 217, 250, 173);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		table.setFillsViewportHeight(true);
		getContentPane().add(table);
		
		lblPicture = new JLabel(new ImageIcon(Data.accounts.getPic(Data.userName)));
		lblPlayerName = new JLabel(Data.userName + "'s Statistics");
		
		lblPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblPicture.setBounds(148, 99, 46, 14);
		lblPlayerName.setBounds(104, 151, 230, 25);
		
		getContentPane().add(lblPicture);
		getContentPane().add(lblPlayerName);
		
		
		
		
		
		
		
		
		
		
		setSize(350,500); // set size of window
		setVisible(true);
		setResizable(false); // cannot resize window
	}
}
