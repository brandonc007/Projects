package edu.ilstu;
import java.util.EventObject;

public class FormEvent extends EventObject {
	private String name;
	private String occupation;
	private int ageCategory;
	private String empCategory;
	private boolean isCitizen;
	private String taxID;
	private String gender;

	public FormEvent(Object source, String name, String occupation, int ageCat, String empCategory, 
			boolean isCitizen, String taxID, String gender) {
		super(source);
		this.name=name;
		this.occupation = occupation;
		this.ageCategory = ageCat;
		this.empCategory = empCategory;
		this.isCitizen = isCitizen;
		this.taxID = taxID;
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public boolean isCitizen() {
		return isCitizen;
	}

	public String getTaxID() {
		return taxID;
	}

	public String getEmpCategory() {
		return empCategory;
	}

	public int getAgeCategory() {
		return ageCategory;
	}

	public String getName() {
		return name;
	}

	public String getOccupation() {
		return occupation;
	}
	
	

}
