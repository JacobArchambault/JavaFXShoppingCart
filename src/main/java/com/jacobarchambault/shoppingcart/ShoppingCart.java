package com.jacobarchambault.shoppingcart;

import java.util.ArrayList;

import javafx.scene.control.ListView;

public class ShoppingCart extends ListView<String> {
	void remove() {
		getItems().remove(getSelectionModel().getSelectedItem());
	}

	void removeAll() {
		getItems().clear();
	}

	Double subTotal() {
		var items = getItems();
		var sum = 0.0;
		for (var item : items) {
			sum += Double.parseDouble(item.split(",")[1]);
		}
		return sum;
	}

}
