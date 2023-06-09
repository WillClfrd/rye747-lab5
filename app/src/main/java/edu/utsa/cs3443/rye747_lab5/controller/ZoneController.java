package edu.utsa.cs3443.rye747_lab5.controller;

import static android.graphics.Typeface.create;
import static android.view.Gravity.CENTER;
import static android.view.Gravity.START;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.widget.LinearLayout.VERTICAL;

import static java.sql.Types.NULL;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.Types;

import edu.utsa.cs3443.rye747_lab5.DinoActivity;
import edu.utsa.cs3443.rye747_lab5.R;
import edu.utsa.cs3443.rye747_lab5.ZoneActivity;
import edu.utsa.cs3443.rye747_lab5.model.Park;
import edu.utsa.cs3443.rye747_lab5.model.Zone;

/**
 * This class represents ZoneController objects.
 * The ZoneController class establishes onClickListeners and handles changes to view elements for the ZoneActivity class.
 *
 * @author William Clifford (rye747)
 * UTSA CS 3443 - Lab 5
 * Spring 2023
 */
public class ZoneController implements View.OnClickListener{
    private ZoneActivity activity;
    private AssetManager manager;
    private LinearLayout zoneLayout;
    private Park park;
    private String key = "zone_abbreviation";
    private String dinoKey = "dino_key";
    private String zoneAbbreviation;
    private Zone currentZone;
    private boolean isInitialRead;
    private String isInitialReadKey = "initial_read";

    /**
     * Constructs a ZoneController class object with the specified value assigned to the ZoneController object activity attribute.
     * Initializes the ZoneController object manager, park, isInitialRead, zoneAbbreviation, and currentZone attributes.
     *
     * @param activity the object to be assigned to the ZoneController object activity attribute.
     */
    public ZoneController(ZoneActivity activity){
        this.activity = activity;
        this.manager = activity.getAssets();
        isInitialRead = activity.getIntent().getBooleanExtra(isInitialReadKey, true);
        park = new Park("Jurassic Park");
        park.loadZones(manager, activity, isInitialRead);
        zoneAbbreviation = activity.getIntent().getStringExtra(key);
        int i;

        Log.d("Zones Count", "" + park.getZonesSize());
        for(i = 0; i < park.getZonesSize(); ++i){
            if(park.getZone(i).getAbbreviation().equalsIgnoreCase(zoneAbbreviation)){
                this.currentZone = park.getZone(i);
            }
        }
        loadZoneLayout(currentZone);
    }

    /**
     * Maintains onClickListeners for views of the ZoneController activity attribute which have been assigned onClickListeners.
     *
     * @param view the View object passed as a parameter from the detected click event
     */
    @Override
    public void onClick(View view){
        if(view.getId() == R.id.relocate_dinosaur_button){
            Intent dinoIntent = new Intent(activity, DinoActivity.class);
            dinoIntent.putExtra(dinoKey, currentZone.getAbbreviation());
            dinoIntent.putExtra(isInitialReadKey, isInitialRead);
            activity.startActivity(dinoIntent);
        }
    }

    /**
     * Generates ZoneActivity views based on the specified Zone object.
     *
     * @param zone the Zone object specified to be used for generating views
     */
    public void loadZoneLayout(Zone zone){
        TextView zoneHeader = activity.findViewById(R.id.zone_header);
        TextView numGuestsView = activity.findViewById(R.id.number_of_guests_textview);
        TextView numDinosView = activity.findViewById(R.id.number_of_dinosaurs_textview);
        zoneLayout = activity.findViewById(R.id.zone_layout);
        Typeface boldTypeface = create(Typeface.SERIF, Typeface.BOLD);
        int i;

        String headerText = "ZONE " + zone.getAbbreviation().toUpperCase();
        zoneHeader.setTextColor(Color.BLACK);
        zoneHeader.setTypeface(boldTypeface);
        zoneHeader.setText(headerText);

        String guestNumText = "# of guests: " + zone.getNumberOfGuests();
        numGuestsView.setTextColor(Color.BLACK);
        numGuestsView.setTypeface(boldTypeface);
        numGuestsView.setText(guestNumText);

        String dinosNumText = "# of dinosaurs: " + zone.getDinosSize();
        numDinosView.setTextColor(Color.BLACK);
        numDinosView.setTypeface(boldTypeface);
        numDinosView.setText(dinosNumText);

        for(i = 0; i < zone.getDinosSize(); ++i) {
            LinearLayout dinoLayout = new LinearLayout(activity);
            ViewGroup.LayoutParams dinoLayoutParams = new ViewGroup.LayoutParams(MATCH_PARENT, 200);
            ViewGroup.LayoutParams dinoImageParams = new ViewGroup.LayoutParams(150, MATCH_PARENT);
            ViewGroup.LayoutParams dinoInfoParams = new ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
            dinoLayout.setPadding(20,5,10,5);

            Bitmap dinoImage = BitmapFactory.decodeResource(activity.getResources(), findPicture(zone.getDino(i).getName()));
            dinoImage = Bitmap.createScaledBitmap(dinoImage, 150, 200, true);
            ImageView dinoPicture = new ImageView(activity);
            dinoPicture.setImageBitmap(dinoImage);
            dinoLayout.addView(dinoPicture, dinoImageParams);

            LinearLayout infoLayout = new LinearLayout(activity);
            infoLayout.setOrientation(VERTICAL);
            infoLayout.setGravity(CENTER|START);
            infoLayout.setPadding(20,30,40,0);

            TextView dinoName = new TextView(activity);
            dinoName.setGravity(START);
            dinoName.setTextColor(Color.BLACK);
            dinoName.setTypeface(boldTypeface);
            dinoName.setText(zone.getDino(i).getName());
            dinoName.setTextSize(23);
            infoLayout.addView(dinoName, dinoInfoParams);

            TextView dinoType = new TextView(activity);
            dinoType.setGravity(START);
            dinoType.setTextColor(Color.BLACK);
            dinoType.setTypeface(Typeface.SERIF);
            String tempString = zone.getDino(i).getSubType() + ", " + dietType(zone.getDino(i).isVegetarian());
            dinoType.setText(tempString);
            dinoType.setTextSize(15);
            infoLayout.addView(dinoType, dinoInfoParams);

            dinoLayout.addView(infoLayout, dinoInfoParams);
            zoneLayout.addView(dinoLayout, dinoLayoutParams);
        }
    }

    /**
     * Returns a drawable id value based on the String name parameter.
     *
     * @param name the String used to determine the correct id value to return
     * @return the id value determined using the name parameter
     */
    public int findPicture(String name){
        Bitmap tempBitmap;
        if(name.equalsIgnoreCase("alice")){
            return R.drawable.alice;
        }
        else if(name.equalsIgnoreCase("armando")){
            return R.drawable.armando;
        }
        else if(name.equalsIgnoreCase("blue")){
            return R.drawable.blue;
        }
        else if(name.equalsIgnoreCase("bob")){
            return R.drawable.bob;
        }
        else if(name.equalsIgnoreCase("brad")){
            return R.drawable.brad;
        }
        else if(name.equalsIgnoreCase("charlie")){
            return R.drawable.charlie;
        }
        else if(name.equalsIgnoreCase("dave")){
            return R.drawable.dave;
        }
        else if(name.equalsIgnoreCase("delta")){
            return R.drawable.delta;
        }
        else if(name.equalsIgnoreCase("dilbert")){
            return R.drawable.dilbert;
        }
        else if(name.equalsIgnoreCase("dude")){
            return R.drawable.dude;
        }
        else if(name.equalsIgnoreCase("echo")){
            return R.drawable.echo;
        }
        else if(name.equalsIgnoreCase("gail")){
            return R.drawable.gail;
        }
        else if(name.equalsIgnoreCase("gilbert")){
            return R.drawable.gilbert;
        }
        else if(name.equalsIgnoreCase("glen")){
            return R.drawable.glen;
        }
        else if(name.equalsIgnoreCase("godfrey")){
            return R.drawable.godfrey;
        }
        else if(name.equalsIgnoreCase("guy")){
            return R.drawable.guy;
        }
        else if(name.equalsIgnoreCase("indy")){
            return R.drawable.indy;
        }
        else if(name.equalsIgnoreCase("littlefoot")){
            return R.drawable.littlefoot;
        }
        else if(name.equalsIgnoreCase("michael")){
            return R.drawable.michael;
        }
        else if(name.equalsIgnoreCase("pat")){
            return R.drawable.pat;
        }
        else if(name.equalsIgnoreCase("pete")){
            return R.drawable.pete;
        }
        else if(name.equalsIgnoreCase("rex")){
            return R.drawable.rex;
        }
        else if(name.equalsIgnoreCase("sarah")){
            return R.drawable.sarah;
        }
        else if(name.equalsIgnoreCase("spike")){
            return R.drawable.spike;
        }
        else if(name.equalsIgnoreCase("stephanie")){
            return R.drawable.stephanie;
        }
        else if(name.equalsIgnoreCase("steve")){
            return R.drawable.steve;
        }
        else if(name.equalsIgnoreCase("trikechael")){
            return R.drawable.trikechael;
        }
        else if(name.equalsIgnoreCase("trudy")){
            return R.drawable.trudy;
        }
        else if(name.equalsIgnoreCase("tyrion")){
            return R.drawable.tyrion;
        }
        else if(name.equalsIgnoreCase("vernan")){
            return R.drawable.vernan;
        }
        else{
            return R.drawable.park_logo;
        }
    }

    /**
     * Returns a formatted string depending on the value of the isVegeterian parameter.
     *
     * @param isVegetarian the boolean value used to determine the return String value
     * @return the formatted string determined by the value of the isVegetarian parameter
     */
    public String dietType(boolean isVegetarian){
        if(isVegetarian){
            return "not carnivore";
        }
        else{
            return "carnivore";
        }
    }

    /**
     * Returns the activity attribute of the ZoneController object.
     *
     * @return the activity attribute of the ZoneController object
     */
    public ZoneActivity getActivity() {
        return activity;
    }

    /**
     * Returns the manager attribute of the ZoneController object.
     *
     * @return the manager attribute of the ZoneController object
     */
    public AssetManager getManager() {
        return manager;
    }

    /**
     * Returns the zoneLayout attribute of the ZoneController object.
     *
     * @return the zoneLayout attribute of the ZoneController object
     */
    public LinearLayout getZoneLayout() {
        return zoneLayout;
    }

    /**
     * Returns the park attribute of the ZoneController object.
     *
     * @return the park attribute of the ZoneController object
     */
    public Park getPark() {
        return park;
    }

    /**
     * Returns the key attribute of the ZoneController object.
     *
     * @return the key attribute of the ZoneController object
     */
    public String getKey() {
        return key;
    }

    /**
     * Returns the dinoKey attribute of the ZoneController object.
     *
     * @return the dinoKey attribute of the ZoneController object
     */
    public String getDinoKey() {
        return dinoKey;
    }

    /**
     * Returns the zoneAbbreviation attribute of the ZoneController object.
     *
     * @return the zoneAbbreviation attribute of the ZoneController object
     */
    public String getZoneAbbreviation() {
        return zoneAbbreviation;
    }

    /**
     * Returns the currentZone attribute of the ZoneController object.
     *
     * @return the currentZone attribute of the ZoneController object
     */
    public Zone getCurrentZone() {
        return currentZone;
    }

    /**
     * Returns the isInitialRead attribute of the ZoneController object.
     *
     * @return the isInitialRead attribute of the ZoneController object
     */
    public boolean isInitialRead() {
        return isInitialRead;
    }

    /**
     * Returns the isInitialReadKey attribute of the ZoneController object.
     *
     * @return the isInitialReadKey attribute of the ZoneController object
     */
    public String getIsInitialReadKey() {
        return isInitialReadKey;
    }

    /**
     * Sets the ZoneController object activity attribute to the specified object.
     *
     * @param activity the object specified for assignment to the ZoneController object activity attribute
     */
    public void setActivity(ZoneActivity activity) {
        this.activity = activity;
    }

    /**
     * Sets the ZoneController object manager attribute to the specified object.
     *
     * @param manager the object specified for assignment to the ZoneController object manager attribute
     */
    public void setManager(AssetManager manager) {
        this.manager = manager;
    }

    /**
     * Sets the ZoneController object zoneLayout attribute to the specified object.
     *
     * @param zoneLayout the object specified for assignment to the ZoneController object zoneLayout attribute
     */
    public void setZoneLayout(LinearLayout zoneLayout) {
        this.zoneLayout = zoneLayout;
    }

    /**
     * Sets the ZoneController object park attribute to the specified object.
     *
     * @param park the object specified for assignment to the ZoneController object park attribute
     */
    public void setPark(Park park) {
        this.park = park;
    }

    /**
     * Sets the ZoneController object key attribute to the specified value.
     *
     * @param key the value specified for assignment to the ZoneController object key attribute
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Sets the ZoneController object dinoKey attribute to the specified value.
     *
     * @param dinoKey the value specified for assignment to the ZoneController object dinoKey attribute
     */
    public void setDinoKey(String dinoKey) {
        this.dinoKey = dinoKey;
    }

    /**
     * Sets the ZoneController object zoneAbbreviation attribute to the specified value.
     *
     * @param zoneAbbreviation the value specified for assignment to the ZoneController object zoneAbbreviation attribute
     */
    public void setZoneAbbreviation(String zoneAbbreviation) {
        this.zoneAbbreviation = zoneAbbreviation;
    }

    /**
     * Sets the ZoneController object currentZone attribute to the specified object.
     *
     * @param currentZone the object specified for assignment to the ZoneController object currentZone attribute
     */
    public void setCurrentZone(Zone currentZone) {
        this.currentZone = currentZone;
    }

    /**
     * Sets the ZoneController object isInitialRead attribute to the specified value.
     *
     * @param initialRead the value specified for assignment to the ZoneController object isInitialRead attribute
     */
    public void setInitialRead(boolean initialRead) {
        isInitialRead = initialRead;
    }

    /**
     * Sets the ZoneController object isInitialReadKey attribute to the specified value.
     *
     * @param isInitialReadKey the value specified for assignment to the ZoneController object isInitialReadKey attribute
     */
    public void setIsInitialReadKey(String isInitialReadKey) {
        this.isInitialReadKey = isInitialReadKey;
    }
}
