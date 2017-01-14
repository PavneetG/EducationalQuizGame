import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Settings extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnChange1, btnChange2, btnChange3, btnChange4,btnConfirm; 
	private JLabel lblChange1, lblChange2, lblChange3, lblChange4;
	private JTextField textField, textField2, textField3, textField4;



	/**
	 * Create the application.
	 */
	public Settings() {
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

		
		
		
		
		
		
		

		
		
		
		
		setSize(350,500);
		setVisible(true);
		setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnChange1) {
			btnChange1.setVisible(false);
			btnChange2.setVisible(false);
			btnChange3.setVisible(false);
			btnChange4.setVisible(false);
		}
		if (e.getSource() == btnChange2) {
			btnChange1.setVisible(false);
			btnChange2.setVisible(false);
			btnChange3.setVisible(false);
			btnChange4.setVisible(false);
			textField.setVisible(true);
			lblChange1.setVisible(true);
			btnConfirm.setVisible(true);
		}
		if (e.getSource() == btnChange3) {
			btnChange1.setVisible(false);
			btnChange2.setVisible(false);
			btnChange3.setVisible(false);
			btnChange4.setVisible(false);
			textField4.setVisible(true);
			lblChange2.setVisible(true);
			btnConfirm.setVisible(true);
		}
		if (e.getSource() == btnChange4) {
			btnChange1.setVisible(false);
			btnChange2.setVisible(false);
			btnChange3.setVisible(false);
			btnChange4.setVisible(false);
			textField2.setVisible(true);
			textField3.setVisible(true);
			lblChange3.setVisible(true);
			lblChange4.setVisible(true);
			btnConfirm.setVisible(true);
		}
		if (e.getSource() == btnConfirm) {
			textField.setVisible(false);
			textField2.setVisible(false);
			textField3.setVisible(false);
			textField4.setVisible(false);
			lblChange1.setVisible(false);
			lblChange2.setVisible(false);
			lblChange3.setVisible(false);
			lblChange4.setVisible(false);
			btnConfirm.setVisible(false);
			btnChange1.setVisible(true);
			btnChange2.setVisible(true);
			btnChange3.setVisible(true);
			btnChange4.setVisible(true);		
		}

	}

	public static void main(String[] args) {
		Settings settings = new Settings();
	}
}
