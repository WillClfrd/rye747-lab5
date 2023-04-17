package edu.utsa.cs3443.rye747_lab5.controller;

import static android.widget.Toast.LENGTH_LONG;

import android.content.Intent;
import android.content.res.AssetManager;
import android.view.View;
import android.widget.Toast;

import edu.utsa.cs3443.rye747_lab5.MainActivity;
import edu.utsa.cs3443.rye747_lab5.R;
import edu.utsa.cs3443.rye747_lab5.ZoneActivity;
import edu.utsa.cs3443.rye747_lab5.model.Park;

public class MainController implements View.OnClickListener{
    private MainActivity activity;
    private Intent zoneIntent;
    private Park park;
    private AssetManager manager;
    private String key = "zone_abbreviation";
    private String isInitialReadKey = "initial_read";
    private boolean isInitialRead;
    public MainController(MainActivity activity){
        this.activity = activity;
        this.manager = activity.getAssets();
        isInitialRead = activity.getIntent().getBooleanExtra(isInitialReadKey, true);

        park = new Park("Jurassic Park");
        park.loadZones(manager, activity, isInitialRead);
        isInitialRead = false;
    }

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
}
