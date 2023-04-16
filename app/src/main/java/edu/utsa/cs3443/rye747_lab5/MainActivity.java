package edu.utsa.cs3443.rye747_lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import edu.utsa.cs3443.rye747_lab5.controller.MainController;

public class MainActivity extends AppCompatActivity {
    private MainController controller;

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

    public void setupClickable(View view){
        view.setOnClickListener(controller);
    }
}