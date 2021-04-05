package challenge;

public class PageReadingException extends RuntimeException {
	private static final long serialVersionUID = -1615432777321544375L;

	public PageReadingException(String errorMessage) {
		super(errorMessage);
	}
}