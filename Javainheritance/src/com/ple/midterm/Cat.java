package com.ple.midterm;

public class Cat extends Mammal{

	public Cat(int id, String name, String type, int age) {
		super(id, name, type, age);
		setFoodCategory("Fishes");
		setCageCleanedFrequency(7);	
	}

}
