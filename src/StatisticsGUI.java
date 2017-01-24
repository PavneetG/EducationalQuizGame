import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;
/*
 * Author: Kevin Subhash
 * Date: January 2017
 * Description: This class is the GUI for the the player Statistics. It displays
 * the player's quizzes attempted, total questions attempted, correct answers,
 * overal percentage, and average time.
 */
public class StatisticsGUI extends JFrame {

	private JLabel lblPicture, lblPlayerName; //creating JLabels and JTable
	private JTable table;

	public static void main(String[] args) throws IOException {
		StatisticsGUI statistics = new StatisticsGUI();
	}

	public StatisticsGUI() throws IOException {
		
		Data.accounts.loadFile("Players.txt"); // loads Players.txt

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		getContentPane().setLayout(null); // setting layout to null
		
		String[] columns = {"Quizzes", "Total Questions", "Correct Answers", "Overall %", "Average Time"}; // creating columns for JTable
		Object [][] data = {{Data.accounts.getStats(Data.userName).getNumQuizzes(), Data.accounts.getStats(Data.userName).getNumTotal(), Data.accounts.getStats(Data.userName).getNumCorrect(),
			Data.accounts.getStats(Data.userName).getOverallPercentage(), Data.accounts.getStats(Data.userName).getAverageTime()}}; // Creating and declaring 2D Arrays which contain data for the JTable
		
		table = new JTable(data, columns); // created JTable with data and columns
		table.getColumnModel().getColumn(1).setPreferredWidth(92); // setting the width of the column names
		table.getColumnModel().getColumn(2).setPreferredWidth(98);
		table.getColumnModel().getColumn(4).setPreferredWidth(87);
		table.setBounds(38, 289, 250, 37); // locating the JTable
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		table.setFillsViewportHeight(true);
		getContentPane().add(table); // adding JTable to frame
		
		lblPicture = new JLabel(new ImageIcon(Data.accounts.getPic(Data.userName))); // using the player's picture for JLabel
		lblPlayerName = new JLabel("<html>" + Data.userName + "'s Statistics" + "<html>"); // JLabel to state whos statistics it is
		
		lblPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 20)); // settings font for lblPlayerName
		
		lblPicture.setBounds(148, 99, 46, 14); // locating lblPicture
		lblPlayerName.setBounds(104, 151, 230, 25); // locating lblPlayerName
		
		getContentPane().add(lblPicture); // adds lblPicture to frame
		getContentPane().add(lblPlayerName); // adds lblPlayerName to frame
		
		setSize(350,500); // set size of window
		setVisible(true); // setting the visibility to true
		setResizable(false); // cannot resize window
	}
}
