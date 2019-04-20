package pers.cs.weather.crawler.entiry;

public class County {
	private String id, name, weatherCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeatherCode() {
		return weatherCode;
	}

	public void setWeatherCode(String weatherCode) {
		this.weatherCode = weatherCode;
	}

	@Override
	public String toString() {
		return "County [id=" + id + ", name=" + name + ", weatherCode=" + weatherCode + "]";
	}

}
