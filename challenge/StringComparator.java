package challenge;

import java.util.Map;

public class StringComparator {

	// CONSTRUCTOR:
	private StringComparator(){

	}

	// METHOD: to check if there is a certain string with/without homoglyphs contained in a text
	public static boolean compareWithHomoglyphs(String text, String string){
		int index = 0;
		Map<Character, String> homoglyphs = Homoglyphs.getMap();
		String letter;
		String letterHomoglyphs;

		// LOOP: for itarating through string letters, min method prevents seg faulting
		while (index < Math.min(text.length(), string.length())) {
			
			letter = text.substring(index,index+1); // gets a single char from text in string format to be checked
			letterHomoglyphs = homoglyphs.get(string.toUpperCase().charAt(index)); // gets the list of homoglyphs in String format for the letter

			if (!letterHomoglyphs.contains(letter)) // if the letter is NOT contained in the desired letter's homoglyphs list
				return false; // sends the signal of diferent words
			index++;
		}

		// if all checked letters are similar, then sends the signal of same word
		// obs: there could be an uneven number of letter in both words, this should be checked in calling environment
		return true;
	}
	
}
