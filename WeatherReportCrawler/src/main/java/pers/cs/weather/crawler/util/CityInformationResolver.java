package pers.cs.weather.crawler.util;

import java.io.File;

import javax.xml.bind.JAXB;

import pers.cs.weather.crawler.entiry.China;

/**
 * 负责将城市信息从xml文件解析到内存中
 * 
 * @author cs
 *
 */
public abstract class CityInformationResolver {
	public static String filePath = "src/main/resources/chinaCityInformation.xml";
	public static China china;

	public static China resolveCitiesToEntiry() {
		if (china != null)
			return china;
		File file = new File(filePath);
		china = JAXB.unmarshal(file, China.class);
		return china;
	}
}
