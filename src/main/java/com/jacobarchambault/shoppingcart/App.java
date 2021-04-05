package com.jacobarchambault.shoppingcart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	public static void main(final String[] args) {
		Application.launch();
	}

	ListView<String> listView;

	ListView<String> initializeListView() throws FileNotFoundException, IOException {
		listView = new ListView<>(
				FXCollections
						.observableArrayList(
								new BookPrices(new BufferedReader(new FileReader(new File("BookPrices.txt"))))
										.toArray()));
		return listView;
	}

	@Override
	public void start(final Stage stage) throws IOException {
		stage
				.setScene(
						new Scene(
								new HBox(
										new VBox(10, new Label("Pick a book"), initializeListView()),
										new VBox(10, new Button("Add to shopping cart")),
										new VBox(10, new Label("Shopping cart"), new ListView<String>()))));

		stage.show();
	}

}