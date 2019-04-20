package pers.cs.weather.crawler.entiry;

import java.util.List;

public class Province {
	private String id, name;
	private List<City> cities;

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

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "Province [id=" + id + ", name=" + name + ", cities=" + cities + "]";
	}

}
