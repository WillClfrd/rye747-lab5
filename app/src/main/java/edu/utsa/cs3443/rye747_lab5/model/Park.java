package edu.utsa.cs3443.rye747_lab5.model;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
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

 public void loadZones(AssetManager manager, Context context, boolean isInitialRead){
     ArrayList<String> dinoTypes = new ArrayList<String>();
     boolean[] diets = new boolean[0];
     int dietsSize = 0;
     int i;
     int j;

     try{
         InputStream zonesFile = manager.open("zones.csv");
         Scanner read = new Scanner(zonesFile);
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
         Scanner read = new Scanner(dinosFile);
         String line;
         String[] lineTokens;

         while(read.hasNextLine()){
             boolean[] tempDiets = new boolean[++dietsSize];
             line = read.nextLine();
             lineTokens = line.split(",");
             dinoTypes.add(lineTokens[0]);
             int z;

             for(z = 0; z < dietsSize - 1; ++z){
                 tempDiets[z] = diets[z];
             }
             diets = tempDiets;

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
         InputStream dinosFile;
         OutputStream outFile;
         ArrayList<String> lines = new ArrayList<String>();

         if(isInitialRead) {
             dinosFile = manager.open("dinos.csv");
             Log.d("Input Stream Type", "Asset manager");
         }
         else{
             dinosFile = context.openFileInput("dinos.csv");
             Log.d("Input Stream Type", "Context.openFileInput");
         }
         Scanner read = new Scanner(dinosFile);
         String line;
         String[] lineTokens;

         while(read.hasNextLine()){
             line = read.nextLine();
             lineTokens = line.split(",");
             for(i = 0; i < zones.size(); ++i){
                 if(lineTokens[2].equals(zones.get(i).getAbbreviation())){
                     zones.get(i).addDino(createDinosaur(lineTokens[0], lineTokens[1]));
                 }
             }
             String tempLine = lineTokens[0] + "," + lineTokens[1] + "," + lineTokens[2] + "\n";
             Log.d("Line read in Park", tempLine);
             lines.add(tempLine);
         }
         dinosFile.close();
         read.close();

         outFile = context.openFileOutput("dinos.csv", Context.MODE_PRIVATE);
         for(i = 0; i < lines.size(); ++i){
             outFile.write(lines.get(i).getBytes(StandardCharsets.UTF_8));
         }
         outFile.close();

         Log.d("Diets array size", String.valueOf(dietsSize));
         for(i = 0; i < zones.size(); ++i){
             for(j = 0; j < zones.get(i).getDinosSize(); ++j){
                 for(int z = 0; z < dinoTypes.size(); ++z){
                     if(dinoTypes.get(z).equalsIgnoreCase(zones.get(i).getDino(j).getType())){
                         zones.get(i).getDino(j).setVeg(diets[z]);
                     }
                 }
             }
         }
     }
     catch(IOException e){
         throw new RuntimeException(e);
     }
 }

 private Dinosaur createDinosaur(String name, String type){
     int i;
     Dinosaur newDino;

     if(type.equalsIgnoreCase("Apatosaurus")){
         newDino = new Apatosaurus(name, true);
     }
     else if(type.equalsIgnoreCase("Brachiosaurus")){
         newDino = new Brachiosaurus(name, true);
     }
     else if(type.equalsIgnoreCase("Dilophosaurus")){
         newDino = new Dilophosaurus(name, true);
     }
     else if(type.equalsIgnoreCase("Gallimimus")){
         newDino = new Gallimimus(name, true);
     }
     else if(type.contains("Indominous")){
         newDino = new Indominous(name, true);
     }
     else if(type.equalsIgnoreCase("Stegosaurus")){
         newDino = new Stegosaurus(name, true);
     }
     else if(type.equalsIgnoreCase("Triceratops")){
         newDino = new Triceratops(name, true);
     }
     else if(type.equalsIgnoreCase("Tyrannosaurus")){
         newDino = new Tyrannosaurus(name, true);
     }
     else if(type.equalsIgnoreCase("Velociraptor")){
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

 public int getZonesSize(){
     return this.zones.size();
 }
 
 //setName is used to set the park object name to a new String that is passed in as a parameter to setName
 public void setName(String newName) {
	 name = newName;
 }

 public void addZone(Zone zone){
     zones.add(zone);
 }
}