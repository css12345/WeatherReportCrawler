package pers.cs.weather;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartUp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(StartUp.class.getResource("view/WeatherReportQueryView.fxml"));
		
		VBox vBox = loader.load();
		Scene scene = new Scene(vBox);
		primaryStage.setTitle("天气预报");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
