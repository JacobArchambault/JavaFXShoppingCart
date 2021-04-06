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

	ArrayList<String> priceArray() {
		var prices = new ArrayList<String>();
		var items = getItems();
		for (var item : items) {
			prices.add(item.split(",")[1]);
		}
		return prices;
	}

}
