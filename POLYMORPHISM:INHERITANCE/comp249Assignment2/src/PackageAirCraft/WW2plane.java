package PackageAirCraft;

import PackageAirCraft.Aircraft;

public class WW2plane extends Aircraft {
	
	// define attributes for the class
	boolean TwinEngine;
	
	public WW2plane() {
		
		//System.out.println("Creating a WW2 Plane object using default constructor");
		
		TwinEngine = false;
		
	}
	
	//define the parameterized constructor 
	public WW2plane(double price, double MaxElevation, boolean TwinEngine) {
		
		super(price, MaxElevation);
		
		this.TwinEngine = TwinEngine;
		
		//System.out.println("Creating a WW2 Plane object using parameterized constructor");
			
	}
	
	public WW2plane(WW2plane ww2Copy) {
		
		TwinEngine = ww2Copy.TwinEngine;
		//System.out.println("Creating a WW2 Plane object using copy constructor");
		
	}
	
	//getter methods
	public boolean getTwinEngine() {
		return TwinEngine;
	}
	
	//setter methods 
	
	public void setTwinEngine(boolean tw) {
		TwinEngine = tw;
		
	}

	
	//have a to String Method
	public String toString() {
		//Have a different message if the twin engine is present or not
		if (TwinEngine == true)
		return "This World War 2 Plane vehicle has a price of " + price + " $. " + 
				"It has a max Elevation of " + MaxElevation+ ". It also has a Twin Engine";
		else 
			return "This World War 2 Plane vehicle has a price of " + price + " million $. " + 
			"It has a max Elevation of " + MaxElevation+ " m. It does not have a Twin Engine";
			
	}
	
	//equals to method 
	public boolean equals(Object ww2plane1) {
		if (ww2plane1 == null || getClass() != ww2plane1.getClass())
			return false;
		else {
			//return true if the attributes of the father are the same and the attributes of this class
			WW2plane ww2plane2 = (WW2plane) ww2plane1;
			return super.equals(ww2plane2) && TwinEngine == ww2plane2.TwinEngine;
		}
	}

}
