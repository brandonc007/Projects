/**
 * IT 178
 */
package edu.ilstu;
import java.util.*;

/**
 * 
 * @author Brandon Claahsen
 * 
 * Reviewing arrays in Java with a cryptogram
 * 
 * ULID: bdclaah
 * 
 * Date: 1/10/22
 *
 */
public class Cryptogram {
	
	private char [] arr= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private char [] scramArr;
	
	/**
	 * This constructor shuffles the characters in the array by providing a random index and passing the swap method.
	 */
	public Cryptogram()
	{
		scramArr=new char[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			scramArr[i]=arr[i];
		}
		int num;
		for(int j=arr.length-1;j>=0;j--)
		{
			num=(int)(Math.random()*(arr.length-j)+j);
			swap(j,num);
		}
	}
	
	/**
	 * This method swaps the index of two elements in the scrambled alphabet array. 
	 * @param index - an integer for an index in the array
	 * @param random - an integer for a random index in the array 
	 */
	public void swap(int index, int random)
	{
		char temp=scramArr[index];
		scramArr[index]=scramArr[random];
		scramArr[random]=temp;
	}
	
	/**
	 * This toString() method returns a string for the alphabet and scrambled alphabet. 
	 */
	public String toString()
	{
		String str="";
		for(int i=0;i<arr.length;i++)
			str+=arr[i]+" ";
		str+="\n";
		for(int i=0;i<scramArr.length;i++)
			str+=scramArr[i]+" ";
		return str;
	}
	
	/**
	 * This method encrypts a string by converting the string to characters and using a for loop obtain the letter equivalent in the scrambled array and add it to the encrypted message.
	 * @param text - the string being encrypted.
	 * @return encryption - the string for the encrypted message.
	 */
	public String encrypt(String text)
	{
		String encryption="";
		for(char a: text.toCharArray())
			encryption+=scramArr[findCode(a)];
		return encryption;
	}
	
	/**
	 * This method finds the location of a character in the alphabet array.
	 * @character - a char that is being searched in the array.
	 * @return i - the index location of the character in the array.
	 */
	public int findCode(char character)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==character)
				return i;
		}
		return -1;
	}
	
	/**
	 * This method decrypts a string by converting the string to characters and using a for loop to obtain the letter equivalent in the alphabet array and add it to the decrypted message.
	 * @param text - the string being decrypted.
	 * @return decryption - the string for the decrypted message.
	 */
	public String decrypt(String text)
	{
		String decryption="";
		for(char a: text.toCharArray())
			decryption+=arr[findLetter(a)];
		return decryption;
	}
	
	/**
	 * This method finds the location of a character in the scrambled array.
	 * @param character - a char that is being searched in the array.
	 * @return i - the index location of the character in the array.
	 */
	public int findLetter(char character)
	{
		for(int i=0;i<scramArr.length;i++)
		{
			if(scramArr[i]==character)
				return i;
		}
		return -1;
	}
	
}