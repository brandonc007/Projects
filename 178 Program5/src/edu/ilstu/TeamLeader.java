/**
 * IT 178
 */
package edu.ilstu;

import java.text.DecimalFormat;

/**
 * @author Brandon Claahsen
 * 
 * ULID: bdclaah
 * 
 * Inheritance with Factory Employees in Java. 
 * 
 * Date: 2/19/21
 *
 */
public class TeamLeader extends ProductionWorker{
	private double bonus;
	private double trainHours;
	private double attendHours;
	
	/**
	 * This is a constructor for a TeamLeader. 
	 */
	public TeamLeader(String empName, String empNum, String hireDate, int shift, double payRate, double bonus, double trainHours, double attendHours)
	{
		super(empName,empNum,hireDate,shift,payRate);
		this.bonus=bonus;
		this.trainHours=trainHours;
		this.attendHours=attendHours;
	}
	
	/**
	 * This is a toString method that returns information about a TeamLeader.
	 */
	public String toString()
	{
		DecimalFormat formatter=new DecimalFormat("$0.00");
		return super.toString()+"Monthly Bonus: "+formatter.format(bonus)+"\nRequired Training Hours: "+trainHours+"\nTraining Hours Attended: "+attendHours+"\n";
	}

	/**
	 * This is a getter method for the bonus of a TeamLeader.
	 * @return the bonus
	 */
	public double getBonus() {
		return bonus;
	}

	/**
	 * This is a getter method for the training hours of a TeamLeader.
	 * @return the trainHours
	 */
	public double getTrainHours() {
		return trainHours;
	}

	/**
	 * This is a getter method for the attended hours of a TeamLeader.
	 * @return the attendHours
	 */
	public double getAttendHours() {
		return attendHours;
	}

	/**
	 * This is a setter method for the bonus of a TeamLeader.
	 * @param bonus the bonus to set
	 */
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	/**
	 * This is a setter method for the training hours of a TeamLeader.
	 * @param trainHours the trainHours to set
	 */
	public void setTrainHours(double trainHours) {
		this.trainHours = trainHours;
	}

	/**
	 * This is a setter method for the attended hours of a TeamLeader.
	 * @param attendHours the attendHours to set
	 */
	public void setAttendHours(double attendHours) {
		this.attendHours = attendHours;
	}
	
	
	
}
