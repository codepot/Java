package com.ple.finalProject.car;

import java.util.Calendar;

import com.ple.finalProject.Helper;

@SuppressWarnings("serial")
public class Other extends Car{
	private String make;
	
	public Other(){
		super();
	}
	
	public Other(int inventoryId, String make, String model, int year, Calendar startDate,
			Calendar soldDate, double cost, double soldPrice, int numberOfDoors) {
		super(inventoryId, model, year, startDate, soldDate, cost, soldPrice, numberOfDoors);		
		this.make = make;
	}	
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@Override
	public String toString() {
		String output = String.format("%-3s", this.getInventoryId());
		output += String.format("%-8s", "Car");
		output += String.format("%-8s", this.make);
		output += String.format("%-15s", this.getModel());
		output += String.format("%-8s", "  " + this.getYear());
		output += String.format("%-10s", Helper.getCalendarText(this.getStartDate()));
		output += String.format("%-10s", Helper.getCalendarText(this.getSoldDate()));
		output += String.format("%12s", "$" + String.format("%1$,.2f", this.getCost()));
		output += String.format("%12s", "$" + String.format("%1$,.2f", this.getSoldPrice()));
		output += String.format("%-10s", "  "+ this.getNumberOfDoors() + "DR");		
		
		return output;
	}
}
