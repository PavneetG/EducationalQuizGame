import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JMenuBar;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class AccountInformation extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	
	public AccountInformation() {
		getContentPane().setBackground(Color.CYAN);
		getContentPane().setForeground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,700);
		setLocationRelativeTo(null);
		
		JButton btnNewButton = new JButton("Change UserName");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(10, 244, 121, 43);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Change Name");
		button.setBackground(Color.WHITE);
		button.setBounds(10, 147, 121, 43);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setForeground(Color.BLACK);
		getContentPane().add(button);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBackground(Color.WHITE);
		btnChangePassword.setBounds(10, 347, 121, 43);
		btnChangePassword.setForeground(Color.BLACK);
		getContentPane().add(btnChangePassword);
		
		JButton btnChangePicture = new JButton("Change Picture");
		btnChangePicture.setBackground(Color.WHITE);
		btnChangePicture.setBounds(10, 440, 121, 49);
		btnChangePicture.setForeground(Color.BLACK);
		getContentPane().add(btnChangePicture);
		
		Label label = new Label("Account Information");
		label.setForeground(Color.WHITE);
		label.setBackground(new Color(0, 191, 255));
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Segoe UI", Font.BOLD, 17));
		label.setBounds(0, 0, 484, 43);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(151, 158, 213, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(151, 255, 213, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(151, 358, 213, 20);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(151, 455, 213, 20);
		getContentPane().add(textField_3);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setForeground(new Color(102, 51, 255));
		button_1.setBounds(10, 49, 81, 24);
		getContentPane().add(button_1);
		setVisible (true);
	}
	public static void main(String[] args) {
		AccountInformation accGUI = new AccountInformation ();
	}
}
