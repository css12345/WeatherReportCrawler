package pers.cs.weather.crawler.entiry;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DateWeather {
	private LocalDate date;
	private String dateDescription;
	private String weatherDescription;
	private int minTemperature, maxTemperature;
	private String temperatureDescription;
	private String windDescription;

	private List<DateTimeWeather> dateTimeWeathers = new ArrayList<>();

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((dateDescription == null) ? 0 : dateDescription.hashCode());
		result = prime * result + ((dateTimeWeathers == null) ? 0 : dateTimeWeathers.hashCode());
		result = prime * result + maxTemperature;
		result = prime * result + minTemperature;
		result = prime * result + ((temperatureDescription == null) ? 0 : temperatureDescription.hashCode());
		result = prime * result + ((weatherDescription == null) ? 0 : weatherDescription.hashCode());
		result = prime * result + ((windDescription == null) ? 0 : windDescription.hashCode());
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
		DateWeather other = (DateWeather) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (dateDescription == null) {
			if (other.dateDescription != null)
				return false;
		} else if (!dateDescription.equals(other.dateDescription))
			return false;
		if (dateTimeWeathers == null) {
			if (other.dateTimeWeathers != null)
				return false;
		} else if (!dateTimeWeathers.equals(other.dateTimeWeathers))
			return false;
		if (maxTemperature != other.maxTemperature)
			return false;
		if (minTemperature != other.minTemperature)
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
		if (windDescription == null) {
			if (other.windDescription != null)
				return false;
		} else if (!windDescription.equals(other.windDescription))
			return false;
		return true;
	}

}
