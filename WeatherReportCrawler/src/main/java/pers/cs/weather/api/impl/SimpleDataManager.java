package pers.cs.weather.api.impl;

import java.util.List;
import java.util.Map;

import pers.cs.weather.api.DataManager;
import pers.cs.weather.crawler.DefaultCrawler;
import pers.cs.weather.crawler.entiry.County;
import pers.cs.weather.crawler.entiry.CountyWithCityAndProvinceInformation;
import pers.cs.weather.crawler.entiry.DateWeather;
import pers.cs.weather.crawler.util.CityInformationResolver;

public class SimpleDataManager implements DataManager {

	private DefaultCrawler defaultCrawler;
	
	public SimpleDataManager() {
		this(new DefaultCrawler());
	}

	public SimpleDataManager(DefaultCrawler defaultCrawler) {
		this.defaultCrawler = defaultCrawler;
	}

	@Override
	public List<DateWeather> getDateWeathersOfCounty(CountyWithCityAndProvinceInformation county) {
		Map<CountyWithCityAndProvinceInformation, County> map = CityInformationResolver.resolveCitiesToMap();
		if(!map.containsKey(county))
			return null;
		County configuredCounty = map.get(county);
		return defaultCrawler.getDateWeathers(configuredCounty);
	}

}
