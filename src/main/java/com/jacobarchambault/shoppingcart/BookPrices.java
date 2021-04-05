package com.jacobarchambault.shoppingcart;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookPrices {
	BufferedReader br;

	BookPrices(final BufferedReader reader) {
		br = reader;
	}

	List<String> toArrayList() throws IOException {
		final var result = new ArrayList<String>();
		while (br.ready()) {
			var titles = br.readLine().split(",");
			result.add(titles[0]);
		}
		return result;
	}

}
