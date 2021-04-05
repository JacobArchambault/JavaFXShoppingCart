package com.jacobarchambault.shoppingcart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	@Override
	public void start(Stage stage) {
		stage.setScene(new Scene(new VBox(10, new Label("Pick a book"), new ListView<String>())));
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}