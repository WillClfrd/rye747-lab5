package edu.utsa.cs3443.rye747_lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import edu.utsa.cs3443.rye747_lab5.controller.DinoController;
import edu.utsa.cs3443.rye747_lab5.controller.MainController;

/**
 * This class represents MainActivity objects.
 * Each MainActivity object is instantiated with a Bundle object
 * MainActivity objects are responsible for initializing the activity_main layout
 *
 * @author William Clifford (rye747)
 * UTSA CS 3443 - Lab 5
 * Spring 2023
 */
public class MainActivity extends AppCompatActivity {
    private MainController controller;

    /**
     * This method is responsible for initializing the application view for the activity_main layout.
     *
     * @param savedInstanceState a Bundle class object that is passed into the inherited class onCreate method
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new MainController(this);

        TextView xButton = findViewById(R.id.x_button);
        TextView gButton = findViewById(R.id.g_button);
        TextView trButton = findViewById(R.id.tr_button);
        TextView tyButton = findViewById(R.id.ty_button);
        TextView bButton = findViewById(R.id.b_button);
        TextView rButton = findViewById(R.id.r_button);
        TextView dButton = findViewById(R.id.d_button);

        setupClickable(xButton);
        setupClickable(gButton);
        setupClickable(trButton);
        setupClickable(tyButton);
        setupClickable(bButton);
        setupClickable(rButton);
        setupClickable(dButton);
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
     * Returns the controller attribute of the MainActivity object.
     *
     * @return the controller attribute of the MainActivity object
     */
    public MainController getController(){
        return controller;
    }

    /**
     * Sets the MainActivity object controller attribute to the specified object.
     *
     * @param controller the object specified for assignment to the MainActivity object controller attribute
     */
    public void setController(MainController controller){
        this.controller = controller;
    }
}