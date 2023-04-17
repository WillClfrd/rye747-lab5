package edu.utsa.cs3443.rye747_lab5.model;
/**
 * This class represents Theropod objects.
 * The Theropod class implements the Dinosaur interface.
 * The Theropod class maintains name, type, and isVeg attributes for Theropod objects
 *
 * @author William Clifford (rye747)
 * UTSA CS 3443 - Lab 5
 * Spring 2023
 */
public abstract class Theropod implements Dinosaur{
	private String name;
	private String type = "Theropod";
	private boolean isVeg;

	/**
	 * Constructs an object of the Theropod class.
	 *
	 * @param pName the value to be assigned to the Theropod class name attribute
	 * @param isVege the value to be assigned to the Theropod class isVeg attribute
	 */
	public Theropod(String pName, boolean isVege) {
		name = pName;
		isVeg = isVege;
	}

	/**
	 * Returns a formatted string representation of Theropod class attributes.
	 *
	 * @return the formatted string representation of Theropod class attributes
	 */
	public String toString() {
		return getTypeString().replace(" -", ":") + " named " + getName() +  " (" + dietType() + ")";
	}

	/**
	 * Returns the Theropod class name atttribute.
	 *
	 * @return the name attribute of the Theropod object
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the Theropod class type attribute.
	 *
	 * @return the type attribute of the Theropod object
	 */
	public String getType(){ return type; }

	/**
	 * Returns a string representation of Theropod type attribute along the value returned from the getSubType method.
	 *
	 * @return the formatted string representation of the Theropod type attribute combined with the output of the getSubType method
	 */
	public String getTypeString() {
		return type + " - " + getSubType();
	}

	/**
	 * Returns the Theropod class isVeg attribute.
	 *
	 * @return the isVeg attribute of the Theropod object
	 */
	public boolean getVeg() {
		return isVeg;
	}

	/**
	 * Sets the value of the Theropod object name attribute to the specified value.
	 *
	 * @param newName the value specified to assign to the Theropod object name attribute
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * Sets the value of the Theropod object isVeg attribute to the specified value.
	 *
	 * @param newVeg the value specified to assign to the Theropod object isVeg attribute
	 */
	public void setVeg(boolean newVeg) {
		isVeg = newVeg;
	}

	/**
	 * Sets the value of the Theropod object type attribute to the specified value.
	 *
	 * @param newType the value specified to assign to the Theropod object type attribute
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
	 * Returns a formatted string representation of the Theropod isVeg attribute.
	 *
	 * @return the formatted string representation of the Theropod isVeg attribute
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
	 * Intended to return type attribute of Theropod subclass objects.
	 *
	 * @return the type attribute of the Theropod subclass object
	 */
	public abstract String getSubType();
}
