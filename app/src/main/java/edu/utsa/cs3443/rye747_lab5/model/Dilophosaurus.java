package edu.utsa.cs3443.rye747_lab5.model;
//William Clifford rye747
/*The Dilophosaurus class extends the Theropod class and can be used to create Dinosaur objects
 * */
public class Dilophosaurus extends Theropod{
    private String myType = "Dilophosaurus";

    //the Dilophosaurus class constructor instantiates an object of the Dilophosaurus subclass by calling the Theropod class constructor
    public Dilophosaurus(String name, boolean isVege) {
        super(name, isVege);
    }

    //getMyType is used to return the myType attribute of the Dilophosaurus object
    public String getMyType() {
        return myType;
    }

    //the Dilophosaurus toString method calls the super class toString method in order to return relevant class data as a string for output
    public String toString() {
        return super.toString();
    }

    //the getSubType method is used to return the Dilophosaurus myType attribute
    public String getSubType() {
        return getMyType();
    }

    //the setMyType method is used to set the value of the myType Dilophosaurus class attribute to the value of newType
    public void setMyType(String newType) {
        myType = newType;
    }
}
