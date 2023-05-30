package PackageWheeledTransportation;

public class WheeledTransportation {
	//initialize the attributes
	protected int numWheels;
	protected double maxSpeed;
	
	public WheeledTransportation() {
		
		//System.out.println("Creating a Wheeled Transportation object using the default constructor");
		numWheels = 12;
		maxSpeed = 875;
		
	}
	
	//Parameterized constructor
	
	public WheeledTransportation(int numWheels, double maxSpeed) {
		this.numWheels = numWheels;
		this.maxSpeed = maxSpeed;
	}
	
	//Creating copy constructor 
	
	public WheeledTransportation(WheeledTransportation transport) {
		//System.out.println("Creating a Wheeled Transportation object using the copy constructor");
		
		numWheels = transport.numWheels;
		maxSpeed = transport.maxSpeed;

		
	}
	
	//getter methods
	public int getNumWheels() {
		return numWheels;
	}
	
	public double getMaxSpeed() {
		return maxSpeed;
	}
	
	//setter methods 
	
	public void setNumWheels(int nw) {
		numWheels = nw;
		
	}
	
	public void setMaxSpeed(int ms) {
		maxSpeed = ms;
		
	}
	
	//have a to String Method
	public String toString() {
		return "This Wheeled Transportation vehicle has " + numWheels + 
				" wheels, has a maximum speed of " + maxSpeed + " km/hr. ";
	}
	
	//equals to method 
	public boolean equals(Object transport1) {
		
		if (transport1 == null || getClass() != transport1.getClass())
		return false;
		else {
			final WheeledTransportation transport2 = (WheeledTransportation) transport1;
			return this.numWheels == transport2.numWheels && this.maxSpeed == transport2.maxSpeed;
		}
		
	}
	
	
	
	

}
