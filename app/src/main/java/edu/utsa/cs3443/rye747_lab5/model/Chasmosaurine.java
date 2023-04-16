package edu.utsa.cs3443.rye747_lab5.model;
//William Clifford rye747
/*The Chasmosaurine class implements the Dinosaur interface, contains many important methods for Dinosaur objects, and can be used to instantiate Dinosaur objects
 * */
public abstract class Chasmosaurine implements Dinosaur{
    private String name;
    private String type = "Chasmosaurine";
    private boolean isVeg;

    /*The Sauropod class constructor takes a String and a boolean in as parameters in order to instantiate a Sauropod object
     * The String parameter is used to assign the Sauropod object's name value
     * The boolean parameter is used to assign the Sauropod object's isVeg value
     * */
    public Chasmosaurine(String pName, boolean isVege) {
        name = pName;
        isVeg = isVege;
    }

    /*The Sauropod toString method formats the Dinosaur object properties into a String for output by calling several methods
     * getType is called to return the Dinosaur type and subtype attributes formatted as a string
     * getName is called to return the Dinosaur name attribute
     * dietType is called to return whether the Dinosaur is a carnivore or not based on the value of isVeg
     * */
    public String toString() {
        return getTypeString().replace(" -", ":") + " named " + getName() +  " (" + dietType() + ")";
    }

    //getName returns the name attribute of the Dinosaur object
    public String getName() {
        return name;
    }

    public String getType(){ return type; }

    //getTypeString is called to return the type attribute from the Sauropod class and the myType(Sauropod subType) attribute from the relevant subclass
    public String getTypeString() {
        return type + " - " + getSubType();
    }

    //getVeg returns the true/false value of the isVeg attribute
    public boolean getVeg() {
        return isVeg;
    }

    //setName is used to set the Sauropod class name attribute to the value of newName
    public void setName(String newName) {
        name = newName;
    }

    //setVeg is used to set the Sauropod class isVeg attribute to the value of newVeg
    public void setVeg(boolean newVeg) {
        isVeg = newVeg;
    }

    //setType is called to set the type attribute in the Sauropod class to the value of newType
    public void setType(String newType) {
        type = newType;
    }

    //isVegetarian is used to return the value of the isVeg attribute
    public boolean isVegetarian() {
        return getVeg();
    }

    //dietType is called to return a string based on the value of isVeg
    public String dietType() {
        if(isVegetarian()) {
            return "not carnivore";
        }
        else {
            return "carnivore";
        }
    }

    //getSubType is abstractly defined in Sauropod and is implemented in the Sauropod subclasses
    public abstract String getSubType();
}

