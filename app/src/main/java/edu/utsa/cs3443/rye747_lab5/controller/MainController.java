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
    public MainController(MainActivity activity){
        this.activity = activity;
        this.manager = activity.getAssets();
    }

    @Override
    public void onClick(View view) {
        park = new Park("Jurassic Park");
        park.loadZones(manager);

        if(view.getId() == R.id.x_button){
            zoneIntent = new Intent(activity, ZoneActivity.class);

        }
        else if(view.getId() == R.id.tr_button){
            zoneIntent = new Intent(activity, ZoneActivity.class);
        }
        else if(view.getId() == R.id.ty_button){
            zoneIntent = new Intent(activity, ZoneActivity.class);
        }
        else if(view.getId() == R.id.g_button){
            zoneIntent = new Intent(activity, ZoneActivity.class);
        }
        else if(view.getId() == R.id.b_button){
            zoneIntent = new Intent(activity, ZoneActivity.class);
        }
        else if(view.getId() == R.id.r_button){
            zoneIntent = new Intent(activity, ZoneActivity.class);
        }
        else if(view.getId() == R.id.d_button){
            zoneIntent = new Intent(activity, ZoneActivity.class);
        }
    }
}
