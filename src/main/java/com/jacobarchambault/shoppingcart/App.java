package com.jacobarchambault.shoppingcart;

import java.io.BufferedReader;
import java.io.File;
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

	ListView<String> shoppingCart = new ListView<>();

	@Override
	public void start(final Stage stage) throws IOException {
		final var listView = new ListView<String>(
				FXCollections
						.observableArrayList(
								new BookPrices(new BufferedReader(new FileReader(new File("BookPrices.txt"))))
										.toArray()));

		final var sc = new ShoppingCart(listView, shoppingCart);

		stage
				.setScene(
						new Scene(
								new HBox(
										10,
										new VBox(
												10,
												new Label("Pick a book"),
												listView,
												new EventButton("Add to shopping cart", e -> sc.addItem())),
										new VBox(
												10,
												new Label("Shopping cart"),
												shoppingCart,
												new HBox(
														10,
														new EventButton("Remove selection", e -> remove()),
														new Button("Clear cart"))))));

		stage.show();
	}

	void remove() {
		shoppingCart.getItems().remove(shoppingCart.getSelectionModel().getSelectedItem());
	}
}