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
public class Passenger {
	private String passengerName,passengerCruise,roomType;
	
	/**
	 * This is a default constructor.
	 */
	public Passenger()
	{
		
	}
	
	/**
	 * This is a constructor for a passenger object that takes the passenger name, the passenger's cruise, and the passeneger's room type. 
	 * @param passengerName - name of the passenger
	 * @param passengerCruise - the cruise that the passenger is taking 
	 * @param roomType - the type of the room the passenger has 
	 */
	public Passenger(String passengerName, String passengerCruise, String roomType) 
	{
		this.passengerName = passengerName;
		this.passengerCruise = passengerCruise;
		this.roomType = roomType;
	}
	
	/**
	 * This method prints the information for a passenger object.
	 */
	public void printPassenger() 
	{
		int count;
		String space1 = "";
		String space2 = "";
		count = 20 - passengerName.length();
		for (int i = 1; i <= count; i++) {
			space1 = space1 + " ";
		}
		count = 20 - passengerCruise.length();
		for (int i = 1; i <= count; i++) {
			space2 = space2 + " ";
		}
		System.out.println(passengerName + space1 + passengerCruise + space2 + roomType);
	}
	
	/**
	 * This is a toString method that returns the passenger name. 
	 * @return passengerName - name of the passenger. 
	 */
	public String toString()
	{
		return passengerName;
	}
	
	/**
	 * This is getter method for the name of the passenger.
	 * @return the passengerName
	 */
	public String getPassengerName() {
		return passengerName;
	}

	/**
	 * This is a getter method for the cruise that the passenger is taking. 
	 * @return the passengerCruise
	 */
	public String getPassengerCruise() {
		return passengerCruise;
	}

	/**
	 * This is a getter method for the type of room the passenger has. 
	 * @return the roomType
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * This is a setter method for the name of the passenger.
	 * @param passengerName the passengerName to set
	 */
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	/**
	 * This is a setter method for the cruise that the passenger is taking. 
	 * @param passengerCruise the passengerCruise to set
	 */
	public void setPassengerCruise(String passengerCruise) {
		this.passengerCruise = passengerCruise;
	}

	/**
	 * This is a setter method for the type of room the passenger has. 
	 * @param roomType the roomType to set
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
}
