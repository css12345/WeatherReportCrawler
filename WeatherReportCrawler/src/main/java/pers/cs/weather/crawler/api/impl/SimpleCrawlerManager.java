package pers.cs.weather.crawler.api.impl;

import java.io.OutputStream;

import pers.cs.weather.crawler.api.CrawlerManager;
import pers.cs.weather.crawler.api.HttpGetManager;
import pers.cs.weather.crawler.entiry.County;

public class SimpleCrawlerManager implements CrawlerManager {

	private HttpGetManager getManager;

	public SimpleCrawlerManager() {
		this(new SimpleHttpGetManager());
	}

	public SimpleCrawlerManager(HttpGetManager getManager) {
		this.getManager = getManager;
	}

	@Override
	public void getAndSaveResponseStream(County county, OutputStream outputStream) {
		String url = prefixOfURL + county.getWeatherCode() + suffixOfURLString;
		getManager.getAndSaveResponseFromURL(url, outputStream);
	}

}
