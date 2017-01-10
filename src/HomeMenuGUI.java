import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HomeMenuGUI extends JFrame {



	/**
	 * Create the frame.
	 */
	public HomeMenuGUI() {
		setSize(500,700);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	public static void main(String[] args) {
		HomeMenuGUI homeMenu = new HomeMenuGUI ();
	}

}
