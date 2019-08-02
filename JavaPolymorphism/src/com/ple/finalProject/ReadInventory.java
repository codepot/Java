package com.ple.finalProject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadInventory {
	private static ObjectInputStream inventoryInput;

	public static Inventory readInventory() throws IOException,
			ClassNotFoundException {
		openFile();
		Inventory inventory = readRecords();
		closeFile();
		return inventory;
	}

	private static void openFile() throws IOException {
		inventoryInput = new ObjectInputStream(Files.newInputStream(Paths
				.get("samsautos.ser")));
	}

	private static Inventory readRecords() throws ClassNotFoundException,
			IOException {		
		Inventory inventory = (Inventory) inventoryInput.readObject();
		return inventory;
	}

	private static void closeFile() throws IOException {
		if (inventoryInput != null)
			inventoryInput.close();
	}
}
