package com.jacobarchambault.shoppingcart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookPrices {
	static List<String> createFile() throws IOException {
		ArrayList<String> result = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader("BookPrices.txt"))) {
			while (br.ready()) {
				result.add(br.readLine());
			}
		}
		return result;
	}

}
