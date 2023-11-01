/**
 * IT 168
 */
package edu.ilstu;
import java.util.*;
/**
 * 
 * @author Brandon Claahsen
 * 
 * Creating the GUESS WHO? Game in Java with classes, methods, objects, etc.
 * 
 * ULID: bdclaah
 * 
 * Date: 10/29/21
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String [] menuItems= {"Display Characters","Add A Character","Play a Game","Display a High Score","Exit"};
		TextMenu menu= new TextMenu(menuItems);
		
		String name; 		
		System.out.println("Welcome to the game!");
		System.out.print("Please enter your name: ");
		name=scan.nextLine();
		Game game1=new Game(name);
		
		int choice=menu.getChoice();
		while(choice!=5)
		{
			if(choice==1)
			{
				 game1.displayCharacter();
			}
			else if(choice==2)
			{
				 game1.addCharacter();
		    }
			else if(choice==3)
			{
				 game1.startGame();
			}
			else if(choice==4)
			{
				 System.out.println("Your highest score was "+game1.getHighScore()+" points");
			}
			choice=menu.getChoice();
			
		}
		System.out.println("Thank you for playing!");
		
	}

}
