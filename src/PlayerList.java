import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;


public class PlayerList {

	private int maxSize;   // creating private variables
	private int size;
	private Player list [];

	public PlayerList() {
		maxSize = 100; //initializing variables
		size = 0; 
		list = new Player [maxSize];
	}

	public void loadFile (String file) throws IOException{ // method to read a file
		FileInputStream ln = new FileInputStream(file);
		FileInputStream ln2 = new FileInputStream(file);
		LineNumberReader inputFile2 = new LineNumberReader (new InputStreamReader(ln2));//inputting file
		BufferedReader inputFile = new BufferedReader (new InputStreamReader(ln)); 
		int size = 0;

		while (inputFile2.readLine () != null) // finds size of array in file
		{
			size++;
		}  
		String fileInfo[] = new String [size]; //declare and create 

		for (int j = 0 ; j < fileInfo.length ; j++)
		{
			fileInfo [j] = inputFile.readLine ();
			Player accountsInfo = new Player();
			accountsInfo.updatePlayerData(fileInfo[j]);
			insert(accountsInfo);
		}
		inputFile.close (); // closes inputFile
	}

	public void writeFile (String file) throws IOException{ // method to write a file

		FileOutputStream file2 = new FileOutputStream (file); // writes to inputed file name (by user)
		PrintWriter output = new PrintWriter (file2);

		for (int i = 0; i < size; i++) { // Reads each line of the text file and stores it in arrays
			output.println(list[i]);
		}

		file2.close (); // Closes file2
	}

	public boolean insert(Player record){ // method used to insert new record
		if (size < maxSize){ // if size is less than maxSize then it inserts record
			size++;
			list[size-1] = record;
			return true;
		}
		return false;
	}	

	public boolean delete(Player record){ // method used to delete a record
		int  location;
		insertSort(); // sorts all record before it deletes

		location = binarySearch(record.toString()); // calls binary search method

		if(location >= -1) // if statement for delete
		{
			list[location] = list[size-1]; // deletes record and reduces size of record by 1
			size--;
			return true;
		}
		return false;
	}

	public void insertSort (){ // An insertion sort method that sorts the customers name
		for (int top = 1; top < size; top++){
			Player item = list[top];
			int i = top-1;
			while (i >= 0){
				if(item.getName().compareToIgnoreCase(list[i].getName())>0){ // compares the inputed name with names in current record
					break;
				}
				list[i+1] = list[i];
				i--;
			}
			list[i+1] = item;
		}
	}

	public void rippleSort(){      // Created a Ripple Sort method that sorts account number
		for(int i = 0; i <= size-2;i++){
			for(int j = i+1; j <= size-1; j++){
				if(list[i].getUserName().compareToIgnoreCase(list[j].getUserName()) > 0){ // compares inputed chequing account number with current account numbers
					Player temp;
					temp = list[i];
					list[i] = list [j]; //swap order
					list[j] = temp;
				}
			}
		}
	}

	public int linearSearch(String searchKey){ // A linear search method that searches for customer name
		for(int i = 0; i < size; i++){
			if(searchKey.equalsIgnoreCase(list[i].toString())){ // compares customer names
				return i;
			}
		}
		return -1; // returns -1 if not found
	}

	public int binarySearch(String searchKey){ // binary search method that searches for customer name
		int low = 0;
		int high = size - 1;
		int middle;

		while(low <= high){
			middle = (high + low)/2; // divides array in two
			if(searchKey.equalsIgnoreCase(list[middle].toString())){  // returns middle when found
				return middle;
			}
			else if(searchKey.compareToIgnoreCase(list[middle].toString())<0){ 
				high = middle - 1;
			}
			else{
				low = middle + 1;
			}
		}
		return -2;
	}

	public boolean change(Player oldR, Player newR){ // method used to change a record	
		if(delete(oldR)){ // deletes old record and inserts new record
			insert(newR); 
			return true;
		}
		return false;
	}

	public int getSize() { // getter method to get the size
		return size;
	}

	public Player[] getList() { // method to return list
		return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		PlayerList accounts = new PlayerList(); 
		String[] button = {"Insert","Print","Delete","Change","File Input","Save","insertion sort","Ripple Sort","Quit"}; // string array of buttons

		while(true){

			char command = (char) JOptionPane.showOptionDialog(null, "What Would You Like To Do With The Account Records?","Account Records",
					JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,button,button[0]);// Asks user some options with buttons

			if(button[command].charAt(0) == 'Q'){ // starting switch case for each button
				break;
			}
			switch (button[command].charAt(0)){
			case 'I':{ // inserts customer info manually 
				String record = JOptionPane.showInputDialog(null,"Enter <name>,<userName>,<password>",
						"Kevin Subhash,KevinSub99,123456");
				Player playerInfo = new Player(record);

				if (!accounts.insert(playerInfo)){ // accounts is not added if not valid
					JOptionPane.showMessageDialog(null, "Account not added");
				}
				break;
			}
			case 'F':{ // inserts all customer info from txt file
				String record = JOptionPane.showInputDialog(null, "Enter File Name", "Players.txt"); // prompts user for file name

				accounts.loadFile(record); // calls method to load file

				break;
			}
			case 'S':{ // Writes to a file
				String fileName = JOptionPane.showInputDialog(null, "Enter File Name ", "Players.txt"); // prompt user for file
				accounts.writeFile(fileName); // calls method to write file
				break;
			}
			case 'P':{ // prints all records
				for (int i = 0; i < accounts.getSize(); i++) { // loops until all record are printed
					System.out.println("Record #" + (i+1) + " " + accounts.getList()[i]);
				}
				break;
			}
			case 'D':{ // deletes a customer record
				Player playerInfo = new Player();
				String record = JOptionPane.showInputDialog(null,"Enter <name>,<userName>,<password>", //prompt user for account info to delete
						"Kevin Subhash,KevinSub99,123456");

				playerInfo.updatePlayerData(record); // processes inputed string

				if(!accounts.delete(playerInfo)){ // performs when record cannot be found
					JOptionPane.showMessageDialog(null, "Record Not Found.");
					break;
				}
				accounts.insertSort();
				break;
			}
			case 'C':{ // changes a customer record into another
				String oldRecord = JOptionPane.showInputDialog(null, "Enter Record to Change", "Kevin Subhash,KevinSub99,123456"); // prompts user for old account info
				Player oldInfo = new Player();
				oldInfo.updatePlayerData(oldRecord); // processes old account string

				String newRecord = JOptionPane.showInputDialog(null, "Enter Record to Change to", "Janujan G.,JG100,789456"); // prompts user for new account info
				Player newInfo = new Player();
				newInfo.updatePlayerData(newRecord); // processes new string info

				if(accounts.change(oldInfo,newInfo)){ // calls method to change the old record to new record
					accounts.insertSort();
					JOptionPane.showMessageDialog(null,"Success");
				}
				else{
					JOptionPane.showMessageDialog(null, "Fail");

					break;
				}
				break;
			}
			case 'i':{ // performs insertion sort
				accounts.insertSort();
				break;
			}
			case 'R':{ // performs ripple sort
				accounts.rippleSort();
				break;
			}
			} // end of while loop
		} // end of main method

	}

}