import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Timi Onireti and Pavneet Gill
 * Date: September 30,2016
 * Description: Saves encrypted and decrypted words into a file
 * MethodList
 *              saveFile (String fileName, String newPhrases[]) saves encrypted and decrypted words into file
 */
public class TheFileSaverClass
{

    private String fileName;
    private String phrases[];
    
    public TheFileSaverClass (String fileName)
    {
      saveFile (fileName, phrases); 
    }
    /**
     * @param args
     */
    public void saveFile (String fileName, String newPhrases[]) throws IOException
    {

	// open file for writing
	PrintWriter fw = new PrintWriter (new FileWriter (fileName));

	fw.println (newPhrases.length); // writing length of file

	for (int i = 0 ; i < newPhrases.length ; i++) // loop to write new Phrases to file
	{
	    fw.println (newPhrases [i]); // Writing new Phrases to file
	}

	fw.close (); // closes file
    }
    public static void main (String[] args) throws IOException
    {
	// TODO Auto-generated method stubString output[];

	//Testing
	//-------------------------------------------------------------------------------------
	String fileName = "testing";

	String phrases[] = new String [5];  //declaring array of phrases with 5 elements

	TheFileSaverClass saver = new TheFileSaverClass (); //creating TheFileSaveClass object

	for (int k = 0 ; k < phrases.length ; k++) //loop to fill array with phrase
	{
	    phrases [k] = "I love ICS";
	}

	saver.saveFile (fileName, phrases); //calling save file with FileName and phrases
	//------------------------------------------------------------------------------------
    }
}
