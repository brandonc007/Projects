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
public class Ship {
	private String shipName="";
	private int balcony,oceanView,suite,interior;
	private boolean service;
	
	/**
	 * This is a constructor for a ship object that takes the name of the ship, the various types of rooms, and whether or not the ship is in service.
	 * @param shipName- name of the ship 
	 * @param balcony - balcony room
	 * @param oceanView - a room with an ocean view
	 * @param suite - a room that features a suite
	 * @param interior - a room in the interior of the ship 
	 */
	public Ship(String shipName, int balcony, int oceanView, int suite, int interior, boolean service) 
	{
		this.shipName = shipName;
		this.balcony = balcony;
		this.oceanView = oceanView;
		this.suite = suite;
		this.interior = interior;
		this.service = service;
	}
	
	/**
	 * This method prints the information for a ship object.
	 */
	public void printShipData() 
	{
		int count;
		String space = "";
		count = 20 - shipName.length();
		for (int i = 1; i <= count; i++) {
			space = space + " ";
		}
		System.out.println(shipName + space + balcony + "\t" + oceanView + "  " + suite + "\t" +	interior + "\t\t" + service);
	}
	
	/**
	 * This is a toString object that returns the name of the ship. 
	 * @return shipName - name of the ship 
	 */
	public String toString()
	{
		return shipName;
	}
	
	/**
	 * This is a getter method for the name of the ship. 
	 * @return the shipName
	 */
	public String getShipName() {
		return shipName;
	}
	/**
	 * This is a getter method for a room that has a balcony.
	 * @return the balcony
	 */
	public int getBalcony() {
		return balcony;
	}
	/**
	 * This is a getter method for a room that has an ocean view. 
	 * @return the oceanView
	 */
	public int getOceanView() {
		return oceanView;
	}
	/**
	 * This is a getter method for a room that features a suite. 
	 * @return the suite
	 */
	public int getSuite() {
		return suite;
	}
	/**
	 * This is a getter method for a room that is in the interior of the ship. 
	 * @return the interior
	 */
	public int getInterior() {
		return interior;
	}
	/**
	 * This is a getter method for whether or not the ship is in service. 
	 * @return the service
	 */
	public boolean getService() {
		return service;
	}
	/**
	 * This is a setter method for the name of the ship. 
	 * @param shipName the shipName to set
	 */
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	/**
	 * This is a setter method for a room that has a balcony.
	 * @param balcony the balcony to set
	 */
	public void setBalcony(int balcony) {
		this.balcony = balcony;
	}
	/**
	 * This is a setter method for a room that has an ocean view.
	 * @param oceanView the oceanView to set
	 */
	public void setOceanView(int oceanView) {
		this.oceanView = oceanView;
	}
	/**
	 * This is a setter method for a room that features a suite. 
	 * @param suite the suite to set
	 */
	public void setSuite(int suite) {
		this.suite = suite;
	}
	/**
	 * This is a setter method for a room that is in the interior of a ship. 
	 * @param interior the interior to set
	 */
	public void setInterior(int interior) {
		this.interior = interior;
	}
	/**
	 * This is a setter method for whether a ship is in service or not. 
	 * @param service the service to set
	 */
	public void setService(boolean service) {
		this.service = service;
	}
	
}
