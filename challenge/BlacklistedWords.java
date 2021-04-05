package challenge;

// ENUM: For blacklisted words
public enum BlacklistedWords {
	SENHA("senha"),
	BLACKFRIDAY("black friday"),
	PROMOCAO("promocao");

	// Stores the word's string
	private final String word;

	// CONSTRUCTOR
	private BlacklistedWords(String word) {
		this.word = word;
	}

	// METHOD: get method
	public String getWord() {
		return this.word;
	}
}
