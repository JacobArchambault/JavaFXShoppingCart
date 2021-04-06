package com.jacobarchambault.shoppingcart;

import javafx.scene.control.ListView;

public class ShoppingCart extends ListView<String> {
	void remove() {
		getItems().remove(getSelectionModel().getSelectedItem());
	}

	void removeAll() {
		getItems().clear();
	}

	Double subTotal() {
		final var items = getItems();
		var sum = 0.0;
		for (final var item : items) {
			sum += Double.parseDouble(item.split(",")[1]);
		}
		return sum;
	}

}
