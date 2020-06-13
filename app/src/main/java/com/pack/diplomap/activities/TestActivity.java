package com.pack.diplomap.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.pack.diplomap.GameManager;
import com.pack.diplomap.MapPanel;
import com.pack.diplommapandr.R;

public class TestActivity extends Activity {
    MapPanel mapPanel;
    int zoom = 100;
    //Состояние кнопки редактирования/сдвига
    private GameManager gameManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);

        gameManager = new GameManager(this);
        mapPanel = findViewById(R.id.canvasPanelSing);
        MapPanel.drawing=true;
        prepareNewGame();
        //prepareNewGame();
        Button addButton = findViewById(R.id.addbutt);
        // Устанавливаем действие по нажатию
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapPanel.drawmap.add();
            }
        });

        Button loadButton = findViewById(R.id.loadbutt);
        // Устанавливаем действие по нажатию
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapPanel.drawmap.loadmap();
            }
        });

        Button saveButton = findViewById(R.id.savebutt);
        // Устанавливаем действие по нажатию
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapPanel.drawmap.savemap();
            }
        });

        Button zoominbutt = findViewById(R.id.zoominbutt);
        // Устанавливаем действие по нажатию
        zoominbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapPanel.mapCamera.setSize(MapPanel.mapCamera.getSize() * 2);
            }
        });

        Button zoomoutbutt = findViewById(R.id.zoomoutbutt);
        // Устанавливаем действие по нажатию
        zoomoutbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapPanel.mapCamera.setSize(MapPanel.mapCamera.getSize() / 2);
            }
        });

        Button regimebutt = findViewById(R.id.regimebutt);
        // Устанавливаем действие по нажатию
        regimebutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapPanel.mapInterface.getRegime() == "move")
                    mapPanel.mapInterface.setRegime("touch");
                else
                    mapPanel.mapInterface.setRegime("move");
            }
        });

        Spinner spinner = findViewById(R.id.floorspin);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // int floor = i ;

                MapPanel.drawmap.setSelectedfloor(i);


            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                MapPanel.drawmap.setSelectedfloor(0);
            }
        });


    }

    private void prepareNewGame ()
    {
        gameManager.game_init();
    }
}