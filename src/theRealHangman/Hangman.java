package theRealHangman;

import java.util.Scanner;

public class Hangman {

	static WordList wordlist = new WordList();
	
	private static String word = wordlist.getRandomWord();
	private static String asterisk = new String(new char[word.length()]).replace("\0", "*");
	private static int count = 0;
	


	public static String getWord() {
		return word;
	}

	public static void hang(String guess) {
		String newasterisk = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess.charAt(0)) {
				newasterisk += guess.charAt(0);
				
			} else if (asterisk.charAt(i) != '*') {
				newasterisk += word.charAt(i);
			} else {
				newasterisk += "*";
			}
		}
		
		

		System.out.println(getAsterisk());
		System.out.println(newasterisk);
		if (getAsterisk().equals(newasterisk)) {
			
			count++;
			hangmanImage();
		} else {
			setAsterisk(newasterisk);
		}
		if (getAsterisk().equals(word)) {
			System.out.println("Correct! You win! The word was " + word);
		}
	}

	public static String hangmanImage() {
		if(count == 0) return null; 
		
		final String filename = String.format("%1$" + 2 + "s", count).replace(' ', '0');
		return "images/Hangman/" + filename + ".png";
	}
	
	
	public static String getAsterisk() {
		return asterisk;
	}

	public static void setAsterisk(String asterisk) {
		Hangman.asterisk = asterisk;
	}
}
