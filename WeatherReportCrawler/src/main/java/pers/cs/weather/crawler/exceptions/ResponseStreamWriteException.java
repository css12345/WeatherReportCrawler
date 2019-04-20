package pers.cs.weather.crawler.exceptions;

public class ResponseStreamWriteException extends RuntimeException {
private static final long serialVersionUID = 1L;
	
	public ResponseStreamWriteException(String message) {
		super(message);
	}
}
