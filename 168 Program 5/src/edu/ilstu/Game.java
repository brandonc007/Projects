/**
 * IT 168
 */
package edu.ilstu;
import java.util.*;
/**
 * 
 *  @author Brandon Claahsen
 * 
 * Creating the GUESS WHO? Game in Java with classes, methods, objects, etc.
 * 
 * ULID: bdclaah
 * 
 * Date: 10/29/21
 *
 */
public class Game {
	
	private Character [] characters;
	private static final String [] FEATURES={"wear glasses","wear a hat","wear earrings","have blue eyes","have brown eyes","have red eyes", "have a beard","have blonde hair", "have brown hair","have a scar"};
	private String player;
	private int highScore;
	private int num=0;
	private TextMenu menu1;
	
	/**
	 * This constructor that takes a string as a parameter and instantiates the player. It sets the array of characters to 20, and creates a menu object with 10 questions.
	 * @param player - a string for the player's name
	 */
	public Game(String player)
	{
		this.player=player;
		this.characters=new Character[20];
		String [] questions= {"do they wear glasses?","do they wear a hat?",
						  "do they wear earrings?",
						  "do they have blue eyes?",
						  "do they have brown eyes?",
						  "do they have red eyes?",
						  "do they have a beard?",
						  "do they have blonde hair?",
						  "do they have brown hair?",
						  "do they have a scar?"};
		this.menu1=new TextMenu(questions);
		addThree();
	}
	
	/**
	 * This method adds a character to the game by creating a new character object and setting the features for that character.
	 */
	public void addCharacter()
	{
		Scanner scan=new Scanner(System.in);
		String name;
		System.out.print("enter the name of the character: ");
		name=scan.nextLine();
		Character char1=new Character(name);
		
		
		String [] questions= {"does this character wear glasses? (yes/no)", 
				"does this character wear a hat? (yes/no)",
				"does this character wear earrings? (yes/no)",
				"does this character have blue eyes? (yes/no)",
				"does this character have brown eyes? (yes/no)",
				"does this character have red eyes? (yes/no)",
				"does this character have a beard? (yes/no)",
				"does this character have blonde hair? (yes/no)",
				"does this character have brown hair? (yes/no)",
				"does this character have a scar? (yes/no)"};
		
		for(int i=0;i<questions.length;i++)
		{
			System.out.print(questions[i]);
			String value=scan.nextLine();
			boolean value2=true;
			if(value.equalsIgnoreCase("yes"))
				value2=true;
			else if(value.equalsIgnoreCase("no"))
				value2=false;
			else
				value2=false;
			char1.setFeature(i,value2);
		}
		characters[num]=char1;
		num++;
		
	}
	
	/**
	 * This method displays the list of questions for the specific features.
	 * @return menu1.getChoice() - gets an integer from the user
	 */
	public int displayList() 
	{
		return menu1.getChoice();
	}
	
	/**
	 * This method displays all the characters in the game with their corresponding features.
	 * @return space
	 */
	public String displayCharacter()
	{
		System.out.println();
		for(int i=0;i<num;i++)
		{
			System.out.println(characters[i].toString());
			for(int j=0;j<FEATURES.length;j++)
				if(characters[i].getFeature(j)==true)
					System.out.print(FEATURES[j]+"\n");
		}
		
		return "";
	}
	
	/**
	 * This method starts the "GUESS WHO" game.
	 */
	public void startGame()
	{
		String [] questions={"ask a question","make a guess"};
		System.out.print("\nGame Started!!!");
		TextMenu menu2=new TextMenu(questions);
		int choice=menu2.getChoice();
		int score=100;
		int choice2;
		
		Random generator= new Random();
		int randomIndex= generator.nextInt(num);
		
		while(score!=0)
		{
			
			
			if(choice==1)
			{
				choice2=menu1.getChoice();
				score-=10;
				if(characters[randomIndex].getFeature(choice2-1)==true)
				{
					System.out.println("\nyes they do\n");
					choice=menu2.getChoice();
				}
				else
				{
					System.out.println("no they do not");
					choice=menu2.getChoice();
				}
			}
			else if(choice==2)
			{
				Scanner scan=new Scanner(System.in);
				System.out.print("Enter your guess: ");
				String guess=scan.nextLine();
				if(guess.equalsIgnoreCase(characters[randomIndex].getName()))
				{
					break;
				}
				else
				{
					System.out.println("Wrong guess!");
					score-=20;
				}
				choice=menu2.getChoice();
			}
		}
		System.out.println("Congratulations "+this.player+"!!");
		System.out.println("game over");
		System.out.println("Your score was "+score);
		
		if(score>this.highScore)
		{
			this.highScore=score;
			System.out.println("Congratulations "+this.player+"!! You have a new high score");
		}
		else
			System.out.println("your top score was "+this.highScore);
		
	}
	
	/**
	 * This method gets the high score of the player for the "GUESS WHO" game 
	 * @return highScore - the highest score the player had.
	 */
	public int getHighScore()
	{
		return this.highScore;
	}
	
	/**
	 * This method adds three characters for the test procedure.
	 */
	private void addThree()
	{
		characters[num]=new Character("shukri");
		boolean [] arr={false,true,false,false,false,true,false,false,false,false};
		characters[num++].setAll(arr);
		
		boolean[] arr2={true,true,true,false,true,false,false,false,false,false};
		characters[num]=new Character("tim");
		characters[num++].setAll(arr2);
		
		boolean[] arr3={false,false,true,false,true,false,false,false,false,true};
		characters[num]=new Character("mike");
		characters[num++].setAll(arr3);
	}

	
}
