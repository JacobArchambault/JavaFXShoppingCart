package com.jacobarchambault.shoppingcart;

import javafx.scene.control.ListView;

public class ShoppingCart {

	ListView<String> listView;
	ListView<String> shoppingCrt;

	ShoppingCart(ListView<String> listView, ListView<String> shoppingCart) {
		this.listView = listView;
		this.shoppingCrt = shoppingCart;
	}

	void addItemToShoppingCart() {
		String selection = listView.getSelectionModel().getSelectedItem();
		var shoppingCartItems = shoppingCrt.getItems();
		if (!shoppingCartItems.contains(selection)) {
			shoppingCartItems.add(selection);
		}
	}

}
