/*
 * Author: Janujan Gathieswaran
 * Date: January 10, 2017
 * Description: The home GUI which allows the user to access a menu bar, recent quizzes, 
 * 				recommendations and favourite quizzes. 
 * Method List:
 * 
 * 
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class HomeMenuGUI extends JFrame implements MouseListener{
	private JTextField txtSearch;
	private JLabel lblSettings, lblCreate, lblLogout, lblCredits, lblStatistics, lblPic;


	public HomeMenuGUI() throws IOException {

		//http://stackoverflow.com/questions/8701716/how-to-remove-title-bar-in-jframe
		//Reference to remove title bar of the JFrame
		Data.accounts.loadFile("Players.txt");
		setContentPane (new JLabel(new ImageIcon ("Images/HomeMenuGUI.png")));
		setSize(500,700);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);



		lblCredits = new JLabel("Credits");
		lblCredits.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredits.setBounds(36, 446, 78, 16);
		getContentPane().add(lblCredits);

		lblLogout = new JLabel("Logout");
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setBounds(36, 495, 78, 16);
		getContentPane().add(lblLogout);
		lblLogout.addMouseListener(this);

		lblStatistics = new JLabel("Statistics");
		lblStatistics.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatistics.setBounds(36, 363, 78, 16);
		getContentPane().add(lblStatistics);

		lblPic = new JLabel(new ImageIcon(Data.accounts.getPic(Data.userName)));
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPic.setBounds(30, 30, 60, 60);
		getContentPane().add(lblPic);

		lblCreate = new JLabel("Create");
		lblCreate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreate.setBounds(32, 327, 78, 16);
		getContentPane().add(lblCreate);
		lblCreate.addMouseListener(this);

		JLabel lblHome = new JLabel("Home");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setBounds(36, 278, 78, 16);
		getContentPane().add(lblHome);

		txtSearch = new JTextField();
		txtSearch.setText("Search");
		txtSearch.setBounds(340, 6, 130, 26);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);

		JLabel lblRecents = new JLabel("Recents: ");
		lblRecents.setBounds(149, 95, 69, 16);
		getContentPane().add(lblRecents);

		JLabel lblFavourites = new JLabel("Favourites: ");
		lblFavourites.setBounds(149, 378, 92, 16);
		getContentPane().add(lblFavourites);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(149, 123, 90, 90);
		getContentPane().add(btnNewButton);

		JButton button = new JButton("New button");
		button.setBounds(261, 123, 90, 90);
		getContentPane().add(button);

		JButton button_1 = new JButton("New button");
		button_1.setBounds(374, 123, 90, 90);
		getContentPane().add(button_1);

		JButton button_2 = new JButton("New button");
		button_2.setBounds(149, 232, 90, 90);
		getContentPane().add(button_2);

		JButton button_3 = new JButton("New button");
		button_3.setBounds(261, 232, 90, 90);
		getContentPane().add(button_3);

		JButton button_4 = new JButton("New button");
		button_4.setBounds(374, 232, 90, 90);
		getContentPane().add(button_4);

		JButton button_5 = new JButton("New button");
		button_5.setBounds(149, 524, 90, 90);
		getContentPane().add(button_5);

		JButton button_6 = new JButton("New button");
		button_6.setBounds(261, 524, 90, 90);
		getContentPane().add(button_6);

		JButton button_7 = new JButton("New button");
		button_7.setBounds(374, 524, 90, 90);
		getContentPane().add(button_7);

		JButton button_8 = new JButton("New button");
		button_8.setBounds(374, 415, 90, 90);
		getContentPane().add(button_8);

		JButton button_9 = new JButton("New button");
		button_9.setBounds(261, 415, 90, 90);
		getContentPane().add(button_9);

		JButton button_10 = new JButton("New button");
		button_10.setBounds(149, 415, 90, 90);
		getContentPane().add(button_10);

		lblSettings = new JLabel("Settings");	
		lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettings.setBounds(36, 403, 78, 16);
		getContentPane().add(lblSettings);
		lblSettings.addMouseListener(this);

		JButton button_11 = new JButton("");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_11.setBounds(149, 6, 32, 26);
		getContentPane().add(button_11);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) throws IOException {
		HomeMenuGUI homeMenu = new HomeMenuGUI ();
	}

	public void mousePressed(MouseEvent e) {

		if(e.getSource() == lblSettings){
			try {
				new Settings();
				dispose();
			} catch (IOException e1) {
			}
		}
		else if(e.getSource() == lblLogout){
			try {
				new AccountLogin();
			} catch (IOException e1) {
			}
			dispose();
		}
		else if(e.getSource() == lblCreate){

			new TriviaCreationGUI();
			dispose();
		}
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


}