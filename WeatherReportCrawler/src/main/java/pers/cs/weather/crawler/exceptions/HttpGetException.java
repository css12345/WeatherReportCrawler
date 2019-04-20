package pers.cs.weather.crawler.exceptions;

public class HttpGetException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public HttpGetException(String message) {
		super(message);
	}
	
}
