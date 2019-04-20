package pers.cs.weather.crawler.util;

import java.io.File;

import javax.xml.bind.JAXB;

import pers.cs.weather.crawler.entiry.China;

/**
 * 负责将城市信息从xml文件解析到内存中
 * @author cs
 *
 */
public class CityInformationResolver {
	public static String filePath = "src/main/resources/chinaCityInformation.xml";
	public static China resolveCities() {
		File file = new File(filePath);
		China china = JAXB.unmarshal(file, China.class);
		return china;	
	}
}
