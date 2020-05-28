package com.pack.diplomap.activities;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.pack.diplomap.GameManager;
import com.pack.diplomap.MapPanel;
import com.pack.diplommapandr.R;

public class MapActivity extends Activity
{
    MapPanel mapPanel;
    int zoom=100;
    //Состояние кнопки редактирования/сдвига
    private GameManager gameManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);

        gameManager = new GameManager(this);
        mapPanel=findViewById(R.id.canvasPanelSing);

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
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapPanel.mapCamera.setSize(MapPanel.mapCamera.getSize()*2);
            }
        });

        Button zoomoutbutt = findViewById(R.id.zoomoutbutt);
        // Устанавливаем действие по нажатию
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapPanel.mapCamera.setSize(MapPanel.mapCamera.getSize()/2);
            }
        });

        Button regimebutt = findViewById(R.id.regimebutt);
        // Устанавливаем действие по нажатию
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(MapPanel.mapInterface.getRegime()=="move")
                    MapPanel.mapInterface.setRegime("touch");
                else
                    MapPanel.mapInterface.setRegime("move");
            }
        });

        Spinner spinner = findViewById(R.id.floorspin);
        String selected = spinner.getSelectedItem().toString();
int floor=Integer.parseInt( selected);
if(mapPanel.drawmap.selectedfloor!=floor)
{mapPanel.drawmap.selectedfloor=floor;}


    }

    private void prepareNewGame()
    {

        gameManager.game_init();
    }
}
