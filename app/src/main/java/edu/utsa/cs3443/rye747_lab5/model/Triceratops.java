package edu.utsa.cs3443.rye747_lab5.model;
//William Clifford rye747
/*The Triceratops class extends the Chasmosaurine class and can be used to create Dinosaur objects
 * */
public class Triceratops extends Chasmosaurine{
    private String myType = "Triceratops";

    //the Triceratops class constructor instantiates an object of the Triceratops subclass by calling the Chasmosaurine class constructor
    public Triceratops(String name, boolean isVege) {
        super(name, isVege);
    }

    //getMyType is used to return the myType attribute of the Triceratops object
    public String getMyType() {
        return myType;
    }

    //the Triceratops toString method calls the super class toString method in order to return relevant class data as a string for output
    public String toString() {
        return super.toString();
    }

    //the getSubType method is used to return the Triceratops myType attribute
    public String getSubType() {
        return getMyType();
    }

    //the setMyType method is used to set the value of the myType Triceratops class attribute to the value of newType
    public void setMyType(String newType) {
        myType = newType;
    }
}
