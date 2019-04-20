package pers.cs.weather.crawler.exceptions;

public class ContentParserException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ContentParserException(String message) {
		super(message);
	}
}
