package challenge;
import java.net.MalformedURLException;
import java.net.URL;

/*
* 	Project made by Gustavo Eugênio to attend Axur's Engineering Intern Test
*		Personal github -> github.com/Gustavoesm.
*
*	This project should detect blacklisted words in the webpage stream given the correct url.
*	It should also detect "disguised words", that replaces common latin letters for their respective Homoglyphs.
* 	To have access to more information about or include further Homoglyphs, check challenge/Homoglyphs.java.
*	To update the blacklisted words list, check challenge/BlacklistedWords.java.
*
*	The main class receives the page's URL as it's single argument, and return it's safety by printing "suspicious" or "safe".
*/

public class AxurChallenge {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL(args[0]);
		SafetyCheck checker = SafetyCheck.create(url, SuspiciousWordTest.getInstance());
		if(checker.isSuspicious())
		// Logger removed due to Disabling External Libraries Test policy
			System.out.println("suspicious");
		else
			System.out.println("safe");
	}
}