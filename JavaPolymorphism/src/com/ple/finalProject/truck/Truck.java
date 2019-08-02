package com.ple.finalProject.truck;

import java.util.Calendar;

import com.ple.finalProject.Helper;
import com.ple.finalProject.Vehicle;

@SuppressWarnings("serial")
public class Truck extends Vehicle{
	private int numberOfWheels;
	
	public Truck(){
		super();
	}
	
	public Truck(int inventoryId, String model, int year, Calendar startDate,
			Calendar soldDate, double cost, double soldPrice, int numberOfWheels) {
		super(inventoryId, model, year, startDate, soldDate, cost, soldPrice);
		this.numberOfWheels = numberOfWheels;
	}

	public int getNumberOfWheels() {
		return numberOfWheels;
	}

	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}
	
	@Override
	public String toString() {		
		String output = String.format("%-3s", this.getInventoryId());
		output += String.format("%-8s", "Truck");
		output += String.format("%-8s", this.getClass().getSimpleName());
		output += String.format("%-15s", this.getModel());
		output += String.format("%-8s", "  " + this.getYear());
		output += String.format("%-10s", Helper.getCalendarText(this.getStartDate()));
		output += String.format("%-10s", Helper.getCalendarText(this.getSoldDate()));
		output += String.format("%12s", "$" + String.format("%1$,.2f", this.getCost()));
		output += String.format("%12s", "$" + String.format("%1$,.2f", this.getSoldPrice()));
		output += String.format("%-10s", "  "+ this.getNumberOfWheels() + "WHL");		
		
		return output;
	}
	
	
}
