package pers.cs.weather.crawler.api.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import pers.cs.weather.crawler.api.HttpGetManager;
import pers.cs.weather.crawler.exceptions.HttpGetException;
import pers.cs.weather.crawler.exceptions.ResponseStreamWriteException;

public class SimpleHttpGetManager implements HttpGetManager {

	@Override
	public void getAndSaveResponseFromURL(String url, OutputStream outputStream) {
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		try {
			client.executeMethod(method);
			InputStream responseStream = method.getResponseBodyAsStream();
			saveToOutputStream(responseStream,outputStream);
		} catch (Exception e) {
			throw new HttpGetException("get from url " + url + " occur an exception,detail is\n" + e.getMessage());
		} finally {
			method.releaseConnection();
		}
	}

	private void saveToOutputStream(InputStream responseStream, OutputStream outputStream) {
		Reader reader = new InputStreamReader(responseStream);
		Writer writer = new OutputStreamWriter(outputStream);
		char[] cbuf = new char[1024];
		int len = -1;
		try {
			while((len = reader.read(cbuf)) != -1) {
				writer.write(cbuf, 0, len);
			}
			reader.close();
			writer.close();
			outputStream.close();
		} catch (IOException e) {
			throw new ResponseStreamWriteException("write from " + responseStream + " to " + outputStream + " occur an exception,detail is\n" + e.getMessage());
		}
	}

}
