package pers.cs.weather.crawler.test.api.impl;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.junit.Test;

import pers.cs.weather.crawler.api.HttpGetManager;
import pers.cs.weather.crawler.api.impl.SimpleHttpGetManager;
import pers.cs.weather.crawler.exceptions.HttpGetException;

public class SimpleHttpGetManagerTest {

	@Test
	public void testGetAndSaveResponseFromURL() throws FileNotFoundException {
		HttpGetManager getManager = new SimpleHttpGetManager();
		String url = "http://www.weather.com.cn/weather/101050810.shtml";
		OutputStream outputStream = new FileOutputStream(new File("src/test/resources/temp/testGetAndSavaResponseFromURL.html"));
		getManager.getAndSaveResponseFromURL(url, outputStream);
	}
	
	@Test
	public void testHttpGetException() throws FileNotFoundException {
		HttpGetManager getManager = new SimpleHttpGetManager();
		String url = "http://www.weather.com.eather/101050810.shtml";
		OutputStream outputStream = new FileOutputStream(new File("src/test/resources/temp/testGetAndSavaResponseFromURL.html"));
		try {
			getManager.getAndSaveResponseFromURL(url, outputStream);
		} catch (HttpGetException e) {
			return;
		}
		fail();
	}

}
