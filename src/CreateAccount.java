import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//Author: Kevin Subhash

public class CreateAccount extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnLogin, btnClear1, btnClear2, btnClear3, btnClear4, btnCreateAccount; 
	private JTextField txtUserName; 
	private JLabel background, lblUserName, lblPassword, lblStatus;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JLabel lblPickAPicture;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;

	/**
	 * Create the frame.
	 */
	public CreateAccount() {
		
		super("Create Account");  // title for the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				btnClear3.setVisible(true);
			}
		});
		textField.setBounds(71, 191, 193, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				btnClear1.setVisible(true);
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(71, 124, 193, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				btnClear4.setVisible(true);
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(71, 259, 193, 20);
		getContentPane().add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				btnClear2.setVisible(true);
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(71, 63, 193, 20);
		getContentPane().add(textField_4);
		
		JLabel lblEnterAUsername = new JLabel("Enter a UserName");
		lblEnterAUsername.setBounds(71, 110, 193, 14);
		getContentPane().add(lblEnterAUsername);
		
		JLabel lblEnterYourName = new JLabel("Enter Your Name");
		lblEnterYourName.setBounds(71, 50, 193, 14);
		getContentPane().add(lblEnterYourName);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setBounds(71, 177, 193, 14);
		getContentPane().add(lblEnterPassword);
		
		JLabel lblComfirmPassword = new JLabel("Comfirm Password");
		lblComfirmPassword.setBounds(71, 244, 193, 14);
		getContentPane().add(lblComfirmPassword);
		
		btnCreateAccount = new JButton("Create Account!");
		btnCreateAccount.setBounds(96, 419, 144, 41);
		getContentPane().add(btnCreateAccount);
		btnCreateAccount.addActionListener(this);
		
		btnClear1 = new JButton("X");
		btnClear1.setBounds(284, 123, 50, 23);
		getContentPane().add(btnClear1);
		btnClear1.setVisible(false);
		btnClear1.addActionListener(this);
		
		btnClear2 = new JButton("X");
		btnClear2.setBounds(284, 62, 50, 23);
		getContentPane().add(btnClear2);
		btnClear2.setVisible(false);
		btnClear2.addActionListener(this);
		
		btnClear3 = new JButton("X");
		btnClear3.setBounds(284, 190, 50, 23);
		getContentPane().add(btnClear3);
		btnClear3.setVisible(false);
		btnClear3.addActionListener(this);
		
		btnClear4 = new JButton("X");
		btnClear4.setBounds(284, 258, 50, 23);
		getContentPane().add(btnClear4);
		
		lblPickAPicture = new JLabel("Select A Picture");
		lblPickAPicture.setBounds(127, 290, 127, 14);
		getContentPane().add(lblPickAPicture);
		
		label = new JLabel("New label");
		label.setIcon(new ImageIcon("p1.jpg"));
		label.setBounds(37, 337, 60, 60);
		getContentPane().add(label);
		
		label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon("p4.png"));
		label_1.setBounds(107, 337, 60, 60);
		getContentPane().add(label_1);
		
		label_2 = new JLabel("New label");
		label_2.setIcon(new ImageIcon("p3.jpg"));
		label_2.setBounds(177, 337, 60, 60);
		getContentPane().add(label_2);
		
		label_3 = new JLabel("New label");
		label_3.setIcon(new ImageIcon("p2.png"));
		label_3.setBounds(246, 337, 60, 60);
		getContentPane().add(label_3);
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBounds(56, 308, 28, 23);
		getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(127, 308, 28, 23);
		getContentPane().add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("");
		radioButton_2.setBounds(198, 308, 28, 23);
		getContentPane().add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("");
		radioButton_3.setBounds(266, 308, 28, 23);
		getContentPane().add(radioButton_3);
		btnClear4.setVisible(false);
		btnClear4.addActionListener(this);
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
			textField_4.setText("");
			btnClear2.setVisible(false);
		}
		if (e.getSource() == btnCreateAccount) {
			JOptionPane.showMessageDialog(null, "Account Created!");
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		CreateAccount createAccount = new CreateAccount();
		
	}
}
