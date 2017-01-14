import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Settings extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnLogin, btnClear1, btnClear2, btnClear3, btnClear4, btnCreateAccount; 
	private JTextField txtUserName; 
	private JLabel background, lblUserName, lblPassword, lblStatus;

	/**
	 * Create the application.
	 */
	public Settings() {
		super("Settings");  // title for the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblChangeName = new JLabel("Change UserName");
		lblChangeName.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 15));
		lblChangeName.setBounds(0, 285, 250, 51);
		getContentPane().add(lblChangeName);
		
		JLabel label = new JLabel("Change Name");
		label.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 15));
		label.setBounds(0, 219, 205, 51);
		getContentPane().add(label);
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 15));
		lblChangePassword.setBounds(0, 347, 271, 51);
		getContentPane().add(lblChangePassword);
		
		JLabel lblChangePic = new JLabel("Change Pic");
		lblChangePic.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 15));
		lblChangePic.setBounds(0, 409, 271, 51);
		getContentPane().add(lblChangePic);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		setSize(350,500);
		setVisible(true);
		setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		Settings settings = new Settings();
	}
}
