package Driver1Package;

import PackageAirCraft.Aircraft;
import PackageAirCraft.WW2plane;
import PackageFerry.Ferry;
import PackageMetro.Metro;
import PackageMonoWheel.Monowheel;
import PackageTrain.Train;
import PackageTrain.Tram;
import PackageWheeledTransportation.WheeledTransportation;

public class Driver1 {
	
	//Create findLeastAndMostExpensiveAircraft () method 
	
	public static void findLeastAndMostExpensiveAircraft(Object[] arr) {
		
		//create an index that keeps track if the most expensive and least expensive aircraft
	    Aircraft leastExpensive = null;
	    Aircraft mostExpensive = null;
	    
	    //go through the array
	    for (int i = 0; i < arr.length; i++) {
	    	
	    	//if one of the objects is an instanceof of the Aircraft then, figure out which one has the bigger price or 
	    	//smaller price
	    	/*
	    	 * If leastExpensive is null, it means that no aircraft has been found yet,
	    	 *  so we just set leastExpensive to the current aircraft
	    	 * */
	        if (arr[i] instanceof Aircraft) {
	            Aircraft currentAircraft = (Aircraft) arr[i];
	            if (leastExpensive == null || currentAircraft.getPrice() < leastExpensive.getPrice()) {
	                leastExpensive = currentAircraft;
	            }
	            if (mostExpensive == null || currentAircraft.getPrice() > mostExpensive.getPrice()) {
	                mostExpensive = currentAircraft;
	            }
	        }
	    }
	    //Print appropriate statements if there is an aircraft 
	    if (leastExpensive != null) {
	        System.out.println("The least expensive aircraft is " + leastExpensive);
	    
	    if(mostExpensive != null) {
	    	System.out.println("The most expensive aircraft is " + mostExpensive);
	    	}
	    }
	    else {
	    	//if no aircraft print the following:
	        System.out.println("No aircraft found in the array.");
	    }
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create the 16 objects 
		
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
		System.out.println("Respond True, if metro 1 and metro 3 are similar (and false if otherwise): " + metro3.equals(metro1));
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
		//test the static method we created that determines the highest/lowest price 
		//array where the aircrafts exist
		findLeastAndMostExpensiveAircraft(array1);
		
		//array where the aircraft does not exist 
		findLeastAndMostExpensiveAircraft(array2);
		
		
		/*
		 * 
		 * This part of the assignment works fine.
		 *  The findLeastAndMostExpensiveAircraft method works 
		 *  fine because the way it operates is the following: it
		 *   takes an array of objects as an argument and searches
		 *    for the least expensive and most expensive Aircraft object in that array.
		 *     It does this by iterating through the array and checking if each
		 *      element is an instance of Aircraft. If it is, it compares the price
		 *       of that Aircraft object to the current least and most expensive Aircraft
		 *        objects found so far. If it is less than the current least expensive,
		 *         it updates the least expensive Aircraft object. 
		   			This method works because it correctly identifies Aircraft 
		   			objects in the input array by checking if each element is an 
		   			instance of the Aircraft class. It then uses a null check to ensure 
		   			that the least and most expensive Aircraft objects are initialized
		   			 properly. The comparison of the price of the Aircraft
		   			  objects ensures that the correct least and most
		   			   expensive objects are found.
		  */
		

	
	}
	

	

}
