package com.phucle.serialize;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadProductObject {
	private static ObjectInputStream productInput;

	public static void main(String[] args) {		
		Product product;
		try {
			product = readProduct();
			System.out.println(product);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static Product readProduct() throws IOException, ClassNotFoundException{
		openFile();
		Product product = readRecords();		
		closeFile();
		return product;
	}

	private static void openFile() throws IOException {		
			productInput = new ObjectInputStream(Files.newInputStream(Paths
					.get("product.ser")));		
	}

	private static Product readRecords() throws ClassNotFoundException, IOException {
					
			Product productRecord = (Product) productInput.readObject();
			return productRecord;

	}

	private static void closeFile() throws IOException {
		
			if (productInput != null)
				productInput.close();
		
	}
}
