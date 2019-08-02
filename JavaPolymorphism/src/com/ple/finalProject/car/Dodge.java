package com.ple.finalProject.car;

import java.util.Calendar;

@SuppressWarnings("serial")
public class Dodge extends Car{
	public Dodge(){
		super();
	}
	
	public Dodge(int inventoryId, String model, int year, Calendar startDate,
			Calendar soldDate, double cost, double soldPrice, int numberOfDoors) {
		super(inventoryId, model, year, startDate, soldDate, cost, soldPrice, numberOfDoors);		
	}	
	
}
