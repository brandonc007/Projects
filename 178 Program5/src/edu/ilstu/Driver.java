/**
 * IT 178
 */
package edu.ilstu;
import java.util.*;
import java.text.*;
import java.io.*;
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
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		readRecords();
		int days=setProduction();
		determineSupervisorBonus(days);
		determineTeamLeadBonus();
		printAllProd();
	}
	public static Employee [] employees=new Employee[20];;
	public static int size=0;
	
	/**
	 * This method reads information from the csv file and creates ProductionWorker, ShiftSuperVisor, or TeamLeader objects.
	 */
	public static void readRecords()
	{
		Scanner scan= null;
		try {
			File file1=new File("employeeRecords.txt"); //I made it a csv file. It says "space delimited" in directions, but it is separated by commas. 
			scan=new Scanner(file1);
			while(scan.hasNext())
			{
				String line=scan.nextLine();
				String [] arr=line.split(",");
				int workerType=Integer.parseInt(arr[0]);
				int shift, trainHours, attendHours;
				double salary, bonus, payRate;
				String empName, empNum, hireDate;
				if(workerType==1)
				{
					empName=arr[1];
					empNum=arr[2];
					hireDate=arr[3];
					shift=Integer.parseInt(arr[4]);
					payRate=Double.parseDouble(arr[5]);
					employees[size]=new ProductionWorker(empName,empNum,hireDate,shift,payRate);
					size++;
				}
				else if(workerType==2)
				{
					empName=arr[1];
					empNum=arr[2];
					hireDate=arr[3];
					shift=Integer.parseInt(arr[4]);
					salary=Double.parseDouble(arr[5]);
					bonus=Integer.parseInt(arr[6]);
					employees[size]=new ShiftSupervisor(empName,empNum,hireDate,salary,bonus,shift);
					size++;
				}
				else if(workerType==3)
				{
					empName=arr[1];
					empNum=arr[2];
					hireDate=arr[3];
					shift=Integer.parseInt(arr[4]);
					bonus=Integer.parseInt(arr[5]);
					payRate=Double.parseDouble(arr[6]);
					trainHours=Integer.parseInt(arr[7]);
					attendHours=Integer.parseInt(arr[8]);
					employees[size]=new TeamLeader(empName,empNum,hireDate,shift,payRate,bonus,trainHours,attendHours);
					size++;
				}
				else
					break;
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		catch(InputMismatchException e)
		{
			System.out.println("Input mismatch");
		}
		finally {
			if(scan!=null)
				scan.close();
		}
	}
	
	/**
	 * This method sets the daily production for a ProductionWorker.
	 * @return days - the number of days that determines production.
	 */
	public static int setProduction()
	{
		Scanner scan=new Scanner(System.in);
		System.out.print("How many days do you want to determine production? (From 1-365)");
		int days=scan.nextInt();
		for(int i=0;i<employees.length;i++)
		{
			Random r= new Random();
			int random= r.nextInt(100) + 1;
			ProductionWorker worker;
			if(employees[i] instanceof ProductionWorker obj) {
				worker=(ProductionWorker)employees[i];
				for(int j=0;j<=days;j++) 
					obj.setDailyProduction(random);
			}
		}
		return days;
	}
	
	/**
	 * This method calculates the average with a double and integer.
	 */
	public static double calculateAverage(double total,int count)
	{
		return total/count;
	}
	
	/**
	 * This method determines the bonus of a ShiftSupervisor given the days worked and then prints for information for a ShiftSupervisor. 
	 * @param days - the number of days worked.
	 */
	public static void determineSupervisorBonus(int days)
	{
		ProductionWorker worker;
		int totalDay=0;
		int totalNight=0;
		int count1=1;
		int count2=1;
		DecimalFormat formatter=new DecimalFormat("$0.00");
		for(int i=0;i<employees.length;i++)
		{
				if(employees[i] instanceof ProductionWorker obj) {
				worker=(ProductionWorker)employees[i];
				for(int j=0;j<=days;j++) {
					if(obj.getShift()==1) {
						totalDay+=obj.calculateYearlyProduction();
						count1++;
					}
					else if(obj.getShift()==2) {
						totalNight+=obj.calculateYearlyProduction();
						count2++;
					}
				}
				}
				double avgDay=calculateAverage(totalDay,count1);
				double avgNight=calculateAverage(totalNight,count2);
				if(employees[i] instanceof ShiftSupervisor obj2) {
					ShiftSupervisor supervisor;
					supervisor=(ShiftSupervisor)employees[i];
					if(avgDay>60)
					{
						System.out.println("Supervisor "+obj2.getEmpName()+" earned "+formatter.format(avgDay)+"\n"+obj2.toString());
					}
					else if(avgNight>50)
					{
						System.out.println("Supervisor "+obj2.getEmpName()+" earned "+formatter.format(avgNight)+"\n"+obj2.toString());
					}
					else
					{
						obj2.setBonus(0);;
						System.out.println("Supervisor "+obj2.getEmpName()+" earned "+formatter.format(obj2.getBonus())+"\n"+obj2.toString());
					}
						
				}
		}
	}
	
	/**
	 * This method gets the bonus for a TeamLeader and returns information for a TeamLeader.
	 */
	public static void determineTeamLeadBonus()
	{
		DecimalFormat formatter=new DecimalFormat("$0.00");
		for(int i=0;i<employees.length;i++)
		{
			if(employees[i] instanceof TeamLeader obj)
			{
				TeamLeader leader;
				leader=(TeamLeader)employees[i];
				if(obj.getTrainHours()<obj.getAttendHours())
				{
					System.out.println("Bonus earned "+formatter.format(obj.getBonus())+"\n"+obj.toString());
				}
				else 
					System.out.println("Bonus not earned"+"\n"+obj.toString());
			}
		}
	}
	
	/**
	 * This method prints all the information for ProductionWorker and TeamLeader objects. 
	 */
	public static void printAllProd()
	{
		System.out.println("All Production Workers\n"+"-----------------------------");
		for(int i=0;i<employees.length;i++)
		{
			if(employees[i] instanceof TeamLeader obj)
			{
				TeamLeader leader;
				leader=(TeamLeader)employees[i];
				System.out.println(obj.toString());
			}
			else if(employees[i] instanceof ProductionWorker obj)
			{
				ProductionWorker worker;
				worker=(ProductionWorker)employees[i];
				System.out.println(obj.toString());
			}
		}
	}
	
	
}
