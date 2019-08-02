package com.ple.finalProject.truck;

import java.util.Calendar;

@SuppressWarnings("serial")
public class Ford extends Truck{
	public Ford(){
		super();
	}
	
	public Ford(int inventoryId, String model, int year, Calendar startDate,
			Calendar soldDate, double cost, double soldPrice, int numberOfWheels) {
		super(inventoryId, model, year, startDate, soldDate, cost, soldPrice, numberOfWheels);		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
