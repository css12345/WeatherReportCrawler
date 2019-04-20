package pers.cs.weather.api;

import java.util.List;

import pers.cs.weather.crawler.entiry.CountyWithCityAndProvinceInformation;
import pers.cs.weather.crawler.entiry.DateWeather;

/**
 * 数据管理器，将对用户输入信息进行处理，返回要显示的数据
 * @author cs
 *
 */
public interface DataManager {
	List<DateWeather> getDateWeathersOfCounty(CountyWithCityAndProvinceInformation county);
}
