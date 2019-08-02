package com.ple.finalProject;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;
import com.ple.finalProject.car.Dodge;
import com.ple.finalProject.car.Ford;
import com.ple.finalProject.car.Other;

public class WriteInventory {
	
	private static ObjectOutputStream inventoryOutput;

	public static void main(String[] args) {
		try {
			createInventory();
			System.out.println("saved inventory");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createInventory() throws IOException {
		Vehicle vehicle1 = new Ford(1, "Crown Victoria", 2010,
				Helper.initCalendar("07/03/2012"),
				Helper.initCalendar("07/23/2012"), 8900.0, 14000.0, 4);
		Vehicle vehicle2 = new Other(2, "Toyota", "Camry", 2009,
				Helper.initCalendar("07/27/2012"),
				Helper.initCalendar("07/27/2012"), 7600.0, 17500.0, 4);
		Vehicle vehicle3 = new com.ple.finalProject.truck.Ford(3, "F-150",
				2010, Helper.initCalendar("07/21/2012"),
				Helper.initCalendar("07/29/2012"), 17600.0, 27500.0, 4);
		Vehicle vehicle7 = new com.ple.finalProject.truck.Ford(7, "F-450",
				2010, Helper.initCalendar("07/14/2012"),
				Helper.initCalendar("07/30/2012"), 17600.0, 39500.0, 6);
		Vehicle vehicle4 = new com.ple.finalProject.truck.Other(4, "GMC",
				"Sierra 1500", 2009, Helper.initCalendar("07/02/2012"),
				Helper.initCalendar("07/24/2012"), 11600.0, 19500.0, 4);
		Vehicle vehicle5 = new Dodge(5, "Caravan", 2009,
				Helper.initCalendar("07/07/2012"),
				Helper.initCalendar("07/18/2012"), 2600.0, 9500.0, 4);
		Vehicle vehicle6 = new Ford(2, "Mustang", 2009,
				Helper.initCalendar("07/14/2012"),
				Helper.initCalendar("08/23/2012"), 12600.0, 25600.0, 2);

		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles.add(vehicle1);
		vehicles.add(vehicle2);
		vehicles.add(vehicle3);
		vehicles.add(vehicle7);
		vehicles.add(vehicle4);
		vehicles.add(vehicle5);
		vehicles.add(vehicle6);

		Inventory inventory = new Inventory();
		inventory.setVehicles(vehicles);

		writeVehicles(inventory);

	}

	public static void writeVehicles(Inventory inventory) throws IOException {
		openFile();
		addRecord(inventory);
		closeFile();
	}

	private static void openFile() throws IOException {
		inventoryOutput = new ObjectOutputStream(Files.newOutputStream(Paths
				.get("samsautos.ser")));
	}

	private static void addRecord(Inventory inventory) throws IOException {
		inventoryOutput.writeObject(inventory);
	}

	private static void closeFile() throws IOException {
		if (inventoryOutput != null)
			inventoryOutput.close();
	}

}
