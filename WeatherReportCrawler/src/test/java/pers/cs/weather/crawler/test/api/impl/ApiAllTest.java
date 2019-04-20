package pers.cs.weather.crawler.test.api.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
	SimpleHttpGetManagerTest.class,
	SimpleCrawlerManagerTest.class,
	SimpleContentParserTest.class
})
public class ApiAllTest {

}
