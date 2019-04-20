package pers.cs.weather.crawler.api.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;

import pers.cs.weather.crawler.api.ContentParser;
import pers.cs.weather.crawler.entiry.DateTimeWeather;
import pers.cs.weather.crawler.entiry.DateWeather;
import pers.cs.weather.crawler.exceptions.ContentParserException;

public class SimpleContentParser implements ContentParser {

	@Override
	public List<DateWeather> parseFromResponseFile(String resource) {
		try {
			List<DateWeather> dateWeathers = new ArrayList<>();
			Parser parser = new Parser(resource);
			NodeFilter filter = new HasAttributeFilter("class", "t clearfix");
			NodeList list = parser.extractAllNodesThatMatch(filter);
			NodeList childList = list.elementAt(0).getChildren();
			LocalDate now = LocalDate.now();
			for (int i = 0, j = 0; i < childList.size(); i++) {
				Node node = childList.elementAt(i);
				if (node.getText().equals("\n"))
					continue;

				DateWeather dateWeather = new DateWeather();
				dateWeather.setDate(now.plusDays(j));
				parseWeatherOfEachDay(node, dateWeather);

				dateWeathers.add(dateWeather);
				j++;
			}

			parser = new Parser(resource);
			filter = new TagNameFilter("script");
			list = parser.extractAllNodesThatMatch(filter);
			for (int i = 0; i < list.size(); i++) {
				Node listNode = list.elementAt(i);
				String text = listNode.getText(), plainText = listNode.toPlainTextString();
				if (text.equals("\n") || plainText.equals(""))
					continue;
//				System.out.println("getText " + text);
//				System.out.println("getPlainText:" + plainText);
//				System.out.println("toHtml:" + listNode.toHtml());
//				System.out.println("=================================================");
				if (plainText.contains("hour3data")) {
					int startIndex = plainText.indexOf("\"7d\""), endIndex = plainText.indexOf('}');
					String hourWeathers = plainText.substring(startIndex + 5, endIndex);
					hourWeathers = hourWeathers.substring(2, hourWeathers.length() - 2);
					parseWeatherOfHours(hourWeathers, dateWeathers);
					break;
				}
			}

			return dateWeathers;
		} catch (Exception e) {
			throw new ContentParserException(
					"parsing from resource " + resource + " occur an exception,detail is\n" + e.getMessage());
		}

	}

	private void parseWeatherOfHours(String hourWeathers, List<DateWeather> dateWeathers) {
		// System.out.println(hourWeathers);
		String[] hourWeatherArray = hourWeathers.split("\"");
		for (String hourWeather : hourWeatherArray)
			if (!(hourWeather.equals("") || hourWeather.equals(",") || hourWeather.equals("],[")))
				ParseWeatherOfEachHour(hourWeather, dateWeathers);
	}

	private void ParseWeatherOfEachHour(String hourWeather, List<DateWeather> dateWeathers) {
		// System.out.println(hourWeather);
		String[] informations = hourWeather.split(",");
		DateTimeWeather dateTimeWeather = new DateTimeWeather();
		DateWeather rightDateWeather = null;
		for (int i = 0; i < informations.length; i++) {
			switch (i) {
			case 0:
				int dayIndex = informations[i].indexOf('日'), hourIndex = informations[i].indexOf('时');
				int day1 = Integer.parseInt(informations[i].substring(0, dayIndex)),
						hour = Integer.parseInt(informations[i].substring(dayIndex + 1, hourIndex));
				for (DateWeather dateWeather : dateWeathers) {
					LocalDate localDate = dateWeather.getDate();
					int day2 = localDate.getDayOfMonth();
					if (day1 == day2) {
						rightDateWeather = dateWeather;
						LocalDateTime dateTime = LocalDateTime.of(localDate.getYear(), localDate.getMonth(),
								localDate.getDayOfMonth(), hour, 0);
						dateTimeWeather.setDateTime(dateTime);
						break;
					}
				}
				break;
			case 2:
				dateTimeWeather.setWeatherDescription(informations[i]);
				break;
			case 3:
				dateTimeWeather.setTemperatureDescription(informations[i]);
				int index = informations[i].indexOf("℃");
				int temperature = Integer.parseInt(informations[i].substring(0, index));
				dateTimeWeather.setTemperature(temperature);
				break;
			case 4:
				dateTimeWeather.setWindDirection(informations[i]);
				break;
			case 5:
				dateTimeWeather.setWindSizeDescription(informations[i]);
				break;
			}
		}

		if (rightDateWeather != null)
			rightDateWeather.getDateTimeWeathers().add(dateTimeWeather);
	}

	private void parseWeatherOfEachDay(Node node, DateWeather dateWeather) {
		NodeList childList = node.getChildren();
		for (int i = 0; i < childList.size(); i++) {
			Node childNode = childList.elementAt(i);
			String text = childNode.getText(), plainText = childNode.toPlainTextString();
			if (text.equals("\n") || plainText.equals(""))
				continue;
//			System.out.println("getText " + text);
//			System.out.println("getPlainText:" + plainText);
//			System.out.println("toHtml:" + childNode.toHtml());
//			System.out.println("=================================================");

			if (text.contains("h1")) {
				int beginIndex = plainText.indexOf('（');
				int endIndex = plainText.indexOf('）');
				String dateDescription = plainText.substring(beginIndex + 1, endIndex);
				dateWeather.setDateDescription(dateDescription);
			} else if (text.contains("wea")) {
				dateWeather.setWeatherDescription(plainText);
			} else if (text.contains("tem")) {
				plainText = plainText.replace("\n", "");

				dateWeather.setTemperatureDescription(plainText);

				int indexOfLine = plainText.indexOf('/');
				int maxTemperature = 0, minTemperature = 0;
				if (indexOfLine == -1) {
					int endIndex = plainText.indexOf("℃");
					maxTemperature = minTemperature = Integer.parseInt(plainText.substring(0,endIndex));
				}
				else {
					String string = plainText.substring(0, indexOfLine);
					int endIndex = string.indexOf("℃");
					maxTemperature = Integer.parseInt(string.substring(0,endIndex));
					
					string = plainText.substring(indexOfLine + 1);
					endIndex = string.indexOf("℃");
					minTemperature = Integer.parseInt(string.substring(0, endIndex));
				}

				dateWeather.setMaxTemperature(maxTemperature);
				dateWeather.setMinTemperature(minTemperature);

			} else if (text.contains("win")) {
				plainText = plainText.replace("\n", "");
				dateWeather.setWindDescription(plainText);
			}
		}
	}

}
