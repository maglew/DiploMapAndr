package com.pack.diplomap.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pack.diplommapandr.R;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        Button RedactButton = findViewById(R.id.mapbutt);
        // Устанавливаем действие по нажатию
        RedactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent SecAct = new Intent(getApplicationContext(), MapActivity.class);
                startActivity(SecAct);
            }
        });

        Button SettingsButton = findViewById(R.id.optbutt);
        // Устанавливаем действие по нажатию
        SettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent SecAct = new Intent(getApplicationContext(), OptionsActivity.class);
                startActivity(SecAct);
            }
        });

        Button ExitButton = findViewById(R.id.exitbutt);
        // Устанавливаем действие по нажатию
        ExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                System.exit(1);
            }
        });
    }
}
