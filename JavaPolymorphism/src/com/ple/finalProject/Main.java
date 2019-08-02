package com.ple.finalProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ple.finalProject.car.Car;
import com.ple.finalProject.car.Ford;
import com.ple.finalProject.truck.Truck;

public class Main {

	public static void main(String[] args) {		
			report(Helper.initCalendar("08/01/2012"));		
	}
	
	public static void report(Calendar reportDate){
		try {
			double totalCost = 0.0;
			double totalSales = 0.0;
			int numberOfCar = 0;
			int numberOfTruck = 0;
			int numberOfFord = 0;
			List<Vehicle> soldVehicles = getVehiclesSold(reportDate);
			System.out.println(String.format("%65s", "MONTHLY SALES REPORT AS OF " + Helper.getCalendarText(reportDate)));
			String line = String.format("%94s", " " ).replace(" ", "-");
			System.out.println(line);
			System.out.println(Helper.getHeader());
			System.out.println(line);
			for(Vehicle vehicle : soldVehicles){
				System.out.println(vehicle);
				totalCost += vehicle.getCost();
				totalSales += vehicle.getSoldPrice();
				if (vehicle instanceof Car)
					numberOfCar += 1;
				
				if (vehicle instanceof Truck)
					numberOfTruck+=1;
				
				if (vehicle instanceof Ford || vehicle instanceof com.ple.finalProject.truck.Ford)
					numberOfFord += 1;				
			}
			System.out.println(line);
			
			String summary = "* TOTAL SALES: " + String.format("%12s", "$" + String.format("%1$,.2f", totalSales));
			summary += "         NUMBER OF CARS  : " + numberOfCar+ "\n";
			summary += "* TOTAL COST : "+ String.format("%12s", "$" + String.format("%1$,.2f", totalCost));
			summary += "         NUMBER OF TRUCKS: " + numberOfTruck+ "\n";
			summary += String.format("%27s", "-------------") + "         NUMBER OF FORDS : " + numberOfFord + "\n";
			summary += "* NET PROFIT : "+ String.format("%12s", "$" + String.format("%1$,.2f", totalSales - totalCost));
			summary += "            TOTAL VEHICLE: " + soldVehicles.size() + "\n\n";
			System.out.println(summary);
			
			Collections.sort(soldVehicles, new Comparator<Vehicle>(){

				@Override
				public int compare(Vehicle thisVehicle, Vehicle thatVehicle) {						
					return Double.compare(thisVehicle.getSoldPrice(),thatVehicle.getSoldPrice());
				}				
			});
			
			System.out.println(String.format("%75s", "LIST OF SOLD VEHICLES AS OF " + Helper.getCalendarText(reportDate) + ", SORTED BY SOLD PRICE"));
			System.out.println(line);
			System.out.println(Helper.getHeader());
			System.out.println(line);
			for(Vehicle vehicle : soldVehicles)
				System.out.println(vehicle);
			System.out.println(line);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static List<Vehicle> getVehiclesSold(Calendar reportDate)
			throws ClassNotFoundException, IOException {
		Inventory inventory = ReadInventory.readInventory();
		List<Vehicle> list = new ArrayList<Vehicle>();
		int reportMonth = reportDate.get(Calendar.MONTH) +1;
		
		for (Vehicle vehicle : inventory.getVehicles()) {
			int soldMonth = vehicle.getSoldDate().get(Calendar.MONTH) + 1;
			
			if ((reportDate.compareTo(vehicle.getSoldDate()) > 0 && ((reportMonth == soldMonth + 1) || (soldMonth == 13- reportMonth)))) {
				list.add(vehicle);
			}
		}
		return list;
	}
}
