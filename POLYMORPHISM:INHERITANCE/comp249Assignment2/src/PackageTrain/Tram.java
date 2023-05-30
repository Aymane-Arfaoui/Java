package PackageTrain;

import PackageMetro.Metro;

//The tram is a child to the Metro Class
public class Tram extends Metro {
	
	//Initialize the attribute for the year of creation
	private int YearCreation;
	
	public Tram() {
		
		//System.out.println("Creating a Tram object using the default constructor");
		
		YearCreation = 1998;
		
		
	}
	
	//Initialize the parameterized constructor
	public Tram(int numWheels, double maxSpeed, int numVehicles, String StationName, String DestName, int numStops, int YearCreation) {
		
		super(numWheels,maxSpeed,numVehicles,StationName,DestName,numStops);
		
		this.YearCreation = YearCreation;
		
		//System.out.println("Creating a Tram object using the parameterized constructor");
		
	
		
	}
	
	
	//create the copy constructor
	
	public Tram(Tram tramCopy) {
		
			YearCreation = tramCopy.YearCreation;
			
			//System.out.println("Creating a Tram object using the copy constructor");
		
	}
	
			//getter methods
			public int getYearCreation() {
				return YearCreation;
			}
			
			//setter methods 
			
			public void setYearCreation(int yc) {
				YearCreation = yc;
				
			}
			
			
			//have a to String Method
			public String toString() {
				return "This Tram vehicle has " + numWheels + 
						" wheels, has a maximum speed of " + maxSpeed + " km/hr. " + 
						"It has " +  numVehicles + " vehicles and its starting and destination stations are " +StationName+
						" and " +  DestName + ". It has " + numStops + " stops. It was created in " +YearCreation;
			}
			
			//equals to method 
			public boolean equals(Object tram1) {
				if (tram1 == null || getClass() != tram1.getClass())
					return false;
				else {
					//return true if the attributes of the father are the same and the attributes of this class
					Tram tram2 = (Tram) tram1;
					return super.equals(tram2) && YearCreation == tram2.YearCreation;
				}
			}
	

}
