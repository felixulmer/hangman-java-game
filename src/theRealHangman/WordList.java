package theRealHangman;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
 
public class WordList {
  
    private ArrayList<String> dictionary;

   
    public WordList() {
       

        // Create memory for our list
        dictionary = new ArrayList<String>();

        Scanner sc;
		try {
			sc = new Scanner(new File("src/wordlist.txt"));
			  int maxlength = 0;
		        int count = 0;
		        // Scan in the words from our file until we reach the end
		        while (sc.hasNextLine()) {
		            dictionary.add(sc.nextLine().toUpperCase());
		        }
		   //     System.out.println(maxlength);
		        sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

      
    }
    // Use this method to get a random word to use for our game
    public String getRandomWord() {
    	
        Random r = new Random();
        int index = r.nextInt(dictionary.size());
        return dictionary.get(index);
    }
    
}
