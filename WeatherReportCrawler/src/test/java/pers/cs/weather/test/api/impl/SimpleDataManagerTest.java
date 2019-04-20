package pers.cs.weather.test.api.impl;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import pers.cs.weather.api.DataManager;
import pers.cs.weather.api.impl.SimpleDataManager;
import pers.cs.weather.crawler.entiry.CountyWithCityAndProvinceInformation;
import pers.cs.weather.crawler.entiry.DateTimeWeather;
import pers.cs.weather.crawler.entiry.DateWeather;

public class SimpleDataManagerTest {
	@Test
	public void testGetDateWeathersOfCounty() {
		DataManager dataManager = new SimpleDataManager();
		CountyWithCityAndProvinceInformation county = new CountyWithCityAndProvinceInformation("陕西", "咸阳", "礼泉");
		List<DateWeather> dateWeathers = dataManager.getDateWeathersOfCounty(county);
		assertTrue(dateWeathers.size() == 7);
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
