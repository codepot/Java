package com.phucle.serialize;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteProductObject {
	
	private static ObjectOutputStream productOutput;

	public static void main(String[] args) {
		
		try {
			writeProduct(new Product(1, "Printer/Photocopier", "Xerox", 1500.75));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void writeProduct(Product product) throws IOException{
		openFile();
		addRecord(product);
		closeFile();
	}

	private static void openFile() throws IOException {
		
			productOutput = new ObjectOutputStream(Files.newOutputStream(Paths
					.get("product.ser")));
		
	}

	private static void addRecord(Product product) throws IOException {		
			productOutput.writeObject(product);		
	}

	private static void closeFile() throws IOException {
		
			if (productOutput != null)
				productOutput.close();
		
	}
}
