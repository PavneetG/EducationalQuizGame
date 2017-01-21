import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//Author: Kevin Subhash

public class CreateAccount extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnLogin, btnClear1, btnClear2, btnClear3, btnClear4, btnCreateAccount; 
	private JRadioButton radioButton, radioButton_1, radioButton_2, radioButton_3;
	private JTextField txtUserName,textField,textField_1,textField_2,textField_3; 
	private JLabel lblPickAPicture,lblEnterAUsername,lblEnterYourName,lblEnterPassword,lblComfirmPassword,label,label_1,label_2,label_3,lblMatch,lblTaken,background, lblUserName, lblPassword, lblStatus;
	PlayerAccountList accounts = new PlayerAccountList(); 

	public CreateAccount() throws IOException {

		super("Create Account");  // title for the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		textField = new JTextField(10);
		textField_1 = new JTextField(10);
		textField_2 = new JTextField(10);
		textField_3 = new JTextField(10);

		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				btnClear3.setVisible(true);
			}
		});

		textField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				btnClear1.setVisible(true);
			}
		});

		textField_2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				btnClear4.setVisible(true);
			}
		});

		textField_3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				btnClear2.setVisible(true);
			}
		});

		textField.setBounds(71, 191, 193, 20);
		textField_1.setBounds(71, 124, 193, 20);
		textField_2.setBounds(71, 259, 193, 20);
		textField_3.setBounds(71, 63, 193, 20);

		getContentPane().add(textField);
		getContentPane().add(textField_1);
		getContentPane().add(textField_2);
		getContentPane().add(textField_3);	

		lblEnterAUsername = new JLabel("Enter a UserName");
		lblEnterYourName = new JLabel("Enter Your Name");
		lblEnterPassword = new JLabel("Enter Password");
		lblComfirmPassword = new JLabel("Comfirm Password");
		lblMatch = new JLabel("Passwords Do NOT Match.");
		lblTaken = new JLabel("UserName Already Taken.");
		lblPickAPicture = new JLabel("Select A Picture");
		label = new JLabel(new ImageIcon("p1.jpg"));
		label_1 = new JLabel(new ImageIcon("p4.png"));
		label_2 = new JLabel(new ImageIcon("p3.jpg"));
		label_3 = new JLabel(new ImageIcon("p2.png"));

		lblEnterAUsername.setBounds(71, 110, 193, 14);
		lblEnterYourName.setBounds(71, 50, 193, 14);
		lblEnterPassword.setBounds(71, 177, 193, 14);
		lblComfirmPassword.setBounds(71, 244, 193, 14);
		lblMatch.setBounds(96, 155, 153, 14);
		lblTaken.setBounds(103, 94, 137, 14);
		lblPickAPicture.setBounds(127, 290, 127, 14);
		label.setBounds(37, 337, 60, 60);
		label_1.setBounds(107, 337, 60, 60);
		label_2.setBounds(177, 337, 60, 60);
		label_3.setBounds(246, 337, 60, 60);

		getContentPane().add(lblEnterAUsername);
		getContentPane().add(lblEnterYourName);
		getContentPane().add(lblEnterPassword);
		getContentPane().add(lblComfirmPassword);
		getContentPane().add(lblMatch);
		getContentPane().add(lblTaken);
		getContentPane().add(lblPickAPicture);
		getContentPane().add(label);
		getContentPane().add(label_1);
		getContentPane().add(label_2);
		getContentPane().add(label_3);

		lblMatch.setVisible(false);
		lblTaken.setVisible(false);





		btnCreateAccount = new JButton("Create Account!");
		btnClear1 = new JButton("X");
		btnClear2 = new JButton("X");
		btnClear3 = new JButton("X");
		btnClear4 = new JButton("X");

		btnCreateAccount.setBounds(96, 419, 144, 41);
		btnClear1.setBounds(284, 123, 50, 23);
		btnClear2.setBounds(284, 62, 50, 23);
		btnClear3.setBounds(284, 190, 50, 23);
		btnClear4.setBounds(284, 258, 50, 23);

		getContentPane().add(btnCreateAccount);
		getContentPane().add(btnClear1);
		getContentPane().add(btnClear2);
		getContentPane().add(btnClear3);
		getContentPane().add(btnClear4);

		btnClear1.setVisible(false);	
		btnClear2.setVisible(false);
		btnClear3.setVisible(false);
		btnClear4.setVisible(false);

		btnCreateAccount.addActionListener(this);
		btnClear1.addActionListener(this);
		btnClear2.addActionListener(this);
		btnClear3.addActionListener(this);
		btnClear4.addActionListener(this);

		radioButton = new JRadioButton();
		radioButton_1 = new JRadioButton();
		radioButton_2 = new JRadioButton();
		radioButton_3 = new JRadioButton();

		radioButton.setBounds(56, 308, 28, 23);
		radioButton_1.setBounds(127, 308, 28, 23);
		radioButton_2.setBounds(198, 308, 28, 23);
		radioButton_3.setBounds(266, 308, 28, 23);

		getContentPane().add(radioButton);
		getContentPane().add(radioButton_1);
		getContentPane().add(radioButton_2);
		getContentPane().add(radioButton_3);

		radioButton.addActionListener(this);
		radioButton_1.addActionListener(this);
		radioButton_2.addActionListener(this);
		radioButton_3.addActionListener(this);

		accounts.loadFile("Players.txt");

		setSize(350,500);
		setVisible(true);
		setResizable(false);
	}

	public void actionPerformed (ActionEvent e){
		if (e.getSource() == btnClear1) {
			textField_1.setText("");
			btnClear1.setVisible(false);
		}
		if (e.getSource() == btnClear4) {
			textField_2.setText("");
			btnClear4.setVisible(false);
		}
		if (e.getSource() == btnClear3) {
			textField.setText("");
			btnClear3.setVisible(false);
		}
		if (e.getSource() == btnClear2) {
			textField_3.setText("");
			btnClear2.setVisible(false);
		}
		if (e.getSource() == radioButton){
			radioButton_1.setSelected(false);
			radioButton_2.setSelected(false);
			radioButton_3.setSelected(false);
		}
		if (e.getSource() == radioButton_1){
			radioButton.setSelected(false);
			radioButton_2.setSelected(false);
			radioButton_3.setSelected(false);
		}
		if (e.getSource() == radioButton_2){
			radioButton_1.setSelected(false);
			radioButton.setSelected(false);
			radioButton_3.setSelected(false);
		}
		if (e.getSource() == radioButton_3){
			radioButton_1.setSelected(false);
			radioButton_2.setSelected(false);
			radioButton.setSelected(false);
		}
		if (e.getSource() == btnCreateAccount) {
			String info;
			String password = null;
			String pic = null;
			String name = textField_3.getText();
			String userName = textField_1.getText();

			if(textField.getText().equals(textField_2.getText())){
				password = textField.getText();
			}

			if(radioButton.isSelected()){
				pic = "p1.jpg";
			}
			else if (radioButton_1.isSelected()){
				pic = "p2.png";
			}
			else if (radioButton_2.isSelected()){
				pic = "p3.jpg";
			}
			else if (radioButton_3.isSelected()){
				pic = "p4.png";
			}

			if(textField_3.getText().equals("")||textField_1.getText().equals("")||textField.getText().equals("")||textField_2.getText().equals("") ){
				JOptionPane.showMessageDialog(null, "Please fill in all the Fields.");
			}
			else if(!accounts.checkUserName(textField_1.getText())){
				JOptionPane.showMessageDialog(null, "Passwords Do Not Match");
			}
			else if(pic == null){
				JOptionPane.showMessageDialog(null, "Select a Picture.");
			}
			else if(textField.getText().equals(textField_2.getText()) == false){
				JOptionPane.showMessageDialog(null, "Passwords Do Not Match");
			}
			else{
				info = name + "," + userName + "," + password + "," + pic;

				Player playerInfo = new Player(info);
				accounts.insert(playerInfo);
				try {
					accounts.writeFile("Players.txt");
				} catch (IOException e1) {
				}
				new AccountLogin();
				dispose();
			}
		}
	}

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		CreateAccount createAccount = new CreateAccount();

	}
}
