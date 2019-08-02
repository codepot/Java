package com.ple.midterm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.SwingUtilities;

import com.ple.midterm.gui.Display;


/*
 * Student: Phuc Le
 * Java 2 - Midterm
 * ABC Humane Society Mammal Project
 */

public class Main {
	private List<Mammal> mammals = new ArrayList<Mammal>();

	public List<Mammal> getMammals() {
		return mammals;
	}

	public Main() {
		Calendar c1 = GregorianCalendar.getInstance();
		c1.set(2015, Calendar.JULY, 23);
		Mammal arlo = new Dog(1, "Arlo", "Irish Setter", 5);
		arlo.setCageLastCleanedDate(c1);
		mammals.add(arlo);

		Calendar c2 = GregorianCalendar.getInstance();
		c2.set(2015, Calendar.JULY, 28);
		Mammal antonio = new Dog(2, "Antonio", "Pug", 4);
		antonio.setCageLastCleanedDate(c2);
		mammals.add(antonio);

		Calendar c3 = GregorianCalendar.getInstance();
		c3.add(Calendar.DAY_OF_MONTH, -3);
		Mammal utie = new Other(3, "Utie", "Guinea Pigs", 2);
		utie.setCageCleanedFrequency(3);
		utie.setCageLastCleanedDate(c3);
		utie.setFoodCategory("Vegetables");
		mammals.add(utie);

		Calendar c4 = GregorianCalendar.getInstance();
		c4.add(Calendar.DAY_OF_MONTH, -3);
		Mammal white = new Cat(4, "Petty White", "American Curl", 7);
		white.setCageLastCleanedDate(c4);
		mammals.add(white);

		Calendar c5 = GregorianCalendar.getInstance();
		c5.set(2015, Calendar.JULY, 27);
		Mammal batty = new Dog(5, "Batty", "Weimaraner", 8);
		batty.setCageLastCleanedDate(c5);
		mammals.add(batty);

		Calendar c6 = GregorianCalendar.getInstance();
		c6.set(2015, Calendar.JULY, 28);
		Mammal buddy = new Shepherd(6, "Buddy", "German Shepherd", 8);
		buddy.setCageLastCleanedDate(c6);
		mammals.add(buddy);

		Calendar c7 = GregorianCalendar.getInstance();
		c7.set(2015, Calendar.JULY, 27);
		Mammal calie = new Cat(7, "Calie", "Bombay", 4);
		calie.setCageLastCleanedDate(c7);
		mammals.add(calie);

		Calendar c8 = GregorianCalendar.getInstance();
		c8.add(Calendar.DAY_OF_MONTH, -4);
		Mammal barkley = new YorkshireTerrier(8, "Barkley", "Terrier", 6);
		barkley.setCageLastCleanedDate(c8);
		mammals.add(barkley);

		Calendar c9 = GregorianCalendar.getInstance();
		c9.add(Calendar.DAY_OF_MONTH, -5);
		Mammal mya = new Cat(9, "Mya", "Burmese", 5);
		mya.setCageLastCleanedDate(c9);
		mammals.add(mya);

		Calendar c10 = GregorianCalendar.getInstance();
		c10.add(Calendar.DAY_OF_MONTH, -2);
		Mammal lexi = new Shepherd(10, "Lexi", "Belgian Shepherd", 7);
		lexi.setCageLastCleanedDate(c10);
		mammals.add(lexi);

	}

	public void report() {
		for (Mammal mammal : mammals)
			System.out.println(mammal);
	}

	// Sorted: sort by class names
	public void reportSortedByType() {
		Collections.sort(mammals, new Comparator<Mammal>() {
			@Override
			public int compare(Mammal thisObject, Mammal thatObject) {
				return (thisObject).getClass().getSimpleName()
						.compareTo((thatObject).getClass().getSimpleName());
			}
		});

		report();
		System.out
				.println("\n\t\t***LIST OF MAMMALS WAS SORTED BY MAMMAL TYPES***");
	}

	// Sorted: cages need to be cleaned on the top of the list
	public void reportSortedByCageCleaningStatus() {
		Collections.sort(mammals, new Comparator<Mammal>() {
			@Override
			public int compare(Mammal thisObject, Mammal thatObject) {
				return -new Boolean((thisObject).needCageCleaning())
						.compareTo(new Boolean((thatObject).needCageCleaning()));
			}
		});

		report();
		System.out
				.println("\n\t\t***LIST OF MAMMALS WAS SORTED BY CAGE CLEANING STATUS***");
	}

	// Sorted: by Name
	public void reportSortedByName() {

		Collections.sort(mammals, new Comparator<Mammal>() {
			@Override
			public int compare(Mammal thisObject, Mammal thatObject) {
				return (thisObject).getName().compareTo((thatObject).getName());
			}
		});

		report();
		System.out.println("\n\t\t***LIST OF MAMMALS WAS SORTED BY NAMES***");
	}

	// Sorted: by Name
	public void reportSortedById() {

		Collections.sort(mammals, new Comparator<Mammal>() {
			@Override
			public int compare(Mammal thisObject, Mammal thatObject) {
				return new Integer((thisObject).getId()).compareTo((thatObject)
						.getId());
			}
		});

		report();
		System.out.println("\n\t\t***LIST OF MAMMALS WAS SORTED BY NAMES***");
	}

	public static void main(String[] args) {
		Main aMain = new Main();
		aMain.report();
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				new Display(aMain);				
			}
		});
		
	}

}
