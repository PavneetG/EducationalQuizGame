import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Settings extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnChange1, btnChange2, btnChange3, btnChange4,btnConfirm,btnConfirm2,btnConfirm3,btnConfirm4,btnBack, btnVerifyLogin, btnCancel; // declared variables as JButtons
	private JLabel lblChange1, lblChange2, lblChange3, lblChange4, label, label_1, label_2, label_3, lblPass, lblUserName, lblPassword, lblTaken, lblEmptyBox; // declared variables as JLabels
	private JTextField textField, textField2, textField3, textField4, usernameField; // declared variables as JTextField
	private JRadioButton radioButton, radioButton_1, radioButton_2, radioButton_3; // declared variables as JRadioButton
	private String name, userName, password, picName; // declared variables as String
	private JPasswordField passwordField; // declared variable as JPasswordField
	PlayerAccountList accounts = new PlayerAccountList();  // created PlayerAccountList object
	Player newInfo, oldInfo; // declared variables as Player

	public Settings() throws IOException {
		super("Settings");  // title for the frame

		accounts.loadFile("Players.txt");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		btnChange1 = new JButton("Change Picture");
		btnChange2 = new JButton("Change Name");
		btnChange3 = new JButton("Change UserName");
		btnChange4 = new JButton("Change Password");
		btnConfirm = new JButton("Confirm");
		btnConfirm2 = new JButton("Confirm");
		btnConfirm3 = new JButton("Confirm");
		btnConfirm4 = new JButton("Confirm");
		btnCancel = new JButton("Cancel");
		btnVerifyLogin = new JButton("Verify Login");
		btnBack = new JButton("Back");
			
		btnChange1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnChange2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnChange3.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnChange4.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnConfirm.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnConfirm2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnConfirm3.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnConfirm4.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnCancel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnVerifyLogin.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		
		
		btnChange1.setBounds(10, 251, 184, 38);
		btnChange2.setBounds(10, 300, 184, 38);
		btnChange3.setBounds(10, 349, 184, 38);
		btnChange4.setBounds(10, 398, 184, 38);
		btnConfirm.setBounds(10, 349, 184, 38);
		btnConfirm2.setBounds(10, 349, 184, 38);
		btnConfirm3.setBounds(10, 349, 184, 38);
		btnConfirm4.setBounds(10, 349, 184, 38);
		btnCancel.setBounds(10, 398, 184, 38);
		btnVerifyLogin.setBounds(76, 269, 184, 38);
		btnBack.setBounds(10, 11, 89, 23);
		
		//getContentPane().add(btnBack);
		btnBack.setVisible(false);
		btnBack.addActionListener(this);
		
		
		getContentPane().add(btnCancel);
		btnCancel.setVisible(false);
		btnCancel.addActionListener(this);
		
		
		getContentPane().add(btnVerifyLogin);
		btnVerifyLogin.addActionListener(this);
		
		
		getContentPane().add(btnChange1);
		btnChange1.setVisible(false);
		btnChange1.addActionListener(this);

		
		getContentPane().add(btnChange2);
		btnChange2.addActionListener(this);
		btnChange2.setVisible(false);

		getContentPane().add(btnChange3);
		btnChange3.addActionListener(this);
		btnChange3.setVisible(false);
		
		getContentPane().add(btnChange4);
		btnChange4.addActionListener(this);
		btnChange4.setVisible(false);

		getContentPane().add(btnConfirm);
		btnConfirm.addActionListener(this);
		btnConfirm.setVisible(false);

		getContentPane().add(btnConfirm2);
		btnConfirm2.addActionListener(this);
		btnConfirm2.setVisible(false);

		getContentPane().add(btnConfirm3);
		btnConfirm3.addActionListener(this);
		btnConfirm3.setVisible(false);
		
		getContentPane().add(btnConfirm4);
		btnConfirm4.addActionListener(this);
		btnConfirm4.setVisible(false);

		textField = new JTextField();
		textField.setBounds(10, 318, 184, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.setVisible(false);

		lblChange1 = new JLabel("Enter New Name");
		lblChange1.setBounds(10, 300, 153, 14);
		getContentPane().add(lblChange1);
		lblChange1.setVisible(false);

		lblChange2 = new JLabel("Enter New UserName");
		lblChange2.setBounds(10, 300, 153, 14);
		getContentPane().add(lblChange2);
		lblChange2.setVisible(false);

		textField2 = new JTextField();
		textField2.setBounds(10, 269, 184, 20);
		getContentPane().add(textField2);
		textField2.setColumns(10);
		textField2.setVisible(false);

		textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setBounds(10, 318, 184, 20);
		getContentPane().add(textField3);
		textField3.setVisible(false);

		lblChange3 = new JLabel("Enter New Password");
		lblChange3.setBounds(10, 256, 132, 14);
		getContentPane().add(lblChange3);
		lblChange3.setVisible(false);

		lblChange4 = new JLabel("Confirm Password");
		lblChange4.setBounds(10, 300, 121, 14);
		getContentPane().add(lblChange4);
		lblChange4.setVisible(false);

		textField4 = new JTextField();
		textField4.setBounds(10, 318, 184, 20);
		getContentPane().add(textField4);
		textField4.setColumns(10);
		textField4.setVisible(false);

		label = new JLabel("");
		label.setIcon(new ImageIcon("p1.jpg"));
		label.setBounds(37, 280, 60, 60);
		getContentPane().add(label);
		label.setVisible(false);

		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("p4.png"));
		label_1.setBounds(107, 280, 60, 60);
		getContentPane().add(label_1);
		label_1.setVisible(false);

		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("p3.jpg"));
		label_2.setBounds(177, 280, 60, 60);
		getContentPane().add(label_2);
		label_2.setVisible(false);

		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("p2.png"));
		label_3.setBounds(246, 280, 60, 60);
		getContentPane().add(label_3);
		label_3.setVisible(false);

		radioButton = new JRadioButton("");
		radioButton.setBounds(56, 250, 28, 23);
		getContentPane().add(radioButton);
		radioButton.setVisible(false);
		radioButton.addActionListener(this);

		radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(127, 250, 28, 23);
		getContentPane().add(radioButton_1);
		radioButton_1.setVisible(false);
		radioButton_1.addActionListener(this);

		radioButton_2 = new JRadioButton("");
		radioButton_2.setBounds(198, 250, 28, 23);
		getContentPane().add(radioButton_2);
		radioButton_2.setVisible(false);
		radioButton_2.addActionListener(this);

		radioButton_3 = new JRadioButton("");
		radioButton_3.setBounds(266, 250, 28, 23);
		getContentPane().add(radioButton_3);
		radioButton_3.setVisible(false);
		radioButton_3.addActionListener(this);

		lblEmptyBox = new JLabel("Fill in the Field(s).");
		lblEmptyBox.setBounds(50, 281, 161, 14);
		getContentPane().add(lblEmptyBox);
		lblEmptyBox.setVisible(false);

		lblPass = new JLabel("Password DO NOT Match.");
		lblPass.setBounds(50, 235, 161, 14);
		getContentPane().add(lblPass);
		lblPass.setVisible(false);

		

		usernameField = new JTextField();
		usernameField.setBounds(91, 165, 153, 20);
		getContentPane().add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(91, 220, 153, 20);
		getContentPane().add(passwordField);

		lblUserName = new JLabel("User Name");
		lblUserName.setBounds(91, 149, 83, 14);
		getContentPane().add(lblUserName);

		lblPassword = new JLabel("Password");
		lblPassword.setBounds(91, 205, 83, 14);
		getContentPane().add(lblPassword);

		

		lblTaken = new JLabel("UserName Taken Already.");
		lblTaken.setBounds(37, 275, 189, 14);
		getContentPane().add(lblTaken);
		lblTaken.setVisible(false);

		

		setSize(350,500);
		setVisible(true);
		setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnBack){
			if(accounts.change(oldInfo, newInfo)){ // when the information is changed, it saves to the file
				try {
					accounts.writeFile("Players.txt");
				} catch (IOException e1) {
				}
			}
			new HomeMenuGUI();
			dispose();
		}
		if(e.getSource() == btnVerifyLogin){
			if(accounts.checkLogin(usernameField.getText(), passwordField.getText())){
				userName = usernameField.getText(); // setting variables to the pre-existing player information
				password = passwordField.getText();
				picName = accounts.getPic(userName);
				name = accounts.getName(userName);
				oldInfo = new Player(name, userName, password, picName);
				/*
				 * Setting visibility of buttons, labels, and textfields 
				 * to either true or false
				 */
				btnBack.setVisible(true);
				btnChange1.setVisible(true);
				btnChange2.setVisible(true);
				btnChange3.setVisible(true);
				btnChange4.setVisible(true);
				usernameField.setVisible(false);
				passwordField.setVisible(false);
				lblUserName.setVisible(false);
				lblPassword.setVisible(false);
				btnVerifyLogin.setVisible(false);
			}
			else{
				JOptionPane.showMessageDialog(null, "Incorrect UserName/Password or the Account does not exist.");
			}
		}
		if (e.getSource() == btnChange1) {
			/*
			 * Setting visibility of buttons, labels, and textfields 
			 * to either true or false
			 */
			btnChange1.setVisible(false);
			btnChange2.setVisible(false);
			btnChange3.setVisible(false);
			btnChange4.setVisible(false);
			btnBack.setVisible(false);
			radioButton.setVisible(true);
			radioButton_1.setVisible(true);
			radioButton_2.setVisible(true);
			radioButton_3.setVisible(true);
			label.setVisible(true);
			label_1.setVisible(true);
			label_2.setVisible(true);
			label_3.setVisible(true);
			radioButton.setSelected(true);
			radioButton_1.setSelected(false);
			radioButton_2.setSelected(false);
			radioButton_3.setSelected(false);
			btnConfirm.setVisible(true);
			btnCancel.setVisible(true);

		}
		if (e.getSource() == btnChange2) {
			/*
			 * Setting visibility of buttons, labels, and textfields 
			 * to either true or false
			 */
			btnChange1.setVisible(false);
			btnChange2.setVisible(false);
			btnChange3.setVisible(false);
			btnChange4.setVisible(false);
			btnBack.setVisible(false);
			textField.setVisible(true);
			lblChange1.setVisible(true);
			btnConfirm2.setVisible(true);
			btnCancel.setVisible(true);
		}
		if (e.getSource() == btnChange3) {
			/*
			 * Setting visibility of buttons, labels, and textfields 
			 * to either true or false
			 */
			btnChange1.setVisible(false);
			btnChange2.setVisible(false);
			btnChange3.setVisible(false);
			btnChange4.setVisible(false);
			btnBack.setVisible(false);
			textField4.setVisible(true);
			lblChange2.setVisible(true);
			btnConfirm3.setVisible(true);
			btnCancel.setVisible(true);
		}
		if (e.getSource() == btnChange4) {
			/*
			 * Setting visibility of buttons, labels, and textfields 
			 * to either true or false
			 */
			btnChange1.setVisible(false);
			btnChange2.setVisible(false);
			btnChange3.setVisible(false);
			btnChange4.setVisible(false);
			btnBack.setVisible(false);
			textField2.setVisible(true);
			textField3.setVisible(true);
			lblChange3.setVisible(true);
			lblChange4.setVisible(true);
			btnConfirm4.setVisible(true);
			btnCancel.setVisible(true);
		}
		/*
		 * Radiobuttons are set to selected false when radioButton
		 * is selected
		 */
		if (e.getSource() == radioButton) {
			radioButton_1.setSelected(false);
			radioButton_2.setSelected(false);
			radioButton_3.setSelected(false);
		}
		/*
		 * Radiobuttons are set to selected false when radioButton_1
		 * is selected
		 */
		if (e.getSource() == radioButton_1) {
			radioButton.setSelected(false);
			radioButton_2.setSelected(false);
			radioButton_3.setSelected(false);
		}
		/*
		 * Radiobuttons are set to selected false when radioButton_2
		 * is selected
		 */
		if (e.getSource() == radioButton_2) {
			radioButton_1.setSelected(false);
			radioButton.setSelected(false);
			radioButton_3.setSelected(false);
		}
		/*
		 * Radiobuttons are set to selected false when radioButton_3
		 * is selected
		 */
		if (e.getSource() == radioButton_3) {
			radioButton_1.setSelected(false);
			radioButton_2.setSelected(false);
			radioButton.setSelected(false);
		}
		if (e.getSource() == btnConfirm) {
			
			/*
			 * When a specific radiobutton is selcted, it will
			 * set the picName to the picture's name
			 */

			if(radioButton.isSelected()){
				picName = "p1.jpg";
			}
			else if(radioButton_1.isSelected()){
				picName = "p2.png";
			}
			else if(radioButton_1.isSelected()){
				picName = "p3.jpg";
			}
			else if(radioButton_1.isSelected()){
				picName = "p4.png";
			}
			else{
				picName = "p1,jpg";
				JOptionPane.showMessageDialog(null, "Picture was set to Default");
			}
			/*
			 * Setting visibility of buttons, labels, and textfields 
			 * to either true or false
			 */
			btnChange1.setVisible(true);
			btnChange2.setVisible(true);
			btnChange3.setVisible(true);
			btnChange4.setVisible(true);
			btnBack.setVisible(true);
			radioButton.setVisible(false);
			radioButton_1.setVisible(false);
			radioButton_2.setVisible(false);
			radioButton_3.setVisible(false);
			label.setVisible(false);
			label_1.setVisible(false);
			label_2.setVisible(false);
			label_3.setVisible(false);
			btnConfirm.setVisible(false);


		}
		if (e.getSource() == btnConfirm2) {
			if(textField.getText().equals("")){
				lblEmptyBox.setVisible(true); // setting lblEmptyBox visible to true when textfield is empty
			}
			else{
				name = textField.getText();
				/*
				 * Setting visibility of buttons, labels, and textfields 
				 * to either true or false
				 */
				btnChange1.setVisible(true);
				btnChange2.setVisible(true);
				btnChange3.setVisible(true);
				btnChange4.setVisible(true);
				btnBack.setVisible(true);
				textField.setVisible(false);
				lblEmptyBox.setVisible(false);
				lblChange1.setVisible(false);
				btnConfirm2.setVisible(false);
			}

		}
		if (e.getSource() == btnConfirm3) { 
			if(textField4.getText().equals("")){ // checking if textfield is empty
				lblTaken.setVisible(false); // setting lblTaken visible to false
				lblEmptyBox.setVisible(true); // setting lblEmptyBox visible to true
			}
			else if(!accounts.checkUserName(textField4.getText())){ // checking if username exists already
				lblEmptyBox.setVisible(false); // making label visible false
				lblTaken.setVisible(true); // making label visible true
			}
			else{

				userName = textField4.getText(); // userName hold text in textField4
				/*
				 * Setting visibility of buttons, labels, and textfields 
				 * to either true or false
				 */
				lblEmptyBox.setVisible(false);
				lblTaken.setVisible(false);
				btnChange1.setVisible(true);
				btnChange2.setVisible(true);
				btnChange3.setVisible(true);
				btnChange4.setVisible(true);
				btnBack.setVisible(true);
				textField4.setVisible(false);
				lblEmptyBox.setVisible(false);
				lblChange2.setVisible(false);
				btnConfirm3.setVisible(false);
			}
		}
		if (e.getSource() == btnConfirm4) {
			if(textField2.getText().equals("") || textField3.getText().equals("")){ // checking if textfields are filled
				lblEmptyBox.setBounds(50, 235, 161, 14); // moving label to new location and making it visible
				lblPass.setVisible(false); // making labelPass visible false
				lblEmptyBox.setVisible(true);
			}
			else if(textField2.getText().equals(textField3.getText()) == false){ // checking if text in both textfields are not the same
				lblEmptyBox.setVisible(false); // setting lblEmptyBox visible to false
				lblPass.setVisible(true); // setting lblPass visible to true
			}
			else{

				password = textField2.getText(); // password hold the text in textField2
				/*
				 * Setting visibility of buttons, labels, and textfields 
				 * to either true or false
				 */
				lblEmptyBox.setBounds(50, 281, 161, 14); // setting label to original location
				btnChange1.setVisible(true);
				btnChange2.setVisible(true);
				btnChange3.setVisible(true);
				btnChange4.setVisible(true);
				btnBack.setVisible(true);
				textField2.setVisible(false);
				textField3.setVisible(false);
				lblChange3.setVisible(false);
				lblChange4.setVisible(false);
				lblEmptyBox.setVisible(false);
				lblPass.setVisible(false);
				btnConfirm4.setVisible(false);
			}

		}
		if (e.getSource() == btnCancel) {
			/*
			 * Setting visibility of buttons, labels, and textfields 
			 * to either true or false
			 */
			btnChange1.setVisible(true); 
			btnChange2.setVisible(true);
			btnChange3.setVisible(true);
			btnChange4.setVisible(true);
			btnBack.setVisible(true);
			btnCancel.setVisible(false);
			radioButton.setVisible(false);
			radioButton_1.setVisible(false);
			radioButton_2.setVisible(false);
			radioButton_3.setVisible(false);
			label.setVisible(false);
			label_1.setVisible(false);
			label_2.setVisible(false);
			label_3.setVisible(false);
			btnConfirm.setVisible(false);
			textField.setVisible(false);
			lblEmptyBox.setVisible(false);
			lblChange1.setVisible(false);
			btnConfirm2.setVisible(false);
			textField4.setVisible(false);
			lblEmptyBox.setVisible(false);
			lblChange2.setVisible(false);
			btnConfirm3.setVisible(false);
			textField2.setVisible(false);
			textField3.setVisible(false);
			lblChange3.setVisible(false);
			lblChange4.setVisible(false);
			lblEmptyBox.setVisible(false);
			lblPass.setVisible(false);
			btnConfirm4.setVisible(false);


		}

		newInfo = new Player(name, userName, password, picName);
	}

	public static void main(String[] args) throws IOException {
		Settings settings = new Settings();
	}
}
