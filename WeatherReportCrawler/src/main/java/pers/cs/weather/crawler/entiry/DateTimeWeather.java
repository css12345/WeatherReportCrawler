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
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(dateTime + "\n");
		stringBuilder.append(temperatureDescription + "\n");
		stringBuilder.append(weatherDescription + "\n");
		stringBuilder.append(windDirection + "\n");
		stringBuilder.append(windSizeDescription + "\n");
		return stringBuilder.toString();
//		return "DateTimeWeather [dateTime=" + dateTime + ", weatherDescription=" + weatherDescription
//				+ ", temperatureDescription=" + temperatureDescription + ", windDirection=" + windDirection
//				+ ", windSizeDescription=" + windSizeDescription + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + temperature;
		result = prime * result + ((temperatureDescription == null) ? 0 : temperatureDescription.hashCode());
		result = prime * result + ((weatherDescription == null) ? 0 : weatherDescription.hashCode());
		result = prime * result + ((windDirection == null) ? 0 : windDirection.hashCode());
		result = prime * result + ((windSizeDescription == null) ? 0 : windSizeDescription.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DateTimeWeather other = (DateTimeWeather) obj;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (temperature != other.temperature)
			return false;
		if (temperatureDescription == null) {
			if (other.temperatureDescription != null)
				return false;
		} else if (!temperatureDescription.equals(other.temperatureDescription))
			return false;
		if (weatherDescription == null) {
			if (other.weatherDescription != null)
				return false;
		} else if (!weatherDescription.equals(other.weatherDescription))
			return false;
		if (windDirection == null) {
			if (other.windDirection != null)
				return false;
		} else if (!windDirection.equals(other.windDirection))
			return false;
		if (windSizeDescription == null) {
			if (other.windSizeDescription != null)
				return false;
		} else if (!windSizeDescription.equals(other.windSizeDescription))
			return false;
		return true;
	}

}
