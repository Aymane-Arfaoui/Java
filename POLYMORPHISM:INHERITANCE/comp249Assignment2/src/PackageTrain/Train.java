package PackageTrain;

import PackageWheeledTransportation.WheeledTransportation;

//The Train class is a child to the WheeledTransportation Class
public class Train extends WheeledTransportation {
	
	//protected modifier
	// define attributes for the class
	 protected int numVehicles;
	 protected String StationName;
	 protected String DestName;
	
	//Initialize the default constructor
	public Train() {
		//System.out.println("Creating a Train object using the default constructor");
		
		numVehicles = 3;
		StationName = "Montreal";
		DestName = "New York";
		
	}
	
	//Initialize the parameterized constructor
	public Train(int numWheels, double maxSpeed, int numVehicles, String StationName, String DestName) {
		
		//Call the variables used in the superclass that is train 
		super(numWheels, maxSpeed);
		
		this.numVehicles = numVehicles;
		this.StationName = StationName;
		this.DestName = DestName;
		
		//System.out.println("Creating a Train object using the parameterized constructor");
		
	}
	
	//create the copy constructor
	
	public Train(Train trainCopy) {
			numVehicles = trainCopy.numVehicles;
			StationName = trainCopy.StationName;
			DestName = trainCopy.DestName;
			
			//System.out.println("Creating a Train object using the copy constructor");
		
	}
	
	//getter methods
	public int getNumvehicles() {
		return numVehicles;
	}
	
	public String getStationName() {
		return StationName;
	}
	
	public String getDestName() {
		return DestName;
	}
	
	//setter methods 
	
	public void setNumvehicles(int nv) {
		numVehicles = nv;
		
	}
	
	public void setStationName(String Sname) {
		StationName = Sname;
		
	}
	
	public void setDestName(String Dname) {
		DestName = Dname;
		
	}
	
	//have a to String Method
	public String toString() {
		return "This Train vehicle has " + numWheels + 
				" wheels, has a maximum speed of " + maxSpeed + " km/hr. " + 
				"It has " +  numVehicles + " vehicles and its starting and destination stations are " +StationName+
				" and " +  DestName;
	}
	
	//equals to method 
	public boolean equals(Object train1) {
		
		if (train1 == null || getClass() != train1.getClass())
		return false;
		else {
			 Train train2 = (Train) train1;
			 
			 //making sure the attributes from the parent are the same as well
			return super.equals(train2) && this.numVehicles == train2.numVehicles && this.StationName == train2.StationName
					&& this.DestName == train2.DestName ;
		}
		
	}
	
	
	
	
	

}