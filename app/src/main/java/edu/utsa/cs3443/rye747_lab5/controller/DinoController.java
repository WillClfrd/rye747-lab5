package edu.utsa.cs3443.rye747_lab5.controller;

import static android.graphics.Typeface.create;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import edu.utsa.cs3443.rye747_lab5.DinoActivity;
import edu.utsa.cs3443.rye747_lab5.MainActivity;
import edu.utsa.cs3443.rye747_lab5.R;
import edu.utsa.cs3443.rye747_lab5.model.Park;
import edu.utsa.cs3443.rye747_lab5.model.Zone;

/**
 * This class represents DinoController objects.
 * The DinoController class establishes onClickListeners and handles changes to view elements for the DinoActivity class.
 *
 * @author William Clifford (rye747)
 * UTSA CS 3443 - Lab 5
 * Spring 2023
 */
public class DinoController implements View.OnClickListener{
    private DinoActivity activity;
    private Park park;
    private AssetManager manager;
    private String zoneAbbreviation;
    private Zone currentZone;
    private String key = "dino_key";
    private String isInitialReadKey = "initial_read";
    private boolean isInitialRead;

    /**
     * Constructs a DinoController class object with the specified value assigned to the DinoController object activity attribute.
     * Initializes the DinoController object manager, park, isInitialRead, zoneAbbreviation, and currentZone attributes.
     *
     * @param activity the object to be assigned to the DinoController object activity attribute.
     */
    public DinoController(DinoActivity activity){
        this.activity = activity;
        manager = activity.getAssets();
        isInitialRead = activity.getIntent().getBooleanExtra(isInitialReadKey, true);

        park = new Park("Jurassic Park");
        park.loadZones(manager, activity, isInitialRead);

        zoneAbbreviation = activity.getIntent().getStringExtra("dino_key");

        int i;
        for(i = 0; i < park.getZonesSize(); ++i){
            if(park.getZone(i).getAbbreviation().equalsIgnoreCase(zoneAbbreviation)){
                this.currentZone = park.getZone(i);
            }
        }

        TextView dinoHeader = activity.findViewById(R.id.dino_header);
        Typeface boldTypeface = create(Typeface.SERIF, Typeface.BOLD);
        dinoHeader.setTextColor(Color.BLACK);
        dinoHeader.setTypeface(boldTypeface);
        dinoHeader.setText("ZONE " + zoneAbbreviation.toUpperCase());
    }

    /**
     * Maintains onClickListeners for views of the DinoController activity attribute which have been assigned onClickListeners.
     *
     * @param view the View object passed as a parameter from the detected click event
     */
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.dino_activity_relocate_button){
            EditText dinoName = activity.findViewById(R.id.dino_name_edit_text);
            EditText newZone = activity.findViewById(R.id.new_zone_edit_text);

            if(validateName(String.valueOf(dinoName.getText())) && validateZone(String.valueOf(newZone.getText()))){
                moveDino(String.valueOf(dinoName.getText()), String.valueOf(newZone.getText()));
                Toast.makeText(activity, String.valueOf(dinoName.getText()) + " successfully moved to zone " + String.valueOf(newZone.getText()).toUpperCase(), Toast.LENGTH_LONG).show();
            }
            else if(validateName(String.valueOf(dinoName.getText()))){
                Toast.makeText(activity, "ERROR: invalid zone abbreviation", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(activity, "ERROR: invalid dino name", Toast.LENGTH_LONG).show();
            }
        }
        else if(view.getId() == R.id.park_map_button){
            Intent parkMapIntent = new Intent(activity, MainActivity.class);
            parkMapIntent.putExtra(isInitialReadKey, isInitialRead);
            activity.startActivity(parkMapIntent);
        }
    }

    /**
     * Checks user input against the name attribute of Dinosaur objects in the currentZone Zone object dinos ArrayList
     *
     * @param userText the input text to be checked against Dinosaur name attributes
     * @return a boolean value, true if userText matched a relevant Dinosaur name attribute, false otherwise
     */
    public boolean validateName(String userText){
        int i;

        for(i = 0; i < currentZone.getDinosSize(); ++i){
            if(userText.equalsIgnoreCase(currentZone.getDino(i).getName())){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks user input against the abbreviation attribute of Zone objects in the park zones ArrayList
     *
     * @param userText the input text to be checked against Zone abbreviation attributes
     * @return a boolean value, true if userText matched an existing Zone abbreviation attribute, false otherwise
     */
    public boolean validateZone(String userText){
        int i;

        for(i = 0; i < park.getZonesSize(); ++i){
            if(userText.equalsIgnoreCase(park.getZone(i).getAbbreviation())){
                return true;
            }
        }
        return false;
    }

    /**
     * Reads in data from the dinos.csv asset file, reassigning the zone abbreviation field of the relevent entry to the updated zone specified by user input.
     *
     * @param searchName the string used to search for the correct entry to alter in the dinos.csv data file.
     * @param newZoneAbbreviation update zone abbreviation value as specified by the user
     */
    public void moveDino(String searchName, String newZoneAbbreviation){
        InputStream inStream;
        OutputStream outStream;
        ArrayList<String> lines = new ArrayList<String>();
        String line;
        String[] lineTokens;
        Scanner read;
        String filename = "dinos.csv";
        int i;

        try{
            inStream = activity.openFileInput(filename);
            read = new Scanner(inStream);

            while(read.hasNextLine()){
                line = read.nextLine();
                lineTokens = line.split(",");

                 if(lineTokens[0].equalsIgnoreCase(searchName)){
                     lineTokens[2] = newZoneAbbreviation.toUpperCase();
                 }

                 String tempLine = lineTokens[0] + "," + lineTokens[1] + "," + lineTokens[2] + "\n";
                 lines.add(tempLine);
            }
            inStream.close();
            read.close();

            outStream = activity.openFileOutput(filename, activity.MODE_PRIVATE);
            for(i = 0; i < lines.size(); ++i){
                outStream.write(lines.get(i).getBytes(StandardCharsets.UTF_8));
            }

            outStream.close();
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the DinoActivity value of the DinoController object activity attribute.
     *
     * @return the activity attribute of the DinoController object
     */
    public DinoActivity getActivity() {
        return activity;
    }

    /**
     * Returns the park attribute of the DinoController object.
     *
     * @return the Park object value of the DinoController park attribute
     */
    public Park getPark() {
        return park;
    }

    /**
     * Returns the manager attribute of the DinoController object.
     *
     * @return the manager attribute of the DinoController object
     */
    public AssetManager getManager() {
        return manager;
    }

    /**
     * Returns the zoneAbbreviation attribute of the DinoController object.
     *
     * @return the zoneAbbreviation attribute of the DinoController object
     */
    public String getZoneAbbreviation() {
        return zoneAbbreviation;
    }

    /**
     * Returns the currentZone Zone object attribute of the DinoController object.
     *
     * @return the currentZone attribute of the DinoController object
     */
    public Zone getCurrentZone() {
        return currentZone;
    }

    /**
     * Returns the key attribute of the DinoController object.
     *
     * @return the key attribute of the DinoController object
     */
    public String getKey() {
        return key;
    }

    /**
     * Returns the isInitialReadKey attribute of the DinoController object.
     *
     * @return the isInitialReadKey attribute of the DinoController object
     */
    public String getIsInitialReadKey() {
        return isInitialReadKey;
    }

    /**
     * Returns the isInitialRead attribute of the DinoController object.
     *
     * @return the isInitialRead attribute of the DinoController object
     */
    public boolean isInitialRead() {
        return isInitialRead;
    }

    /**
     * Sets the DinoController object activity attribute to the specified object.
     *
     * @param activity the object specified for assignment to the DinoController object activity attribute
     */
    public void setActivity(DinoActivity activity) {
        this.activity = activity;
    }

    /**
     * Sets the DinoController object park attribute to the specified object.
     *
     * @param park the object specified for assignment to the DinoController object park attribute
     */
    public void setPark(Park park) {
        this.park = park;
    }

    /**
     * Sets the DinoController object manager attribute to the specified object.
     *
     * @param manager the objet specified for assignment to the DinoController object manager attribute
     */
    public void setManager(AssetManager manager) {
        this.manager = manager;
    }

    /**
     * Sets the DinoController object zoneAbbreviation attribute to the specified value.
     *
     * @param zoneAbbreviation the value specified for assignment to the DinoController object zoneAbbreviation attribute
     */
    public void setZoneAbbreviation(String zoneAbbreviation) {
        this.zoneAbbreviation = zoneAbbreviation;
    }

    /**
     * Sets the DinoController object currentZone attribute to the specified object.
     *
     * @param currentZone the object specified for assignment to the DinoController object currentZone attribute
     */
    public void setCurrentZone(Zone currentZone) {
        this.currentZone = currentZone;
    }

    /**
     * Sets the DinoController object key attribute to the specified value.
     *
     * @param key the value specified for assignment to the DinoController object key attribute
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Sets the DinoController object isInitialReadKey attribute to the specified value.
     *
     * @param isInitialReadKey the value specified for assignment to the DinoController object isInitialReadkey attribute
     */
    public void setIsInitialReadKey(String isInitialReadKey) {
        this.isInitialReadKey = isInitialReadKey;
    }

    /**
     * Sets the DinoController object isInitialRead attribute to the specified value.
     *
     * @param initialRead the value specified for assignment to the DinoController object isInitialRead attribute
     */
    public void setInitialRead(boolean initialRead) {
        isInitialRead = initialRead;
    }
}
