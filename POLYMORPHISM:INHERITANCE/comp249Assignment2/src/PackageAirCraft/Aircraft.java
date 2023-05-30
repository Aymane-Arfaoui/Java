package PackageAirCraft;

import PackageFerry.Ferry;

public class Aircraft {
	
	//protected so WW2	plane can access it 
	// define attributes for the class
	protected double price;
	protected double MaxElevation;
	
	public Aircraft() {
		//System.out.println("Creating an AirCraft object using default constructor");
		
		price = 25;
		MaxElevation = 45;
		
	}
	
	public Aircraft (double price, double MaxElevation) {
		this.price = price;
		this.MaxElevation = MaxElevation;
		
		//System.out.println("Creating an Aircraft object using parameterized constructor");
		
	}
	
	// Create the Copy constructor 
	
	public Aircraft(Aircraft aircraftCopy) {
		price = aircraftCopy.price;
		MaxElevation = aircraftCopy.MaxElevation;
		
		//System.out.println("Creating an Aircraft object using the copy constructor");
		
	}
	
			//getter methods
			public double getPrice() {
				return price;
			}
			
			public double getMaxElevation() {
				return MaxElevation;
			}
			
			//setter methods 
			
			public void setPrice(double pr) {
				price = pr;
				
			}
			
			public void setMaxElevation(double me) {
				MaxElevation = me;
				
			}
			
			//have a to String Method
			public String toString() {
				return "This Aircraft vehicle has a price of " + price + " million $. " + 
						"It also has a max Elevation of " + MaxElevation + " m.";
			}
			
			//equals to method 
			public boolean equals(Object aircraft1) {
				if (aircraft1 == null || getClass() != aircraft1.getClass())
					return false;
				else {
					//return true if the attributes of the father are the same and the attributes of this class
					Aircraft aircraft2 = (Aircraft) aircraft1;
					return super.equals(aircraft2) && price == aircraft2.price && MaxElevation == aircraft2.MaxElevation ;
				}
			}

}
