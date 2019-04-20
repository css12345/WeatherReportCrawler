package pers.cs.weather.crawler.entiry;

import java.time.LocalDate;
import java.util.List;

public class DateWeather {
	private LocalDate date;
	private String dateDescription;
	private String weatherDescription;
	private int minTemperature, maxTemperature;
	private String temperatureDescription;
	private String windDescription;

	private List<DateTimeWeather> dateTimeWeathers;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDateDescription() {
		return dateDescription;
	}

	public void setDateDescription(String dateDescription) {
		this.dateDescription = dateDescription;
	}

	public String getWeatherDescription() {
		return weatherDescription;
	}

	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	public int getMinTemperature() {
		return minTemperature;
	}

	public void setMinTemperature(int minTemperature) {
		this.minTemperature = minTemperature;
	}

	public int getMaxTemperature() {
		return maxTemperature;
	}

	public void setMaxTemperature(int maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	public String getWindDescription() {
		return windDescription;
	}

	public void setWindDescription(String windDescription) {
		this.windDescription = windDescription;
	}

	public List<DateTimeWeather> getDateTimeWeathers() {
		return dateTimeWeathers;
	}

	public void setDateTimeWeathers(List<DateTimeWeather> dateTimeWeathers) {
		this.dateTimeWeathers = dateTimeWeathers;
	}

	public String getTemperatureDescription() {
		return temperatureDescription;
	}

	public void setTemperatureDescription(String temperatureDescription) {
		this.temperatureDescription = temperatureDescription;
	}

	@Override
	public String toString() {
		return "DateWeather [date=" + date + ", dateDescription=" + dateDescription + ", weatherDescription="
				+ weatherDescription + ", temperatureDescription=" + temperatureDescription + ", windDescription="
				+ windDescription + ", dateTimeWeathers=" + dateTimeWeathers + "]";
	}

}
