package edu.utsa.cs3443.rye747_lab5.model;

import java.util.ArrayList;

public class Zone {
    private String name;
    private String riskLevel;
    private String abbreviation;
    private int numberOfGuests;
    private ArrayList<Dinosaur> dinos;

    public Zone(String name, String riskLevel, String abbreviation, int numberOfGuests){
        this.name = name;
        this.riskLevel = riskLevel;
        this.abbreviation = abbreviation;
        this.numberOfGuests = numberOfGuests;
        dinos = new ArrayList<Dinosaur>();
    }

    public String getName(){
        return this.name;
    }

    public String getRiskLevel(){
        return this.riskLevel;
    }

    public String getAbbreviation(){
        return this.abbreviation;
    }
    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public Dinosaur getDino(int index){
        return dinos.get(index);
    }

    public ArrayList getDinos(){
        return this.dinos;
    }

    public int getDinosSize(){ return this.dinos.size(); }

    public void setName(String name){
        this.name = name;
    }

    public void setRiskLevel(String riskLevel){
        this.riskLevel = riskLevel;
    }

    public void setAbbreviation(String abbreviation){
        this.abbreviation = abbreviation;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void addDino(Dinosaur dino){
        this.dinos.add(dino);
    }
}
