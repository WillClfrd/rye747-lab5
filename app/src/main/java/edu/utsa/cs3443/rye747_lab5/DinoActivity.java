package edu.utsa.cs3443.rye747_lab5;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.rye747_lab5.controller.DinoController;
import edu.utsa.cs3443.rye747_lab5.controller.ZoneController;

public class DinoActivity extends AppCompatActivity {
    private DinoController controller;
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

    public void setupClickable(View view){
        view.setOnClickListener(controller);
    }

    public DinoController getController(){
        return controller;
    }

    public void setController(DinoController controller){
        this.controller = controller;
    }
}
