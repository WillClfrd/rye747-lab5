package edu.utsa.cs3443.rye747_lab5;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.rye747_lab5.controller.MainController;
import edu.utsa.cs3443.rye747_lab5.controller.ZoneController;

public class ZoneActivity extends AppCompatActivity {
    private ZoneController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone);

        controller = new ZoneController(this);

        TextView relocateButton = findViewById(R.id.relocate_dinosaur_button);
        setupClickable(relocateButton);
    }

    public void setupClickable(View view){
        view.setOnClickListener(controller);
    }
}
