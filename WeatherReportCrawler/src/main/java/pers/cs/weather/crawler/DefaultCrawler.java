package pers.cs.weather.crawler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import pers.cs.weather.crawler.api.ContentParser;
import pers.cs.weather.crawler.api.CrawlerManager;
import pers.cs.weather.crawler.api.impl.SimpleContentParser;
import pers.cs.weather.crawler.api.impl.SimpleCrawlerManager;
import pers.cs.weather.crawler.entiry.County;
import pers.cs.weather.crawler.entiry.DateWeather;

public class DefaultCrawler {
	private CrawlerManager crawlerManager;
	private ContentParser contentParser;
	public static String DEFAULT_SAVE_LOCATION = "src/main/resources/queriedCountiesResponse/";

	public DefaultCrawler() {
		this(new SimpleCrawlerManager(), new SimpleContentParser());
	}
	
	public DefaultCrawler(CrawlerManager crawlerManager, ContentParser contentParser) {
		this.crawlerManager = crawlerManager;
		this.contentParser = contentParser;
	}

	public List<DateWeather> getDateWeathers(County county) {
		try {
			String resource = DEFAULT_SAVE_LOCATION + county.getName() + ".html";
			OutputStream outputStream = new FileOutputStream(new File(resource));
			crawlerManager.getAndSaveResponseStream(county, outputStream);
			return contentParser.parseFromResponseFile(resource);
		} catch (FileNotFoundException e) {

		}
		return null;

	}

}
