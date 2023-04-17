package edu.utsa.cs3443.rye747_lab5.model;
/**
 * This class represents Stegosaurus objects.
 * The Stegosaurus class extends the Stegosaur abstract class.
 * The Stegosaurus class maintains the myType attribute for Stegosaurus objects
 *
 * @author William Clifford (rye747)
 * UTSA CS 3443 - Lab 5
 * Spring 2023
 */
public class Stegosaurus extends Stegosaur{
	private String myType = "Stegosaurus";

	/**
	 * Constructs Stegosaurus class objects with the name and isVeg parameters by calling the super class constructor.
	 *
	 * @param name the value to pass into the super class constructor for assignment to the super class name attribute
	 * @param isVege the value to pass into the super class constructor for assignment to the super class isVeg attribute
	 */
	public Stegosaurus(String name, boolean isVege) {
		super(name, isVege);
	}

	/**
	 * Returns the Stegosaurus object myType attribute.
	 *
	 * @return the value of the Stegosaurus object myType attribute
	 */
	public String getMyType() {
		return myType;
	}

	/**
	 * Returns the string output of the super class toString method.
	 *
	 * @return the string output value of the super class toString method
	 */
	public String toString() {
		return super.toString();
	}

	/**
	 * Returns the value of the getMyType method output.
	 *
	 * @return the output value of the getMyType method
	 */
	public String getSubType() {
		return getMyType();
	}

	/**
	 * Sets the value of the Stegosaurus object myType attribute to the specified value.
	 *
	 * @param newType the value specified for assignment to the Stegosaurus object myType attribute
	 */
	public void setMyType(String newType) {
		myType = newType;
	}
}