package pers.cs.weather.crawler.test;

import java.util.List;

import org.junit.Test;

import pers.cs.weather.crawler.DefaultCrawler;
import pers.cs.weather.crawler.api.ContentParser;
import pers.cs.weather.crawler.api.CrawlerManager;
import pers.cs.weather.crawler.api.impl.SimpleContentParser;
import pers.cs.weather.crawler.api.impl.SimpleCrawlerManager;
import pers.cs.weather.crawler.api.impl.SimpleHttpGetManager;
import pers.cs.weather.crawler.entiry.County;
import pers.cs.weather.crawler.entiry.DateTimeWeather;
import pers.cs.weather.crawler.entiry.DateWeather;

public class DefaultCrawlerTest {
	@Test
	public void testGetWeathers() {
		CrawlerManager crawlerManager = new SimpleCrawlerManager(new SimpleHttpGetManager());
		ContentParser contentParser = new SimpleContentParser();
		DefaultCrawler defaultCrawler = new DefaultCrawler(crawlerManager, contentParser);
		County county = new County();
		county.setId("110102");
		county.setName("长安");
		county.setWeatherCode("101110102");

		List<DateWeather> dateWeathers = defaultCrawler.getDateWeathers(county);
		for (DateWeather dateWeather : dateWeathers) {
			System.out.println(dateWeather.getDate() + " " + dateWeather.getDateDescription() + " "
					+ dateWeather.getWeatherDescription() + " " + dateWeather.getTemperatureDescription() + " "
					+ dateWeather.getWindDescription());
			for(DateTimeWeather dateTimeWeather:dateWeather.getDateTimeWeathers())
				System.out.println(dateTimeWeather);
			System.out.println("------------------------------------------");
		}
	}
}
