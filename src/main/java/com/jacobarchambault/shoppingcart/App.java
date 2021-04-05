package com.jacobarchambault.shoppingcart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
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
	public void start(Stage stage) throws IOException {
		stage
				.setScene(
						new Scene(
								new VBox(
										10,
										new Label("Pick a book"),
										new ListView<String>(
												FXCollections.observableArrayList(BookPrices.createFile())))));

		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}