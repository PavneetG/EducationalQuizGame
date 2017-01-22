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
			this.stats = null;
	}
	
	public Player (String info)
	{
		String word [];
		word = info.split(";");
		this.name = word[0];
		this.userName = word[1];
		this.password = word[2];
		this.picName = word[3];
		String str = word[4];
		String[] data = str.split("\\|");
		this.stats = new Statistics(data);
	}
	
	public void updatePlayerData (String info)
	{
		String word [];
		word = info.split("|");
		this.name = word[0];
		this.userName = word[1];
		this.password = word[2];
		this.picName = word[3];
		String str = word[4];
		String[] data = str.split("\\|");
		this.stats = new Statistics(data);
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
	
//	public Statistics setStats(String info) 
//	{
//		this.stats = new Statistics(info);
//	}

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
		return (getName() + "|" + getUserName() + "|" + getPassword() + "|" + getAccountpic() + "|" + getStats());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//self testing
				//-----------------------------------------------------------------------------------
				String playerInfo = ""; //creating variable for playerInfo 


				playerInfo = JOptionPane.showInputDialog(null, "Enter:"+ "<name>,<userName>,<password>","Kevin Subhash;KevinSub99;123456;p1.jpg;3|20|18|90.0|3.5|3|[American History, European History, World History]");

				//process Record
				Player playerRecord = new Player(playerInfo); //creating a Customer constructor 

				System.out.println(playerRecord.toString()); 
				
				System.out.println("Name: "+ playerRecord.getName()); 
				
				System.out.println("UserName: " + playerRecord.getUserName());
				
				System.out.println("Password: " + playerRecord.getPassword()); 
				
				System.out.println("Stats: " + playerRecord.getStats().getOverallPercentage()); 
	}

}
