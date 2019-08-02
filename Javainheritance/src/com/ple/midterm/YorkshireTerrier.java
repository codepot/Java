package com.ple.midterm;

public class YorkshireTerrier extends Dog{

	public YorkshireTerrier(int id, String name, String type, int age) {
		super(id, name, type, age);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String guard() {
		return "Yorkshire Terriers do not fear bigger dogs and will even fight bigger dogs on sight";
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String dogToString =  super.toString();
		return dogToString.replace(" ***", " * " + guard());
	}

}
