/**
 * IT 168
 */
package edu.ilstu;

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
public class Element {

	private String chemName, symbol;
	private int atomNum;
	private double  boilingPoint, meltingPoint, density, atomWeight;
	
	/**
	 * This is a getter method for the chemical name of an element.
	 * @return the chemName - String for the chemical name
	 */
	public String getChemName() {
		return chemName;
	}

	/**
	 * This is a getter method for the atomic number of an element.
	 * @return the atomNum - integer for the atomic number
	 */
	public int getAtomNum() {
		return atomNum;
	}

	/**
	 * This is a getter method for the symbol of an element.
	 * @return the symbol - String for symbol of an element (Ex: Au for gold)
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * This is a getter method for the boiling point of an element.
	 * @return the boilingPoint - double for the boiling point
	 */
	public double getBoilingPoint() {
		return boilingPoint;
	}

	/**
	 * This is a getter method for the melting point of an element.
	 * @return the meltingPoint - double for the melting point.
	 */
	public double getMeltingPoint() {
		return meltingPoint;
	}

	/**
	 * This is a getter method for the density of an element.
	 * @return the density - double for the density
	 */
	public double getDensity() {
		return density;
	}

	/**
	 * This is a getter method for the atomic weight or molecular weight of an element.
	 * @return the atomWeight - double for the atomic weight
	 */
	public double getAtomWeight() {
		return atomWeight;
	}
	
	/**
	 * This is a constructor for an element that has parameters for the atomic number, symbol, boiling point, melting point, density and molecular/atomic weight.
	 * @param chemName - String for chemical name
	 * @param atomNum - integer for the atomic number
	 * @param symbol - String for the symbol of an element 
	 * @param boilingPoint -double for the boiling point
	 * @param meltingPoint - double for the melting point
	 * @param density - double for the density
	 * @param atomWeight - double for the atomic weight
	 */
	public Element(String chemName, int atomNum,String symbol,double boilingPoint,double meltingPoint,double density,double atomWeight)
	{
		this.chemName=chemName;
		this.atomNum=atomNum;
		this.symbol=symbol;
		this.boilingPoint=boilingPoint;
		this.meltingPoint=meltingPoint;
		this.density=density;
		this.atomWeight=atomWeight;
	}
	
	/**
	 * This is a toString() method that contains the information for any element.
	 * @return String - String for the element information
	 */
	public String toString()
	{
		return "\nElement name: "+this.chemName+"\nSymbol: "+this.symbol+"\nBoiling Point: "+this.boilingPoint+" Kelvin"+"\nMelting Point: "+this.meltingPoint+" Kelvin"+"\nDensity: "+this.density+" g/L"+"\nMolecular Weight: "+this.atomWeight+" g/mole\n";
	}
	
	
}
