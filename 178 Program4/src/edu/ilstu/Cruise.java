/**
 * IT 178
 */
package edu.ilstu;

/**
 * @author Brandon Claahsen
 * 
 * Making a menu-driven system for a cruise company in Java.
 * 
 * ULID: bdclaah
 * 
 * Date: 2/7/22
 *
 */
public class Cruise {
	private String cruiseName,shipName,departurePort,destination,returnPort;
	
	/**
	 * Default constructor
	 */
	public Cruise()
	{
		
	}
	
	/**
	 * Constructor for a cruise object that takes the cruise name, ship name, departure port, destination, and return port 
	 * @param cruiseName - name of the cruise
	 * @param shipName - name of the ship
	 * @param departurePort - the port that the cruise is being departed from
	 * @param destination - the place where the cruise is traveling to
	 * @param returnPort - the port where the cruise is returning to
	 */
	public Cruise(String cruiseName, String shipName, String departurePort, String destination, String returnPort) 
	{
		this.cruiseName = cruiseName;
		this.shipName = shipName;
		this.departurePort = departurePort;
		this.destination = destination;
		this.returnPort = returnPort;
	}
	
	/**
	 * This method prints the details for a Cruise object.
	 */
	public void printCruiseDetails()
	{
		int count;                                                           
		int count1;
		int count2;
		int count3;
		String space = "";                                                     
		String space1 = "";
		String space2 = "";
		String space3 = "";
		count = 20 - cruiseName.length();                                 
		count1 = 20 - shipName.length();                           
		count2 = 20 - departurePort.length();                               
		count3 = 20 - destination.length();
		for (int i = 1; i <= count; i++) {                                   
			space = space + " ";
		}
		for (int i = 1; i <= count1; i++) {
			space1 = space1 + " ";
		}
		for (int i = 1; i <= count2; i++) {
			space2 = space2 + " ";
		}
		for (int i = 1; i <= count3; i++) {
			space3 = space3 + " ";
		}
		System.out.println(cruiseName + space + shipName + space1 + departurePort + space2 + destination + space3 + returnPort);
	}
	
	/**
	 * This is a toString method that returns the ship name.
	 * @return shipName - name of the ship
	 */
	public String toString()
	{
		return shipName;
	}
	
	/**
	 * This is a getter method for the cruise name. 
	 * @return the cruiseName
	 */
	public String getCruiseName() {
		return cruiseName;
	}

	/**
	 * This is a getter method for the ship name.
	 * @return the shipName
	 */
	public String getShipName() {
		return shipName;
	}

	/**
	 * This is a getter method for the departure port.
	 * @return the departurePort
	 */
	public String getDeparturePort() {
		return departurePort;
	}

	/**
	 * THis is a getter method for the destination.
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * This is a getter method for the return port.
	 * @return the returnPort
	 */
	public String getReturnPort() {
		return returnPort;
	}

	/**
	 * This is a setter method for the cruise name.
	 * @param cruiseName the cruiseName to set
	 */
	public void setCruiseName(String cruiseName) {
		this.cruiseName = cruiseName;
	}

	/**
	 * This is a setter method for the ship name.
	 * @param shipName the shipName to set
	 */
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	/**
	 * This is a setter method for the depature port.
	 * @param departurePort the departurePort to set
	 */
	public void setDeparturePort(String departurePort) {
		this.departurePort = departurePort;
	}

	/**
	 * This is a setter method for the desination. 
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * This is a setter method for the return port. 
	 * @param returnPort the returnPort to set
	 */
	public void setReturnPort(String returnPort) {
		this.returnPort = returnPort;
	}
	
}
