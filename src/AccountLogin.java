import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AccountLogin extends JFrame implements ActionListener {
	private JButton btnLogin, btnClear1, btnClear2; 
	private JTextField txtUserName; 
	private JLabel background, lblUserName, lblPassword, lblStatus;
	private JPasswordField passwordField;
	private int tries = 0; 
	private String password = "admin", userName = "admin";
	private JLabel lblCreateAccount;


	public AccountLogin() {
		super("Login");  // title for the frame

		setSize(350,500);
		getContentPane().setLayout(null);
		txtUserName = new JTextField("");
		txtUserName.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				btnClear2.setVisible(true);
			}
		});
		passwordField= new JPasswordField(10);
		passwordField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent key) {
				if (key.getKeyCode() == KeyEvent.VK_ENTER) { 
					if(access()==true && tries < 5) {
						JOptionPane.showMessageDialog(null,"Success");
						lblStatus.setText("");
					}
					else{
						txtUserName.setText("");
						passwordField.setText("");
						lblStatus.setText("Invalid username or password");
						tries ++;
						btnClear1.setVisible(false);
						btnClear2.setVisible(false);

						if (tries >=3) {
							lblStatus.setText("Too many attempts");
							btnLogin.setEnabled(false);
						}
					}
				}
			}
			public void keyTyped(KeyEvent arg0) {
				btnClear1.setVisible(true);
			}
		});
		btnLogin = new JButton("Login");
		background = new JLabel (new ImageIcon ("pic3.jpg"));
		background.setBounds(0,0,334,462);
		txtUserName.setBounds(70,230,200,25);
		passwordField.setBounds(70,290,200,25);
		btnLogin.setBounds(131,340,75,40);

		getContentPane().add(txtUserName);
		getContentPane().add(btnLogin);
		getContentPane().add(passwordField);
		//add(background);

		lblUserName = new JLabel("User Name");
		lblUserName.setBounds(70, 213, 84, 14);
		getContentPane().add(lblUserName);

		lblPassword = new JLabel("Password");
		lblPassword.setBounds(70, 276, 84, 14);
		getContentPane().add(lblPassword);

		lblStatus = new JLabel("");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(58, 186, 217, 14);
		getContentPane().add(lblStatus);

		lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "Slithering Jonathan");
			}
		});
		lblCreateAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAccount.setBounds(53, 419, 217, 14);
		getContentPane().add(lblCreateAccount);

		btnClear1 = new JButton("X");
		btnClear1.setBounds(280, 291, 44, 23);
		getContentPane().add(btnClear1);
		btnClear1.setVisible(false);
		btnClear1.addActionListener(this);
		
		btnClear2 = new JButton("X");
		btnClear2.setBounds(280, 231, 44, 23);
		getContentPane().add(btnClear2);
		btnClear2.setVisible(false);
		btnClear2.addActionListener(this);


		setSize(350,500);
		setVisible(true);
		btnLogin.addActionListener(this);
		passwordField.addActionListener(this);
	}
	public boolean access(){
		if(txtUserName.getText().equalsIgnoreCase(userName) && passwordField.getText().equalsIgnoreCase(password)){
			return true;
		}
		return false;
	}
	//method for actions events
	public void actionPerformed (ActionEvent e){
		if (e.getSource() == btnClear2) {
			txtUserName.setText("");
			btnClear2.setVisible(false);
		}
		if (e.getSource() == btnClear1) {
			passwordField.setText("");
			btnClear1.setVisible(false);
		}
		if(e.getSource()==btnLogin){
			if(access()==true && tries < 5) {
				JOptionPane.showMessageDialog(null,"Success");
				lblStatus.setText("");
			}
			else{
				txtUserName.setText("");
				passwordField.setText("");
				lblStatus.setText("Invalid username or password");
				tries ++;
				btnClear1.setVisible(false);
				btnClear2.setVisible(false);


				if (tries >=3) {
					lblStatus.setText("Too many attempts");
					btnLogin.setEnabled(false);
				}
			}
		}
	}
	//getter methods
	public String getPassword() {
		return password;
	}
	public String getUserName() {
		return userName;
	}
	//setter methods
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public static void main(String[] args) {
		AccountLogin accountLogin = new AccountLogin();
	}
}
