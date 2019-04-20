package pers.cs.weather.crawler.api;

import java.util.List;

import pers.cs.weather.crawler.entiry.DateWeather;

/**
 * 内容解析管理器，负责解析出近七天的天气信息
 * @author cs
 *
 */
public interface ContentParser {
	/**
	 * 从爬虫爬取并保存的文件中解析出近七天的天气作为列表返回
	 * @param resource 保存文件的目录
	 * @return 近七天天气的列表
	 */
	List<DateWeather> parseFromResponseFile(String resource);
}
