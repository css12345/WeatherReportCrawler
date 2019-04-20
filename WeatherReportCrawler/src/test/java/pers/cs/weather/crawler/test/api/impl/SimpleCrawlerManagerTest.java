package pers.cs.weather.crawler.test.api.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.junit.Test;

import pers.cs.weather.crawler.api.CrawlerManager;
import pers.cs.weather.crawler.api.impl.SimpleCrawlerManager;
import pers.cs.weather.crawler.api.impl.SimpleHttpGetManager;
import pers.cs.weather.crawler.entiry.County;

public class SimpleCrawlerManagerTest {
	@Test
	public void testGetAndSaveResponseStream() throws FileNotFoundException {
		CrawlerManager manager = new SimpleCrawlerManager(new SimpleHttpGetManager());
		County county = new County();
		county.setId("010102");
		county.setName("海淀");
		county.setWeatherCode("101010200");
		OutputStream outputStream = new FileOutputStream(new File("src/test/resources/temp/" + county.getName() + ".html"));
		manager.getAndSaveResponseStream(county, outputStream );
	}
}
