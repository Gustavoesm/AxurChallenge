package challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;

// this class checks the safety of an URL given a suspiciousness test
public class SafetyCheck {
	
	
	private final URL url;					// URL to be checked	
	private final SuspiciousnessTest test;	// a test for the page

	// CONSTRUCTOR: private to force the "create" method
	private SafetyCheck(URL url, SuspiciousnessTest test){
		this.url = url;
		this.test = test;
	}

	// METHOD: to explicitly create an instance
	public static SafetyCheck create(URL url, SuspiciousnessTest test){
		return new SafetyCheck(url, test);
	}

	// METHOD: to check the object for suspiciousness
	public boolean isSuspicious() {

		boolean isSuspicious = false;							// a flag for suspiciousness of the object
		
		BufferedReader reader = HTMLPageReader.readPage(url);	// reads full HTML page from given URL, returning Buffered Reader content
		
		String line;
		
		try { 
			while ((line = reader.readLine()) != null) { 			// reads the HTML page line by line
				isSuspicious = test.validate(line);					// validates the test for the given text
				if(isSuspicious)									// first negative test determines object is suspicious, stopping the validation
					break;
			}
		} catch (IOException e) { 									// throws custom PageReadingException if an generic IOException was caught
			throw new PageReadingException("There was a problem loading the page.");
		}

		return isSuspicious;
	}
}
