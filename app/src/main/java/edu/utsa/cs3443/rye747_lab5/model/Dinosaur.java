package edu.utsa.cs3443.rye747_lab5.model;

/**
 * This interface represents Dinosaur objects.
 * The Dinosaur interface contains method declarations for required inherited method.
 *
 * @author William Clifford (rye747)
 * UTSA CS 3443 - Lab 5
 * Spring 2023
 */
public interface Dinosaur {
	/**
	 * Abstract method declaration of toString method.
	 * Intended to return a formatted string representation of subclass attributes.
	 *
	 * @return the formatted string of Dinosaur subclass attributes
	 */
	public abstract String toString();

	/**
	 * Abstract method declaration of isVegetarian method.
	 * Intended to return boolean value of a Dinosaur subclass attribute.
	 *
	 * @return the boolean value of the Dinosaur subclass attribute
	 */
	public abstract boolean isVegetarian();

	/**
	 * Abstract method declaration of getName method.
	 * Intended to return String value of a Dinosaur subclass name attribute.
	 *
	 * @return the String value of the Dinosaur subclass name attribute
	 */
	public abstract String getName();

	/**
	 * Abstract method declaration of getType method.
	 * Intended to return String value of a Dinosaur subclass type attribute.
	 *
	 * @return the String value of the Dinosaur subclass type attribute
	 */
	public abstract String getType();

	/**
	 * Abstract method declaration of getSubType method.
	 * Intended to return String value of a Dinosaur subclass subType attribute.
	 *
	 * @return the String value of the Dinosaur subclass subType attribute
	 */
	public abstract String getSubType();

	/**
	 * Abstract method declaration of the setVeg method.
	 * Intended to set the value of Dinosaur subclass isVeg attribute to the specified value.
	 *
	 * @param newVeg the specified value for assignment to the Dinosaur subclass isVeg attribute
	 */
	public abstract void setVeg(boolean newVeg);
}