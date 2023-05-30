package PackageFerry;

import PackageMonoWheel.Monowheel;

public class Ferry {
	
	//Initializing the variables for the Ferry
	private double maxSpeed;
	private double maxLoad;
	
	public Ferry() {
		
		//System.out.println("Creating a Ferry object using default constructor");
		
		maxSpeed = 1200;
		maxLoad = 18000;
		
	}
	
	//create Parameterized constructor for the ferry 
	
	public Ferry (double maxSpeed, double maxLoad) {
		this.maxSpeed=maxSpeed;
		this.maxLoad = maxLoad;
		
		//System.out.println("Creating a Ferry object using parametirized constructor");
		
		
	}
	
	// Create the Copy constructor 
	
	public Ferry(Ferry ferryCopy) {
		maxSpeed = ferryCopy.maxSpeed;
		maxLoad = ferryCopy.maxLoad;
		
		//System.out.println("Creating a Ferry object using the copy constructor");
		
	}
	
		//getter methods
		public double getMaxSpeed() {
			return maxSpeed;
		}
		
		public double getMaxLoad() {
			return maxLoad;
		}
		
		//setter methods 
		
		public void setMaxSpeed(double ms) {
			maxSpeed = ms;
			
		}
		
		public void setMaxLoad(double ml) {
			maxLoad = ml;
			
		}
		
		//have a to String Method
		public String toString() {
			return "This Ferry vehicle has a maximum speed of " + maxSpeed + " km/hr. " + 
					"It also has a maxLoad of " + maxLoad + " kg.";
		}
		
		//equals to method 
		public boolean equals(Object ferry1) {
			if (ferry1 == null || getClass() != ferry1.getClass())
				return false;
			else {
				//return true if the attributes of the father are the same and the attributes of this class
				Ferry ferry2 = (Ferry) ferry1;
				return maxSpeed == ferry2.maxSpeed && maxLoad == ferry2.maxLoad ;
			}
		}

}
