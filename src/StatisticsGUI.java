import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*
 * Author: Kevin Subhash and Janujan
 * Date: January 2017
 * Description: This class is the GUI for the the player Statistics. It displays
 * the player's quizzes attempted, total questions attempted, correct answers,
 * overall percentage, and average time.
 */
public class StatisticsGUI extends JFrame {

	private JLabel lblPicture, lblPlayerName, userName; //creating JLabels and JTable
	private JTable table;
	private JButton btnBack;
	private JScrollPane scrollPane;
	private JLabel label;

	public static void main(String[] args) throws IOException {
		StatisticsGUI statistics = new StatisticsGUI();
	}

	public StatisticsGUI() throws IOException {

		Data.accounts.loadFile("Players.txt"); // loads Players.txt

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		getContentPane().setLayout(null); // setting layout to null

		String[] columns = {"Quizzes", "Total\nQuestions", "Correct Answers", "Overall %", "Average Time"}; // creating columns for JTable
		Object [][] data = {{Data.accounts.getStats(Data.userName).getNumQuizzes(), Data.accounts.getStats(Data.userName).getNumTotal(), Data.accounts.getStats(Data.userName).getNumCorrect(),
			Data.accounts.getStats(Data.userName).getOverallPercentage(), Data.accounts.getStats(Data.userName).getAverageTime()}}; // Creating and declaring 2D Arrays which contain data for the JTablee

		table = new JTable(data, columns);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setFillsViewportHeight(true);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		table.setFillsViewportHeight(true);

		scrollPane = new JScrollPane(table);
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnBack){
					new HomeGUI();
					dispose();
				}
			}
		});
		btnBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));

		lblPicture = new JLabel(new ImageIcon(Data.accounts.getPic(Data.userName)));
		lblPlayerName = new JLabel("<html>" + Data.accounts.getName(Data.userName) + "'s Statistics" + "<html>");
		lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		userName = new JLabel("<html>" + "UserName: " + Data.userName + "<html>");
		userName.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		userName.setHorizontalAlignment(SwingConstants.CENTER);

		lblPlayerName.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

		lblPicture.setBounds(138, 68, 60, 60);
		btnBack.setBounds(10, 11, 89, 23);
		lblPlayerName.setBounds(10, 150, 324, 85);
		scrollPane.setBounds(10, 278, 324, 44);
		userName.setBounds(10, 232, 314, 14);

		getContentPane().add(lblPicture);
		getContentPane().add(lblPlayerName);
		getContentPane().add(userName);
		getContentPane().add(scrollPane);
		getContentPane().add(btnBack);
		
		label = new JLabel(new ImageIcon("tree.png"));
		label.setBounds(99, 333, 138, 127);
		getContentPane().add(label);

		setSize(350,500); // set size of window
		setVisible(true); // setting the visibility to true
		setResizable(false); // cannot resize window
	}
}