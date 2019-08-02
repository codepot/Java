package com.ple.finalProject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Inventory implements Serializable{
	private List<Vehicle> vehicles;
	
	public Inventory(){
		this.vehicles = new ArrayList<Vehicle>();
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	
	
}
