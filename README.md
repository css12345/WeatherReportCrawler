# WeatherReportCrawler
一个针对七天天气预报的java爬虫，使用javafx来创建交互界面，对于要查询的地方使用apache httpclient从中国天气网进行网页爬取，使用htmlparser解析，最后将相应信息反馈至界面中。<br>
定义了ContentParser、CrawlerManager、HttpGetManager三个接口的功能分别是负责对爬取的内容解析出天气列表、根据County爬取并保存在本地、根据url爬取并保存在本地，接口CrawlerManager依赖于接口HttpGetManager。<br>
然后定义了三个简单实现类对以上接口进行了实现，同时定义类DefaultCrawler负责将三个接口的功能进行整合，对外只暴露出给一个County返回一个天气列表的接口。
<br>
然后定义了实体类包括China,Province,City,County分别表示国内所有省，省内所有市，市内所有县的概念，同时省、市、县包含id和name两个属性;<br>
还有表示每日天气和每时天气两个类DateWeather和DateTimeWeather，对应于每一天的天气和这一天中某几个时间点的天气，DateWeather包含一个DateTimeWeather的列表，两个类都有对天气信息描述的熟悉。<br>
还定义了几个异常类便于在获取天气时统一管理异常，还有两个工具类来简化操作。<br>
最后安装见链接：https://pan.baidu.com/s/1jXNtK1qFsadPNyby-BWKVw 提取码：b6g0 
