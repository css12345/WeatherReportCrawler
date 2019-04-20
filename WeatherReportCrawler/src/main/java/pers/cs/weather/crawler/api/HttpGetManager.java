package pers.cs.weather.crawler.api;

import java.io.OutputStream;

/**
 * 针对一个get请求进行管理
 * @author cs
 *
 */
public interface HttpGetManager {
	/**
	 * 从参数url中获取响应，将响应保存到对应的输出流中
	 * @param url 要请求的url
	 * @param outputStream 要保存的位置的输出流
	 */
	void getAndSaveResponseFromURL(String url,OutputStream outputStream);
}
