package com.jacobarchambault.shoppingcart;

import javafx.scene.control.ListView;

public class Selection {

	ListView<String> listView;
	ListView<String> shoppingCrt;

	Selection(final ListView<String> listView, final ListView<String> shoppingCart) {
		this.listView = listView;
		shoppingCrt = shoppingCart;
	}

	void addItem() {
		final var selection = listView.getSelectionModel().getSelectedItem();
		final var shoppingCartItems = shoppingCrt.getItems();
		if (!shoppingCartItems.contains(selection) && selection != null) {
			shoppingCartItems.add(selection);
		}
	}

}
