package com.ple.finalProject;

import java.io.Serializable;
import java.util.Calendar;

@SuppressWarnings("serial")
public class Vehicle implements Serializable{
	private int inventoryId;
	private int year;
	private Calendar startDate;
	private Calendar soldDate;
	private double cost;
	private double soldPrice;	
	private String model;
	
	public Vehicle(){
		
	}
	
	public Vehicle(int inventoryId, String model, int year, Calendar startDate,
			Calendar soldDate, double cost, double soldPrice) {
		super();
		this.inventoryId = inventoryId;		
		this.model = model;
		this.year = year;
		this.startDate = startDate;
		this.soldDate = soldDate;
		this.cost = cost;
		this.soldPrice = soldPrice;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getSoldDate() {
		return soldDate;
	}

	public void setSoldDate(Calendar soldDate) {
		this.soldDate = soldDate;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getSoldPrice() {
		return soldPrice;
	}

	public void setSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	@Override
	public String toString() {		
		return this.inventoryId + "  " + this.model;
	}
}
