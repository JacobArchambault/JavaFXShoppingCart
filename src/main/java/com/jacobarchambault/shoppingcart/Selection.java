package com.jacobarchambault.shoppingcart;

import javafx.scene.control.ListView;

public class Selection {

	ListView<String> listView;
	ListView<String> shoppingCrt;

	Selection(ListView<String> listView, ListView<String> shoppingCart) {
		this.listView = listView;
		this.shoppingCrt = shoppingCart;
	}

	void addItem() {
		String selection = listView.getSelectionModel().getSelectedItem();
		var shoppingCartItems = shoppingCrt.getItems();
		if (!shoppingCartItems.contains(selection) && selection != null) {
			shoppingCartItems.add(selection);
		}
	}

}
