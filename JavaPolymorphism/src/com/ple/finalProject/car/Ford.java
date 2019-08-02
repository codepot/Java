package com.ple.finalProject.car;

import java.util.Calendar;

@SuppressWarnings("serial")
public class Ford extends Car{
	public Ford(){
		super();
	}
	
	public Ford(int inventoryId, String model, int year, Calendar startDate,
			Calendar soldDate, double cost, double soldPrice, int numberOfDoors) {
		super(inventoryId, model, year, startDate, soldDate, cost, soldPrice, numberOfDoors);		
	}
	
}
