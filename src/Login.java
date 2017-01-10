/**
 * Author: Kevin & Pavneet
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
/**
 * @(#)SimpleGUI.java
 *
 *
 * @author 
 * @version 1.00 2014/11/7
 */

public class Login extends JFrame implements ActionListener{

	private JButton btnExit,btnLogin; 
	private JTextField userName; 
	private JLabel background;
	private JPasswordField password;

	/**
	 * Creates a new instance of SimpleGUI.
	 */
	public Login(){
		super("Login");  // title for the frame
		
		setSize(350,500);
		setLayout(null);

		btnExit = new JButton ("Exit");
		userName = new JTextField("");
		password= new JPasswordField(10);
		btnLogin = new JButton("Login");
		background = new JLabel (new ImageIcon ("pic3.jpg"));
		background.setBounds(0,0,350,500);


		btnExit.setBounds(90,340,75,40);
		userName.setBounds(70,230,200,25);
		password.setBounds(70,290,200,25);
		btnLogin.setBounds(170,340,75,40);

		add(userName);
		add(btnExit);
		add(btnLogin);
		add(password);
		add(background);

		setSize(350,500);
		setVisible(true);

		btnExit.addActionListener(this);
		btnLogin.addActionListener(this);
		password.addActionListener(this);
	}

	public boolean access(){
		if(userName.getText().equalsIgnoreCase("admin") && password.getText().equalsIgnoreCase("admin")){
			return true;
		}
		return false;
	}
	// method for actions events
	public void actionPerformed (ActionEvent e){

		if(e.getSource()==btnExit){

			System.exit(0);
		}
		else if(e.getSource()==btnLogin){
			if(access()==true){

				JOptionPane.showMessageDialog(null,"Success");
			}
			else{
				userName.setText("");
				password.setText("");
				JOptionPane.showMessageDialog(null,"Invalid username or password");
			}

		}

	}

	private static boolean isPasswordCorrect(char[] input) {

		String password ="Password"; 

		String userPass  = input.toString(); 

		if (userPass == password)
		{
			return true; 
		}
		return false; 

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Login sGUI = new Login();
	}
}

