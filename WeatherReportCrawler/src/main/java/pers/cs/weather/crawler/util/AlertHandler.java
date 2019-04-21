package pers.cs.weather.crawler.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public abstract class AlertHandler {
	public static Alert getAlert(AlertType type, String headerText, String contentText) {
		Alert alert = new Alert(type);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		return alert;
	}
	
	public static Alert getAlert(AlertType type,String contentText) {
		return getAlert(type, "", contentText);
	}
}
