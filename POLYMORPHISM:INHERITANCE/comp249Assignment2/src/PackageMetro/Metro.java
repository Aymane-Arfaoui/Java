package PackageMetro;

import PackageTrain.Train;

//The Metro class is a child to the Train Class
public class Metro extends Train{
	
	// define attributes for the class
	//use protected to let classes from other packages access it
	protected int numStops;
	
	public Metro() {
		
		//System.out.println("Creating a Metro object using default constructor");
		
		numStops = 9;
		
	}
	
	
	//Parameterized constructor 
	public Metro(int numWheels, double maxSpeed, int numVehicles, String StationName, String DestName ,int numStops) {
		
		super(numWheels,maxSpeed,numVehicles, StationName, DestName);
		this.numStops = numStops;
		
		//System.out.println("Creating a Metro object using the parameterized constructor");
		
	}
	
	//create the copy constructor
	
	public Metro(Metro metroCopy) {
			numStops = metroCopy.numStops;
			
			//System.out.println("Creating a Metro object using the copy constructor");
		
	}
	
	//getter methods
		public int getNumStops() {
			return numStops;
		}
		
		//setter methods 
		
		public void setNumStops(int ns) {
			numStops = ns;
			
		}
		
		
		//have a to String Method
		public String toString() {
			return "This Metro vehicle has " + numWheels + 
					" wheels, has a maximum speed of " + maxSpeed + " km/hr. " + 
					"It has " +  numVehicles + " vehicles and its starting and destination stations are " +StationName+
					" and " +  DestName + ". It also has " + numStops + " stops";
		}
		
		//equals to method 
		public boolean equals(Object metro1) {
			
			if (metro1 == null || getClass() != metro1.getClass())
			return false;
			else {
				 Metro metro2 = (Metro) metro1;
				 //return true if the attributes of the father are the same and the attributes of the metro class
				return super.equals(metro2) 
						&& numStops == metro2.numStops;
			}
			
		}
	

}
