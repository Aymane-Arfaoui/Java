package PART2;

import PackageAirCraft.Aircraft;
import PackageAirCraft.WW2plane;
import PackageFerry.Ferry;
import PackageMetro.Metro;
import PackageMonoWheel.Monowheel;
import PackageTrain.Train;
import PackageTrain.Tram;
import PackageWheeledTransportation.WheeledTransportation;

public class Driver2 {
	
	//Create the copyTheObjects method 
	/*
	 * The reason why the copyTheObjects() method doesn't work is 
	 * because the Object class doesn't have a copy constructor, giving us an
	 *  error on  line arr2[i] = new Object(arr1[i]); is invalid. The new Object()
	 *   statement creates a new instance of the Object class,
	 *    which is a base class for all other classes in Java. 
	 *    arr2[i] is simply pointing to the same object as arr1[i], 
	 *    not a copy of it.
	 * */
	public static Object[] copyTheObjects(Object[] arr1) {
		Object[] arr2 = new Object[arr1.length];
		
		for(int i = 0; i<arr1.length; i++)
			arr2[i]= new Object(arr1[i]);
		
		return arr2;
		
		
		
	}

	public static void main(String[] args) {
		
		//Create The Objects Necessary 
		
		WheeledTransportation  WT1 = new WheeledTransportation();
		WT1.setMaxSpeed(28);
		System.out.println(WT1);
		
		Train train1 = new Train();
		System.out.println(train1);
		
		Monowheel MW1 = new Monowheel();
		System.out.println(MW1);
		
		Metro metro1 = new Metro();
		System.out.println(metro1);
		
		Tram tram1 = new Tram();
		System.out.println(tram1);
		
		Ferry ferry1 = new Ferry();
		System.out.println(ferry1);
		
		Aircraft AC1 = new Aircraft();
		AC1.setPrice(30);
		System.out.println(AC1);
		
		WW2plane WP1 = new WW2plane();
		System.out.println(WP1);
		
		System.out.println("");
		
		WheeledTransportation  WT2 = new WheeledTransportation();
		WT2.setMaxSpeed(350);
		System.out.println(WT2);
		
		Train train2 = new Train();
		train2.setStationName("Casablanca");
		train2.setDestName("Dublin");
		
		System.out.println(train2);
		System.out.println("Max speed is : " + train2.getMaxSpeed()+ " km/hr.");
		
		Monowheel MW2 = new Monowheel();
		System.out.println(MW2);
		
		Metro metro2 = new Metro();
		System.out.println(metro2);
		
		
		Tram tram2 = new Tram();
		System.out.println(tram2);
		
		Ferry ferry2 = new Ferry();
		System.out.println(ferry2);
		
		Aircraft AC2 = new Aircraft();
		AC2.setPrice(10);
		System.out.println(AC2);
		
		WW2plane WP2 = new WW2plane();
		WP2.setTwinEngine(true);
		WP2.setMaxElevation(78);
		System.out.println(WP2);
		
		
		///create other objects 
		Aircraft AC3 = new Aircraft();
		AC3.setPrice(43);
		AC3.setMaxElevation(87);
		
		
		WW2plane WP3 = new WW2plane();
		WP3.setTwinEngine(true);
		WP3.setMaxElevation(132);
		
		
		//create more objects
		Train train3 = new Train();
		
		
		Monowheel MW3 = new Monowheel();
		System.out.println(MW3);
		
		Metro metro3 = new Metro();
		System.out.println(metro3);
		
		
		//Equal method of two similar objects
		System.out.println("\nRespond True, if metro 1 and metro 3 are similar (and false if otherwise): " + metro3.equals(metro1));
		System.out.println("Respond True, if train 1 and train 2 are similar (and false if otherwise): " + train1.equals(train2));
		
		//Equal method with two different objects
		System.out.println("Respond True, if the following objects are similar (and false if otherwise): " + train1.equals(metro2));
		
		//Object[] array1 = {WT1,train1, MW1,metro1, tram1, ferry1, AC1, WP1, AC2, AC3,WP3 };
		
		
		//Create the array of objects
		Object[] array1 = {WT1,train1, MW1,metro1, tram1, ferry1, AC1, WP1,
							WT1, train2, MW2,metro2, tram2, ferry2, AC2, WP2,AC3,WP3 
				};
		
		Object[] array2 = {WT1,train1, MW1,metro1, tram1, ferry1, 
				WT1, train2, MW2,metro2, tram2, ferry2,  MW3, metro3,
	};

		
	
		System.out.println("");
		
		//Use the copyTheObjects method
		copyTheObjects(array1);

	}

}
