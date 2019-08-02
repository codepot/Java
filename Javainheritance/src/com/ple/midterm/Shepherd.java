package com.ple.midterm;

public class Shepherd extends Dog{

	public Shepherd(int id, String name, String type, int age) {
		super(id, name, type, age);		
	}
	
	@Override
	public String guard() {
		return "A Shepherd quickly reacts when its family or home is threatened";
	}
	
	@Override
	public String toString() {		
		// TODO Auto-generated method stub
		String dogToString =  super.toString();
		return dogToString.replace(" ***", " * " + guard());
	}

}
