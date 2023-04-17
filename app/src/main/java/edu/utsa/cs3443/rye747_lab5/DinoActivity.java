package edu.utsa.cs3443.rye747_lab5;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.rye747_lab5.controller.DinoController;
import edu.utsa.cs3443.rye747_lab5.controller.ZoneController;

/**
 * This class represents DinoActivity objects.
 * Each DinoActivity object is instantiated with a Bundle object
 * DinoActivity objects are responsible for initializing the activity_dino layout
 *
 * @author William Clifford (rye747)
 * UTSA CS 3443 - Lab 5
 * Spring 2023
 */
public class DinoActivity extends AppCompatActivity {
    private DinoController controller;

    /**
     * This method is responsible for initializing the application view for the activity_dino layout.
     *
     * @param savedInstanceState a Bundle class object that is passed into the inherited class onCreate method
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dino);

        controller = new DinoController(this);

        TextView relocateButton = findViewById(R.id.dino_activity_relocate_button);
        TextView parkMapButton = findViewById(R.id.park_map_button);

        setupClickable(relocateButton);
        setupClickable(parkMapButton);
    }

    /**
     * This method establishes an onClickListener for the view parameter View object.
     *
     * @param view the View that is assigned an OnClickListener
     */
    public void setupClickable(View view){
        view.setOnClickListener(controller);
    }

    /**
     * Returns the controller attribute of the DinoActivity object.
     *
     * @return the controller attribute of the DinoActivity object
     */
    public DinoController getController(){
        return controller;
    }

    /**
     * Sets the DinoActivity object controller attribute to the specified object.
     *
     * @param controller the object specified for assignment to the DinoActivity object controller attribute
     */
    public void setController(DinoController controller){
        this.controller = controller;
    }
}
