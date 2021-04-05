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

	List<String> toArray() throws IOException {
		final var result = new ArrayList<String>();
		while (br.ready()) {
			result.add(br.readLine());
		}
		return result;
	}

}
