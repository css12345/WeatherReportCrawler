package pers.cs.weather.crawler.entiry;

import java.time.LocalDateTime;

public class DateTimeWeather {
	private LocalDateTime dateTime;
	private String weatherDescription;
	private int temperature;
	private String temperatureDescription;
	private String windDirection;
	private String windSizeDescription;

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getWeatherDescription() {
		return weatherDescription;
	}

	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public String getTemperatureDescription() {
		return temperatureDescription;
	}

	public void setTemperatureDescription(String temperatureDescription) {
		this.temperatureDescription = temperatureDescription;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public String getWindSizeDescription() {
		return windSizeDescription;
	}

	public void setWindSizeDescription(String windSizeDescription) {
		this.windSizeDescription = windSizeDescription;
	}

	@Override
	public String toString() {
		return "DateTimeWeather [dateTime=" + dateTime + ", weatherDescription=" + weatherDescription
				+ ", temperatureDescription=" + temperatureDescription + ", windDirection=" + windDirection
				+ ", windSizeDescription=" + windSizeDescription + "]";
	}

}
