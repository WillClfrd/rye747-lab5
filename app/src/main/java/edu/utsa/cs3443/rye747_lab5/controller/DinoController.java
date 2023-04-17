package edu.utsa.cs3443.rye747_lab5.controller;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

public class DinoController implements View.OnClickListener{
    private DinoActivity activity;
    private Park park;
    private AssetManager manager;
    private String zoneAbbreviation;
    private Zone currentZone;
    private String key = "dino_key";
    private String isInitialReadKey = "initial_read";
    private boolean isInitialRead;

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
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.dino_activity_relocate_button){
            EditText dinoName = activity.findViewById(R.id.dino_name_edit_text);
            EditText newZone = activity.findViewById(R.id.new_zone_edit_text);

            if(validateName(String.valueOf(dinoName.getText())) && validateZone(String.valueOf(newZone.getText()))){
                moveDino(String.valueOf(dinoName.getText()), String.valueOf(newZone.getText()));
                Toast.makeText(activity, String.valueOf(dinoName.getText()) + " successfully moved to " + String.valueOf(newZone.getText()), Toast.LENGTH_LONG).show();
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

    public boolean validateName(String userText){
        int i;

        for(i = 0; i < currentZone.getDinosSize(); ++i){
            if(userText.equalsIgnoreCase(currentZone.getDino(i).getName())){
                return true;
            }
        }
        return false;
    }

    public boolean validateZone(String userText){
        int i;

        for(i = 0; i < park.getZonesSize(); ++i){
            if(userText.equalsIgnoreCase(park.getZone(i).getAbbreviation())){
                return true;
            }
        }
        return false;
    }

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
                 Log.d("tempLine", tempLine);
                 lines.add(tempLine);
            }
            inStream.close();
            read.close();

            outStream = activity.openFileOutput(filename, activity.MODE_PRIVATE);
            for(i = 0; i < lines.size(); ++i){
                Log.d("Line to be Written", lines.get(i));
                outStream.write(lines.get(i).getBytes(StandardCharsets.UTF_8));
            }

            outStream.close();
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
