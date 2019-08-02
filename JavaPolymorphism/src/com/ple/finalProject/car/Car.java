package com.ple.finalProject.car;

import java.util.Calendar;

import com.ple.finalProject.Helper;
import com.ple.finalProject.Vehicle;

@SuppressWarnings("serial")
public class Car extends Vehicle {
	private int numberOfDoors;
	
	public Car(){
		super();
	}

	public Car(int inventoryId, String model, int year, Calendar startDate,
			Calendar soldDate, double cost, double soldPrice, int numberOfDoors) {
		super(inventoryId, model, year, startDate, soldDate, cost, soldPrice);
		this.numberOfDoors = numberOfDoors;
	}

	public int getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}
	
	@Override
	public String toString() {		
		String output = String.format("%-3s", this.getInventoryId());
		output += String.format("%-8s", "Car");
		output += String.format("%-8s", this.getClass().getSimpleName());
		output += String.format("%-15s", this.getModel());
		output += String.format("%-8s", "  " + this.getYear());
		output += String.format("%-10s", Helper.getCalendarText(this.getStartDate()));
		output += String.format("%-10s", Helper.getCalendarText(this.getSoldDate()));
		output += String.format("%12s", "$" + String.format("%1$,.2f", this.getCost()));
		output += String.format("%12s", "$" + String.format("%1$,.2f", this.getSoldPrice()));
		output += String.format("%-10s","  "+ this.getNumberOfDoors() + "DR");		
		
		return output;
	}
}
