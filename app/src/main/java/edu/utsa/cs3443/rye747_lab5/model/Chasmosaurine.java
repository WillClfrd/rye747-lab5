package edu.utsa.cs3443.rye747_lab5.model;
/**
 * This class represents Chasmosaurine objects.
 * The Chasmosaurine class implements the Dinosaur interface.
 * The Chasmosaurine maintains name, type, and isVeg attributes for Chasmosaurine objects
 *
 * @author William Clifford (rye747)
 * UTSA CS 3443 - Lab 5
 * Spring 2023
 */
public abstract class Chasmosaurine implements Dinosaur{
    private String name;
    private String type = "Chasmosaurine";
    private boolean isVeg;

    /**
     * Constructs an object of the Chasmosaurine class.
     *
     * @param pName the value to be assigned to the Chasmosaurine class name attribute
     * @param isVege the value to be assigned to the Chasmosaurine class isVeg attribute
     */
    public Chasmosaurine(String pName, boolean isVege) {
        name = pName;
        isVeg = isVege;
    }

    /**
     * Returns a formatted string representation of Chasmosaurine class attributes.
     *
     * @return the formatted string representation of Chasmosaurine class attributes
     */
    public String toString() {
        return getTypeString().replace(" -", ":") + " named " + getName() +  " (" + dietType() + ")";
    }

    /**
     * Returns the Chasmosaurine class name atttribute.
     *
     * @return the name attribute of the Chasmosaurine object
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the Chasmosaurine class type attribute.
     *
     * @return the type attribute of the Chasmosaurine object
     */
    public String getType(){ return type; }

    /**
     * Returns a string representation of Chasmosaurine type attribute along the value returned from the getSubType method.
     *
     * @return the formatted string representation of the Chasmosaurine type attribute combined with the output of the getSubType method
     */
    public String getTypeString() {
        return type + " - " + getSubType();
    }

    /**
     * Returns the Chasmosaurine class isVeg attribute.
     *
     * @return the isVeg attribute of the Chasmosaurine object
     */
    public boolean getVeg() {
        return isVeg;
    }

    /**
     * Sets the value of the Chasmosaurine object name attribute to the specified value.
     *
     * @param newName the value specified to assign to the Chasmosaurine object name attribute
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * Sets the value of the Chasmosaurine object isVeg attribute to the specified value.
     *
     * @param newVeg the value specified to assign to the Chasmosaurine object isVeg attribute
     */
    public void setVeg(boolean newVeg) {
        isVeg = newVeg;
    }

    /**
     * Sets the value of the Chasmosaurine object type attribute to the specified value.
     *
     * @param newType the value specified to assign to the Chasmosaurine object type attribute
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
     * Returns a formatted string representation of the Chasmosaurine isVeg attribute.
     *
     * @return the formatted string representation of the Chasmosaurine isVeg attribute
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
     * Intended to return type attribute of Chasmosaurine subclass objects.
     *
     * @return the type attribute of the Chasmosaurine subclass object
     */
    public abstract String getSubType();
}

