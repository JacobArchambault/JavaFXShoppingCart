package com.jacobarchambault.shoppingcart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
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

	ShoppingCart shoppingCart = new ShoppingCart();
	Label subTotal = new Label("$0.00");
	Label tax = new Label("$0.00");
	Label total = new Label("$0.00");

	@Override
	public void start(final Stage stage) throws IOException {
		final var listView = new ListView<>(
				FXCollections
						.observableArrayList(
								new BookPrices(new BufferedReader(new FileReader(new File("BookPrices.txt"))))
										.toArrayList()));
		stage
				.setScene(
						new Scene(
								new HBox(
										10,
										new VBox(
												10,
												new Label("Pick a book"),
												listView,
												new EventButton("Add to shopping cart", e -> {
													new Selection(listView, shoppingCart).addItem();
													update(shoppingCart.subTotal());
												})),
										new VBox(
												10,
												new Label("Shopping cart"),
												shoppingCart,
												new HBox(10, new EventButton("Remove selection", e -> {
													shoppingCart.remove();
													update(shoppingCart.subTotal());
												}),
														new EventButton("Clear cart", e -> clear()),
														new EventButton("Checkout", e -> clear())),
												new HBox(
														10,
														new Label("Subtotal: "),
														subTotal,
														new Label("Tax: "),
														tax,
														new Label("Total: "),
														total)))));

		stage.show();
	}

	private void clear() {
		shoppingCart.removeAll();
		update(shoppingCart.subTotal());
	}

	void update(final double sum) {
		final var taxAmount = sum * .07;
		subTotal.setText(NumberFormat.getCurrencyInstance().format(sum));
		tax.setText(NumberFormat.getCurrencyInstance().format(taxAmount));
		total.setText(NumberFormat.getCurrencyInstance().format(sum + taxAmount));

	}

}