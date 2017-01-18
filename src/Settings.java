import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Settings extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnChange1, btnChange2, btnChange3, btnChange4,btnConfirm,btnConfirm2,btnConfirm3,btnConfirm4,btnBack; 
	private JLabel lblChange1, lblChange2, lblChange3, lblChange4, label, label_1, label_2, label_3, lblPass;
	private JTextField textField, textField2, textField3, textField4;
	private JRadioButton radioButton, radioButton_1, radioButton_2, radioButton_3;
	private String name, userName, password, picName;
	private JLabel lblFillInThe;
	PlayerList accounts = new PlayerList(); 



	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Settings() throws IOException {
		super("Settings");  // title for the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		btnChange1 = new JButton("Change Picture");
		btnChange1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnChange1.setBounds(10, 251, 184, 38);
		getContentPane().add(btnChange1);
		btnChange1.addActionListener(this);

		btnChange2 = new JButton("Change Name");
		btnChange2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnChange2.setBounds(10, 300, 184, 38);
		getContentPane().add(btnChange2);
		btnChange2.addActionListener(this);

		btnChange3 = new JButton("Change UserName");
		btnChange3.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnChange3.setBounds(10, 349, 184, 38);
		getContentPane().add(btnChange3);
		btnChange3.addActionListener(this);

		btnChange4 = new JButton("Change Password");
		btnChange4.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnChange4.setBounds(10, 398, 184, 38);
		getContentPane().add(btnChange4);
		btnChange4.addActionListener(this);

		btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnConfirm.setBounds(10, 349, 184, 38);
		getContentPane().add(btnConfirm);
		btnConfirm.addActionListener(this);
		btnConfirm.setVisible(false);

		btnConfirm2 = new JButton("Confirm");
		btnConfirm2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnConfirm2.setBounds(10, 349, 184, 38);
		getContentPane().add(btnConfirm2);
		btnConfirm2.addActionListener(this);
		btnConfirm2.setVisible(false);

		btnConfirm3 = new JButton("Confirm");
		btnConfirm3.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnConfirm3.setBounds(10, 349, 184, 38);
		getContentPane().add(btnConfirm3);
		btnConfirm3.addActionListener(this);
		btnConfirm3.setVisible(false);

		btnConfirm4 = new JButton("Confirm");
		btnConfirm4.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnConfirm4.setBounds(10, 349, 184, 38);
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

		label = new JLabel("New label");
		label.setIcon(new ImageIcon("p1.jpg"));
		label.setBounds(37, 280, 60, 60);
		getContentPane().add(label);
		label.setVisible(false);

		label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon("p4.png"));
		label_1.setBounds(107, 280, 60, 60);
		getContentPane().add(label_1);
		label_1.setVisible(false);

		label_2 = new JLabel("New label");
		label_2.setIcon(new ImageIcon("p3.jpg"));
		label_2.setBounds(177, 280, 60, 60);
		getContentPane().add(label_2);
		label_2.setVisible(false);

		label_3 = new JLabel("New label");
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

		lblFillInThe = new JLabel("Fill in the Field(s).");
		lblFillInThe.setBounds(50, 281, 161, 14);
		getContentPane().add(lblFillInThe);
		lblFillInThe.setVisible(false);

		lblPass = new JLabel("Password DO NOT Match.");
		lblPass.setBounds(50, 235, 161, 14);
		getContentPane().add(lblPass);
		lblPass.setVisible(false);

		btnBack = new JButton("Back");
		btnBack.setBounds(10, 11, 89, 23);
		getContentPane().add(btnBack);
		btnBack.setVisible(true);
		btnBack.addActionListener(this);

		accounts.loadFile("Players.txt");













		setSize(350,500);
		setVisible(true);
		setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnBack){
			new HomeMenuGUI();
			dispose();
		}
		if (e.getSource() == btnChange1) {
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

		}
		if (e.getSource() == btnChange2) {
			btnChange1.setVisible(false);
			btnChange2.setVisible(false);
			btnChange3.setVisible(false);
			btnChange4.setVisible(false);
			btnBack.setVisible(false);
			textField.setVisible(true);
			lblChange1.setVisible(true);
			btnConfirm2.setVisible(true);
		}
		if (e.getSource() == btnChange3) {
			btnChange1.setVisible(false);
			btnChange2.setVisible(false);
			btnChange3.setVisible(false);
			btnChange4.setVisible(false);
			btnBack.setVisible(false);
			textField4.setVisible(true);
			lblChange2.setVisible(true);
			btnConfirm3.setVisible(true);
		}
		if (e.getSource() == btnChange4) {
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
		}
		if (e.getSource() == radioButton) {
			radioButton_1.setSelected(false);
			radioButton_2.setSelected(false);
			radioButton_3.setSelected(false);
		}
		if (e.getSource() == radioButton_1) {
			radioButton.setSelected(false);
			radioButton_2.setSelected(false);
			radioButton_3.setSelected(false);
		}
		if (e.getSource() == radioButton_2) {
			radioButton_1.setSelected(false);
			radioButton.setSelected(false);
			radioButton_3.setSelected(false);
		}
		if (e.getSource() == radioButton_3) {
			radioButton_1.setSelected(false);
			radioButton_2.setSelected(false);
			radioButton.setSelected(false);
		}
		if (e.getSource() == btnConfirm) {

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
				lblFillInThe.setVisible(true);
			}
			else{
				name = textField.getText();
				btnChange1.setVisible(true);
				btnChange2.setVisible(true);
				btnChange3.setVisible(true);
				btnChange4.setVisible(true);
				btnBack.setVisible(true);
				textField.setVisible(false);
				lblFillInThe.setVisible(false);
				lblChange1.setVisible(false);
				btnConfirm2.setVisible(false);
			}

		}
		if (e.getSource() == btnConfirm3) {
			if(textField4.getText().equals("")){
				lblFillInThe.setVisible(true);
			}
			else{
				userName = textField4.getText();

				btnChange1.setVisible(true);
				btnChange2.setVisible(true);
				btnChange3.setVisible(true);
				btnChange4.setVisible(true);
				btnBack.setVisible(true);
				textField4.setVisible(false);
				lblFillInThe.setVisible(false);
				lblChange2.setVisible(false);
				btnConfirm3.setVisible(false);
			}
		}
		if (e.getSource() == btnConfirm4) {
			if(textField2.getText().equals("") || textField3.getText().equals("")){
				lblFillInThe.setBounds(50, 235, 161, 14);
				lblPass.setVisible(false);
				lblFillInThe.setVisible(true);
			}
			else if(textField2.getText().equals(textField3.getText()) == false){		
				lblFillInThe.setVisible(false);
				lblPass.setVisible(true);
			}
			else{
				password = textField2.getText();

				lblFillInThe.setBounds(50, 281, 161, 14);
				btnChange1.setVisible(true);
				btnChange2.setVisible(true);
				btnChange3.setVisible(true);
				btnChange4.setVisible(true);
				btnBack.setVisible(true);
				textField2.setVisible(false);
				textField3.setVisible(false);
				lblChange3.setVisible(false);
				lblChange4.setVisible(false);
				lblFillInThe.setVisible(false);
				lblPass.setVisible(false);
				btnConfirm4.setVisible(false);
			}

		}
	}

	public static void main(String[] args) throws IOException {
		Settings settings = new Settings();
	}
}
