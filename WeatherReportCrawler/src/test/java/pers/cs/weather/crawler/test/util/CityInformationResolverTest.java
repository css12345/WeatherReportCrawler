package pers.cs.weather.crawler.test.util;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.Ignore;
import org.junit.Test;

import pers.cs.weather.crawler.entiry.China;
import pers.cs.weather.crawler.entiry.City;
import pers.cs.weather.crawler.entiry.County;
import pers.cs.weather.crawler.entiry.Province;
import pers.cs.weather.crawler.util.CityInformationResolver;

public class CityInformationResolverTest {
	@Ignore
	@Test
	public void testResolveCitiesToEntity() throws FileNotFoundException {
		China china = CityInformationResolver.resolveCitiesToEntiry();
		assertNotNull(china);
		PrintWriter out = new PrintWriter(new File("src/test/resources/temp/cityInformation.txt"));
		for(Province province:china.getProvinces()) {
			out.println("	" + province.getId() + " " + province.getName());
			for(City city:province.getCities()) {
				out.println("		" + city.getId() + " " + city.getName());
				for(County county:city.getCounties()) {
					out.println("			" + county.getId() + " " + county.getName() + " " + county.getWeatherCode());
				}
				out.println("--------------------------------------------------------");
			}
			out.println("----------------------------------------------------------------------");
		}
	}
}
