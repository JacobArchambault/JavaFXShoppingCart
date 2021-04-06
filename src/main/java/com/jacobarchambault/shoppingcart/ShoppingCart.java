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

	ArrayList<Double> priceArray() {
		var prices = new ArrayList<Double>();
		var items = getItems();
		for (var item : items) {
			prices.add(Double.parseDouble(item.split(",")[1]));
		}
		return prices;
	}

}
