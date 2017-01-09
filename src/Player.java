import java.awt.Color;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * 
 */

/**Name: Pavneet Gill
	 * Date: December 2016
	 * Description: This program allow the creation of a plauer 
	 */
public class Player {

	//private variables for name, user name 
	private String name; 
	
	private String userName; 
	
	private String password; 
	
	private Statistics stats; 
	
	private ImageIcon accountpic;
	
	public Player() {
		// TODO Auto-generated constructor stub
		this.name = ""; 
		this.userName = ""; 
		this.stats = null;
		this.accountpic = null; 
		this.password = ""; 
	}

	//Overloads Constructor initializes the customer data
	public Player(String name, String userName, String password)
	{
			this.name= name; 
			this.userName = userName; 
			this.password = password; 
	}
	
	public Player (String info)
	{
		String word [];
		word = info.split(",");
		this.name = word[0];
		this.userName = word[1];
		this.password = word[2];
	}
	
	public void updatePlayerData (String info)
	{
		String word [];
		word = info.split(",");
		this.name = word[0];
		this.userName = word[1];
		this.password = word[2];
	}
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getUserName() 
	{
		return userName;
	}

	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public Statistics getStats() 
	{
		return stats;
	}

	public void setAccountpic(ImageIcon accountpic) 
	{
		this.accountpic = accountpic;
	}

	public String getPassword ()
	{
	     return password; 
	}
	
	public String toString(){ // method to change inputed variable to full form and return a string record
		return (getName() + "," + getUserName() + "," + getPassword());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//self testing
				//-----------------------------------------------------------------------------------
				String playerInfo = ""; //creating variable for playerInfo 


				playerInfo = JOptionPane.showInputDialog(null, "Enter:"+ "<name>,<userName>,<password>");

				//process Record
				Player playerRecord = new Player(playerInfo); //creating a Customer constructor 

				System.out.println(playerInfo); 
				
				System.out.println("Name: "+ playerRecord.getName()); 
				
				System.out.println("UserName: " + playerRecord.getUserName());
				
				System.out.println("Password: " + playerRecord.getPassword()); 
	}

}
