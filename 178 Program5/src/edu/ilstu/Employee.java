/**
 * IT 178
 */
package edu.ilstu;

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
public class Employee {
	private String empName;
	private String empNum;
	private String hireDate;
	
	/**
	 * This is a constructor for an Employee.
	 */
	public Employee(String empName, String empNum, String hireDate) {
		this.empName = empName;
		this.empNum = empNum;
		this.hireDate = hireDate;
	}
	
	/**
	 * This method validates whether a String for an employee number is correct.
	 * @return true - valid String
	 * @return false - invalid String
	 */
	public boolean isValidEmplNum(String str)
	{
		 if(empNum.length() == 5
	               && Character.isDigit(empNum.charAt(0))
	               && Character.isDigit(empNum.charAt(1))
	               && Character.isDigit(empNum.charAt(2))
	               && empNum.charAt(3) == '-'
	               && (empNum.charAt(4) <= 'A' && empNum.charAt(4) >= 'Z')) {
			 this.empNum=empNum;
		 	 return true;
		 } 
	     else {
	    	 empNum="INVALID EMPLOYEE NUMBER";
	    	 return false;
	     }
	    	 
	}
	
	/**
	 * This is a toString method that returns information for an Employee.
	 */
	public String toString()
	{
			return "Name: "+empName+"\nEmployee Number: "+empNum+"\nHire Date: "+hireDate+"\n";
	}
	
	/**
	 * This is a getter method for the name of an Employee.
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * This is a getter method for an Employee number. 
	 * @return the empNum
	 */
	public String getEmpNum() {
		return empNum;
	}
	/**
	 * This is a getter method for the hire date of an employee.
	 * @return the hireDate
	 */
	public String getHireDate() {
		return hireDate;
	}
	/**
	 * This is a setter method for the name of an Employee.
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * This is a setter method for an Employee number.
	 * @param empNum the empNum to set
	 */
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}
	       
	/**
	 * This is a setter method for the hire date of an employee.
	 * @param hireDate the hireDate to set
	 */
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	
}
