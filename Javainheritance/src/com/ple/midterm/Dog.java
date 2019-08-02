package com.ple.midterm;

public class Dog extends Mammal{

	public Dog(int id, String name, String type, int age) {
		super(id, name, type, age);
		setFoodCategory("Biscuits");
		setCageCleanedFrequency(2);		
	}
	
	public String guard(){
		return "Dog is a loyal friend and a brave guard.";
	}

}
