package edu.utsa.cs3443.rye747_lab5;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.rye747_lab5.controller.DinoController;
import edu.utsa.cs3443.rye747_lab5.controller.MainController;
import edu.utsa.cs3443.rye747_lab5.controller.ZoneController;

/**
 * This class represents ZoneActivity objects.
 * Each ZoneActivity object is instantiated with a Bundle object
 * ZoneActivity objects are responsible for initializing the activity_zone layout
 *
 * @author William Clifford (rye747)
 * UTSA CS 3443 - Lab 5
 * Spring 2023
 */
public class ZoneActivity extends AppCompatActivity {
    private ZoneController controller;

    /**
     * This method is responsible for initializing the application view for the activity_zone layout.
     *
     * @param savedInstanceState a Bundle class object that is passed into the inherited class onCreate method
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone);

        controller = new ZoneController(this);

        TextView relocateButton = findViewById(R.id.relocate_dinosaur_button);
        setupClickable(relocateButton);
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
     * Returns the controller attribute of the ZoneActivity object.
     *
     * @return the controller attribute of the ZoneActivity object
     */
    public ZoneController getController(){
        return controller;
    }

    /**
     * Sets the ZoneActivity object controller attribute to the specified object.
     *
     * @param controller the object specified for assignment to the ZoneActivity object controller attribute
     */
    public void setController(ZoneController controller){
        this.controller = controller;
    }
}
