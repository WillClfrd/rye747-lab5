package edu.utsa.cs3443.rye747_lab5.model;

import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

//William Clifford rye747
/*The Park class is used to construct Park objects
 * Park objects have a name stored as a String, a maximum capacity stored as an int, and a list of Dinosaurs in the park stored as an array of Dinosaur objects
 * */
public class Park {
 private String name;
 private ArrayList<Zone> zones;
 
 /*The Park constructor takes a String in as the name for the park and an int as the maximum capacity for the park
  * A park object is constructed using these parameters
 */
 public Park(String pName) {
	 name = pName;
     zones = new ArrayList<Zone>();
 }
 
 /*toString formats the park information into a string by calling the getName method for the park and the Dinosaur toString method for each item in the Dinosaurs array
  * This formatted array is then returned
  * */
 public String toString() {
	 String parkStr = "Welcome to " + getName() + "!\n- - - - - - - - - - - - -\n";
	 return parkStr;
 }

 public void loadZones(AssetManager manager){
     ArrayList<String> dinoTypes = new ArrayList<String>();
     boolean[] diets = new boolean[0];
     int dietsSize = 0;
     Scanner read;
     int i;
     int j;

     try{
         InputStream zonesFile = manager.open("zones.csv");
         read = new Scanner(zonesFile);
         String line;
         String[] lineTokens;

         while(read.hasNextLine()){
             line = read.nextLine();
             lineTokens = line.split(",");
             zones.add(new Zone(lineTokens[0], lineTokens[1], lineTokens[2], Integer.parseInt(lineTokens[3])));
         }
         read.close();
     }
     catch(IOException e){
         throw new RuntimeException(e);
     }

     try{
         InputStream dinosFile = manager.open("types.csv");
         read = new Scanner(dinosFile);
         String line;
         String[] lineTokens;

         while(read.hasNextLine()){
             line = read.nextLine();
             lineTokens = line.split(",");
             dinoTypes.add(lineTokens[0]);
             diets = new boolean[++dietsSize];
             if(lineTokens[1].equalsIgnoreCase("true")){
                 diets[dietsSize - 1] = true;
             }
             else{
                 diets[dietsSize - 1] = false;
             }
         }
         read.close();
     }
     catch(IOException e){
         throw new RuntimeException(e);
     }

     try{
         InputStream dinosFile = manager.open("dinos.csv");
         read = new Scanner(dinosFile);
         String line;
         String[] lineTokens;

         while(read.hasNextLine()){
             line = read.nextLine();
             lineTokens = line.split(",");
             for(i = 0; i < zones.size(); ++i){
                 if(lineTokens[2].equals(zones.get(i).getAbbreviation())){
                     zones.get(i).addDino(createDinosaur(lineTokens[0], lineTokens[1]));
                 }
                 for(j = 0; j < dinoTypes.size(); ++j)
                 if(zones.get(i).getDino(zones.get(i).getDinosSize() - 1).getType().equalsIgnoreCase(dinoTypes.get(j))){
                     zones.get(i).getDino(zones.get(i).getDinosSize() - 1).setVeg(diets[j]);
                 }
             }
         }
     }
     catch(IOException e){
         throw new RuntimeException(e);
     }
 }

 private Dinosaur createDinosaur(String name, String type){
     Dinosaur newDino;

     if(type.equals("Apatosaurus")){
         newDino = new Apatosaurus(name, true);
     }
     else if(type.equals("Brachiosaurus")){
         newDino = new Brachiosaurus(name, true);
     }
     else if(type.equals("Dilophosaurus")){
         newDino = new Dilophosaurus(name, true);
     }
     else if(type.equals("Gallimimus")){
         newDino = new Gallimimus(name, true);
     }
     else if(type.equals("Indominous")){
         newDino = new Indominous(name, true);
     }
     else if(type.equals("Stegosaurus")){
         newDino = new Stegosaurus(name, true);
     }
     else if(type.equals("Triceratops")){
         newDino = new Triceratops(name, true);
     }
     else if(type.equals("Tyrannosaurus")){
         newDino = new Tyrannosaurus(name, true);
     }
     else if(type.equals("Velociraptor")){
         newDino = new Velociraptor(name, true);
     }
     else{
         newDino = new Apatosaurus(name, true);
     }

     return newDino;
 }

 //getName is used to return the name of the park as a String
 public String getName() {
	 return name;
 }

 public Zone getZone(int index){
     return zones.get(index);
 }
 
 //setName is used to set the park object name to a new String that is passed in as a parameter to setName
 public void setName(String newName) {
	 name = newName;
 }

 public void addZone(Zone zone){
     zones.add(zone);
 }
}