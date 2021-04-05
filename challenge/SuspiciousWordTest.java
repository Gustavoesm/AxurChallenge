package challenge;

// A class for testing the suspiciousness of sites, using a list of suspicious words
public class SuspiciousWordTest implements SuspiciousnessTest{

	// CONSTRUCTOR:
	private SuspiciousWordTest(){

	}

	// OBJECT: To force and store a single instance of this class
	private static SuspiciousWordTest instance;

	// METHOD: To return the instance of this class, also creates a new one if none exists
	public static SuspiciousWordTest getInstance(){
		if(instance == null){
			instance = new SuspiciousWordTest();
		}

		return instance;
	}

	// METHOD: To check for blacklisted words in text
	public boolean validate(String text){
		for(BlacklistedWords suspiciousWords : BlacklistedWords.values()){	// For each blacklisted word...
			for (int index = 0; index < text.length(); index++) {				// ...iterate through all letters...
				if (StringComparator.compareWithHomoglyphs(text.substring(index), suspiciousWords.getWord()))	// ...and check if there is a blacklisted word in the text
					return true;
			}
		}
		return false;
	}

}
