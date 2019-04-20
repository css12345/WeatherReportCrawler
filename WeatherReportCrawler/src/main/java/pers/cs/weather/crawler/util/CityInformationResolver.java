package pers.cs.weather.crawler.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXB;

import pers.cs.weather.crawler.entiry.China;
import pers.cs.weather.crawler.entiry.City;
import pers.cs.weather.crawler.entiry.County;
import pers.cs.weather.crawler.entiry.Province;

/**
 * 负责将城市信息从xml文件解析到内存中
 * @author cs
 *
 */
public class CityInformationResolver {
	public static String filePath = "src/main/resources/chinaCityInformation.xml";
	public static China china;
	public static China resolveCitiesToEntiry() {
		if(china != null)
			return china;
		File file = new File(filePath);
		china = JAXB.unmarshal(file, China.class);
		return china;
	}
	
	public static Map<String,County> resolveCitiesToMap() {
		China china = resolveCitiesToEntiry();
		return resolveCitiesToMap(china);
	}
	
	public static Map<String,County> resolveCitiesToMap(China china) {
		Map<String,County> counties = new HashMap<>();
		for(Province province:china.getProvinces())
			for(City city:province.getCities())
				for(County county:city.getCounties()) 
					counties.put(county.getId(), county);
		return counties;
	}
}
