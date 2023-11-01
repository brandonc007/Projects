/**
 * IT 168
 */
package edu.ilstu;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
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
public class PeriodicTableApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String [] menu={"Display element information","Display particle information (# of protons, electrons, neutrons)","Get element with highest boiling point","Get element with lowest melting points","Molecular mass calculations","Quit"};
		TextMenu menu1=new TextMenu(menu);
		int choice=menu1.getChoice();
		String symbol="";
		if(choice!=5 && choice!=6 && choice!=3 && choice!=4)
		{
			System.out.print("Enter symbol for element: ");
			symbol=scan.next();
		}
		
		PeriodicTable table1=new PeriodicTable();
		table1.readElement("PeriodicTableData.txt");
		
		
		while(choice!=6)
		{
			if(choice==1)
			{
				table1.elemInfo(symbol);
			}
			else if(choice==2)
			{
				table1.particleInfo(symbol);
		    }
			else if(choice==3)
			{
				 System.out.print(table1.getHighBoiling());
			}
			else if(choice==4)
			{
				 System.out.print(table1.getLowMelting());
			}
			else if(choice==5)
			{
				DecimalFormat formatter=new DecimalFormat("0.00");
				
				System.out.println("Molecular Mass calculations: ");
				Scanner fileReader=null;
				
				String fileName="MolecularWeightInput.txt";
				try {
					File inputFile=new File(fileName);
					fileReader=new Scanner(inputFile);
					int count=0;
					String [] arr=new String[6];
					String line="";
					while(fileReader.hasNextLine())
					{
						line=fileReader.nextLine();
						arr[count]=line;
						count++;
					}
					fileReader.close();
					String [] arr2=new String[6];
					String str="";
					String str1="";
					String str2="";
					for(int i=0;i<arr.length;i++)
					{
						str=arr[i];
						str1=str.replace(" ","");
						str2=str1.replace("1","");
						arr2[i]=str2;
					}
					double total=0;
					for(int j=0;j<arr2.length;j++)
					{
						str=arr2[j];
						total=table1.calculateMolarMass(str);
						System.out.println(arr2[j]+" = "+formatter.format(total));
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
			
			choice=menu1.getChoice();
			if(choice!=5 && choice!=6 && choice!=3 && choice!=4)
			{
				System.out.print("Enter symbol for element: ");
				symbol=scan.next();
			}
		}
		System.out.println("Goodbye!");
		
		
	}

}
