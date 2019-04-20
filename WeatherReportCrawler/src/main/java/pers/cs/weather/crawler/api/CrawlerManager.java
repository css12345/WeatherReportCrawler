package pers.cs.weather.crawler.api;

import java.io.OutputStream;

import pers.cs.weather.crawler.entiry.County;

/**
 * 爬虫管理器
 * @author cs
 *
 */
public interface CrawlerManager {
	String prefixOfURL = "http://www.weather.com.cn/weather/",suffixOfURLString = ".shtml";
	
	/**
	 * 针对要查询天气的县进行数据爬取，将响应的html流写入到输出流中
	 * @param county 要查询的县
	 * @param outputStream 要保存的位置的输出流
	 */
	void getAndSaveResponseStream(County county,OutputStream outputStream);
}
