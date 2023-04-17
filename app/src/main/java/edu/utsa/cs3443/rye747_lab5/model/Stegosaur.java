package edu.utsa.cs3443.rye747_lab5.model;
/**
 * This class represents Stegosaur objects.
 * The Stegosaur class implements the Dinosaur interface.
 * The Stegosaur class maintains name, type, and isVeg attributes for Stegosaur objects
 *
 * @author William Clifford (rye747)
 * UTSA CS 3443 - Lab 5
 * Spring 2023
 */
public abstract class Stegosaur implements Dinosaur{
	private String name;
	private String type = "Stegosaur";
	private boolean isVeg;

	/**
	 * Constructs an object of the Stegosaur class.
	 *
	 * @param pName the value to be assigned to the Stegosaur class name attribute
	 * @param isVege the value to be assigned to the Stegosaur class isVeg attribute
	 */
	public Stegosaur(String pName, boolean isVege) {
		name = pName;
		isVeg = isVege;
	}

	/**
	 * Returns a formatted string representation of Stegosaur class attributes.
	 *
	 * @return the formatted string representation of Stegosaur class attributes
	 */
	public String toString() {
		return getTypeString().replace(" -", ":") + " named " + getName() +  " (" + dietType() + ")";
	}

	/**
	 * Returns the Stegosaur class name atttribute.
	 *
	 * @return the name attribute of the Stegosaur object
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the Stegosaur class type attribute.
	 *
	 * @return the type attribute of the Stegosaur object
	 */
	public String getType(){ return type; }

	/**
	 * Returns a string representation of Stegosaur type attribute along the value returned from the getSubType method.
	 *
	 * @return the formatted string representation of the Stegosaur type attribute combined with the output of the getSubType method
	 */
	public String getTypeString() {
		return type + " - " + getSubType();
	}

	/**
	 * Returns the Stegosaur class isVeg attribute.
	 *
	 * @return the isVeg attribute of the Stegosaur object
	 */
	public boolean getVeg() {
		return isVeg;
	}

	/**
	 * Sets the value of the Stegosaur object name attribute to the specified value.
	 *
	 * @param newName the value specified to assign to the Stegosaur object name attribute
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * Sets the value of the Stegosaur object isVeg attribute to the specified value.
	 *
	 * @param newVeg the value specified to assign to the Stegosaur object isVeg attribute
	 */
	public void setVeg(boolean newVeg) {
		isVeg = newVeg;
	}

	/**
	 * Sets the value of the Stegosaur object type attribute to the specified value.
	 *
	 * @param newType the value specified to assign to the Stegosaur object type attribute
	 */
	public void setType(String newType) {
		type = newType;
	}

	/**
	 * Returns the output of the getVeg method.
	 *
	 * @return the output value of the getVeg method
	 */
	public boolean isVegetarian() {
		return getVeg();
	}

	/**
	 * Returns a formatted string representation of the Stegosaur isVeg attribute.
	 *
	 * @return the formatted string representation of the Stegosaur isVeg attribute
	 */
	public String dietType() {
		if(isVegetarian()) {
			return "not carnivore";
		}
		else {
			return "carnivore";
		}
	}

	/**
	 * Abstract method declaration of getSubType method.
	 * Intended to return type attribute of Stegosaur subclass objects.
	 *
	 * @return the type attribute of the Stegosaur subclass object
	 */
	public abstract String getSubType();
}