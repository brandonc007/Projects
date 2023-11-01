/**
 * IT 178
 */
package edu.ilstu;
import java.text.DecimalFormat;
import java.util.*;
/**
 * 
 * @author Brandon Claahsen
 * 
 * ULID: bdclaah
 * 
 * Inheritance with Factory Employees in Java. 
 * 
 * Date: 2/19/21
 *
 */
public class ProductionWorker extends Employee {
	private final int DAY_SHIFT=1;
	private final int NIGHT_SHIFT=2;
	private int shift;
	private double payRate;
	private int [] dailyProduction=new int[365];
	private int size;
	
	/**
	 * This is a constructor for a ProductionWorker.
	 */
	public ProductionWorker(String empName, String empNum, String hireDate, int shift, double payRate)
	{
		super(empName,empNum,hireDate);
		this.shift=shift;
		this.payRate=payRate;
	}

	/**
	 * This is a toString method that returns information about a ProductionWorker.
	 */
	public String toString()
	{
		DecimalFormat formatter=new DecimalFormat("$0.00");
		if(shift==DAY_SHIFT)
			return super.toString()+"Shift: Day"+"\nHourly Pay Rate: "+formatter.format(payRate)+"\n";
		else if(shift==NIGHT_SHIFT)
			return super.toString()+"Shift: Night\n"+"Hourly Pay Rate: "+formatter.format(payRate)+"\n";
		else
			return super.toString()+"Shift: INVALID SHIFT NUMBER\n"+"Hourly Pay Rate: "+formatter.format(payRate);
	}
	
	/**
	 * This method calculates the yearly production and returns the sum. 
	 * @return sum - integer for the sum of yearly production.
	 */
	public int calculateYearlyProduction()
	{
		int sum=0;
		for(int i=0;i<size;i++)
		{
			sum+=dailyProduction[i];
		}
		return sum;
	}
	
	/**
	 * This is a getter method for a shift.
	 * @return the shift
	 */
	public int getShift() {
		return shift;
	}

	/**
	 * This is a getter method for the pay rate. 
	 * @return the payRate
	 */
	public double getPayRate() {
		return payRate;
	}

	/**
	 * This is a getter method for the size of the array. 
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * This is a setter method for a shift.
	 * @param shift the shift to set
	 */
	public void setShift(int shift) {
		this.shift = shift;
	}

	/**
	 * This is a setter method for the pay rate.
	 * @param payRate the payRate to set
	 */
	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}

	/**
	 * This is a setter method for the size of the array.
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * This is a getter method for the dailyProduction.
	 * @return the dailyProduction
	 */
	public int[] getDailyProduction() {
		return dailyProduction;
	}

	/**
	 * This method sets the daily production with an integer. 
	 * @param num - integer for the amount of daily production.
	 */
	public void setDailyProduction(int num) {
		for(int i=0;i<dailyProduction.length;i++)
			if(dailyProduction[i]==0)
			{
				dailyProduction[i]=num;
				size++;
			}	
	}


	
	
	
}
