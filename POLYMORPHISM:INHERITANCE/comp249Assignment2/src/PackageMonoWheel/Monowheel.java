package PackageMonoWheel;

import PackageTrain.Train;
import PackageTrain.Tram;
import PackageWheeledTransportation.WheeledTransportation;

public class Monowheel extends WheeledTransportation {
	
	// define attributes for the class
	private double MaxWeight;
	
	public Monowheel() {
		
		//System.out.println("Creating a Monowheel object using the default constructor");
		
		MaxWeight = 20000;
		
	}
	
	//Initialize the parameterized constructor
	public Monowheel(int numWheels, double maxSpeed, double MaxWeight) {
		
		//Call the variables used in the superclass that is train 
		super(numWheels, maxSpeed);
		
		this.MaxWeight = MaxWeight;
		
		//System.out.println("Creating a MonoWheel object using the parameterized constructor");
		
		
	}
	
	//Create the copy constructor 
	
	public Monowheel(Monowheel MonoCopy) {
		
		MaxWeight = MonoCopy.MaxWeight;
		
		//System.out.println("Creating a MonoWheel object using the copy constructor");
	
	}
	
	//getter methods
	public double getMaxWeight() {
		return MaxWeight;
	}
	
	//setter methods 
	
	public void setMaxWeight(double mw) {
		MaxWeight = mw;
		
	}
	
	
	//have a to String Method
	public String toString() {
		return "This MonoWheel vehicle has " + numWheels + 
				" wheels, has a maximum speed of " + maxSpeed + " km/hr. " + 
				"It also has a maxweight of " + MaxWeight;
	}
	
	//equals to method 
	public boolean equals(Object mono1) {
		if (mono1 == null || getClass() != mono1.getClass())
			return false;
		else {
			//return true if the attributes of the father are the same and the attributes of this class
			Monowheel mono2 = (Monowheel) mono1;
			return super.equals(mono2) && MaxWeight == mono2.MaxWeight;
		}
	}

}
