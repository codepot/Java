package com.ple.finalProject.truck;

import java.util.Calendar;

import com.ple.finalProject.Helper;

@SuppressWarnings("serial")
public class Other extends Truck {
	private String make;

	public Other() {
		super();
	}

	public Other(int inventoryId, String make, String model, int year,
			Calendar startDate, Calendar soldDate, double cost,
			double soldPrice, int numberOfWheels) {
		super(inventoryId, model, year, startDate, soldDate, cost, soldPrice,
				numberOfWheels);
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
		output += String.format("%-8s", "Truck");
		output += String.format("%-8s", this.make);
		output += String.format("%-15s", this.getModel());
		output += String.format("%-8s", "  " + this.getYear());
		output += String.format("%-10s", Helper.getCalendarText(this.getStartDate()));
		output += String.format("%-10s", Helper.getCalendarText(this.getSoldDate()));
		output += String.format("%12s", "$" + String.format("%1$,.2f", this.getCost()));
		output += String.format("%12s", "$" + String.format("%1$,.2f", this.getSoldPrice()));
		output += String.format("%-10s", "  "+  this.getNumberOfWheels() + "WHL");		
		
		return output;
	}
	
}
