/**
 * IT 178
 */
package edu.ilstu;
import java.util.*;
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
public class Driver {
	private static ArrayList<Ship> shipList = new ArrayList<Ship>();
	private static ArrayList<Cruise> cruiseList = new ArrayList<Cruise>();
	private static ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
	
	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);
		String choice= "";
		initializeShipList(shipList);       
		initializeCruiseList(cruiseList);        
		initializePassengerList(passengerList);  
		do {                                                                  
			try {                                                               
				displayMenu();                                                                                                                 
				choice=scan.nextLine();                                   
			              
				if (choice.equals("1")) { 
					addShip();
				}
				else if (choice.equals("2")) {                               
					editShip();
				}
				else if (choice.equals("3")) {
					addCruise();
				}
				else if (choice.equals("4")) {
					editCruise();
				}
				else if (choice.equals("5")) {
					addPassenger();
				}
				else if (choice.equals("6")) {
					editPassenger();
				}
				else if (choice.equalsIgnoreCase("A")) {
					printShipList("name");
				}
				else if (choice.equalsIgnoreCase("B")) {
					printShipList("active");
				}
				else if (choice.equalsIgnoreCase("C")) {
					printShipList("full");
				}
				else if (choice.equalsIgnoreCase("D")) {
					printCruiseList("list");
				}
				else if (choice.equalsIgnoreCase("E")) {
					printCruiseList("details");
				}
				else if (choice.equalsIgnoreCase("F")) {
					printPassengerList();
				}
				else if (choice.equalsIgnoreCase("x")) {
					System.out.println("Goodbye!");
					return;
				}
			} catch (Exception e) {                                                      
				System.out.println("Error, invalid input. Please try again.");
				e.printStackTrace();
			}
		}while (!choice.equalsIgnoreCase("x"));
		
		initializeShipList(shipList); 
		initializeCruiseList(cruiseList);
		initializePassengerList(passengerList); 
	}
	
	/**
	 * This method hard codes four ship objects into an arraylist.
	 */
	public static void initializeShipList(ArrayList<Ship> shipList) {
		shipList.add(new Ship("Candy Cane", 20, 40, 10, 60, true));
		shipList.add(new Ship("Peppermint", 10, 20, 5, 50, true));
		shipList.add(new Ship("Bon Bon", 12, 18, 2, 24, true));
		shipList.add(new Ship("Candy Corn", 12, 18, 2, 24, false));
	}

	/**
	 * This method hard codes three cruise objects into an arraylist.
	 */
	public static void initializeCruiseList(ArrayList<Cruise> cruiseList) {
		Cruise newCruise = new Cruise("Southern Swirl", "Candy Cane", "Miami", "Cuba", "Miami");
		cruiseList.add(newCruise);
		Cruise newCruise1 = new Cruise("Jolly Fun", "Peppermint", "New Orleans", "Cozumel", "New Orleans");
		cruiseList.add(newCruise1);
		Cruise newCruise2 = new Cruise("Lollipop","Candy Corn" , "Ft Lauderdale", "Bahamas", "Ft Lauderdale");
		cruiseList.add(newCruise2);
	}
	
	/**
	 * This method hard codes six passenger objects into an arraylist.
	 */
	public static void initializePassengerList(ArrayList<Passenger> passengerList) {
		Passenger newPassenger1 = new Passenger("Neo Anderson", "Southern Swirl", "STE");
		passengerList.add(newPassenger1);

		Passenger newPassenger2 = new Passenger("Trinity", "Southern Swirl", "BAL");
		passengerList.add(newPassenger2);

		Passenger newPassenger3 = new Passenger("Morpheus", "Jolly Fun", "INT");
		passengerList.add(newPassenger3);
		
		Passenger newPassenger4 = new Passenger("Rick", "Lollipop", "BAL");
		passengerList.add(newPassenger4);
		
		Passenger newPassenger5 = new Passenger("Jack", "Lollipop", "STE");
		passengerList.add(newPassenger5);
		
		Passenger newPassenger6 = new Passenger("Daniel", "Jolly Fun", "INT");
		passengerList.add(newPassenger6);
	}

	/**
	 * This method prints information about each ship object in the arraylist.
	 */
	public static void printShipList(String listType) {
		if (shipList.size() < 1) {
			System.out.println("\nThere are no ships to print.");
			return;
		}
		if (listType == "name") {
			System.out.println("\n\nSHIP LIST - Name");
		for (int i = 0; i < shipList.size(); i++) 
			System.out.println(shipList.get(i));
		} 
		else if (listType == "active") {	
			System.out.println("\n\nSHIP LIST - Active");
			int i = 0;                                                    
			for (i = 0; i < shipList.size(); ++i) 
			   if (shipList.get(i).getService()) 
			       System.out.println(shipList.get(i).toString()); 
			i = i + 1;                                                 
		} 
		else if (listType == "full") {
			System.out.println("\n\nSHIP LIST - FULL");
			System.out.println("---------------------------------------------------------");
			System.out.println("\t\t   Number of Rooms\t\t In");
			System.out.print("SHIP NAME\t   Bal  OV Ste Int\t        Service");
			System.out.println("\n-------------------------------------------------------");
			for (Ship eachShip: shipList)
				eachShip.printShipData();
		} 
		else
			System.out.println("\n\nError: List type not defined.");
	}

	/**
	 * This method prints information about each cruise in the arraylist.
	 */
	public static void printCruiseList(String listType) {
		if (cruiseList.size() < 1) {
			System.out.println("\nThere are no cruises to print.");
			return;
		}
		if (listType == "list") {
			System.out.println("\n\nCRUISE LIST - NAME");
		for (int i=0; i < cruiseList.size(); i++) 
			System.out.println(cruiseList.get(i).getCruiseName());
		} 
		else if (listType == "details") {
			System.out.println("\n\nCRUISE LIST - DETAILS");
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t\t\t  ----------------------PORTS-----------------------");
			System.out.print("CRUISE NAME         SHIP NAME      \tDEPARTURE\t    DESTINATION     \tRETURN");
			System.out.println("\n-----------------------------------------------------------------------------------------");
		for (Cruise eachCruise: cruiseList)
			eachCruise.printCruiseDetails();
		} 
		else
			System.out.println("\n\nError: List type not defined.");
	}
	
	/**
	 * This method prints information about each passenger in the arraylist.
	 */
	public static void printPassengerList() {
		if (passengerList.size() < 1) {
			System.out.println("\nThere are no passengers to print.");
			return;
		}
		System.out.println("\n\nPASSENGER LIST");
		System.out.println("---------------------------------------------------------");
		System.out.print("PASSENGER NAME \t    CRUISE\t\tROOM TYPE");
		System.out.println("\n---------------------------------------------------------");
		for (Passenger eachPassenger: passengerList)
			eachPassenger.printPassenger();
		}
		
	/**
	 * This method displays the menu for Luxury Ocean Cruise Outings.
	 */
	public static void displayMenu() {
		System.out.println("\n\n");
		System.out.println("\t\t\tLuxury Ocean Cruise Outings");
		System.out.println("\t\t\t\tSystem Menu\n");
		System.out.println("[1] Add Ship \t\t[A] Print Ship Names");
		System.out.println("[2] Edit Ship \t\t[B] Print Ship In Service List");
		System.out.println("[3] Add Cruise \t\t[C] Print Ship Full List");
		System.out.println("[4] Edit Cruise \t[D] Print Cruise List");
		System.out.println("[5] Add Passenger \t[E] Print Cruise Details");
		System.out.println("[6] Edit Passenger \t[F] Print Passenger List");
		System.out.println("[x] Exit System");
		System.out.print("\nEnter a menu selection: ");
	}

	/**
	 * This method prompts the user for information and adds a ship to the arraylist.
	 */
	public static void addShip() {
		Scanner scan = new Scanner(System.in);
		int num = 1;
		do {
			try {
				System.out.print("Enter the new ship name: ");
				String newShipName = scan.nextLine();				
				
				for (Ship eachShip: shipList) {       
					if (eachShip.getShipName().equalsIgnoreCase(newShipName)) {       
						System.out.println("That ship is already in the system.");
						return;                                                        
					}                                                                                          
				}   
				System.out.print("How many balcony rooms? ");
				int room=scan.nextInt();
				System.out.print("How many OceanView rooms? ");
				int ocean=scan.nextInt();
				System.out.print("How many rooms are suites? ");
				int suites=scan.nextInt();
				System.out.print("How many interior rooms? ");
				int interior=scan.nextInt();
				System.out.print("Has this ship been assigned a service? ");
				boolean service; 
				System.out.print("\nY for Yes, N for No ");
				String answer=scan.next();
				if(answer.equalsIgnoreCase("Y"))
					service=true;
				else if(answer.equalsIgnoreCase("N"))
					service=false; 
				else
					service=true;
				Ship newShip1 = new Ship(newShipName,room, ocean, suites, interior, service);              
				shipList.add(newShip1);
				num = 2;
			} 
			catch (Exception e) {
				System.out.println("Error - please enter valid character.");
			}
		} while(num==1);
	}
		
	/**
	 * This method allows the user to edit a ship object.
	 */
	public static void editShip() {
		Scanner scan=new Scanner(System.in);
		System.out.print("Which ship would you like to edit: \n");
		int count=0;
		int choice=0;
		for(int i=0;i<shipList.size();i++)
		{
			count++;
			System.out.println("  "+(i+1)+"-"+" "+shipList.get(i).getShipName());
			if(count==shipList.size())
			{
				System.out.println("  "+(count+1)+"- Return to previous menu");
				System.out.print("\nEnter a menu selection: ");
				choice=scan.nextInt();
				if(choice==(count+1))
				{
					return;
				}
			}
		}	
		System.out.println("Which item do you wish to edit: ");
		System.out.println("  1- Ship name");
		System.out.println("  2- Number of balconies");
		System.out.println("  3- Number of Ocean Views");
		System.out.println("  4- Number of Suites");
		System.out.println("  5- Number of Interior");
		System.out.println("  6- Service status");
		System.out.println("  7- Update all");
		System.out.println("  8- Return to previous menu");
		System.out.print("\nEnter a menu selection: ");
		int choice2=scan.nextInt();
		if(choice2==1)
		{
			System.out.print("Enter a new ship name: ");
			scan.nextLine();
			String name=scan.nextLine();
			shipList.get(choice-1).setShipName(name);
		}
		else if(choice2==2)
		{
			System.out.print("How many balcony rooms: ");
			int num=scan.nextInt();
			shipList.get(choice-1).setBalcony(num);			
		}
		else if(choice2==3)
		{
			System.out.print("How many ocean view rooms: ");
			int num=scan.nextInt();
			shipList.get(choice-1).setOceanView(num);
		}
		else if(choice2==4)
		{
			System.out.print("How many suite rooms: ");
			int num=scan.nextInt();
			shipList.get(choice-1).setSuite(num);
		}
		else if(choice2==5)
		{
			System.out.print("How many interior rooms: ");
			int num=scan.nextInt();
			shipList.get(choice-1).setInterior(num);
		}
		else if(choice2==6)
		{
			System.out.print("Enter the service status: ");
			boolean service=scan.nextBoolean();
			shipList.get(choice-1).setService(service);
		}
		else if(choice2==7)
		{
			for(Ship eachShip: shipList)
				if(eachShip.getService()!=true)
				{
					System.out.print("Ship"+shipList.get(choice-2).getShipName()+" is currently not in service");
					System.out.print("Would you like to put it in service? ");
					boolean answer=scan.nextBoolean();
					shipList.get(choice-2).setService(answer);
				}
				else
				{
					System.out.print("Enter a new ship name: ");
					scan.nextLine();
					String name=scan.nextLine();
					shipList.get(choice-1).setShipName(name);
					System.out.print("How many balcony rooms: ");
					int num=scan.nextInt();
					shipList.get(choice-1).setBalcony(num);	
					System.out.print("How many ocean view rooms: ");
					num=scan.nextInt();
					shipList.get(choice-1).setOceanView(num);
					System.out.print("How many suite rooms: ");
					num=scan.nextInt();
					shipList.get(choice-1).setSuite(num);
					System.out.print("How many interior rooms: ");
					num=scan.nextInt();
					shipList.get(choice-1).setInterior(num);
					System.out.print("Enter the service status: ");
					boolean service=scan.nextBoolean();
					shipList.get(choice-1).setService(service);
				}
		}
		else if(choice2==8)
		{
			do {
				int count2=0;
				for(int k=0;k<shipList.size();k++)
				{
					count2++;
					System.out.println("  "+(k+1)+"-"+" "+shipList.get(k).getShipName());			
					if(count2==shipList.size())
					{
						System.out.println("  "+(count+1)+"- Return to previous menu");
						System.out.print("\nEnter a menu selection: ");
						choice2=scan.nextInt();
					}
				}
			}while(choice2==8);
		}
	}

	/**
	 * This method prompts the user for information and adds a cruise object to the arraylist.
	 */
	public static void addCruise() {
		Scanner scan = new Scanner(System.in);    
		System.out.print("Enter the cruise name: ");
		String cruiseName=scan.nextLine();
		System.out.print("Enter the ship name: ");
		String newShipName = scan.nextLine();
		for (Ship eachShip: shipList) {
			if (eachShip.getShipName().equalsIgnoreCase(newShipName) && eachShip.getService()==true) {       
				continue;
			}
		}
		for (Cruise eachCruise: cruiseList) {       
			if(eachCruise.getCruiseName().equalsIgnoreCase(cruiseName)) { 
				System.out.println("Error: Cruise Ship Name taken");
				return;
			}  
		}
		System.out.print("Enter the departure port: ");
		String departPort=scan.nextLine();
		System.out.print("Enter the destination: ");
		String destination=scan.nextLine();
		System.out.print("Enter the return port: ");
		String returnPort=scan.nextLine();
		
		Cruise newCruise1 = new Cruise(cruiseName, newShipName, departPort, destination, returnPort);   
		cruiseList.add(newCruise1);                                                                       
	}
	
	/**
	 * This method allows the user to edit a cruise object.
	 */
	public static void editCruise()	{
		Scanner scan=new Scanner(System.in);
		System.out.print("Which cruise would you like to edit: \n");
		int count=0;
		int choice=0;
		for(int i=0;i<cruiseList.size();i++)
		{
			count++;
			System.out.println("  "+(i+1)+"-"+" "+cruiseList.get(i).getCruiseName());
			if(count==cruiseList.size())
			{
				System.out.println("  "+(count+1)+"- Return to previous menu");
				System.out.print("\nEnter a menu selection: ");
				choice=scan.nextInt();
				if(choice==(count+1))
				{
					return;
				}
			}
		}	
		System.out.println("Which item do you wish to edit: ");
		System.out.println("  1- Cruise name");
		System.out.println("  2- Ship name");
		System.out.println("  3- Departure Port");
		System.out.println("  4- Destination");
		System.out.println("  5- Return Port");
		System.out.println("  6- Update all");
		System.out.println("  7- Return to previous menu");
		System.out.print("\nEnter a menu selection: ");
		int choice2=scan.nextInt();
		if(choice2==1)
		{
			System.out.print("Enter a new cruise name: ");
			scan.nextLine();
			String name=scan.nextLine();
			cruiseList.get(choice-1).setCruiseName(name);
		}
		else if(choice2==2)
		{
			System.out.print("Enter a new ship name: ");
			scan.nextLine();
			String name=scan.nextLine();
			cruiseList.get(choice-1).setShipName(name);			
		}
		else if(choice2==3)
		{
			System.out.print("Enter a new departure port: ");
			scan.nextLine();
			String name=scan.nextLine();
			cruiseList.get(choice-1).setDeparturePort(name);			
		}
		else if(choice2==4)
		{
			System.out.print("Enter a new destination: ");
			scan.nextLine();
			String name=scan.nextLine();
			cruiseList.get(choice-1).setDestination(name);			
		}
		else if(choice2==5)
		{
			System.out.print("Enter a new return port: ");
			scan.nextLine();
			String name=scan.nextLine();
			cruiseList.get(choice-1).setReturnPort(name);			
		}
		else if(choice2==6)
		{
			
			System.out.print("Enter a new cruise name: ");
			scan.nextLine();
			String name=scan.nextLine();
			cruiseList.get(choice-1).setCruiseName(name);
			System.out.print("Enter a new ship name: ");
			name=scan.nextLine();
			cruiseList.get(choice-1).setShipName(name);		
			System.out.print("Enter a new departure port: ");
			name=scan.nextLine();
			cruiseList.get(choice-1).setDeparturePort(name);	
			System.out.print("Enter a new destination: ");
			name=scan.nextLine();
			cruiseList.get(choice-1).setDestination(name);	
			System.out.print("Enter a new return port: ");
			name=scan.nextLine();
			cruiseList.get(choice-1).setReturnPort(name);			
		}
		else if(choice2==7)
		{
			do {
				int count2=0;
				for(int k=0;k<cruiseList.size();k++)
				{
					count2++;
					System.out.println("  "+(k+1)+"-"+" "+cruiseList.get(k).getCruiseName());			
					if(count2==cruiseList.size())
					{
						System.out.println("  "+(count+1)+"- Return to previous menu");
						System.out.print("\nEnter a menu selection: ");
						choice2=scan.nextInt();
					}
				}
			}while(choice2==7);
		}
	}
	
	/**
	 * THis method prompts the user for information and adds a passenger object to the arraylist.
	 */
	public static void addPassenger() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the new passenger's name: ");
		String newPassengerName = scan.nextLine();
		for (Passenger eachPassenger: passengerList) {
			if (eachPassenger.getPassengerName().equalsIgnoreCase(newPassengerName)) {
				System.out.println("That passenger is already in the system.");
				return;
			}
		}
		
		System.out.print("Enter cruise name: ");
		String newCruiseName = scan.nextLine();
		for (Cruise eachCruise: cruiseList) {
			if (eachCruise.getCruiseName().equalsIgnoreCase(newCruiseName)) {
				
			}	
			else {
				System.out.println("That cruise does not exist in the system.");
				return;
			}
		}
		
		System.out.print("Enter Room Type (BAL, OV, STE, or INT): ");
		String room = scan.nextLine();
		if ((room.equalsIgnoreCase("BAL")) || (room.equalsIgnoreCase("OV")) || (room.equalsIgnoreCase("STE")) || (room.equalsIgnoreCase("INT"))) {
			Passenger newPassenger = new Passenger(newPassengerName, newCruiseName, room.toUpperCase());
			passengerList.add(newPassenger);
		} 
		else {
			System.out.println("Invalid input.");
			return; 
		}
	}
	
	/**
	 * This method allows the user to edit a passenger object.
	 */
	public static void editPassenger() {
		Scanner scan=new Scanner(System.in);
		System.out.print("Which cruise would you like to edit: \n");
		int count=0;
		int choice=0;
		for(int i=0;i<passengerList.size();i++)
		{
			count++;
			System.out.println("  "+(i+1)+"-"+" "+passengerList.get(i).getPassengerName());
			if(count==passengerList.size())
			{
				System.out.println("  "+(count+1)+"- Return to previous menu");
				System.out.print("\nEnter a menu selection: ");
				choice=scan.nextInt();
				if(choice==(count+1))
				{
					return;
				}
			}
		}	
		System.out.println("Which item do you wish to edit: ");
		System.out.println("  1- Passenger name");
		System.out.println("  2- Passenger's cruise");
		System.out.println("  3- Passenger's room type");
		System.out.println("  4- Update all");
		System.out.println("  5- Return to previous menu");
		System.out.print("\nEnter a menu selection: ");
		int choice2=scan.nextInt();
		if(choice2==1)
		{
			System.out.print("Enter a new passenger name: ");
			scan.nextLine();
			String name=scan.nextLine();
			passengerList.get(choice-1).setPassengerName(name);
		}
		else if(choice2==2)
		{
			System.out.print("Enter a new cruise name: ");
			scan.nextLine();
			String name=scan.nextLine();
			passengerList.get(choice-1).setPassengerCruise(name);	
		}
		else if(choice2==3)
		{
			System.out.print("Enter a new room type(Bal OV Ste Int): ");
			scan.nextLine();
			String name=scan.nextLine();
			passengerList.get(choice-1).setRoomType(name);			
		}
		else if(choice2==4)
		{
			System.out.print("Enter a new passenger name: ");
			scan.nextLine();
			String name=scan.nextLine();
			passengerList.get(choice-1).setPassengerName(name);
			System.out.print("Enter a new cruise name: ");
			name=scan.nextLine();
			passengerList.get(choice-1).setPassengerCruise(name);
			System.out.print("Enter a new room type(Bal OV Ste Int): ");
			name=scan.nextLine();
			passengerList.get(choice-1).setRoomType(name);		
			
		}
		else if(choice2==5)
		{
			do {
				int count2=0;
				for(int k=0;k<passengerList.size();k++)
				{
					count2++;
					System.out.println("  "+(k+1)+"-"+" "+passengerList.get(k).getPassengerName());			
					if(count2==passengerList.size())
					{
						System.out.println("  "+(count+1)+"- Return to previous menu");
						System.out.print("\nEnter a menu selection: ");
						choice2=scan.nextInt();
					}
				}
			}while(choice2==5);
		}
	}
		
}

