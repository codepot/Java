package com.ple.midterm;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Mammal {
	private int id;
	private String name;
	private String type;
	private int age;
	private String foodCategory;
	private int cageCleanedFrequency;
	private Calendar cageLastCleanedDate;

	public Mammal(int id, String name, String type, int age) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	public int getCageCleanedFrequency() {
		return cageCleanedFrequency;
	}

	public void setCageCleanedFrequency(int cageCleanedFrequency) {
		this.cageCleanedFrequency = cageCleanedFrequency;
	}

	public Calendar getCageLastCleanedDate() {
		return cageLastCleanedDate;
	}

	public void setCageLastCleanedDate(Calendar cageLastCleanedDate) {
		this.cageLastCleanedDate = cageLastCleanedDate;
	}

	public boolean needCageCleaning() {
		Calendar today = GregorianCalendar.getInstance();
		long days = (today.getTime().getTime() - cageLastCleanedDate.getTime()
				.getTime()) / (1000 * 60 * 60 * 24);
		if (days >= 2)
			return true;
		return false;
	}

	@Override
	public String toString() {
		String info ="  [" + this.getClass().getSimpleName() + "] ***\n";
		info += "\tID: " + this.id + "\n";
		info += "\tName: " + this.name + "\n";
		info += "\tAge: " + this.age + "\n";
		info += "\tType: " + this.type + "\n";
		info += "\tFood Category: " + this.foodCategory + "\n";
		info += "\tCage Last Cleaned Date: "
				+ formatCalendar(this.cageLastCleanedDate) + "\n";
		if (needCageCleaning())
			info += "\t\t!!! need to clean the cage\n";
		else
			info += "\t\t* cage was cleaned\n";
		return info;
	}

	private String formatCalendar(Calendar calendar) {
		return new SimpleDateFormat("MM/dd/yyyy").format(calendar.getTime());
	}
	
	public String getFormatedCageLastCleanedDate(){
		return formatCalendar(this.cageLastCleanedDate);
	}
}
