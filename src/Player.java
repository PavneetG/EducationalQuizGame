import java.awt.Color;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * 
 */

/**Name: Pavneet Gill & Kevin Subhash
	 * Date: December 2016
	 * Description: This program allow the creation of a plauer 
	 */
public class Player {

	//private variables for name, user name 
	private String name; 
	
	private String userName; 
	
	private String password;
	
	private String picName;
	
	private Statistics stats; 
	
	public Player() {
		this.name = ""; 
		this.userName = ""; 
		this.stats = null;
		this.picName = ""; 
		this.password = ""; 
	}

	//Overloads Constructor initializes the customer data
	public Player(String name, String userName, String password, String picName)
	{
			this.name= name; 
			this.userName = userName; 
			this.password = password; 
			this.picName = picName;
	}
	
	public Player (String info)
	{
		String word [];
		word = info.split(",");
		this.name = word[0];
		this.userName = word[1];
		this.password = word[2];
		this.picName = word[3];
	}
	
	public void updatePlayerData (String info)
	{
		String word [];
		word = info.split(",");
		this.name = word[0];
		this.userName = word[1];
		this.password = word[2];
		this.picName = word[3];
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

	public void setAccountpic(String picName) 
	{
		this.picName = picName;
	}
	
	public String getAccountpic() 
	{
		return this.picName;
	}

	public String getPassword ()
	{
	     return password; 
	}
	
	public String toString(){ // method to change inputed variable to full form and return a string record
		return (getName() + "," + getUserName() + "," + getPassword() + "," + getAccountpic());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//self testing
				//-----------------------------------------------------------------------------------
				String playerInfo = ""; //creating variable for playerInfo 


				playerInfo = JOptionPane.showInputDialog(null, "Enter:"+ "<name>,<userName>,<password>","Kevin Subhash,KevinSub,489568");

				//process Record
				Player playerRecord = new Player(playerInfo); //creating a Customer constructor 

				System.out.println(playerRecord); 
				
				System.out.println("Name: "+ playerRecord.getName()); 
				
				System.out.println("UserName: " + playerRecord.getUserName());
				
				System.out.println("Password: " + playerRecord.getPassword()); 
	}

}
