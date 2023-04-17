package edu.utsa.cs3443.rye747_lab5.model;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents Park objects.
 * The Park class maintains a Park object name attribute as well as an ArrayList of Zone objects.
 *
 * @author William Clifford (rye747)
 * UTSA CS 3443 - Lab 5
 * Spring 2023
 */
public class Park {
     private String name;
     private ArrayList<Zone> zones;

    /**
     * Constructs a Park object with the specified value assigned to the corresponding Park object attributes.
     * Initializes the Park object zones ArrayList.
     *
     * @param pName the value specified for assignment to the Park object name attribute
     */
    public Park(String pName) {
         name = pName;
         zones = new ArrayList<Zone>();
     }

    /**
     * Parses the contents of the zones.csv, types.csv, and dinos.csv asset files.
     * Using data read in from the zones.csv asset file Zone objects are added to the Park zones ArrayList attribute.
     * Using data read in from the types.csv and dinos.csv asset files Dinosaur objects are added to the corresponding Zone object dinos ArrayList attribute.
     *
     * @param manager the AssetManager used to access the zones.csv, types.csv, and dinos.csv asset files
     * @param context the context used to open file input and output streams
     * @param isInitialRead a boolean value used to determine whether the dinos.csv file should be accessed with the AssetManager manager or not
     */
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

    /**
     * Returns a Dinosaur object created with the correct Dinosaur subclass based on the data read in from the input file.
     *
     * @param name the String value to be passed in as the name parameter for the Dinosaur subclass constructor
     * @param type used to determine the correct Dinosaur subclass constructor to call for construction of the newDino object
     * @return a Dinosaur object created with the correct subclass constructor based on the type parameter
     */
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

    /**
     * Returns the String value of the Park object name attribute.
     *
     * @return the name attribute of the Park object
     */
    public String getName() {
     return name;
    }

    /**
     * Returns the Zone object in the Park zones ArrayList attribute corresponding to the specified index.
     *
     * @param index the specified index in the Park zones ArrayList attribute of the desired return object
     * @return the Zone object located at the specified index of the Park zones Arraylist attribute
     */
    public Zone getZone(int index){
     return zones.get(index);
    }

    /**
     * Returns the integer value of the size of the Park object zones ArrayList.
     *
     * @return the count of the Park zones ArrayList attribute elements
     */
    public int getZonesSize(){
     return this.zones.size();
    }

    /**
     * Sets the value of the Park object name attribute to the value specified by newName
     *
     * @param newName the value to be assigned to the Park object name attribute
     */
    public void setName(String newName) {
     name = newName;
    }

    /**
     * Adds the specified Zone object to the Park object zones ArrayList attribute.
     *
     * @param zone the specified Zone object to be added to the Park object zones ArrayList attribute
     */
    public void addZone(Zone zone){
     zones.add(zone);
    }
}