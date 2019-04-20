package pers.cs.weather.crawler.test.api.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import pers.cs.weather.crawler.api.ContentParser;
import pers.cs.weather.crawler.api.impl.SimpleContentParser;
import pers.cs.weather.crawler.entiry.DateWeather;

public class SimpleContentParserTest {
	@Test
	public void testParseFromResponseFile() {
		ContentParser contentParser = new SimpleContentParser();
		String filePath = "src/test/resources/temp/海淀.html";
		List<DateWeather> weathers = contentParser.parseFromResponseFile(filePath);
		
		assertEquals(7, weathers.size());
		for(DateWeather dateWeather:weathers)
			System.out.println(dateWeather);
	}
}
