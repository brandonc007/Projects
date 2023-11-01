/**
 * IT 178
 */
package edu.ilstu;

import java.text.DecimalFormat;

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
public class ShiftSupervisor extends Employee{
	private final int DAY_SHIFT=1;
	private final int NIGHT_SHIFt=2;
	private double salary;
	private double bonus;
	private int shift;
	
	/**
	 * This is a constructor for a ShiftSupervisor.
	 */
	public ShiftSupervisor(String empName, String empNum, String hireDate, double salary, double bonus, int shift) 
	{
		super(empName,empNum,hireDate);
		this.bonus=bonus;
		this.salary=salary*365*8+bonus;
		this.shift=shift;
	}
	
	/**
	 * This is a toString method that returns information about a ShiftSupervisor.
	 */
	public String toString()
	{
		DecimalFormat formatter=new DecimalFormat("$0.00");
		return super.toString()+"Annual Salary: "+formatter.format(salary)+"\nProduction Bonus: "+formatter.format(bonus)+"\n";
	}

	/**
	 * This is a getter method for the salary of a ShiftSupervisor.
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * This is a getter method for the bonus of a ShiftSupervisor.
	 * @return the bonus
	 */
	public double getBonus() {
		return bonus;
	}

	/**
	 * This is a getter method for a shift of a ShiftSupervisor.
	 * @return the shift
	 */
	public int getShift() {
		return shift;
	}

	/**
	 * This is a setter method for the salary of a ShiftSupervisor.
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/** 
	 * This is a setter method for the bonus of a ShiftSupervisor.
	 * @param bonus the bonus to set
	 */
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	/**
	 * This is a setter method for a shift of a ShiftSupervisor.
	 * @param shift the shift to set
	 */
	public void setShift(int shift) {
		this.shift = shift;
	}
	
	
}
