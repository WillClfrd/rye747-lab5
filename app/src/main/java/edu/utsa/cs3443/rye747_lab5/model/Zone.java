package edu.utsa.cs3443.rye747_lab5.model;

import java.util.ArrayList;

public class Zone {
    private int numberOfGuests;
    private ArrayList<Dinosaur> dinos;

    public Zone(int numberOfGuests){
        this.numberOfGuests = numberOfGuests;
        dinos = new ArrayList<Dinosaur>();
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

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void addDino(Dinosaur dino){
        this.dinos.add(dino);
    }
}
