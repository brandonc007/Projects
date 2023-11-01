/**
 * IT 168
 */
package edu.ilstu;

/**
 * @author Brandon Claahsen
 * 
 * Creating the GUESS WHO? Game in Java with classes, methods, objects, etc.
 * 
 * ULID: bdclaah
 * 
 * Date: 10/29/21
 *
 */
public class Character {
	
	private String name;
	private boolean [] features;
	
	/**
	 * This is a constructor for the character that has a String as parameter and instantiates the boolean array of features to 10 elements.
	 * @param name - a string for the character's name
	 */
	public Character(String name)
	{
		this.name=name;
		this.features=new boolean[10];
	}

	/**
	 * This getter method gets the name of the character. 
	 * @return name - a string for the name of the character
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * This setter method sets the feature by taking an index and boolean value to set the elements in the boolean array to true or false.
	 * @param index - an integer for the index of the array
	 * @param value - a boolean for the array elements
	 */
	public void setFeature(int index, boolean value)
	{
		if(value==true)
			features[index]=true;
		else 
			features[index]=false;
	}
	
	/**
	 * This method gets the feature at a particular index of the boolean array.
	 * @param index- an integer for the index of the array
	 * @return features[index] - the boolean value of that index in the boolean array
	 */
	public boolean getFeature(int index)
	{
		return this.features[index];
	}
	
	/**
	 * This toString method returns a string for the character output.
	 * @return a string for the Character output and features
	 */
	public String toString()
	{
		return "\nCharacter name:"+this.name+"\nfeatures:";
	}
	
	/**
	 * This setter method sets the test procedure boolean features.
	 * @param arr - a boolean array 
	 */
	public void setAll(boolean [] arr)
	{
		for(int i=0;i<this.features.length;i++)
			features[i]=arr[i];
	}
	
}
