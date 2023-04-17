package edu.utsa.cs3443.rye747_lab5.controller;

import android.content.Intent;
import android.content.res.AssetManager;
import android.view.View;
import edu.utsa.cs3443.rye747_lab5.MainActivity;
import edu.utsa.cs3443.rye747_lab5.R;
import edu.utsa.cs3443.rye747_lab5.ZoneActivity;
import edu.utsa.cs3443.rye747_lab5.model.Park;

/**
 * This class represents MainController objects.
 * The MainController class establishes onClickListeners and handles changes to view elements for the MainActivity class.
 *
 * @author William Clifford (rye747)
 * UTSA CS 3443 - Lab 5
 * Spring 2023
 */
public class MainController implements View.OnClickListener{
    private MainActivity activity;
    private Intent zoneIntent;
    private Park park;
    private AssetManager manager;
    private String key = "zone_abbreviation";
    private String isInitialReadKey = "initial_read";
    private boolean isInitialRead;

    /**
     * Constructs a MainController class object with the specified value assigned to the MainController object activity attribute.
     * Initializes the MainController object manager, park, and isInitialRead attributes.
     *
     * @param activity the object to be assigned to the MainController object activity attribute.
     */
    public MainController(MainActivity activity){
        this.activity = activity;
        this.manager = activity.getAssets();
        isInitialRead = activity.getIntent().getBooleanExtra(isInitialReadKey, true);

        park = new Park("Jurassic Park");
        park.loadZones(manager, activity, isInitialRead);
        isInitialRead = false;
    }

    /**
     * Maintains onClickListeners for views of the MainController activity attribute which have been assigned onClickListeners.
     *
     * @param view the View object passed as a parameter from the detected click event
     */
    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.x_button){
            zoneIntent = new Intent(activity, ZoneActivity.class);
            zoneIntent.putExtra(key, "x");
            zoneIntent.putExtra(isInitialReadKey, isInitialRead);
            activity.startActivity(zoneIntent);
        }
        else if(view.getId() == R.id.tr_button){
            zoneIntent = new Intent(activity, ZoneActivity.class);
            zoneIntent.putExtra(key, "tr");
            zoneIntent.putExtra(isInitialReadKey, isInitialRead);
            activity.startActivity(zoneIntent);
        }
        else if(view.getId() == R.id.ty_button){
            zoneIntent = new Intent(activity, ZoneActivity.class);
            zoneIntent.putExtra(key, "ty");
            zoneIntent.putExtra(isInitialReadKey, isInitialRead);
            activity.startActivity(zoneIntent);
        }
        else if(view.getId() == R.id.g_button){
            zoneIntent = new Intent(activity, ZoneActivity.class);
            zoneIntent.putExtra(key, "g");
            zoneIntent.putExtra(isInitialReadKey, isInitialRead);
            activity.startActivity(zoneIntent);
        }
        else if(view.getId() == R.id.b_button){
            zoneIntent = new Intent(activity, ZoneActivity.class);
            zoneIntent.putExtra(key, "b");
            zoneIntent.putExtra(isInitialReadKey, isInitialRead);
            activity.startActivity(zoneIntent);
        }
        else if(view.getId() == R.id.r_button){
            zoneIntent = new Intent(activity, ZoneActivity.class);
            zoneIntent.putExtra(key, "r");
            zoneIntent.putExtra(isInitialReadKey, isInitialRead);
            activity.startActivity(zoneIntent);
        }
        else if(view.getId() == R.id.d_button){
            zoneIntent = new Intent(activity, ZoneActivity.class);
            zoneIntent.putExtra(key, "d");
            zoneIntent.putExtra(isInitialReadKey, isInitialRead);
            activity.startActivity(zoneIntent);
        }
    }

    /**
     * Returns the activity attribute of the MainController object.
     *
     * @return the activity attribute of the MainController object
     */
    public MainActivity getActivity() {
        return activity;
    }

    /**
     * Returns the zoneIntent attribute of the MainController object.
     *
     * @return the zoneIntent attribute of the MainController object
     */
    public Intent getZoneIntent() {
        return zoneIntent;
    }

    /**
     * Returns the park attribute of the MainController object.
     *
     * @return the park attribute of the MainController object
     */
    public Park getPark() {
        return park;
    }

    /**
     * Returns the manager attribute of the MainController object.
     *
     * @return the manager attribute of the MainController object
     */
    public AssetManager getManager() {
        return manager;
    }

    /**
     * Returns the key attribute of the MainController object.
     *
     * @return the key attribute of the MainController object
     */
    public String getKey() {
        return key;
    }

    /**
     * Returns the isInitialReadKey attribute of the MainController object.
     *
     * @return the isInitialReadKey attribute of the MainController object
     */
    public String getIsInitialReadKey() {
        return isInitialReadKey;
    }

    /**
     * Returns the isInitialRead attribute of the MainController object.
     *
     * @return the isInitialRead attribute of the MainController object
     */
    public boolean isInitialRead() {
        return isInitialRead;
    }

    /**
     * Sets the MainController object activity attribute to the specified object.
     *
     * @param activity the object specified for assignment to the MainController object activity attribute
     */
    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }

    /**
     * Sets the MainController object zoneIntent attribute to the specified object.
     *
     * @param zoneIntent the object specified for assignment to the MainController object zoneIntent attribute
     */
    public void setZoneIntent(Intent zoneIntent) {
        this.zoneIntent = zoneIntent;
    }

    /**
     * Sets the MainController object park attribute to the specified object.
     *
     * @param park the object specified for assignment to the MainController object park attribute
     */
    public void setPark(Park park) {
        this.park = park;
    }

    /**
     * Sets the MainController object manager attribute to the specified object.
     *
     * @param manager the object specified for assignment to the MainController object manager attribute
     */
    public void setManager(AssetManager manager) {
        this.manager = manager;
    }

    /**
     * Sets the MainController object key attribute to the specified value.
     *
     * @param key the value specified for assignment to the MainController object key attribute
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Sets the MainController object isInitialReadKey attribute to the specified value.
     *
     * @param isInitialReadKey the value specified for assignment to the MainController object isInitialReadKey attribute
     */
    public void setIsInitialReadKey(String isInitialReadKey) {
        this.isInitialReadKey = isInitialReadKey;
    }

    /**
     * Sets the MainController object isInitialRead attribute to the specified value.
     *
     * @param initialRead the value specified for assignment to the MainController object isInitialRead attribute
     */
    public void setInitialRead(boolean initialRead) {
        isInitialRead = initialRead;
    }
}
