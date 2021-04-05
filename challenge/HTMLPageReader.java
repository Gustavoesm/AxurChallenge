package challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

// This class simply reads an HTML page and returns it's buffered content
public class HTMLPageReader {
	// CONSTRUCTOR:
	private HTMLPageReader(){

	}

	// METHOD: readPage requires an URL and return's a buffered reader for it's HTML
		// Throwing custom Exception for error feedback. 
	public static BufferedReader readPage(URL url) throws PageReadingException{
		try{
			InputStreamReader iStreamReader = new InputStreamReader(url.openStream());
			return new BufferedReader(iStreamReader);
		} catch (IOException e) {	
			// throws custom PageReadingException if an generic IOException was caught
			throw new PageReadingException("There was a problem loading the page.");
		}
	}
}
