/**
 * IT 168
 */
package edu.ilstu;
import java.io.*;
import java.text.*;
import java.util.*;
/**
 * 
 * @author Brandon Claahsen
 * 
 * Displaying information about elements from the periodic table in Java. 
 * 
 * ULID: bdclaah
 * 
 * Date: 11/21/21
 *
 */
public class PeriodicTable {

	private int size=120;
	private Element [] elements=new Element[size];
	private int countElems;
	
	/**
	 * This is a default constructor that instantiates an integer size, element array, and an integer for values in the array.
	 */
	public PeriodicTable()
	{
		this.size=size;
		this.elements=elements;
		this.countElems=countElems;
	}
	
	/**
	 * This method reads data from a file into an Element object.
	 * @param fileName - a string for the name of the file
	 */
	public void readElement(String fileName)
	{
		Scanner fileReader=null;
		try {
			File inputFile=new File(fileName);
			fileReader=new Scanner(inputFile);
			fileReader.nextLine();
			while(fileReader.hasNext())
			{
				String chemName="";
				int atomNum=0;
				String symbol="";
				double boilingPoint=0;
				double meltingPoint=0;
				double density=0;
				double atomWeight=0;
				String input=fileReader.nextLine();
				String [] line=input.split(",",-1);
				chemName=line[0];
				if(line[1].length()>0)
					atomNum=Integer.valueOf(line[1]);
				symbol=line[2];
				if(line[3].length()>0)
					boilingPoint=Double.valueOf(line[3]);
				if(line[4].length()>0)
					meltingPoint=Double.valueOf(line[4]);
				if(line[5].length()>0)
					density=Double.valueOf(line[5]);
				if(line[6].length()>0)
					atomWeight=Double.valueOf(line[6]);
				Element element=new Element(chemName,atomNum,symbol,boilingPoint,meltingPoint,density,atomWeight);
				this.elements[this.countElems]=element;
				this.countElems++;
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File "+fileName+" was not found!");
		}
		catch(InputMismatchException e)
		{
			System.out.println("Input does not match!");
		}
		finally {
			fileReader.close();
		}
		
	}
	
	/**
	 * This method displays the information of the element with the highest boiling point.
	 * @return elements[maxIndex] - the element with the highest boiling point
	 */
	public Element getHighBoiling()
	{
		int maxIndex=0;
		for(int i=0;i<this.countElems;i++)
		{
			if(elements[i].getBoilingPoint()>elements[maxIndex].getBoilingPoint())
				maxIndex=i;
		}
		return elements[maxIndex];
	}
	
	/**
	 * This method displays the information of the element with the lowest melting point.
	 * @return elements[minIndex] - the element with the lowest melting point
	 */
	public Element getLowMelting()
	{
		int minIndex=0;
		for(int i=0;i<this.countElems;i++)
		{
			if(elements[i].getBoilingPoint()<elements[minIndex].getBoilingPoint())
				minIndex=i;
		}
		return elements[minIndex];
	}
	
	/**
	 * This method displays the information for specific element given the symbol as a parameter.
	 * @param symbol - the symbol of the element (ex: Au for gold)
	 */
	public void elemInfo(String symbol)
	{
		for(int i=0;i<this.countElems;i++)
		{
			if(elements[i].getSymbol().equals(symbol))
				System.out.print(elements[i].toString());
		}
	}
	
	/**
	 * This method displays the number of protons, electrons, and neutrons for a specific element given the symbol as a parameter.
	 * @param symbol - the symbol of the element (ex: Au for gold)
	 */
	public void particleInfo(String symbol)
	{
		
		for(int i=0;i<this.countElems;i++)
		{
			DecimalFormat formatter=new DecimalFormat("0");
			if(elements[i].getSymbol().equals(symbol))
			{
				System.out.print("\nNumber of Protons: "+elements[i].getAtomNum()+"\n");
				System.out.print("Number of Electrons: "+elements[i].getAtomNum()+"\n");
				double neutrons=elements[i].getAtomWeight()-elements[i].getAtomNum();
				System.out.print("Number of Neutrons: "+formatter.format(neutrons)+"\n");
			}
		}
	}
	
	/**
	 * This method calculates the molar mass of compounds from a string array as a parameter.
	 * @param arr - a string array that contains compounds
	 * @return result - the final product of the calculations for molar mass
	 */
	public double calculateMolarMass(String input)
	{
		double result=0;
		for(int i=0;i<input.length();i++)
			if(input.equals(elements[i].getSymbol()))
				result=elements[i].getAtomWeight();
		
		
		return result;
	}
	
	
}
