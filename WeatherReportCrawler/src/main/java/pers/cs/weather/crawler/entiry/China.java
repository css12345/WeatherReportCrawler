package pers.cs.weather.crawler.entiry;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class China {
	private List<Province> provinces;

	@XmlElement(name = "province")
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
