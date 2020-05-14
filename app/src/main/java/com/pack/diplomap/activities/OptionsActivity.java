package com.pack.diplomap.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pack.diplommapandr.R;

public class OptionsActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_layout);


        Button ExitButton = findViewById(R.id.optexitbutt);
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
