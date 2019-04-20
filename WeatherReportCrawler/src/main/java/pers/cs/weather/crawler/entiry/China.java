package pers.cs.weather.crawler.entiry;

import java.util.List;

public class China {
	private List<Province> provinces;

	public List<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}

	@Override
	public String toString() {
		return "China [provinces=" + provinces + "]";
	}

}
