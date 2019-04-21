package pers.cs.weather.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.util.StringConverter;
import pers.cs.weather.crawler.DefaultCrawler;
import pers.cs.weather.crawler.entiry.China;
import pers.cs.weather.crawler.entiry.City;
import pers.cs.weather.crawler.entiry.County;
import pers.cs.weather.crawler.entiry.DateTimeWeather;
import pers.cs.weather.crawler.entiry.DateWeather;
import pers.cs.weather.crawler.entiry.Province;
import pers.cs.weather.crawler.exceptions.UnselectdCountyException;
import pers.cs.weather.crawler.util.CityInformationResolver;
import pers.cs.weather.crawler.util.AlertHandler;

public class WeatherReportQueryController implements Initializable {

	@FXML
	private ComboBox<Province> provinceComboBox;

	@FXML
	private ComboBox<City> cityComboBox;

	@FXML
	private ComboBox<County> countyComboBox;

	@FXML
	private Label provinceLabel;

	@FXML
	private Label cityLabel;

	@FXML
	private Label countyLabel;

	@FXML
	private ListView<DateWeather> dateWeathersListView;

	private ObservableList<DateWeather> dateWeathers = FXCollections.observableArrayList();

	@FXML
	private ListView<DateTimeWeather> dateTimeWeathersListView;

	private ObservableList<DateTimeWeather> dateTimeWeathers = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeChoiceBoxs();
		setLabels();
		initializeListViews();
	}

	private void setLabels() {
		String text = provinceComboBox.getValue() == null ? "" : provinceComboBox.getValue().getName() + " >";
		provinceLabel.setText(text);

		text = cityComboBox.getValue() == null ? "" : cityComboBox.getValue().getName() + " >";
		cityLabel.setText(text);

		text = countyComboBox.getValue() == null ? "" : countyComboBox.getValue().getName();
		countyLabel.setText(text);
	}

	private void initializeListViews() {
		dateWeathersListView.setItems(dateWeathers);
		dateTimeWeathersListView.setItems(dateTimeWeathers);

		dateWeathersListView.widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				double fixedValue = dateWeathers.size() == 0 ? 100 : newValue.doubleValue() / dateWeathers.size();
				dateWeathersListView.setFixedCellSize(fixedValue);
			}

		});

		dateTimeWeathersListView.widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				double fixedValue = dateTimeWeathers.size() == 0 ? 100 : newValue.doubleValue() / dateTimeWeathers.size();
				dateTimeWeathersListView.setFixedCellSize(fixedValue);
			}
		});

		dateWeathersListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<DateWeather>() {

			@Override
			public void changed(ObservableValue<? extends DateWeather> observable, DateWeather oldValue,
					DateWeather newValue) {
				if (newValue == null)
					return;
				dateTimeWeathers.setAll(newValue.getDateTimeWeathers());
			}
		});
	}

	private void initializeChoiceBoxs() {
		setConverters();

		China china = CityInformationResolver.resolveCitiesToEntiry();
		ObservableList<Province> list = FXCollections.observableArrayList(china.getProvinces());
		provinceComboBox.setItems(list);
	}

	@FXML
	private void dealProvinceSelected() {
		Province selectedProvince = provinceComboBox.getValue();
		if (selectedProvince == null)
			return;
		ObservableList<City> list = FXCollections.observableArrayList(selectedProvince.getCities());
		cityComboBox.setItems(list);
		countyComboBox.getItems().clear();
	}

	@FXML
	private void dealCitySelected() {
		City selectedCity = cityComboBox.getValue();
		if (selectedCity == null)
			return;
		ObservableList<County> list = FXCollections.observableArrayList(selectedCity.getCounties());
		countyComboBox.setItems(list);
	}

	@FXML
	private void dealQuery() {
		try {
			County county = getSelectedCounty();
			DefaultCrawler defaultCrawler = new DefaultCrawler();

			List<DateWeather> currentDateWeathers = defaultCrawler.getDateWeathers(county);
			dateWeathers.setAll(currentDateWeathers);

			List<DateTimeWeather> currentDateTimeWeathers = currentDateWeathers.get(0).getDateTimeWeathers();
			dateTimeWeathers.setAll(currentDateTimeWeathers);

			setLabels();
		} catch (UnselectdCountyException e) {
			Alert alert = AlertHandler.getAlert(AlertType.ERROR, e.getMessage());
			alert.show();
		}
	}

	private County getSelectedCounty() throws UnselectdCountyException {
		County county = countyComboBox.getValue();
		if (county != null)
			return county;
		throw new UnselectdCountyException("you have not selected a county to query!");
	}

	private void setConverters() {
		provinceComboBox.setConverter(new StringConverter<Province>() {

			@Override
			public String toString(Province object) {
				return object.getName();
			}

			@Override
			public Province fromString(String string) {
				Province province = new Province();
				province.setName(string);
				return province;
			}
		});

		cityComboBox.setConverter(new StringConverter<City>() {

			@Override
			public String toString(City object) {
				return object.getName();
			}

			@Override
			public City fromString(String string) {
				City city = new City();
				city.setName(string);
				return city;
			}
		});

		countyComboBox.setConverter(new StringConverter<County>() {

			@Override
			public String toString(County object) {
				return object.getName();
			}

			@Override
			public County fromString(String string) {
				County county = new County();
				county.setName(string);
				return county;
			}
		});
	}

}
