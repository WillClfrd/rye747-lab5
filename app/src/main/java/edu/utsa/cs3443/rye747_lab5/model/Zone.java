package edu.utsa.cs3443.rye747_lab5.model;

import java.util.ArrayList;

/**
 * This class represents Zone objects.
 * The Zone class maintains Zone object name, riskLevel, abbreviation, and numberOfGuests attributes as well as an ArrayList of Dinosaur objects.
 *
 * @author William Clifford (rye747)
 * UTSA CS 3443 - Lab 5
 * Spring 2023
 */
public class Zone {
    private String name;
    private String riskLevel;
    private String abbreviation;
    private int numberOfGuests;
    private ArrayList<Dinosaur> dinos;

    /**
     * Constructs a Zone class object with the given parameters assigned to the corresponding Zone attributes.
     * Initializes the Zone dinos ArrayList.
     *
     * @param name the value specified to be assigned to the Zone object name attribute
     * @param riskLevel the value specified to be assigned to the Zone object riskLevel attribute
     * @param abbreviation the value specified to be assigned to the Zone object abbreviation attribute
     * @param numberOfGuests the value specified to be assigned to the Zone object numberOfGuests attribute
     */
    public Zone(String name, String riskLevel, String abbreviation, int numberOfGuests){
        this.name = name;
        this.riskLevel = riskLevel;
        this.abbreviation = abbreviation;
        this.numberOfGuests = numberOfGuests;
        dinos = new ArrayList<Dinosaur>();
    }

    /**
     * Returns the String value of the Zone object name attribute.
     *
     * @return the name attribute of the Zone object
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns the String value of the Zone object riskLevel attribute.
     *
     * @return the riskLevel attribute of the Zone object
     */
    public String getRiskLevel(){
        return this.riskLevel;
    }

    /**
     * Returns the String value of the Zone object abbreviation attribute.
     *
     * @return the abbreviation attribute of the Zone object
     */
    public String getAbbreviation(){
        return this.abbreviation;
    }

    /**
     * Returns the integer value of the Zone object numberOfGuests attribute.
     *
     * @return the numberOfGuests attribute of the Zone object
     */
    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    /**
     * Returns the Dinosaur object at the specified index of the Zone object dinos ArrayList.
     *
     * @param index the index in the dinos ArrayList of the desired return object
     * @return the Dinosaur at the specified index of the Zone object dinos ArrayList
     */
    public Dinosaur getDino(int index){
        return dinos.get(index);
    }

    /**
     * Returns the dinos Arraylist attribute of the Zone object.
     *
     * @return the dinos ArrayList attribute of the Zone object
     */
    public ArrayList getDinos(){
        return this.dinos;
    }

    /**
     * Returns the integer value of the size of the Zone object dinos ArrayList.
     *
     * @return the integer size of the Zone object dinos ArrayList
     */
    public int getDinosSize(){ return this.dinos.size(); }

    /**
     * Sets the Zone object name attribute to the specified value.
     *
     * @param name the value specified for assignment to the Zone object name attribute
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Sets the Zone object riskLevel attribute to the specified value.
     *
     * @param riskLevel the value specified for assignment to the Zone object riskLevel attribute
     */
    public void setRiskLevel(String riskLevel){
        this.riskLevel = riskLevel;
    }

    /**
     * Sets the Zone object abbreviation attribute to the specified value.
     *
     * @param abbreviation the value specified for assignment to the Zone object abbreviation attribute
     */
    public void setAbbreviation(String abbreviation){
        this.abbreviation = abbreviation;
    }

    /**
     * Sets the Zone object numberOfGuests attribute to the specified value.
     *
     * @param numberOfGuests the value specified for assignment to the Zone object numberOfGuests attribute
     */
    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    /**
     * Adds the specified Dinosaur object to the Zone object dinos ArrayList attribute.
     *
     * @param dino the object specified to be added to the Zone object dinos Arraylist attribute
     */
    public void addDino(Dinosaur dino){
        this.dinos.add(dino);
    }
}
